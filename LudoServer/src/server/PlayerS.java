package server;


public class PlayerS {
	
	private String name;
	private int color = 0;
	private boolean isOnTurn;
	private int playerId;
	
	private static PawnS[] pawns = new PawnS[3];

	public PlayerS(int playerId) {
		super();
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public boolean isOnTurn() {
		return isOnTurn;
	}

	public void setOnTurn(boolean isOnTurn) {
		this.isOnTurn = isOnTurn;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public static PawnS[] getPawns() {
		return pawns;
	}

	public static void setPawns(PawnS[] pawns) {
		PlayerS.pawns = pawns;
	}
	
	
	
	

}
