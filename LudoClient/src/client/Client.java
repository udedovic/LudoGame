package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client implements Runnable {
	
	/*
	 * 	obavezno proveri da li sam sve nizove dobro inicijalizovao jer sam svuda oduzimao 1
	 */
	

	private static Socket socket;
	private static String address = "localhost";
	
	private static boolean wait = true; // setuje se na true u ludoStart


	static LudoStart ludoStart = new LudoStart();
	static LudoMain ludoMain = new LudoMain();
	static LudoGame ludoGame = new LudoGame();
	
	static GameC game = new GameC();
	
	
	/*
	 *	Ovde dodavaj sve atribute 
	 */
	
	public static Socket getSocket() {
		return socket;
	}

	public static void setSocket(Socket socket) {
		Client.socket = socket;
	}

	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		Client.address = address;
	}
	
	/*
	 * 	main i run se paralelno izvrsavaju
	 */
	
	
	public static void main(String[] args) {
		
		int port = 9000;
		
			try {
				
				game.make_game(); // pravimo pijune i grace
				System.out.println(game.getPlayerRed().getPawns()[0].getCoordinatePawn_x());
				System.out.println(game.getPlayerRed().getPawns()[0].getColor());
				
				ludoStart.setVisible(true);	// pokrecemo gui
				
				while(wait) {
					Thread.sleep(200);
				}
					
					
					socket = new Socket(address, port);
					
					new Thread(new Client()).start();
					
					ClientExecute clientExecutes = new ClientExecute();
					clientExecutes.clientExecutes(); // saljemo sve vreme serveru

				
				socket.close();
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void run() {
		
		RunExecutes runExecutes = new RunExecutes();
		
		try {
			
			runExecutes.runExecutes();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //	stalno primamo poruke od servera
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static boolean isWait() {
		return wait;
	}

	public static void setWait(boolean wait) {
		Client.wait = wait;
	}
	

}
