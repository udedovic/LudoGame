package client;

public class PlayerC {

	private String name;
	private int color = 0;
	private boolean active;
	private int playerId = -1; // mozda treba izbrisati, ako je -1 tada taj igrac nije u igri

	private PawnC[] pawns = new PawnC[4];

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
		return active;
	}

	public void setOnTurn(boolean isOnTurn) {
		this.active = isOnTurn;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public PawnC[] getPawns() {
		return pawns;
	}

	public void setPawns(PawnC[] pawns) {
		this.pawns = pawns;
	}
	
	public PawnC findPawnByIndex(int pawnIndex) {
		for(PawnC pawn : pawns) {
			if(pawn.getPawnID() == pawnIndex) {
				return pawn;
			}
		}
		return null;
	}

}
