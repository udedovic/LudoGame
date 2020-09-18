package server;

public class Node {

	public boolean active = false;
	public int color;
	public Node next;
	private boolean onTurn;

	public Node(int color, Node next) {
		super();
		this.color = color;
		this.next = next;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getColour() {
		return color;
	}

	public void setColour(int colour) {
		this.color = colour;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public boolean isOnTurn() {
		return onTurn;
	}

	public void setOnTurn(boolean onTurn) {
		this.onTurn = onTurn;
	}
	
	

}
