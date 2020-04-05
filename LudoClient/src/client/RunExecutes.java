package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RunExecutes {

	private DataInputStream dataIn = null;
	private BufferedReader textIn = null;

	private int receivedCode = CommandC.NOTHING_TO_DO;
	private int dataInteger;
	private String dataText = null;

	// pomocni atributi

	private static boolean colorIsSelected = false;

	public static boolean isColorIsSelected() {
		return colorIsSelected;
	}

	public static void setColorIsSelected(boolean colorIsSelected) {
		RunExecutes.colorIsSelected = colorIsSelected;
	}

	void runExecutes() throws IOException, InterruptedException {

		try {

			dataIn = new DataInputStream(Client.getSocket().getInputStream());
			textIn = new BufferedReader(new InputStreamReader(Client.getSocket().getInputStream()));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * stalno primamo poruke od servera
		 */

		while (!GameC.isEndOfGame()) {

			while (dataIn.available() == 0) {
				Thread.sleep(10);
			}
			receivedCode = dataIn.readInt();
			System.out.println("primio odgovor - klijent");

			switch (receivedCode) {

			case CommandC.THROW_DICE:
				throw_dice();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			case CommandC.CREATE_ROOM:
				create_room();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			case CommandC.ERROR:
				error();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			case CommandC.GO_START:
				go_start();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			case CommandC.SEND_COLOR:
				send_color();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			case CommandC.PLAY:
				play();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			default:
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			}

		}
	}

	private void play() throws IOException, InterruptedException {

		// ovde ima mnogo gresaka!!!

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int color = dataIn.readInt();

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int code = dataIn.readInt();

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int codeAll = dataIn.readInt();

		// ako je 1 onda je jedan novi spreman, ako je 2 onda su svi spremni
		if (code == 1) {

			// // -->
			//
			// while (dataIn.available() == 0) {
			// Thread.sleep(10);
			// }
			// int playerID = dataIn.readInt();
			//
			// // ovde treba neka cekajuca za read line
			// String name = textIn.readLine();

			switch (color) {

			case CommandC.RED:
				// Client.game.getPlayerRed().setColor(CommandC.RED);
				// Client.game.getPlayerRed().setName(name);
				// Client.game.getPlayerRed().setPlayerId(playerID);
				// if(playerID == 1) {
				// Client.game.getPlayerRed().setOnTurn(true);;
				// }
				Client.ludoMain.getLblPawnRed()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedR.png")));
				break;

			case CommandC.BLUE:
				// Client.game.getPlayerBlue().setColor(CommandC.BLUE);
				// Client.game.getPlayerBlue().setName(name);
				// Client.game.getPlayerBlue().setPlayerId(playerID);
				// if(playerID == 1) {
				// Client.game.getPlayerBlue().setOnTurn(true);;
				// }
				Client.ludoMain.getLblPawnBlue()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueR.png")));
				break;

			case CommandC.GREEN:
				// Client.game.getPlayerGreen().setColor(CommandC.GREEN);
				// Client.game.getPlayerGreen().setName(name);
				// Client.game.getPlayerGreen().setPlayerId(playerID);
				// if(playerID == 1) {
				// Client.game.getPlayerGreen().setOnTurn(true);;
				// }
				Client.ludoMain.getLblPawnGreen()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenR.png")));
				break;

			case CommandC.YELLOW:
				// Client.game.getPlayerYellow().setColor(CommandC.YELLOW);
				// Client.game.getPlayerYellow().setName(name);
				// Client.game.getPlayerYellow().setPlayerId(playerID);
				// if(playerID == 1) {
				// Client.game.getPlayerYellow().setOnTurn(true);;
				// }
				Client.ludoMain.getLblPawnYellow()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowR.png")));
				break;

			default:
				break;

			}
		}
		if (codeAll == 2) {

			// switch(Client.game.getPlayerYou().getColor()) {
			//
			// case CommandC.RED:
			// Client.game.setPlayerRed( Client.game.getPlayerYou());
			// break;
			//
			// case CommandC.BLUE:
			// Client.game.setPlayerRed( Client.game.getPlayerYou());
			// break;
			//
			// case CommandC.GREEN:
			// Client.game.setPlayerRed( Client.game.getPlayerYou());
			// break;
			//
			// case CommandC.YELLOW:
			// Client.game.setPlayerRed( Client.game.getPlayerYou());
			// break;
			//
			// default:
			// break;
			// }

			// setPlayers();

			/*
			 * ovde ima dosta setovanjza za novu igru
			 */
			Client.ludoMain.setVisible(false);
			Client.ludoGame.setVisible(true);
		}

	}

	/*
	 * pomocu ove metode se setuje ludoGame, dodeljuju se boje mesta....
	 */
	private void setPlayers() {

		switch (Client.game.getPlayerYou().getColor()) {

		case CommandC.RED:
			Client.ludoGame.getLblPlayerYou()
					.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Rededge (6).png")));
			;
			break;

		case CommandC.BLUE:
			Client.ludoGame.getLblPlayerYou()
					.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Blueedge (5).png")));
			break;

		case CommandC.GREEN:
			Client.ludoGame.getLblPlayerYou()
					.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Greenedge (8).png")));
			break;

		case CommandC.YELLOW:
			Client.ludoGame.getLblPlayerYou()
					.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Yellowedge (7).png")));
			break;

		default:
			break;
		}

		Client.ludoGame.getLblNamePlayerYou().setText(Client.game.getPlayerYou().getName());

		// nas klijent je zavrsen

		// int[] niz = {Client.game.getPlayerRed().getPlayerId(),
		// Client.game.getPlayerBlue().getPlayerId(),
		// Client.game.getPlayerGreen().getPlayerId(),
		// Client.game.getPlayerYellow().getPlayerId()};

		int[] array = new int[4];
		int counter = 0;

		if (Client.game.getPlayerRed().getPlayerId() != -1) {
			array[counter] = Client.game.getPlayerRed().getPlayerId();
			counter++;
		}

		if (Client.game.getPlayerBlue().getPlayerId() != -1) {
			array[counter] = Client.game.getPlayerBlue().getPlayerId();
			counter++;
		}

		if (Client.game.getPlayerGreen().getPlayerId() != -1) {
			array[counter] = Client.game.getPlayerGreen().getPlayerId();
			counter++;
		}

		if (Client.game.getPlayerYellow().getPlayerId() != -1) {
			array[counter] = Client.game.getPlayerYellow().getPlayerId();
			counter++;
		}

		// izbacujem iz niza sebe jer sam ja sebe vec setovo

		for (int i = 0; i < counter; i++) {
			if (array[i] == Client.game.getPlayerYou().getPlayerId()) {
				array[i] = 100;
			}
		}

		// obavezno vodi racuna da iskljucujem uvek 100 iz niza

		int min = array[0];
		int pom = counter;
		int pom2 = 0;

		while (pom > 0) {

			for (int i = 0; i < counter; i++) {
				if (array[i] < min) {
					if (array[i] != 100) {
						min = array[i];
						array[i] = 100;
						break;
					}
				}
			}

			if (pom2 == 0) {
				PlayerC p = returnPlayer(min);
				System.out.println(min);

				switch (p.getColor()) {

				case CommandC.RED:
					Client.ludoGame.getLblPlayer2()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Rededge (6).png")));
					break;

				case CommandC.BLUE:
					Client.ludoGame.getLblPlayer2()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Blueedge (5).png")));
					break;

				case CommandC.GREEN:
					Client.ludoGame.getLblPlayer2()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Greenedge (8).png")));
					break;

				case CommandC.YELLOW:
					Client.ludoGame.getLblPlayer2()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Yellowedge (7).png")));
					break;
				}
				Client.ludoGame.getLblNamePlayer2().setText(p.getName());
				pom2++;
			}

			if (pom2 == 1) {

				PlayerC p = returnPlayer(min);

				switch (p.getColor()) {

				case CommandC.RED:
					Client.ludoGame.getLblPlayer3()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Rededge (6).png")));
					break;

				case CommandC.BLUE:
					Client.ludoGame.getLblPlayer3()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Blueedge (5).png")));
					break;

				case CommandC.GREEN:
					Client.ludoGame.getLblPlayer3()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Greenedge (8).png")));
					break;

				case CommandC.YELLOW:
					Client.ludoGame.getLblPlayer3()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Yellowedge (7).png")));
					break;
				}
				Client.ludoGame.getLblNamePlayer3().setText(p.getName());
				pom2++;
			}

			if (pom2 == 2) {

				PlayerC p = returnPlayer(min);

				switch (p.getColor()) {

				case CommandC.RED:
					Client.ludoGame.getLblPlayer4()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Rededge (6).png")));
					break;

				case CommandC.BLUE:
					Client.ludoGame.getLblPlayer4()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Blueedge (5).png")));
					break;

				case CommandC.GREEN:
					Client.ludoGame.getLblPlayer4()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Greenedge (8).png")));
					break;

				case CommandC.YELLOW:
					Client.ludoGame.getLblPlayer4()
							.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Yellowedge (7).png")));
					break;
				}
				Client.ludoGame.getLblNamePlayer4().setText(p.getName());

				pom2++;
			}
			pom--;
		}

	}

	private PlayerC returnPlayer(int playerID) {

		if (Client.game.getPlayerGreen().getPlayerId() == playerID) {
			return Client.game.getPlayerGreen();
		}
		if (Client.game.getPlayerRed().getPlayerId() == playerID) {
			return Client.game.getPlayerRed();
		}
		if (Client.game.getPlayerBlue().getPlayerId() == playerID) {
			return Client.game.getPlayerBlue();
		}
		if (Client.game.getPlayerYellow().getPlayerId() == playerID) {
			return Client.game.getPlayerYellow();
		}

		return null;
	}

	private void send_color() throws IOException, InterruptedException {

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int palayerID = dataIn.readInt();

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int colour = dataIn.readInt();

		if (palayerID == Client.game.getPlayerYou().getPlayerId()) {
			// setujem da sam ja uzeo boju
			// za sada ce izgledati isto jer treba ubaciti nove ikonice za te slucajeve

			Client.game.getPlayerYou().setColor(colour);
			colorIsSelected = true;

			switch (colour) {

			case CommandC.RED:
				Client.ludoMain.getLblPawnRed()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedEdge.png")));
				break;

			case CommandC.BLUE:
				Client.ludoMain.getLblPawnBlue()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueEdge.png")));
				break;

			case CommandC.GREEN:
				Client.ludoMain.getLblPawnGreen()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenEdge.png")));
				break;

			case CommandC.YELLOW:
				Client.ludoMain.getLblPawnYellow()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowEdge.png")));
				break;

			default:
				break;

			}

		} else {
			// kad drugi uzmu boju
			// za sada ce izgledati isto jer treba ubaciti nove ikonice za te slucajeve

			switch (colour) {

			case CommandC.RED:
				Client.ludoMain.getLblPawnRed()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedS.png")));
				break;

			case CommandC.BLUE:
				Client.ludoMain.getLblPawnBlue()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueS.png")));
				break;

			case CommandC.GREEN:
				Client.ludoMain.getLblPawnGreen()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenS.png")));
				break;

			case CommandC.YELLOW:
				Client.ludoMain.getLblPawnYellow()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowS.png")));
				break;

			default:
				break;

			}
		}

	}

	private void go_start() throws IOException, InterruptedException {

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int palayerID = dataIn.readInt();

		// sstigo sam dovde 26.3.
		// mozda treba reorganizacija klijent strane jer mi ne trebaju tolike
		// informacije o drugim klijentima
		// kada treba nesto da se pomera na talonu server me obavestava o tomedd
		// ne treba da se sve te info prukupljaju kod mene
		// meni su potrebne samo striktne info o meni

		Client.game.getPlayerYou().setPlayerId(palayerID);

		if (palayerID == 1) {
			Client.game.setPlayersOnTurn(palayerID);
			Client.game.getPlayerYou().setOnTurn(true);
		}

		Client.ludoStart.setVisible(false);
		Client.ludoMain.setVisible(true);

	}

	/*
	 * sve greske prvo salju error kod, a drugi kod se gleda u ovom svicu i na
	 * osnovu njega izlai poruka
	 * 
	 */
	private void error() throws IOException, InterruptedException {

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		dataInteger = dataIn.readInt();

		switch (dataInteger) {

		case CommandC.ERROR_ROOM:
			JOptionPane.showMessageDialog(new JFrame(), "Room error", "Error", JOptionPane.ERROR_MESSAGE);
			break;

		case CommandC.ERROR_COLOR:
			JOptionPane.showMessageDialog(new JFrame(), "Color error, try again", "Error", JOptionPane.ERROR_MESSAGE);
			break;

		default:
			break;

		}

	}

	/*
	 * citam sa servera roomID, upisujem ga objekat game na klijentu
	 */
	private void create_room() throws IOException, InterruptedException {

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		dataInteger = dataIn.readInt();

		GameC.setRoomID(dataInteger);

		JOptionPane.showMessageDialog(new JFrame(), "You have successfully created room number: " + GameC.getRoomID(),
				"Room created", JOptionPane.INFORMATION_MESSAGE);

		LudoStart.textRoom.setText(String.valueOf(GameC.getRoomID()));

	}

	private void throw_dice() throws IOException, InterruptedException {
		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int color = dataIn.readInt();
		
		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int numberOnDice = dataIn.readInt();
		
		if(Client.game.getPlayerYou().getColor() == color) {
			if(numberOnDice > 6) {
				//klikni na kockicu
			}
			else {
				//setuj kockicu na broj
				switch(numberOnDice) {
				case 1:
					//slike 
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
					break;
				}
			}
		}
		else {
			//setuj kockicu koja nije tvoje, pre toga proveri da je manje od 6
		}

	}

}
