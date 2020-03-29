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
		 * 	stalno primamo poruke od servera
		 */
		
		while(!GameC.isEndOfGame()) {
			
			while (dataIn.available() == 0) {
				Thread.sleep(10);
			}
			receivedCode = dataIn.readInt();
			System.out.println("primio odgovor - klijent");
			
			switch(receivedCode) {
			
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
		
		//	ako je 1 onda je jedan novi spreman, ako je 2 onda su svi spremni
		if(code == 1) {
			// na osnovu boje menja se ikonica onih koji su spremni
			switch(color) {
			
			case CommandC.RED:
				Client.ludoMain.getLblPawnRed().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedEdge.png")));
				break;
				
			case CommandC.BLUE:
				Client.ludoMain.getLblPawnBlue().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueEdge.png")));
				break;
				
			case CommandC.GREEN:
				Client.ludoMain.getLblPawnGreen().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenEdge.png")));
				break;

			case CommandC.YELLOW:
				Client.ludoMain.getLblPawnYellow().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowEdge.png")));
				break;

			default:
				break;
			
			}
		}
		if(codeAll == 2) {
			
			
			/*
			 * 	ovde ima dosta setovanjza za novu igru
			 */
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
		
		if(palayerID == Client.game.getPlayerYou().getPlayerId()) {
			// setujem da sam ja uzeo boju
			// za sada ce izgledati isto jer treba ubaciti nove ikonice za te slucajeve
			
			Client.game.getPlayerYou().setColor(colour);
			colorIsSelected = true;
			
			
			switch(colour) {
			
			case CommandC.RED:
				Client.ludoMain.getLblPawnRed().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedEdge.png")));
				break;
				
			case CommandC.BLUE:
				Client.ludoMain.getLblPawnBlue().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueEdge.png")));
				break;
				
			case CommandC.GREEN:
				Client.ludoMain.getLblPawnGreen().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenEdge.png")));
				break;

			case CommandC.YELLOW:
				Client.ludoMain.getLblPawnYellow().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowEdge.png")));
				break;

			default:
				break;
			
			}
				
		} else {
			// kad drugi uzmu boju
			// za sada ce izgledati isto jer treba ubaciti nove ikonice za te slucajeve
			
			switch(colour) {
			
			case CommandC.RED:
					Client.ludoMain.getLblPawnRed().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedEdge.png")));
				break;
				
			case CommandC.BLUE:
				Client.ludoMain.getLblPawnBlue().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueEdge.png")));
				break;
				
			case CommandC.GREEN:
				Client.ludoMain.getLblPawnGreen().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenEdge.png")));
				break;

			case CommandC.YELLOW:
				Client.ludoMain.getLblPawnYellow().setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowEdge.png")));
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
		
		//	sstigo sam dovde 26.3.
		// mozda treba reorganizacija klijent strane jer mi ne trebaju tolike informacije o drugim klijentima
		// kada treba nesto da se pomera na talonu server me obavestava o tomedd
		// ne treba da se sve te info prukupljaju kod mene
		// meni su potrebne samo striktne info o meni
		
		Client.game.getPlayerYou().setPlayerId(palayerID);
		
		if(palayerID == 1) {
			Client.game.setPlayersOnTurn(palayerID);
			Client.game.getPlayerYou().setOnTurn(true);
		}
		
		Client.ludoStart.setVisible(false);
		Client.ludoMain.setVisible(true);
		
	}


	/*
	 * 	sve greske prvo salju error kod, a drugi kod se gleda u ovom svicu i na osnovu njega izlai poruka
	 * 
	 */
	private void error() throws IOException, InterruptedException {
		
		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		dataInteger = dataIn.readInt();
		
		switch(dataInteger) {
		
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
	 * 	citam sa servera roomID, upisujem ga objekat game na klijentu
	 */
	private void create_room() throws IOException, InterruptedException {
		
		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		dataInteger = dataIn.readInt();
		
		GameC.setRoomID(dataInteger);
		
		JOptionPane.showMessageDialog(new JFrame(),
				"You have successfully created room number: " + GameC.getRoomID(), "Room created",
				JOptionPane.INFORMATION_MESSAGE);
		
		LudoStart.textRoom.setText(String.valueOf(GameC.getRoomID()));
		
		
	}

	private void throw_dice() throws IOException, InterruptedException {
		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		dataInteger = dataIn.readInt();
		System.out.println(dataInteger);	// ovo se brise
		
	}
	
	
}

	
