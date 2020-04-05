package server;

public class GameS {
	
	private boolean endOfGame = false;	// ovo ne sme da bude static kao na klijentu
	private int roomID = -1;	// ovo ne sme da bude static kao na klijentu; setovano je na -1 jer to nikada nije room
	private int numberOfPlayers = 0;
	private int playersOnTurn; 	// playerID
	private float timeInGame;
	private int round = 1;
	private Node first;

	
	PlayerS[] players = new PlayerS[4];

	FieldS[] fields = new FieldS[104];
	

	public boolean emptyList() {
		return first == null;
	}
	
	public void addElementOnBeginning(int a) {
		first = new Node(a, first);
	}
	
	public void addElementToEnd(int a) {
		if (emptyList()) {
			addElementOnBeginning(a);
			return;
		}
		Node pom = first;
		while (pom.next != null)
			pom = pom.next;
		Node novi = new Node(a, null);
		pom.next = novi;
		}
	
	
	public void inicialization() {
		addElementToEnd(CommandS.BLUE);
		addElementToEnd(CommandS.YELLOW);
		addElementToEnd(CommandS.RED);
		addElementToEnd(CommandS.GREEN);
		Node pom = first;
		pom.next.next.next.next = first;
	}
	
	
//	public void ispisi() {
//		if (emptyList())
//			return;
//		Node pom = first;
//		while (pom != null) {
//			System.out.println(pom.colour);
//			pom = pom.next;
//		}
//	}
	
//	public static void main(String[] args) {
//		GameS gs = new GameS();
//		gs.inicialization();
////	gs.ispisi();
//	}
	
	
	/*
	 * 	poziva se po izboru boje za igraca, pravimo objekte pawns
	 */
	
	
	public void make_red_pawns(int playerID) {
		
		PawnS p1 = new PawnS(CommandS.RED, 1, 92, 835, 85);
		PawnS p2 = new PawnS(CommandS.RED, 2, 93, 933, 85);
		PawnS p3 = new PawnS(CommandS.RED, 3, 94, 835, 173);
		PawnS p4 = new PawnS(CommandS.RED, 4, 95, 933, 173);
		
		players[playerID - 1].getPawns()[0] = p1;
		players[playerID - 1].getPawns()[1] = p2;
		players[playerID - 1].getPawns()[2] = p3;
		players[playerID - 1].getPawns()[3] = p4;
		
	}
	
	public void make_blue_pawns(int playerID) {
		
		PawnS p1 = new PawnS(CommandS.BLUE, 1, 96, 372, 550);
		PawnS p2 = new PawnS(CommandS.BLUE, 2, 97, 470, 550);
		PawnS p3 = new PawnS(CommandS.BLUE, 3, 98, 372, 635);
		PawnS p4 = new PawnS(CommandS.BLUE, 4, 99, 470, 635);
		
		players[playerID - 1].getPawns()[0] = p1;
		players[playerID - 1].getPawns()[1] = p2;
		players[playerID - 1].getPawns()[2] = p3;
		players[playerID - 1].getPawns()[3] = p4;
		
	}
	
	public void make_green_pawns(int playerID) {
		
		PawnS p1 = new PawnS(CommandS.GREEN, 1, 100, 835, 550);
		PawnS p2 = new PawnS(CommandS.GREEN, 2, 101, 933, 550);
		PawnS p3 = new PawnS(CommandS.GREEN, 3, 102, 835, 635);
		PawnS p4 = new PawnS(CommandS.GREEN, 4, 103, 933, 635);
		
		players[playerID - 1].getPawns()[0] = p1;
		players[playerID - 1].getPawns()[1] = p2;
		players[playerID - 1].getPawns()[2] = p3;
		players[playerID - 1].getPawns()[3] = p4;
		
	}
	
	public void make_yelow_pawns(int playerID) {
		
		PawnS p1 = new PawnS(CommandS.YELLOW, 1, 88, 372, 85);
		PawnS p2 = new PawnS(CommandS.YELLOW, 2, 89, 470, 85);
		PawnS p3 = new PawnS(CommandS.YELLOW, 3, 90, 372, 173);
		PawnS p4 = new PawnS(CommandS.YELLOW, 4, 91, 470, 173);
		
		players[playerID - 1].getPawns()[0] = p1;
		players[playerID - 1].getPawns()[1] = p2;
		players[playerID - 1].getPawns()[2] = p3;
		players[playerID - 1].getPawns()[3] = p4;
		
	}
	
	/*
	 * 	poziva se na pocetku igre, tj kada se napravi igra
	 */
	public void make_fields() {
	
		
		FieldS f1 = new FieldS(0, true, false, false, CommandS.YELLOW, 295, 310);
		FieldS f2 = new FieldS(1, false, false, false, -1, 346, 310);
		FieldS f3 = new FieldS(2, false, false, false, -1, 397, 310);
		FieldS f4 = new FieldS(3, false, false, false, -1, 448, 310);
		FieldS f5 = new FieldS(4, false, false, false, -1, 499, 310);
		FieldS f6 = new FieldS(5, false, false, false, -1, 550, 310);
		
		FieldS f7 = new FieldS(6, false, false, false, -1, 601, 260);
		FieldS f8 = new FieldS(7, false, false, false, -1, 601, 209);
		FieldS f9 = new FieldS(8, false, false, false, -1, 601, 158);
		FieldS f10 = new FieldS(9, false, false, false, -1, 601, 107);
		FieldS f11 = new FieldS(10, false, false, false, -1, 601, 56);
		FieldS f12 = new FieldS(11, false, false, false, -1, 601, 5);
		
		FieldS f13 = new FieldS(12, false, false, false, -1, 652, 5);
		
		FieldS f14 = new FieldS(13, true, false, false, CommandS.RED, 703, 5);
		FieldS f15 = new FieldS(14, false, false, false, -1, 703, 56);
		FieldS f16 = new FieldS(15, false, false, false, -1, 703, 107);
		FieldS f17 = new FieldS(16, false, false, false, -1, 703, 158);
		FieldS f18 = new FieldS(17, false, false, false, -1, 703, 209);
		FieldS f19 = new FieldS(18, false, false, false, -1, 703, 260);
		
		FieldS f20 = new FieldS(19, false, false, false, -1, 754, 310);
		FieldS f21 = new FieldS(20, false, false, false, -1, 805, 310);
		FieldS f22 = new FieldS(21, false, false, false, -1, 856, 310);
		FieldS f23 = new FieldS(22, false, false, false, -1, 907, 310);
		FieldS f24 = new FieldS(23, false, false, false, -1, 958, 310);
		FieldS f25 = new FieldS(24, false, false, false, -1, 1009, 310);
		
		FieldS f26 = new FieldS(25, false, false, false, -1, 1009, 361);
		
		FieldS f27 = new FieldS(26, true, false, false, -1, 1009, 414);
		FieldS f28 = new FieldS(27, false, false, false, -1, 958, 414);
		FieldS f29 = new FieldS(28, false, false, false, -1, 907, 414);
		FieldS f30 = new FieldS(29, false, false, false, -1, 856, 414);
		FieldS f31 = new FieldS(30, false, false, false, -1, 805, 414);
		FieldS f32 = new FieldS(31, false, false, false, -1, 754, 414);
		
		FieldS f33 = new FieldS(32, false, false, false, -1, 703, 465);
		FieldS f34 = new FieldS(33, false, false, false, -1, 703, 516);
		FieldS f35 = new FieldS(34, false, false, false, -1, 703, 567);
		FieldS f36 = new FieldS(35, false, false, false, -1, 703, 618);
		FieldS f37 = new FieldS(36, false, false, false, -1, 703, 669);
		FieldS f38 = new FieldS(37, false, false, false, -1, 703, 720);
		
		FieldS f39 = new FieldS(38, false, false, false, -1, 652, 720);
		
		FieldS f40 = new FieldS(39, true, false, false, CommandS.BLUE, 601, 720);
		FieldS f41 = new FieldS(40, false, false, false, -1, 601, 669);
		FieldS f42 = new FieldS(41, false, false, false, -1, 601, 618);
		FieldS f43 = new FieldS(42, false, false, false, -1, 601, 567);
		FieldS f44 = new FieldS(43, false, false, false, -1, 601, 516);
		FieldS f45 = new FieldS(44, false, false, false, -1, 601, 465);
		
		FieldS f46 = new FieldS(45, false, false, false, -1, 550, 414);
		FieldS f47 = new FieldS(46, false, false, false, -1, 499, 414);
		FieldS f48 = new FieldS(47, false, false, false, -1, 448, 414);
		FieldS f49 = new FieldS(48, false, false, false, -1, 397, 414);
		FieldS f50 = new FieldS(49, false, false, false, -1, 346, 414);
		FieldS f51 = new FieldS(50, false, false, false, -1, 295, 414);
		
		FieldS f52 = new FieldS(51, false, false, false, -1, 295, 361);
		
		// ovde se zavrsavaju polja za hod
		
		//	ovo su ulazi u cilj
		
		FieldS f53 = new FieldS(52, true, false, false, CommandS.YELLOW, 346, 361);
		FieldS f54 = new FieldS(53, true, false, false, CommandS.YELLOW, 397, 361);
		FieldS f55 = new FieldS(54, true, false, false, CommandS.YELLOW, 448, 361);
		FieldS f56 = new FieldS(55, true, false, false, CommandS.YELLOW, 499, 361);
		FieldS f57 = new FieldS(56, true, false, false, CommandS.YELLOW, 550, 361);
		
		FieldS f58 = new FieldS(57, true, false, false, CommandS.RED, 652, 56);
		FieldS f59 = new FieldS(58, true, false, false, CommandS.RED, 652, 107);
		FieldS f60 = new FieldS(59, true, false, false, CommandS.RED, 652, 158);
		FieldS f61 = new FieldS(60, true, false, false, CommandS.RED, 652, 209);
		FieldS f62 = new FieldS(61, true, false, false, CommandS.RED, 652, 260);
	
		FieldS f63 = new FieldS(62, true, false, false, CommandS.GREEN, 958, 361);
		FieldS f64 = new FieldS(63, true, false, false, CommandS.GREEN, 907, 361);
		FieldS f65 = new FieldS(64, true, false, false, CommandS.GREEN, 856, 361);
		FieldS f66 = new FieldS(65, true, false, false, CommandS.GREEN, 805, 361);
		FieldS f67 = new FieldS(66, true, false, false, CommandS.GREEN, 754, 361);
		
		FieldS f68 = new FieldS(67, true, false, false, CommandS.BLUE, 669, 310);
		FieldS f69 = new FieldS(68, true, false, false, CommandS.BLUE, 618, 310);
		FieldS f70 = new FieldS(69, true, false, false, CommandS.BLUE, 567, 310);
		FieldS f71 = new FieldS(70, true, false, false, CommandS.BLUE, 516, 310);
		FieldS f72 = new FieldS(71, true, false, false, CommandS.BLUE, 465, 310);
		

		//	ovde su ciljevi
		//	za ciljeve sam stavljao kordinate za punu velicinu figure, figure treba da se promene na male tj 44x62
		
		// zuti
		FieldS f73 = new FieldS(72, true, false, true, CommandS.YELLOW, 597, 386);
		FieldS f74 = new FieldS(73, true, false, true, CommandS.YELLOW, 597, 371);
		FieldS f75 = new FieldS(74, true, false, true, CommandS.YELLOW, 597, 356);
		FieldS f76 = new FieldS(75, true, false, true, CommandS.YELLOW, 597, 341);
		
		
		// crveni
		FieldS f77 = new FieldS(76, true, false, true, CommandS.RED, 623, 305);
		FieldS f78 = new FieldS(77, true, false, true, CommandS.RED, 643, 305);
		FieldS f79 = new FieldS(78, true, false, true, CommandS.RED, 663, 305);
		FieldS f80 = new FieldS(79, true, false, true, CommandS.RED, 683, 305);
		
		// zeleni
		FieldS f81 = new FieldS(80, true, false, true, CommandS.BLUE, 707, 341);
		FieldS f82 = new FieldS(81, true, false, true, CommandS.BLUE, 707, 356);
		FieldS f83 = new FieldS(82, true, false, true, CommandS.BLUE, 707, 371);
		FieldS f84 = new FieldS(83, true, false, true, CommandS.BLUE, 707, 386);
		
		
		//	plavi
		FieldS f85 = new FieldS(84, true, false, true, CommandS.GREEN, 623, 417);
		FieldS f86 = new FieldS(85, true, false, true, CommandS.GREEN, 643, 417);
		FieldS f87 = new FieldS(86, true, false, true, CommandS.GREEN, 663, 417);
		FieldS f88 = new FieldS(87, true, false, true, CommandS.GREEN, 683, 417);
			
		
		// ovde pocinju baze
		// zuta
		FieldS f89 = new FieldS(88, true, true, false, CommandS.YELLOW, 372, 85);
		FieldS f90 = new FieldS(89, true, true, false, CommandS.YELLOW, 470, 85);
		FieldS f91 = new FieldS(90, true, true, false, CommandS.YELLOW, 372, 173);
		FieldS f92 = new FieldS(91, true, true, false, CommandS.YELLOW, 470, 173);
		
		// crvena
		FieldS f93 = new FieldS(92, true, true, false, CommandS.RED, 835, 85);
		FieldS f94 = new FieldS(93, true, true, false, CommandS.RED, 933, 85);
		FieldS f95 = new FieldS(94, true, true, false, CommandS.RED, 835, 173);
		FieldS f96 = new FieldS(95, true, true, false, CommandS.RED, 933, 173);
		
		//	plava
		FieldS f97 = new FieldS(96, true, true, false, CommandS.BLUE, 372, 550);
		FieldS f98 = new FieldS(97, true, true, false, CommandS.BLUE, 470, 550);
		FieldS f99 = new FieldS(98, true, true, false, CommandS.BLUE, 372, 635);
		FieldS f100 = new FieldS(99, true, true, false, CommandS.BLUE, 470, 635);
		
		// zelena
		FieldS f101 = new FieldS(100, true, true, false, CommandS.GREEN, 835, 550);
		FieldS f102 = new FieldS(101, true, true, false, CommandS.GREEN, 933, 550);
		FieldS f103 = new FieldS(102, true, true, false, CommandS.GREEN, 835, 635);
		FieldS f104 = new FieldS(103, true, true, false, CommandS.GREEN, 933, 635);
		
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
	
	public float getTimeInGame() {
		return timeInGame;
	}
	
	public void setTimeInGame(float timeInGame) {
		this.timeInGame = timeInGame;
	}
	
	public FieldS[] getFields() {
		return fields;
	}
	
	public void setFields(FieldS[] fields) {
		this.fields = fields;
	}
	
	public PlayerS[] getPlayers() {
		return players;
	}

	public void setPlayers(PlayerS[] players) {
		this.players = players;
	}
	
	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	
	
}
