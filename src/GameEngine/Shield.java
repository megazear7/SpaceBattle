package gameEngine;

public class Shield {
	
	private int power;
	private int front;
	private int left;
	private int right;
	private int rear;
	
	public Shield(int power, int front, int left, int right, int rear){
		this.power = power;
		this.front = front;
		this.left = left;
		this.right = right;
		this.rear = rear;
	}

	public int rear() {
		return rear;
	}

	public void rear(int rear) {
		this.rear = rear;
	}

	public void addRear(int rear) {
		this.rear += rear;
	}
	public int right() {
		return right;
	}

	public void right(int right) {
		this.right = right;
	}

	public void addRight(int right) {
		this.right += right;
	}
	public int left() {
		return left;
	}

	public void left(int left) {
		this.left = left;
	}

	public void addLeft(int left) {
		this.left += left;
	}
	public int front() {
		return front;
	}

	public void front(int front) {
		this.front = front;
	}

	public void addFront(int front) {
		this.front = front;
	}
	public int power() {
		return power;
	}

	public void addPower(int power) {
		this.power = power;
	}

	public void power(int power) {
		this.power = power;
	}
}
