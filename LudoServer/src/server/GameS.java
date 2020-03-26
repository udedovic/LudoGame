package server;


public class GameS {
	
	private boolean endOfGame = false;	// ovo ne sme da bude static kao na klijentu
	private int roomID = -1;	// ovo ne sme da bude static kao na klijentu; setovano je na -1 jer to nikada nije room
	private int numberOfPlayers = 0;
	private int playersOnTurn; 	// playerID
	private float timeInLobby;
	private float timeInGame;
	
	PlayerS[] players = new PlayerS[3];
	FieldS[] Fields = new FieldS[91];
	

	public boolean isEndOfGame() {
		return endOfGame;
	}
	
	public void setEndOfGame(boolean endOfGame) {
		this.endOfGame = endOfGame;
	}
	
	public int getRoomID() {
		return roomID;
	}
	
	public void setRoomID(int roomID) {
		this.roomID = roomID;
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
	
	public FieldS[] getFields() {
		return Fields;
	}
	
	public void setFields(FieldS[] fields) {
		Fields = fields;
	}
	
}
