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
				
			case CommandC.GAMESTART:
				gameStart();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			default:
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			}

		}
	}

	private void gameStart() throws IOException, InterruptedException {
		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int playerColor = dataIn.readInt();
		
		switch (playerColor) {

		case CommandC.RED:
			Client.ludoGame.getLblDiceBackPlayerRed().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			break;

		case CommandC.BLUE:
			Client.ludoGame.getLblDiceBackPlayerBlue().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			break;

		case CommandC.GREEN:
			Client.ludoGame.getLblDiceBackPlayerGreen().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			break;

		case CommandC.YELLOW:
			Client.ludoGame.getLblDiceBackPlayerYellow().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			break;

		default:
			break;

		}
		
	}

	private void play() throws IOException, InterruptedException {

		// ovde ima mnogo gresaka!!!

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int playerID = dataIn.readInt();

		System.out.println("Uso u play - klijent");
		System.out.println(playerID);

		// ovde je greska, mozda i na server strani

		// ova linija ne prima info od servera!!!!!!!!!!!!!!
		// zauvek ostaje u ovoj liniji koda
		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int codeAll = dataIn.readInt();

		System.out.println("Procitao kod");
		System.out.println(codeAll);

		String name = textIn.readLine();
		System.out.println("Procito ime sa servera");
		System.out.println(name);

		// ako je 1 onda je jedan novi spreman, ako je 2 onda su svi spremni

		Client.game.getPlayers()[playerID - 1].setName(name);

		switch (Client.game.getPlayers()[playerID - 1].getColor()) {

		case CommandC.RED:
			Client.ludoMain.getLblPawnRed()
					.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedR.png")));
			Client.ludoGame.getLblNamePlayerRed().setText(name);
			break;

		case CommandC.BLUE:
			Client.ludoMain.getLblPawnBlue()
					.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueR.png")));
			Client.ludoGame.getLblNamePlayerBlue().setText(name);
			break;

		case CommandC.GREEN:
			Client.ludoMain.getLblPawnGreen()
					.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenR.png")));
			Client.ludoGame.getLblNamePlayerGreen().setText(name);
			break;

		case CommandC.YELLOW:
			Client.ludoMain.getLblPawnYellow()
					.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowR.png")));
			Client.ludoGame.getLblNamePlayerYellow().setText(name);
			break;

		default:
			break;

		}
		if (codeAll == 1) {

			Client.ludoMain.setVisible(false);
			Client.ludoGame.setVisible(true);
		}

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

		Client.game.getPlayers()[palayerID - 1].setColor(colour);

		if (palayerID == GameC.getYouPlayerID()) {
			// setujem da sam ja uzeo boju
			// za sada ce izgledati isto jer treba ubaciti nove ikonice za te slucajeve

			colorIsSelected = true;

			switch (colour) {

			case CommandC.RED:
				Client.ludoMain.getLblPawnRed()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedEdge.png")));
				Client.game.make_red_pawns(palayerID);
				break;

			case CommandC.BLUE:
				Client.ludoMain.getLblPawnBlue()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueEdge.png")));
				Client.game.make_blue_pawns(palayerID);
				break;

			case CommandC.GREEN:
				Client.ludoMain.getLblPawnGreen()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenEdge.png")));
				Client.game.make_green_pawns(palayerID);
				break;

			case CommandC.YELLOW:
				Client.ludoMain.getLblPawnYellow()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowEdge.png")));
				Client.game.make_yelow_pawns(palayerID);
				break;

			default:
				break;

			}

		} else {
			// kad drugi uzmu boju
			// za sada ce izgledati isto jer treba ubaciti nove ikonice za te slucajeve

			Client.game.getPlayers()[palayerID - 1].setPlayerId(palayerID);

			switch (colour) {

			case CommandC.RED:
				Client.ludoMain.getLblPawnRed()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedS.png")));
				Client.game.make_red_pawns(palayerID);
				break;

			case CommandC.BLUE:
				Client.ludoMain.getLblPawnBlue()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueS.png")));
				Client.game.make_blue_pawns(palayerID);
				break;

			case CommandC.GREEN:
				Client.ludoMain.getLblPawnGreen()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenS.png")));
				Client.game.make_green_pawns(palayerID);
				break;

			case CommandC.YELLOW:
				Client.ludoMain.getLblPawnYellow()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowS.png")));
				Client.game.make_yelow_pawns(palayerID);
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

		Client.game.setYouPlayerID(palayerID);

		Client.game.getPlayers()[palayerID - 1].setPlayerId(palayerID);

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

//		if(Client.game.getPlayerYou().getColor() == color) {
//			if(numberOnDice > 6) {
//				//klikni na kockicu
//			}
//			else {
//				//setuj kockicu na broj
//				switch(numberOnDice) {
//				case 1:
//					//slike 
//					break;
//				case 2:
//					break;
//				case 3:
//					break;
//				case 4:
//					break;
//				case 5:
//					break;
//				case 6:
//					break;
//				default:
//					break;
//				}
//			}
//		}
		// else {
		// setuj kockicu koja nije tvoje, pre toga proveri da je manje od 6
		// }

	}

}
