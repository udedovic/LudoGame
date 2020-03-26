package client;

public class GameC {
	
	private static boolean endOfGame = false;	// ovi podaci na klijentu mogu da budu static jer se odnose na celu klasu
	private static int roomID = -1;	// ovi podaci na klijentu mogu da budu static jer se odnose na celu klasu
	private int numberOfPlayers;
	private int playersOnTurn; 	// playerID
	private float timeInLobby;
	private float timeInGame;
	
	private static PlayerC[] players = new PlayerC[3];
	FieldC[] Fields = new FieldC[91];
	
	
	
	public static boolean isEndOfGame() {
		return endOfGame;
	}

	public static void setEndOfGame(boolean endOfGame) {
		GameC.endOfGame = endOfGame;
	}

	public static int getRoomID() {
		return roomID;
	}

	public static void setRoomID(int roomID) {
		GameC.roomID = roomID;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public int getPlayersOnTurn() {
		return playersOnTurn;
	}
	
	public void setPlayersOnTurn(int playersOnTurn) {
		this.playersOnTurn = playersOnTurn;
	}
	
	public float getTimeInLobby() {
		return timeInLobby;
	}
	
	public void setTimeInLobby(float timeInLobby) {
		this.timeInLobby = timeInLobby;
	}
	
	public float getTimeInGame() {
		return timeInGame;
	}
	
	public void setTimeInGame(float timeInGame) {
		this.timeInGame = timeInGame;
	}
	
	public static PlayerC[] getPlayers() {
		return players;
	}
	
	public static void setPlayers(PlayerC[] players) {
		GameC.players = players;
	}
	
	public FieldC[] getFields() {
		return Fields;
	}
	
	public void setFields(FieldC[] fields) {
		Fields = fields;
	}
	
	

}
