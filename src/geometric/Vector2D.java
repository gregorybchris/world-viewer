package geometric;

import math.MT;

public class Vector2D {
	private double x = 0;
	private double y = 0;

	public Vector2D() {}

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D(Point2D p1, Point2D p2) {
		this.x = p2.x - p1.x;
		this.y = p2.y - p1.y;
	}

	public void setByTrig(double magnitude, double angle) {
		this.x = magnitude * MT.cos(angle);
		this.y = magnitude * MT.sin(angle);
	}

	public double getAngle() {
		return MT.atan(x, y);
	}

	public double getMagnitude() {
		return MT.sqrt(x * x + y * y);
	}

	public boolean isZeroVector() {
		return x == 0 && y == 0;
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
		Vector3D v = (Vector3D) o;
		return this.getX() == v.getX() && this.getY() == v.getY();
	}
	
	@Override
	public String toString() {
		return "V2D(" + MT.dRound(this.x) + ", " + MT.dRound(this.y) + ")";
	}
}
