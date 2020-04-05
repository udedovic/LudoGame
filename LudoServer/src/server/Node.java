package server;

public class Node {

	public boolean active = false;
	public int colour;
	public Node next;
	
	public Node(int colour, Node next) {
		super();
		this.colour = colour;
		this.next = next;
	}
	
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getColour() {
		return colour;
	}
	public void setColour(int colour) {
		this.colour = colour;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
}
