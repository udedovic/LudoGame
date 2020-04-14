package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	static ServerThread clients[] = new ServerThread[40]; // 10 igara max

	static GameS[] games = new GameS[10];

	public static void main(String[] args) {

		int port = 9000;
		Socket clientSocket = null;

		/*
		 * pravimo objekte klase GameS u niz
		 */
		for (int i = 0; i < 10; i++) {
			games[i] = new GameS();
		}

		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {

				clientSocket = serverSocket.accept();

				for (int i = 0; i <= 39; i++) {
					if (clients[i] == null) {
						clients[i] = new ServerThread(clientSocket, clients);
						clients[i].start();
						break;
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
