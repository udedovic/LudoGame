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

	private DataOutputStream dataOut = null;
	private PrintStream textOut = null;
	private static int pawnIndex;

	public static int getPawnIndex() {
		return pawnIndex;
	}

	public static void setPawnIndex(int pawnIndex) {
		ClientExecute.pawnIndex = pawnIndex;
	}

	void clientExecutes() throws IOException, InterruptedException {

		try {

			dataOut = new DataOutputStream(Client.getSocket().getOutputStream());
			textOut = new PrintStream(Client.getSocket().getOutputStream());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * stalno saljemo poruke serveru
		 */

		while (!GameC.isEndOfGame()) {

			// dodajemo while koji se vrti sve svreme dok se ne klikne na bilo koji gui
			Thread.sleep(10);
			// ovde umesto uspavljivanja treba staviti neku cekajucu metodu

			if (sendingCode != CommandC.NOTHING_TO_DO) {

				switch (sendingCode) {

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
					if (RunExecutes.isColorIsSelected() == false) {
						dataOut.writeInt(CommandC.SEND_COLOR);
						dataOut.writeInt(GameC.getRoomID());
						dataOut.writeInt(GameC.getYouPlayerID());
						dataOut.writeInt(Client.ludoMain.getSelectedColor());
					}
					sendingCode = CommandC.NOTHING_TO_DO;
					break;

				case CommandC.PLAY:
					dataOut.writeInt(CommandC.PLAY);
					dataOut.writeInt(GameC.getRoomID());
					dataOut.writeInt(GameC.getYouPlayerID());
					textOut.println(Client.game.getPlayers()[GameC.getYouPlayerID() - 1].getName());
					// textOut.flush();
					sendingCode = CommandC.NOTHING_TO_DO;
					break;
					
				case CommandC.MOVE:
					dataOut.writeInt(CommandC.MOVE);
					dataOut.writeInt(Client.game.getDiceNumber());
					dataOut.writeInt(pawnIndex);
					sendingCode = CommandC.NOTHING_TO_DO;
					break;
					
				case CommandC.END_OF_MOVE:
					System.out.println("evo me bato");
					dataOut.writeInt(CommandC.END_OF_MOVE);
//					dataOut.writeInt(Client.game.getPlayersOnTurn());
					Thread.sleep(3000);
					dataOut.writeInt(CommandC.THROW_DICE);
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
