package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class RunExecutes {
	
	private static DataInputStream dataIn = null;
	private static BufferedReader textIn = null;
	
	private int receivedCode = CommandC.NOTHING_TO_DO;
	private int dataInteger;
	private String dataText = null;
	
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
			
			while (dataIn.available() == 0);
			receivedCode = dataIn.readInt();
			System.out.println("proba");
			
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
				
			default:
				receivedCode = CommandC.NOTHING_TO_DO;
				break;
				
				
			}
			
			
		}
	}
	
	
	private void go_start() throws IOException {
		
		while (dataIn.available() == 0);
		int palayerID = dataIn.readInt();
		
		//	sstigo sam dovde 26.3.
		// mozda treba reorganizacija klijent strane jer mi ne trebaju tolike informacije o drugim klijentima
		// kada treba nesto da se pomera na talonu server me obavestava o tomedd
		// ne treba da se sve te info prukupljaju kod mene
		// meni su potrebne samo striktne info o meni
		
		
		
		
		
	}


	/*
	 * 	sve greske prvo salju error kod, a drugi kod se gleda u ovom svicu i na osnovu njega izlai poruka
	 * 
	 */
	private void error() throws IOException {
		
		while (dataIn.available() == 0);
		dataInteger = dataIn.readInt();
		
		switch(dataInteger) {
		
		case CommandC.ERROR_ROOM:
			 JOptionPane.showMessageDialog(new JFrame(), "Room error", "Error", JOptionPane.ERROR_MESSAGE);
			 break;
			
		default:
			break;
		
		
		
		}
		
		
	}

	/*
	 * 	citam sa servera roomID, upisujem ga objekat game na klijentu
	 */
	private void create_room() throws IOException {
		
		while (dataIn.available() == 0);
		dataInteger = dataIn.readInt();
		
		GameC.setRoomID(dataInteger);
		
		JOptionPane.showMessageDialog(new JFrame(),
				"You have successfully created room number: " + GameC.getRoomID(), "Room created",
				JOptionPane.INFORMATION_MESSAGE);
		
		LudoStart.textRoom.setText(String.valueOf(GameC.getRoomID()));
		
		
	}

	private void throw_dice() throws IOException {
		while (dataIn.available() == 0);
		dataInteger = dataIn.readInt();
		System.out.println(dataInteger);	// ovo se brise
		
	}
	
	
}

	
