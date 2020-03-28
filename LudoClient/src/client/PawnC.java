package client;

import server.ServerThread;

public class PawnC {
	
	private int color;
	private int pawnID;	// id je 1, 2, 3, 4 za svaku boju
	private int fieldIndex;	
	private int coordinatePawn_x;
	private int coordinatePawn_y;
	
	
	public PawnC(int color, int pawnID, int fieldIndex, int coordinatePawn_x, int coordinatePawn_y) {
		super();
		this.color = color;
		this.pawnID = pawnID;
		this.fieldIndex = fieldIndex;
		this.coordinatePawn_x = coordinatePawn_x;
		this.coordinatePawn_y = coordinatePawn_y;
	}


	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}


	public int getPawnID() {
		return pawnID;
	}


	public void setPawnID(int pawnID) {
		this.pawnID = pawnID;
	}


	public int getFieldIndex() {
		return fieldIndex;
	}


	public void setFieldIndex(int fieldIndex) {
		this.fieldIndex = fieldIndex;
	}


	public int getCoordinatePawn_x() {
		return coordinatePawn_x;
	}


	public void setCoordinatePawn_x(int coordinatePawn_x) {
		this.coordinatePawn_x = coordinatePawn_x;
	}


	public int getCoordinatePawn_y() {
		return coordinatePawn_y;
	}


	public void setCoordinatePawn_y(int coordinatePawn_y) {
		this.coordinatePawn_y = coordinatePawn_y;
	}
	
	
	
	
	
	
	
	
	
	
	

}
