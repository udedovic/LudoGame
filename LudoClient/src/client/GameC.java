package client;


public class GameC {

	private static boolean endOfGame = false; // ovi podaci na klijentu mogu da budu static jer se odnose na celu klasu
												// stavlja se na true kada se udje u ludoGame, onaj ko ima player id 1
												// ima pravo da pokrene ovo
												// ili se automatski pokrece kada svi kliknu play
	private static int roomID = -1; // ovi podaci na klijentu mogu da budu static jer se odnose na celu klasu
	private static int youPlayerID = -1;
	private int numberOfPlayers;
	private int playersOnTurn; // playerID
	private float timeInGame;

//	private PlayerC playerYou = new PlayerC();
//	private PlayerC playerRed = new PlayerC();
//	private PlayerC playerBlue = new PlayerC();
//	private PlayerC playerGreen = new PlayerC();
//	private PlayerC playerYellow = new PlayerC();

	FieldC[] fields = new FieldC[104];
	PlayerC[] players = new PlayerC[4];
	
	public void make_red_pawns(int playerID) {
		
		PawnC p1 = new PawnC(CommandC.RED, 1, 92, 805, 85);
		PawnC p2 = new PawnC(CommandC.RED, 2, 93, 903, 85);
		PawnC p3 = new PawnC(CommandC.RED, 3, 94, 805, 173);
		PawnC p4 = new PawnC(CommandC.RED, 4, 95, 903, 173);
		
		players[playerID - 1].getPawns()[0] = p1;
		players[playerID - 1].getPawns()[1] = p2;
		players[playerID - 1].getPawns()[2] = p3;
		players[playerID - 1].getPawns()[3] = p4;
		
	}
	
	public void make_blue_pawns(int playerID) {
		
		PawnC p1 = new PawnC(CommandC.BLUE, 1, 96, 342, 550);
		PawnC p2 = new PawnC(CommandC.BLUE, 2, 97, 440, 550);
		PawnC p3 = new PawnC(CommandC.BLUE, 3, 98, 342, 635);
		PawnC p4 = new PawnC(CommandC.BLUE, 4, 99, 440, 635);
		
		players[playerID - 1].getPawns()[0] = p1;
		players[playerID - 1].getPawns()[1] = p2;
		players[playerID - 1].getPawns()[2] = p3;
		players[playerID - 1].getPawns()[3] = p4;
		
	}
	
	public void make_green_pawns(int playerID) {
		
		PawnC p1 = new PawnC(CommandC.GREEN, 1, 100, 805, 550);
		PawnC p2 = new PawnC(CommandC.GREEN, 2, 101, 903, 550);
		PawnC p3 = new PawnC(CommandC.GREEN, 3, 102, 805, 635);
		PawnC p4 = new PawnC(CommandC.GREEN, 4, 103, 903, 635);
		
		players[playerID - 1].getPawns()[0] = p1;
		players[playerID - 1].getPawns()[1] = p2;
		players[playerID - 1].getPawns()[2] = p3;
		players[playerID - 1].getPawns()[3] = p4;
		
	}
	
	public void make_yelow_pawns(int playerID) {
		
		PawnC p1 = new PawnC(CommandC.YELLOW, 1, 88, 342, 85);
		PawnC p2 = new PawnC(CommandC.YELLOW, 2, 89, 440, 85);
		PawnC p3 = new PawnC(CommandC.YELLOW, 3, 90, 342, 173);
		PawnC p4 = new PawnC(CommandC.YELLOW, 4, 91, 440, 173);
		
		players[playerID - 1].getPawns()[0] = p1;
		players[playerID - 1].getPawns()[1] = p2;
		players[playerID - 1].getPawns()[2] = p3;
		players[playerID - 1].getPawns()[3] = p4;
		
	}

	public void make_game() {
		
		PlayerC p1 = new PlayerC();
		PlayerC p2 = new PlayerC();
		PlayerC p3 = new PlayerC();
		PlayerC p4 = new PlayerC();
		
		// mecuju se index + 1 i player ID
		players[0] = p1;
		players[1] = p2;
		players[2] = p3;
		players[3] = p4;

		/*
		 * ovde dalje cemo praviti i polja
		 */

		FieldC f1 = new FieldC(0, true, false, false, CommandC.YELLOW, 265, 310);
		FieldC f2 = new FieldC(1, false, false, false, -1, 316, 310);
		FieldC f3 = new FieldC(2, false, false, false, -1, 367, 310);
		FieldC f4 = new FieldC(3, false, false, false, -1, 418, 310);
		FieldC f5 = new FieldC(4, false, false, false, -1, 469, 310);
		FieldC f6 = new FieldC(5, false, false, false, -1, 520, 310);

		FieldC f7 = new FieldC(6, false, false, false, -1, 571, 260);
		FieldC f8 = new FieldC(7, false, false, false, -1, 571, 209);
		FieldC f9 = new FieldC(8, false, false, false, -1, 571, 158);
		FieldC f10 = new FieldC(9, false, false, false, -1, 571, 107);
		FieldC f11 = new FieldC(10, false, false, false, -1, 571, 56);
		FieldC f12 = new FieldC(11, false, false, false, -1, 571, 5);

		FieldC f13 = new FieldC(12, false, false, false, -1, 622, 5);
		//
		FieldC f14 = new FieldC(13, true, false, false, CommandC.RED, 673, 5);
		FieldC f15 = new FieldC(14, false, false, false, -1, 673, 56);
		FieldC f16 = new FieldC(15, false, false, false, -1, 673, 107);
		FieldC f17 = new FieldC(16, false, false, false, -1, 673, 158);
		FieldC f18 = new FieldC(17, false, false, false, -1, 673, 209);
		FieldC f19 = new FieldC(18, false, false, false, -1, 673, 260);

		FieldC f20 = new FieldC(19, false, false, false, -1, 724, 310);
		FieldC f21 = new FieldC(20, false, false, false, -1, 775, 310);
		FieldC f22 = new FieldC(21, false, false, false, -1, 826, 310);
		FieldC f23 = new FieldC(22, false, false, false, -1, 877, 310);
		FieldC f24 = new FieldC(23, false, false, false, -1, 928, 310);
		FieldC f25 = new FieldC(24, false, false, false, -1, 979, 310);

		FieldC f26 = new FieldC(25, false, false, false, -1, 979, 361);

		FieldC f27 = new FieldC(26, true, false, false, -1, 979, 414);
		FieldC f28 = new FieldC(27, false, false, false, -1, 928, 414);
		FieldC f29 = new FieldC(28, false, false, false, -1, 877, 414);
		FieldC f30 = new FieldC(29, false, false, false, -1, 826, 414);
		FieldC f31 = new FieldC(30, false, false, false, -1, 775, 414);
		FieldC f32 = new FieldC(31, false, false, false, -1, 724, 414);

		FieldC f33 = new FieldC(32, false, false, false, -1, 673, 465);
		FieldC f34 = new FieldC(33, false, false, false, -1, 673, 516);
		FieldC f35 = new FieldC(34, false, false, false, -1, 673, 567);
		FieldC f36 = new FieldC(35, false, false, false, -1, 673, 618);
		FieldC f37 = new FieldC(36, false, false, false, -1, 673, 669);
		FieldC f38 = new FieldC(37, false, false, false, -1, 673, 720);

		FieldC f39 = new FieldC(38, false, false, false, -1, 622, 720);

		FieldC f40 = new FieldC(39, true, false, false, CommandC.BLUE, 571, 720);
		FieldC f41 = new FieldC(40, false, false, false, -1, 571, 669);
		FieldC f42 = new FieldC(41, false, false, false, -1, 571, 618);
		FieldC f43 = new FieldC(42, false, false, false, -1, 571, 567);
		FieldC f44 = new FieldC(43, false, false, false, -1, 571, 516);
		FieldC f45 = new FieldC(44, false, false, false, -1, 571, 465);

		FieldC f46 = new FieldC(45, false, false, false, -1, 520, 414);
		FieldC f47 = new FieldC(46, false, false, false, -1, 469, 414);
		FieldC f48 = new FieldC(47, false, false, false, -1, 418, 414);
		FieldC f49 = new FieldC(48, false, false, false, -1, 367, 414);
		FieldC f50 = new FieldC(49, false, false, false, -1, 316, 414);
		FieldC f51 = new FieldC(50, false, false, false, -1, 265, 414);

		FieldC f52 = new FieldC(51, false, false, false, -1, 265, 361);

		// ovde se zavrsavaju polja za hod

		// ovo su ulazi u cilj

		FieldC f53 = new FieldC(52, true, false, false, CommandC.YELLOW, 316, 361);
		FieldC f54 = new FieldC(53, true, false, false, CommandC.YELLOW, 367, 361);
		FieldC f55 = new FieldC(54, true, false, false, CommandC.YELLOW, 418, 361);
		FieldC f56 = new FieldC(55, true, false, false, CommandC.YELLOW, 469, 361);
		FieldC f57 = new FieldC(56, true, false, false, CommandC.YELLOW, 520, 361);

		FieldC f58 = new FieldC(57, true, false, false, CommandC.RED, 622, 56);
		FieldC f59 = new FieldC(58, true, false, false, CommandC.RED, 622, 107);
		FieldC f60 = new FieldC(59, true, false, false, CommandC.RED, 622, 158);
		FieldC f61 = new FieldC(60, true, false, false, CommandC.RED, 622, 209);
		FieldC f62 = new FieldC(61, true, false, false, CommandC.RED, 622, 260);

		FieldC f63 = new FieldC(62, true, false, false, CommandC.GREEN, 928, 361);
		FieldC f64 = new FieldC(63, true, false, false, CommandC.GREEN, 877, 361);
		FieldC f65 = new FieldC(64, true, false, false, CommandC.GREEN, 826, 361);
		FieldC f66 = new FieldC(65, true, false, false, CommandC.GREEN, 775, 361);
		FieldC f67 = new FieldC(66, true, false, false, CommandC.GREEN, 724, 361);

		FieldC f68 = new FieldC(67, true, false, false, CommandC.BLUE, 639, 310);
		FieldC f69 = new FieldC(68, true, false, false, CommandC.BLUE, 588, 310);
		FieldC f70 = new FieldC(69, true, false, false, CommandC.BLUE, 537, 310);
		FieldC f71 = new FieldC(70, true, false, false, CommandC.BLUE, 486, 310);
		FieldC f72 = new FieldC(71, true, false, false, CommandC.BLUE, 435, 310);

		// ovde su ciljevi
		// za ciljeve sam stavljao kordinate za punu velicinu figure, figure treba da se
		// promene na male tj 44x62

		// zuti
		FieldC f73 = new FieldC(72, true, false, true, CommandC.YELLOW, 567, 386);
		FieldC f74 = new FieldC(73, true, false, true, CommandC.YELLOW, 567, 371);
		FieldC f75 = new FieldC(74, true, false, true, CommandC.YELLOW, 567, 356);
		FieldC f76 = new FieldC(75, true, false, true, CommandC.YELLOW, 567, 341);

		// crveni
		FieldC f77 = new FieldC(76, true, false, true, CommandC.RED, 593, 305);
		FieldC f78 = new FieldC(77, true, false, true, CommandC.RED, 613, 305);
		FieldC f79 = new FieldC(78, true, false, true, CommandC.RED, 633, 305);
		FieldC f80 = new FieldC(79, true, false, true, CommandC.RED, 653, 305);

		// zeleni
		FieldC f81 = new FieldC(80, true, false, true, CommandC.BLUE, 677, 341);
		FieldC f82 = new FieldC(81, true, false, true, CommandC.BLUE, 677, 356);
		FieldC f83 = new FieldC(82, true, false, true, CommandC.BLUE, 677, 371);
		FieldC f84 = new FieldC(83, true, false, true, CommandC.BLUE, 677, 386);

		// plavi
		FieldC f85 = new FieldC(84, true, false, true, CommandC.GREEN, 593, 417);
		FieldC f86 = new FieldC(85, true, false, true, CommandC.GREEN, 613, 417);
		FieldC f87 = new FieldC(86, true, false, true, CommandC.GREEN, 633, 417);
		FieldC f88 = new FieldC(87, true, false, true, CommandC.GREEN, 653, 417);

		// ovde pocinju baze
		// zuta
		FieldC f89 = new FieldC(88, true, true, false, CommandC.YELLOW, 342, 85);
		FieldC f90 = new FieldC(89, true, true, false, CommandC.YELLOW, 440, 85);
		FieldC f91 = new FieldC(90, true, true, false, CommandC.YELLOW, 342, 173);
		FieldC f92 = new FieldC(91, true, true, false, CommandC.YELLOW, 440, 173);

		// crvena
		FieldC f93 = new FieldC(92, true, true, false, CommandC.RED, 805, 85);
		FieldC f94 = new FieldC(93, true, true, false, CommandC.RED, 903, 85);
		FieldC f95 = new FieldC(94, true, true, false, CommandC.RED, 805, 173);
		FieldC f96 = new FieldC(95, true, true, false, CommandC.RED, 903, 173);

		// plava
		FieldC f97 = new FieldC(96, true, true, false, CommandC.BLUE, 342, 550);
		FieldC f98 = new FieldC(97, true, true, false, CommandC.BLUE, 440, 550);
		FieldC f99 = new FieldC(98, true, true, false, CommandC.BLUE, 342, 635);
		FieldC f100 = new FieldC(99, true, true, false, CommandC.BLUE, 440, 635);

		// zelena
		FieldC f101 = new FieldC(100, true, true, false, CommandC.GREEN, 805, 550);
		FieldC f102 = new FieldC(101, true, true, false, CommandC.GREEN, 903, 550);
		FieldC f103 = new FieldC(102, true, true, false, CommandC.GREEN, 805, 635);
		FieldC f104 = new FieldC(103, true, true, false, CommandC.GREEN, 903, 635);

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

	public FieldC[] getFields() {
		return fields;
	}

	public void setFields(FieldC[] fields) {
		fields = fields;
	}

	public PlayerC[] getPlayers() {
		return players;
	}

	public void setPlayers(PlayerC[] players) {
		this.players = players;
	}

	public static int getYouPlayerID() {
		return youPlayerID;
	}

	public static void setYouPlayerID(int youPlayerID) {
		GameC.youPlayerID = youPlayerID;
	}
}
