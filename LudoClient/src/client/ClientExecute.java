package client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ClientExecute {
	
	private static int sendingCode = CommandC.NOTHING_TO_DO;
	
	private static DataOutputStream dataOut = null;
	private static PrintStream textOut = null;
	private static int click;
	
	
	void clientExecutes() throws IOException, InterruptedException {
		
		try {
			
			dataOut = new DataOutputStream(Client.getSocket().getOutputStream());
			textOut = new PrintStream(Client.getSocket().getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * 	stalno saljemo poruke serveru
		 */
		
		while(!GameC.isEndOfGame()) {
			
			// dodajemo while koji se vrti sve svreme dok se ne klikne na bilo koji gui
			Thread.sleep(200);
			//ovde umesto uspavljivanja treba staviti neku cekajucu metodu
			
			if(sendingCode != CommandC.NOTHING_TO_DO) {
				
				switch(sendingCode) {
				
				case CommandC.THROW_DICE:
					dataOut.writeInt(CommandC.THROW_DICE);
					sendingCode = CommandC.NOTHING_TO_DO;
					break;
					
				case CommandC.CREATE_ROOM:
					dataOut.writeInt(CommandC.CREATE_ROOM);
					sendingCode = CommandC.NOTHING_TO_DO;
					break;
					
				case CommandC.GO_START:
					dataOut.writeInt(CommandC.GO_START);
					dataOut.writeInt(GameC.getRoomID());
					sendingCode = CommandC.NOTHING_TO_DO;
					break;
					
				case CommandC.SEND_COLOR:
					dataOut.writeInt(CommandC.SEND_COLOR);
					dataOut.writeInt(GameC.getRoomID());
					dataOut.writeInt(Client.game.getPlayerYou().getPlayerId());
					dataOut.writeInt(Client.ludoMain.getSelectedColor());
					sendingCode = CommandC.NOTHING_TO_DO;
					break;
					
					
				default:
					sendingCode = CommandC.NOTHING_TO_DO;
					break;
				
				
				
				
				
				
				
				}
		
			}
		}
	}
	
	public static int getSendingCode() {
		return sendingCode;
	}

	public static void setSendingCode(int sendingCode) {
		ClientExecute.sendingCode = sendingCode;
	}

	
}
