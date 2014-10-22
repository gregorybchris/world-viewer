package geometric;

import math.MT;

public class Point2D {
	public double x = 0;
	public double y = 0;
	
	public Point2D() {}
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void translate(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		Point2D p = (Point2D) o;
		return (this.x == p.x && this.y == p.y);
	}
	
	@Override
	public String toString() {
		return "P2D(" + MT.dRound(this.x) + ", " + MT.dRound(this.y) + ")";
	}
}
