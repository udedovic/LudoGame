package client;

public class PlayerC {

	private String name;
	private int color = 0;
	private boolean isOnTurn;
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

	public PawnC[] getPawns() {
		return pawns;
	}

	public void setPawns(PawnC[] pawns) {
		this.pawns = pawns;
	}

}
