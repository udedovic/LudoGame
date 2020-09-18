package server;

public class PlayerS {

	private String name;
	private int color = 0;
	private boolean isOnTurn = false;
	private int playerId;
	private boolean isReady = false; // koristi se samo za prelaz sa main menua na ludo game

	private PawnS[] pawns = new PawnS[4];
	
	public PawnS findPawnByIndex(int index) {
		for(PawnS pawn : pawns) {
			if(pawn.getPawnID() == index) {
				return pawn;
			}
		}
		return null;
	}

	public PlayerS(int playerId) {
		super();
		this.playerId = playerId;
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
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

	public PawnS[] getPawns() {
		return pawns;
	}

	public void setPawns(PawnS[] pawns) {
		this.pawns = pawns;
	}

}
