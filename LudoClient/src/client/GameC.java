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
	
	
	
	public void make_game() {
		
		PawnC pr1 = new PawnC(CommandC.RED, 1, 81, 835, 85);
		PawnC pr2 = new PawnC(CommandC.RED, 2, 82, 933, 85);
		PawnC pr3 = new PawnC(CommandC.RED, 3, 83, 835, 173);
		PawnC pr4 = new PawnC(CommandC.RED, 4, 84, 933, 173);
		
		PawnC pb1 = new PawnC(CommandC.BLUE, 1, 85, 372, 550);
		PawnC pb2 = new PawnC(CommandC.BLUE, 2, 86, 470, 550);
		PawnC pb3 = new PawnC(CommandC.BLUE, 3, 87, 372, 635);
		PawnC pb4 = new PawnC(CommandC.BLUE, 4, 88, 470, 635);
		
		PawnC pg1 = new PawnC(CommandC.GREEN, 1, 89, 835, 550);
		PawnC pg2 = new PawnC(CommandC.GREEN, 2, 90, 933, 550);
		PawnC pg3 = new PawnC(CommandC.GREEN, 3, 91, 835, 635);
		PawnC pg4 = new PawnC(CommandC.GREEN, 4, 92, 933, 635);
		
		PawnC py1 = new PawnC(CommandC.YELLOW, 1, 77, 372, 85);
		PawnC py2 = new PawnC(CommandC.YELLOW, 2, 78, 470, 85);
		PawnC py3 = new PawnC(CommandC.YELLOW, 3, 79, 372, 173);
		PawnC py4 = new PawnC(CommandC.YELLOW, 4, 80, 470, 173);
		
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
		
		// treba dodati unutra atribut isGoal
		
		FieldC f1 = new FieldC(0, true, false, false, CommandC.YELLOW, 295, 310);
		FieldC f2 = new FieldC(1, false, false, false, -1, 346, 310);
		FieldC f3 = new FieldC(2, false, false, false, -1, 397, 310);
		FieldC f4 = new FieldC(3, false, false, false, -1, 448, 310);
		FieldC f5 = new FieldC(4, false, false, false, -1, 499, 310);
		FieldC f6 = new FieldC(5, false, false, false, -1, 550, 310);
		
		FieldC f7 = new FieldC(6, false, false, false, -1, 601, 260);
		FieldC f8 = new FieldC(7, false, false, false, -1, 601, 209);
		FieldC f9 = new FieldC(8, false, false, false, -1, 601, 158);
		FieldC f10 = new FieldC(9, false, false, false, -1, 601, 107);
		FieldC f11 = new FieldC(10, false, false, false, -1, 601, 56);
		FieldC f12 = new FieldC(11, false, false, false, -1, 601, 5);
		
		FieldC f13 = new FieldC(12, false, false, false, -1, 652, 5);
		
		FieldC f14 = new FieldC(13, true, false, false, CommandC.RED, 703, 5);
		FieldC f15 = new FieldC(14, false, false, false, -1, 703, 56);
		FieldC f16 = new FieldC(15, false, false, false, -1, 703, 107);
		FieldC f17 = new FieldC(16, false, false, false, -1, 703, 158);
		FieldC f18 = new FieldC(17, false, false, false, -1, 703, 209);
		FieldC f19 = new FieldC(18, false, false, false, -1, 703, 260);
		
		FieldC f20 = new FieldC(19, false, false, false, -1, 754, 310);
		FieldC f21 = new FieldC(20, false, false, false, -1, 805, 310);
		FieldC f22 = new FieldC(21, false, false, false, -1, 856, 310);
		FieldC f23 = new FieldC(22, false, false, false, -1, 907, 310);
		FieldC f24 = new FieldC(23, false, false, false, -1, 958, 310);
		FieldC f25 = new FieldC(24, false, false, false, -1, 1009, 310);
		
		FieldC f26 = new FieldC(25, false, false, false, -1, 1009, 361);
		
		FieldC f27 = new FieldC(26, true, false, false, -1, 1009, 414);
		FieldC f28 = new FieldC(27, false, false, false, -1, 958, 414);
		FieldC f29 = new FieldC(28, false, false, false, -1, 907, 414);
		FieldC f30 = new FieldC(29, false, false, false, -1, 856, 414);
		FieldC f31 = new FieldC(30, false, false, false, -1, 805, 414);
		FieldC f32 = new FieldC(31, false, false, false, -1, 754, 414);
		
		FieldC f33 = new FieldC(32, false, false, false, -1, 703, 465);
		FieldC f34 = new FieldC(33, false, false, false, -1, 703, 516);
		FieldC f35 = new FieldC(34, false, false, false, -1, 703, 567);
		FieldC f36 = new FieldC(35, false, false, false, -1, 703, 618);
		FieldC f37 = new FieldC(36, false, false, false, -1, 703, 669);
		FieldC f38 = new FieldC(37, false, false, false, -1, 703, 720);
		
		FieldC f39 = new FieldC(38, false, false, false, -1, 652, 720);
		
		FieldC f40 = new FieldC(39, true, false, false, CommandC.BLUE, 601, 720);
		FieldC f41 = new FieldC(40, false, false, false, -1, 601, 669);
		FieldC f42 = new FieldC(41, false, false, false, -1, 601, 618);
		FieldC f43 = new FieldC(42, false, false, false, -1, 601, 567);
		FieldC f44 = new FieldC(43, false, false, false, -1, 601, 516);
		FieldC f45 = new FieldC(44, false, false, false, -1, 601, 465);
		
		FieldC f46 = new FieldC(45, false, false, false, -1, 550, 414);
		FieldC f47 = new FieldC(46, false, false, false, -1, 499, 414);
		FieldC f48 = new FieldC(47, false, false, false, -1, 448, 414);
		FieldC f49 = new FieldC(48, false, false, false, -1, 397, 414);
		FieldC f50 = new FieldC(49, false, false, false, -1, 346, 414);
		FieldC f51 = new FieldC(50, false, false, false, -1, 295, 414);
		
		FieldC f52 = new FieldC(51, false, false, false, -1, 295, 361);
		
		// ovde se zavrsavaju polja za hod
		
		FieldC f53 = new FieldC(52, true, false, false, CommandC.YELLOW, 346, 361);
		FieldC f54 = new FieldC(53, true, false, false, CommandC.YELLOW, 397, 361);
		FieldC f55 = new FieldC(54, true, false, false, CommandC.YELLOW, 448, 361);
		FieldC f56 = new FieldC(55, true, false, false, CommandC.YELLOW, 499, 361);
		FieldC f57 = new FieldC(56, true, false, false, CommandC.YELLOW, 550, 361);
		
		FieldC f58 = new FieldC(57, true, false, false, CommandC.RED, 652, 56);
		FieldC f59 = new FieldC(58, true, false, false, CommandC.RED, 652, 107);
		FieldC f60 = new FieldC(59, true, false, false, CommandC.RED, 652, 158);
		FieldC f61 = new FieldC(60, true, false, false, CommandC.RED, 652, 209);
		FieldC f62 = new FieldC(61, true, false, false, CommandC.RED, 652, 260);
		
		FieldC f63 = new FieldC(62, true, false, false, CommandC.GREEN, 958, 361);
		FieldC f64 = new FieldC(63, true, false, false, CommandC.GREEN, 907, 361);
		FieldC f65 = new FieldC(64, true, false, false, CommandC.GREEN, 856, 361);
		FieldC f66 = new FieldC(65, true, false, false, CommandC.GREEN, 805, 361);
		FieldC f67 = new FieldC(66, true, false, false, CommandC.GREEN, 754, 361);
		
		FieldC f68 = new FieldC(67, true, false, false, CommandC.BLUE, 669, 310);
		FieldC f69 = new FieldC(68, true, false, false, CommandC.BLUE, 618, 310);
		FieldC f70 = new FieldC(69, true, false, false, CommandC.BLUE, 567, 310);
		FieldC f71 = new FieldC(70, true, false, false, CommandC.BLUE, 516, 310);
		FieldC f72 = new FieldC(71, true, false, false, CommandC.BLUE, 465, 310);
		
		// gore je gotovo ali prover
		
		//FieldC a = new FieldC(index, isSafe, isBase, isGoal, colour, coordinate_x, coordinate_y)
		
		//	ovde su ciljevi
		//	za ciljeve sam stavljao kordinate za punu velicinu figure, figure treba da se promene na male tj 44x62
		
		// zuti
		FieldC f73 = new FieldC(72, true, false, true, CommandC.YELLOW, 601, 310);
		FieldC f74 = new FieldC(73, true, false, true, CommandC.YELLOW, 601, 310);
		FieldC f75 = new FieldC(74, true, false, true, CommandC.YELLOW, 601, 310);
		FieldC f76 = new FieldC(75, true, false, true, CommandC.YELLOW, 601, 310);
		
		
		// crveni
		FieldC f77 = new FieldC(76, true, false, true, CommandC.YELLOW, 295, 310);
		FieldC f78 = new FieldC(77, true, false, true, CommandC.YELLOW, 295, 310);
		FieldC f79 = new FieldC(78, true, false, true, CommandC.YELLOW, 295, 310);
		FieldC f80 = new FieldC(79, true, false, true, CommandC.YELLOW, 295, 310);
		
		// zeleni
		FieldC f81 = new FieldC(80, true, false, true, CommandC.YELLOW, 295, 310);
		FieldC f82 = new FieldC(81, true, false, true, CommandC.YELLOW, 295, 310);
		FieldC f83 = new FieldC(82, true, false, true, CommandC.YELLOW, 295, 310);
		FieldC f84 = new FieldC(83, true, false, true, CommandC.YELLOW, 295, 310);
		
		
		//	plavi
		FieldC f85 = new FieldC(84, true, false, true, CommandC.YELLOW, 295, 310);
		FieldC f86 = new FieldC(85, true, false, true, CommandC.YELLOW, 295, 310);
		FieldC f87 = new FieldC(86, true, false, true, CommandC.YELLOW, 295, 310);
		FieldC f88 = new FieldC(87, true, false, true, CommandC.YELLOW, 295, 310);
		
		// ovde pocinju baze
		// zuta
		FieldC f89 = new FieldC(88, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f90 = new FieldC(89, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f91 = new FieldC(90, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f92 = new FieldC(91, true, true, false, CommandC.YELLOW, 295, 310);
		
		// crvena
		FieldC f93 = new FieldC(92, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f94 = new FieldC(93, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f95 = new FieldC(94, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f96 = new FieldC(95, true, true, false, CommandC.YELLOW, 295, 310);
		
		//	plava
		FieldC f97 = new FieldC(96, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f98 = new FieldC(97, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f99 = new FieldC(98, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f100 = new FieldC(99, true, true, false, CommandC.YELLOW, 295, 310);
		
		// zelena
		FieldC f101 = new FieldC(100, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f102 = new FieldC(101, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f103 = new FieldC(102, true, true, false, CommandC.YELLOW, 295, 310);
		FieldC f104 = new FieldC(103, true, true, false, CommandC.YELLOW, 295, 310);
		
		
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
