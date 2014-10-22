package geometric;

import math.MT;


public class Triangle2D {
	public double x1 = 0;
	public double y1 = 0;
	
	public double x2 = 0;
	public double y2 = 0;
	
	public double x3 = 0;
	public double y3 = 0;
	
	public Triangle2D() {}
	
	public Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}
	
	public Triangle2D(Point2D p1, Point2D p2, Point2D p3) {
		this.x1 = p1.x;
		this.y1 = p1.y;
		this.x2 = p2.x;
		this.y2 = p2.y;
		this.x3 = p3.x;
		this.y3 = p3.y;
	}

	public Point2D getPoint1() {
		return new Point2D(this.x1, this.y1);
	}
	
	public Point2D getPoint2() {
		return new Point2D(this.x2, this.y2);
	}
	
	public Point2D getPoint3() {
		return new Point2D(this.x3, this.y3);
	}
	
	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}
	
	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public double getX3() {
		return x3;
	}

	public void setX3(double x3) {
		this.x3 = x3;
	}

	public double getY3() {
		return y3;
	}

	public void setY3(double y3) {
		this.y3 = y3;
	}
	
	@Override
	public boolean equals(Object o) {
		Triangle2D t = (Triangle2D) o;
		return (this.getX1() == t.getX1() && this.getX2() == t.getX2() && this.getX3() == t.getX3() &&
				this.getY1() == t.getY1() && this.getY2() == t.getY2() && this.getY3() == t.getY3());
	}
	
	@Override
	public String toString() {
		return "T2D[(" + MT.dRound(this.x1) + ", " + MT.dRound(this.y1) + ") - (" + 
				MT.dRound(this.x2) + ", " + MT.dRound(this.y2) + ") - (" + 
						MT.dRound(this.x3) + ", " + MT.dRound(this.y3) + ")]";	}
}
