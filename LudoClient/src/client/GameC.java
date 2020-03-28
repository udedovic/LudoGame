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
	
	FieldC[] fields = new FieldC[104];
	
	
	
	public void make_game() {
		
		
		PawnC pr1 = new PawnC(CommandC.RED, 1, 92, 835, 85);
		PawnC pr2 = new PawnC(CommandC.RED, 2, 93, 933, 85);
		PawnC pr3 = new PawnC(CommandC.RED, 3, 94, 835, 173);
		PawnC pr4 = new PawnC(CommandC.RED, 4, 95, 933, 173);
		
		PawnC pb1 = new PawnC(CommandC.BLUE, 1, 96, 372, 550);
		PawnC pb2 = new PawnC(CommandC.BLUE, 2, 97, 470, 550);
		PawnC pb3 = new PawnC(CommandC.BLUE, 3, 98, 372, 635);
		PawnC pb4 = new PawnC(CommandC.BLUE, 4, 99, 470, 635);
		
		PawnC pg1 = new PawnC(CommandC.GREEN, 1, 100, 835, 550);
		PawnC pg2 = new PawnC(CommandC.GREEN, 2, 101, 933, 550);
		PawnC pg3 = new PawnC(CommandC.GREEN, 3, 102, 835, 635);
		PawnC pg4 = new PawnC(CommandC.GREEN, 4, 103, 933, 635);
		
		PawnC py1 = new PawnC(CommandC.YELLOW, 1, 88, 372, 85);
		PawnC py2 = new PawnC(CommandC.YELLOW, 2, 89, 470, 85);
		PawnC py3 = new PawnC(CommandC.YELLOW, 3, 90, 372, 173);
		PawnC py4 = new PawnC(CommandC.YELLOW, 4, 91, 470, 173);
		
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
		
		//	ovo su ulazi u cilj
		
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
		

		//	ovde su ciljevi
		//	za ciljeve sam stavljao kordinate za punu velicinu figure, figure treba da se promene na male tj 44x62
		
		// zuti
		FieldC f73 = new FieldC(72, true, false, true, CommandC.YELLOW, 597, 386);
		FieldC f74 = new FieldC(73, true, false, true, CommandC.YELLOW, 597, 371);
		FieldC f75 = new FieldC(74, true, false, true, CommandC.YELLOW, 597, 356);
		FieldC f76 = new FieldC(75, true, false, true, CommandC.YELLOW, 597, 341);
		
		
		// crveni
		FieldC f77 = new FieldC(76, true, false, true, CommandC.RED, 623, 305);
		FieldC f78 = new FieldC(77, true, false, true, CommandC.RED, 643, 305);
		FieldC f79 = new FieldC(78, true, false, true, CommandC.RED, 663, 305);
		FieldC f80 = new FieldC(79, true, false, true, CommandC.RED, 683, 305);
		
		// zeleni
		FieldC f81 = new FieldC(80, true, false, true, CommandC.BLUE, 707, 341);
		FieldC f82 = new FieldC(81, true, false, true, CommandC.BLUE, 707, 356);
		FieldC f83 = new FieldC(82, true, false, true, CommandC.BLUE, 707, 371);
		FieldC f84 = new FieldC(83, true, false, true, CommandC.BLUE, 707, 386);
		
		
		//	plavi
		FieldC f85 = new FieldC(84, true, false, true, CommandC.GREEN, 623, 417);
		FieldC f86 = new FieldC(85, true, false, true, CommandC.GREEN, 643, 417);
		FieldC f87 = new FieldC(86, true, false, true, CommandC.GREEN, 663, 417);
		FieldC f88 = new FieldC(87, true, false, true, CommandC.GREEN, 683, 417);
			
		
		// ovde pocinju baze
		// zuta
		FieldC f89 = new FieldC(88, true, true, false, CommandC.YELLOW, 372, 85);
		FieldC f90 = new FieldC(89, true, true, false, CommandC.YELLOW, 470, 85);
		FieldC f91 = new FieldC(90, true, true, false, CommandC.YELLOW, 372, 173);
		FieldC f92 = new FieldC(91, true, true, false, CommandC.YELLOW, 470, 173);
		
		// crvena
		FieldC f93 = new FieldC(92, true, true, false, CommandC.RED, 835, 85);
		FieldC f94 = new FieldC(93, true, true, false, CommandC.RED, 933, 85);
		FieldC f95 = new FieldC(94, true, true, false, CommandC.RED, 835, 173);
		FieldC f96 = new FieldC(95, true, true, false, CommandC.RED, 933, 173);
		
		//	plava
		FieldC f97 = new FieldC(96, true, true, false, CommandC.BLUE, 372, 550);
		FieldC f98 = new FieldC(97, true, true, false, CommandC.BLUE, 470, 550);
		FieldC f99 = new FieldC(98, true, true, false, CommandC.BLUE, 372, 635);
		FieldC f100 = new FieldC(99, true, true, false, CommandC.BLUE, 470, 635);
		
		// zelena
		FieldC f101 = new FieldC(100, true, true, false, CommandC.GREEN, 835, 550);
		FieldC f102 = new FieldC(101, true, true, false, CommandC.GREEN, 933, 550);
		FieldC f103 = new FieldC(102, true, true, false, CommandC.GREEN, 835, 635);
		FieldC f104 = new FieldC(103, true, true, false, CommandC.GREEN, 933, 635);
		
		fields[0] = f1;
		fields[1] = f2;
		fields[2] = f3;
		fields[3] = f4;
		fields[4] = f5;
		fields[5] = f6;
		fields[6] = f7;
		fields[7] = f8;
		fields[8] = f9;
		fields[9] = f10;
		fields[10] = f11;
		fields[11] = f12;
		fields[12] = f13;
		fields[13] = f14;
		fields[14] = f15;
		fields[15] = f16;
		fields[16] = f17;
		fields[17] = f18;
		fields[18] = f19;
		fields[19] = f20;
		fields[20] = f21;
		fields[21] = f22;
		fields[22] = f23;
		fields[23] = f24;
		fields[24] = f25;
		fields[25] = f26;
		fields[26] = f27;
		fields[27] = f28;
		fields[28] = f29;
		fields[29] = f30;
		fields[30] = f31;
		fields[31] = f32;
		fields[32] = f33;
		fields[33] = f34;
		fields[34] = f35;
		fields[35] = f36;
		fields[36] = f37;
		fields[37] = f38;
		fields[38] = f39;
		fields[39] = f40;
		fields[40] = f41;
		fields[41] = f42;
		fields[42] = f43;
		fields[43] = f44;
		fields[44] = f45;
		fields[45] = f46;
		fields[46] = f47;
		fields[47] = f48;
		fields[48] = f49;
		fields[49] = f50;
		fields[50] = f51;
		fields[51] = f52;
		fields[52] = f53;
		fields[53] = f54;
		fields[54] = f55;
		fields[55] = f56;
		fields[56] = f57;
		fields[57] = f58;
		fields[58] = f59;
		fields[59] = f60;
		fields[60] = f61;
		fields[61] = f62;
		fields[62] = f63;
		fields[63] = f64;
		fields[64] = f65;
		fields[65] = f66;
		fields[66] = f67;
		fields[67] = f68;
		fields[68] = f69;
		fields[69] = f70;
		fields[70] = f71;
		fields[71] = f72;
		fields[72] = f73;
		fields[73] = f74;
		fields[74] = f75;
		fields[75] = f79;
		fields[76] = f77;
		fields[77] = f78;
		fields[78] = f79;
		fields[79] = f80;
		fields[80] = f81;
		fields[81] = f82;
		fields[82] = f83;
		fields[83] = f84;
		fields[84] = f85;
		fields[85] = f86;
		fields[86] = f87;
		fields[87] = f88;
		fields[88] = f89;
		fields[89] = f90;
		fields[90] = f91;
		fields[91] = f92;
		fields[92] = f93;
		fields[93] = f94;
		fields[94] = f95;
		fields[95] = f96;
		fields[96] = f97;
		fields[97] = f98;
		fields[98] = f99;
		fields[99] = f100;
		fields[100] = f101;
		fields[101] = f102;
		fields[102] = f103;
		fields[103] = f104;

		
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
		return fields;
	}
	public void setFields(FieldC[] fields) {
		fields = fields;
	}
	
	

}
