package client;


public class GameC {
	
	private static boolean endOfGame = false;	// ovi podaci na klijentu mogu da budu static jer se odnose na celu klasu
												// stavlja se na true kada se udje u ludoGame, onaj ko ima player id 1 ima pravo da pokrene ovo
												// ili se automatski pokrece kada svi kliknu play
	private static int roomID = -1;	// ovi podaci na klijentu mogu da budu static jer se odnose na celu klasu
	private int numberOfPlayers;
	private int playersOnTurn; 	// playerID
	private float timeInGame;
	
	private PlayerC playerYou = new PlayerC();
	private PlayerC playerRed= new PlayerC();
	private PlayerC playerBlue = new PlayerC();
	private PlayerC playerGreen = new PlayerC();
	private PlayerC playerYellow = new PlayerC();
	
	FieldC[] Fields = new FieldC[91];
	
	PawnC pr1 = new PawnC(CommandC.RED, 1, 81, 835, 55);
	PawnC pr2 = new PawnC(CommandC.RED, 2, 82, 933, 55);
	PawnC pr3 = new PawnC(CommandC.RED, 3, 83, 835, 143);
	PawnC pr4 = new PawnC(CommandC.RED, 4, 84, 933, 143);
	
	PawnC pb1 = new PawnC(CommandC.BLUE, 1, 85, 372, 520);
	PawnC pb2 = new PawnC(CommandC.BLUE, 2, 86, 470, 520);
	PawnC pb3 = new PawnC(CommandC.BLUE, 3, 87, 372, 605);
	PawnC pb4 = new PawnC(CommandC.BLUE, 4, 88, 470, 605);
	
	PawnC pg1 = new PawnC(CommandC.GREEN, 1, 89, 835, 520);
	PawnC pg2 = new PawnC(CommandC.GREEN, 2, 90, 933, 520);
	PawnC pg3 = new PawnC(CommandC.GREEN, 3, 91, 835, 605);
	PawnC pg4 = new PawnC(CommandC.GREEN, 4, 92, 933, 605);
	
	PawnC py1 = new PawnC(CommandC.YELLOW, 1, 77, 372, 55);
	PawnC py2 = new PawnC(CommandC.YELLOW, 2, 78, 470, 55);
	PawnC py3 = new PawnC(CommandC.YELLOW, 3, 79, 372, 143);
	PawnC py4 = new PawnC(CommandC.YELLOW, 4, 80, 470, 143);
	
	public void make_game() {
		
		playerRed.getPawns()[0] = pr1;
		playerRed.getPawns()[1] = pr2;
		playerRed.getPawns()[2] = pr3;
		playerRed.getPawns()[3] = pr4;
		
		playerBlue.getPawns()[0] = pb1;
		playerBlue.getPawns()[1] = pb2;
		playerBlue.getPawns()[2] = pb3;
		playerBlue.getPawns()[3] = pb4;
		
		playerGreen.getPawns()[0] = pg1;
		playerGreen.getPawns()[1] = pg2;
		playerGreen.getPawns()[2] = pg3;
		playerGreen.getPawns()[3] = pg4;
		
		playerYellow.getPawns()[0] = py1;
		playerYellow.getPawns()[1] = py2;
		playerYellow.getPawns()[2] = py3;
		playerYellow.getPawns()[3] = py4;
		
		/*
		 * 	ovde dalje cemo praviti i polja
		 */
		
	}
	
	
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
	public float getTimeInGame() {
		return timeInGame;
	}
	public void setTimeInGame(float timeInGame) {
		this.timeInGame = timeInGame;
	}
	public PlayerC getPlayerYou() {
		return playerYou;
	}
	public void setPlayerYou(PlayerC playerYou) {
		this.playerYou = playerYou;
	}
	public PlayerC getPlayerRed() {
		return playerRed;
	}
	public void setPlayerRed(PlayerC playerRed) {
		this.playerRed = playerRed;
	}
	public PlayerC getPlayerBlue() {
		return playerBlue;
	}
	public void setPlayerBlue(PlayerC playerBlue) {
		this.playerBlue = playerBlue;
	}
	public PlayerC getPlayerGreen() {
		return playerGreen;
	}
	public void setPlayerGreen(PlayerC playerGreen) {
		this.playerGreen = playerGreen;
	}
	public PlayerC getPlayerYellow() {
		return playerYellow;
	}
	public void setPlayerYellow(PlayerC playerYellow) {
		this.playerYellow = playerYellow;
	}
	public FieldC[] getFields() {
		return Fields;
	}
	public void setFields(FieldC[] fields) {
		Fields = fields;
	}
	
	

}
