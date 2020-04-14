package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import com.sun.security.ntlm.Client;

public class ServerThread extends Thread {

	private DataOutputStream dataOut = null;
	private DataInputStream dataIn = null;
	private PrintStream textOut = null;
	private BufferedReader textIn = null;

	Socket socketForCom = null;
	ServerThread[] clients;

	private int receivedCode = 0;
	private int roomID = -1;
	private Node first;
	private int gameIndex;

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public ServerThread(Socket socket, ServerThread[] clients) {
		super();
		this.socketForCom = socket;
		this.clients = clients;
	}

	public void run() {

		try {

			dataOut = new DataOutputStream(socketForCom.getOutputStream());
			dataIn = new DataInputStream(socketForCom.getInputStream());
			textIn = new BufferedReader(new InputStreamReader(socketForCom.getInputStream()));
			textOut = new PrintStream(socketForCom.getOutputStream());

			while (true) { // vidi ovde sta treba za uslov, na pocetku je bilo game.isEnd

				/*
				 * ovde se ucitavaju kodovi koje klijent stalno salje i posle svake izmene u
				 * istoj metodi poslati ostalim klijentima obavestenje o tome
				 */

				while (dataIn.available() == 0) {
					Thread.sleep(10);
				}
				receivedCode = dataIn.readInt();

				switch (receivedCode) {

				case CommandS.THROW_DICE:
					throw_dice();
					break;

				case CommandS.CREATE_ROOM:
					create_room();
					break;

				case CommandS.GO_START:
					go_start();
					break;

				case CommandS.SEND_COLOR:
					send_colour();
					break;

				case CommandS.PLAY:
					play();
					break;

				case CommandS.GAMESTART:
					gameStart();
					break;

				default:
					break;

				}

				receivedCode = CommandS.NOTHING_TO_DO;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * ovde mozda neko obavestenje da je taj i taj igrac napustio igru
		 */

		endOfThread();
	}

	private void play() throws IOException, InterruptedException {

		// ovde ima mnogo gresaka

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int roomID = dataIn.readInt();
		System.out.println(roomID);

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int playerID = dataIn.readInt();

				
		// ovde treba neka cekajuca za read line
		String name = textIn.readLine();
//		System.out.println(name);
		int allIsReady = 0;
		for (int m = 0; m < 10; m++) {
			if (Server.games[m].getRoomID() == roomID) {
				Server.games[m].getPlayers()[playerID - 1].setName(name);
				Server.games[m].getPlayers()[playerID - 1].setReady(true);
				allIsReady = all_is_ready(roomID, playerID);
				send_to_players_in_game(CommandS.PLAY, playerID, allIsReady, name);

			}
		}
		if(allIsReady == 1) {
			gameStart();
		}

	}

	private int all_is_ready(int roomID, int playerID) throws IOException, InterruptedException {

		for (int i = 0; i < 10; i++) {
			if (Server.games[i].getRoomID() == roomID) {

				int pom = 0;
				for (int j = 0; j < 4; j++) {
					if (Server.games[i].getPlayers()[j] != null && Server.games[i].getPlayers()[j].isReady() == true) {
						pom++;
					}
				}

				if (pom == Server.games[i].getNumberOfPlayers()) {

					// za datu sobu na serveru uzimamo prvi cvor i smestamo u pom
					for (int j = 0; j < 10; j++) {
						if (Server.games[j].getRoomID() == roomID) {
							first = Server.games[j].getFirst();
							gameIndex = j;
						}
					}

					return 1; // svi su spremni
				} else {

					return 0; // nisu spremni
				}
			}
		}
		return 0;
	}

	private void gameStart() throws IOException {
		Node pom = first;
		
		while (pom.active != true) {
			pom = pom.next;
		}
		
		send_to_players_in_game(CommandS.GAMESTART, pom.color); 

		
	}

	/*OVU METODU NECEMO KORISTITI !!!!
	 
	private void game() throws IOException, InterruptedException {
		Node pom = first; // mozda ovo treba van ako se game poziva vise puta !!!!!!!!!!!!!!
		while (Server.games[gameIndex].isEndOfGame() == false) {
			if (pom.active == false) {
				pom = pom.next;
				if (pom.getColour() == CommandS.GREEN) {
					Server.games[gameIndex].setRound(Server.games[gameIndex].getRound() + 1);
				}
				continue;
			}

			// bacanje kocku u slucaju da je prva runda
			if (Server.games[gameIndex].getRound() == 1) {
				for (int i = 1; i <= 3; i++) {
					send_to_players_in_game(CommandS.THROW_DICE, pom.colour, 10); // 10 je baci kockicu
					while (dataIn.available() == 0) {
						Thread.sleep(10);
					}
					int diceSignal = dataIn.readInt();
					int numberOnDice = throw_dice();
					send_to_players_in_game(CommandS.THROW_DICE, pom.colour, numberOnDice);
					if (numberOnDice == 6) {
						break;
					}
					if (i == 3 && numberOnDice != 6) {
						pom = pom.next;
						continue;
					}
				}
			} else {
				send_to_players_in_game(CommandS.THROW_DICE, pom.colour, 10); // 10 je baci kockicu
				while (dataIn.available() == 0) {
					Thread.sleep(10);
				}
				int diceSignal = dataIn.readInt();
				int numberOnDice = throw_dice();
				send_to_players_in_game(CommandS.THROW_DICE, pom.colour, numberOnDice);

			}

			if (pom.getColour() == CommandS.GREEN) {
				Server.games[gameIndex].setRound(Server.games[gameIndex].getRound() + 1);
			}
			pom = pom.next;
		}

	}
	*/

	private void send_colour() throws IOException, InterruptedException {

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int roomID = dataIn.readInt();

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int playerID = dataIn.readInt();

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int color = dataIn.readInt();

		for (int i = 0; i < 10; i++) {
			if (Server.games[i].getRoomID() == roomID) {
				activatePlayer(color, Server.games[i].getFirst());
				int pom = 0;
				for (int j = 0; j < 4; j++) {
					if (Server.games[i].getPlayers()[j] != null
							&& Server.games[i].getPlayers()[j].getColor() == color) {
						pom++;
					}
				}
				if (pom == 0) {

					activatePlayer(color, Server.games[i].getFirst());

					/*
					 * pravimo objekte pijuna za izabranu boju
					 */
					if (color == CommandS.RED) {
						Server.games[i].make_red_pawns(playerID);
					}
					if (color == CommandS.BLUE) {
						Server.games[i].make_blue_pawns(playerID);
					}
					if (color == CommandS.GREEN) {
						Server.games[i].make_green_pawns(playerID);
					}
					if (color == CommandS.YELLOW) {
						Server.games[i].make_yelow_pawns(playerID);
					}

					Server.games[i].getPlayers()[playerID - 1].setColor(color);
					send_to_players_in_game(CommandS.SEND_COLOR, playerID, color); // ako je sve proslo ok

					/*
					 * vraca onu boju koju je zauzeo
					 */

				} else {
					dataOut.writeInt(CommandS.ERROR);
					dataOut.writeInt(CommandS.ERROR_COLOR);
				}

			}
		}

	}

	private void activatePlayer(int color, Node first) {
		Node pom = first;
		while (pom.color != color)
			pom = pom.next;
		pom.setActive(true);
	}

	/*
	 * u ovoj metodi proveravamo da li soba posroji, ako ne saljemo gresku, ako da
	 * pravimo novog igraca i ubacujemo ga u igru koja se poklapa sa brojom sobe,
	 * ako je usao prvi u sobu on je prvi na potezu
	 */
	private void go_start() throws IOException, InterruptedException {

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int room = dataIn.readInt();

		for (int i = 0; i < 10; i++) {
			if (Server.games[i].getRoomID() == room) {

				if (Server.games[i].getNumberOfPlayers() < 4) {

					PlayerS player = new PlayerS(Server.games[i].getNumberOfPlayers() + 1);

					Server.games[i].players[Server.games[i].getNumberOfPlayers()] = player;
					Server.games[i].setNumberOfPlayers(Server.games[i].getNumberOfPlayers() + 1); // dodali smo
																									// igraca
					roomID = room; // setovali smo roomID od niti

					dataOut.writeInt(CommandS.GO_START);
					dataOut.writeInt(Server.games[i].players[Server.games[i].getNumberOfPlayers() - 1].getPlayerId()); // id
																														// novog
																														// igraca
																														// je
																														// zapravo
																														// sadasnji
																														// broj
																														// igraca
					return;
				}
			}
		}

		dataOut.writeInt(CommandS.ERROR);
		dataOut.writeInt(CommandS.ERROR_ROOM);
	}

	/*
	 * pravimo novu sobu, tj pravimo objekat klase game i ubacujemo ga u niz na
	 * serveru i dodaljujemo roomID podatke saljemo klijentu, ali samo onom koji je
	 * napravio sobu
	 */

	private void create_room() throws IOException {

		// pravim sobu, prolayim kroy niy ako ne postoji upisujem je i vracam klijentu
		// sta sam uradio

		int numberOfRoom;
		do {
			numberOfRoom = (int) (Math.random() * ((999 - 100) + 1)) + 100;
		} while (room_exists(numberOfRoom) == 1);

		for (int i = 0; i <= Server.games.length; i++) {
			if (Server.games[i].getRoomID() == -1) {
				Server.games[i].setRoomID(numberOfRoom);
				Server.games[i].make_fields(); // pravim polja u igri
				Server.games[i].inicialization();
				break;
			}
		}

		dataOut.writeInt(CommandS.CREATE_ROOM);
		dataOut.writeInt(numberOfRoom);
	}

	private int throw_dice() throws IOException {
		return (int) (Math.random() * 6 + 1);
	}

	/*
	 * naredne dve metode salju int i string svim tredovima
	 */

	private void send_to_players_in_game(int command, int playerID, int dataInt) throws IOException {

		for (int i = 0; i <= 39; i++) {

			if (clients[i] != null && clients[i].getRoomID() == roomID) {

				clients[i].dataOut.writeInt(command); // salje se primljeni kod klijentskoj strani da bi znao koji
														// podatci stizu
				clients[i].dataOut.writeInt(playerID);
				clients[i].dataOut.writeInt(dataInt);
			}
		}
	}

	private void send_to_players_in_game(int command, int playerID, String text) throws IOException {

		for (int r = 0; r <= 39; r++) {

			if (clients[r] != null && clients[r].getRoomID() == roomID) {

				clients[r].dataOut.writeInt(command); // salje se primljeni kod klijentskoj strani da bi znao koji
														// podatci stizu
				clients[r].dataOut.writeInt(playerID);
				clients[r].textOut.println(text);
				textOut.flush();

			}
		}
	}

	private void send_to_players_in_game(int command, int playerID) throws IOException {

		for (int r = 0; r <= 39; r++) {

			if (clients[r] != null && clients[r].getRoomID() == roomID) {

				clients[r].dataOut.writeInt(command); // salje se primljeni kod klijentskoj strani da bi znao koji
														// podatci stizu
				clients[r].dataOut.writeInt(playerID);
			}
		}
	}

	private void send_to_players_in_game(int command, int playerID, int data, String text) throws IOException {

		for (int r = 0; r <= 39; r++) {

			if (clients[r] != null && clients[r].getRoomID() == roomID) {

				clients[r].dataOut.writeInt(command); // salje se primljeni kod klijentskoj strani da bi znao koji
														// podatci stizu
				clients[r].dataOut.writeInt(playerID);

				clients[r].dataOut.writeInt(data);

				clients[r].textOut.println(text);
				textOut.flush();

			}
		}
	}

	/*
	 * metoda oslobadja mesto u nizu tako sto brise nit
	 */
	private void endOfThread() {
		for (int i = 0; i <= 39; i++) {
			if (clients[i] == this) {
				clients[i] = null;
			}
		}
	}

	/*
	 * 0 NE, 1 DA
	 */
	private int room_exists(int numberOfRoom) {

		for (int i = 0; i < 10; i++) {
			if (Server.games[i].getRoomID() == numberOfRoom) {
				return 1;
			}
		}
		return 0;
	}

}
