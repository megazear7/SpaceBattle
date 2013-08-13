package util;

public final class Line {
	private int intB;
	private double b;
	private int gameAngle;
	private double m;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private boolean isHorizontal;

	public Line(int x, int y, int gameAngle){
		this.x1(x);
		this.y1(y);
		this.gameAngle(gameAngle);
		double m = gameAngle * 22.5;
		this.m = m;
		this.b = ( -1 * m * x + y);
		this.intB((int) ((int) -1 * m * x + y));
		
		if(gameAngle == 1){
			this.x2(x + 100);
			this.y2(y + 241);
		} else if (gameAngle == 2){
			this.x2(x + 1);
			this.y2(y + 1);
		} else if (gameAngle == 3){
			this.x2(x + 241);
			this.y2(y + 100);	
		} else if (gameAngle == 4){
			this.x2(x + 1);
			this.y2(y + 0);
		} else if (gameAngle == 5){
			this.x2(x + 241);
			this.y2(y + -100);
		} else if (gameAngle == 6){
			this.x2(x + 1);
			this.y2(y + -1);
		} else if (gameAngle == 7){
			this.x2(x + 100);
			this.y2(y + -241);
		} else if (gameAngle == 8){
			this.x2(x + 0);
			this.y2(y + -1);
		} else if (gameAngle == 9){
			this.x2(x + -241);
			this.y2(y + -100);
		} else if (gameAngle == 10){
			this.x2(x + -1);
			this.y2(y + -1);
		} else if (gameAngle == 11){
			this.x2(x + -241);
			this.y2(y + -100);
		} else if (gameAngle == 12){
			this.x2(x + -1);
			this.y2(y + 0);
		} else if (gameAngle == 13){
			this.x2(x + -241);
			this.y2(y + 100);
		} else if (gameAngle == 14){
			this.x2(x + -1);
			this.y2(y + 1);
		} else if (gameAngle == 15){
			this.x2(x + -100);
			this.y2(y + 241);
		} else if (gameAngle == 16){
			this.x2(x + 0);
			this.y2(y + 1);
		}
		
	}

	public Line(int x1, int y1, int x2, int y2){
		int m = y1 - y2 / x1 - x2;
		this.x1(x1);
		this.y1(y1);
		this.x2(x2);
		this.y2(y2);
		this.m = m;
		this.b = -1 * m * x1 + y1;
	}	
	public boolean isHorizontal(){
		return this.isHorizontal;
	}
	
	private int yAtX(int x){
		return (int) ((int) this.m * x + this.b);
	}
	
	@SuppressWarnings("unused")
	private int xAtY(int y){
		return (int) ((int) (y - this.b)/this.m);
	}

	public boolean pointIsLeft(int x3, int y3){
		
		int x1 = this.x1();
		int y1 = this.y1();
		int x2 = this.x2();
		int y2 = this.y2();
			
		return ((x2 - x1)*(y3 - y1) - (y2 - y1)*(x3 - x1)) > 0;
		
	}
	
	public boolean pointIsAbove (int x, int y){
		int yOfLine = yAtX(x);
		boolean isAbove = false;
		if (y > yOfLine){
			isAbove = true;
		} else if (y < yOfLine){
			isAbove = false;
		}
		return isAbove;
	}

	public int gameAngle() {
		return gameAngle;
	}

	public void gameAngle(int gameAngle) {
		this.gameAngle = gameAngle;
	}

	public int intB() {
		return intB;
	}

	public void intB(int intB) {
		this.intB = intB;
	}

	public int x1() {
		return x1;
	}

	public void x1(int x1) {
		this.x1 = x1;
	}

	public int x2() {
		return x2;
	}

	public void x2(int x2) {
		this.x2 = x2;
	}

	public int y1() {
		return y1;
	}

	public void y1(int y1) {
		this.y1 = y1;
	}

	public int y2() {
		return y2;
	}

	public void y2(int y2) {
		this.y2 = y2;
	}
	
	
		
	
}
