package geometric;

import math.MT;


public class Triangle3D {
	public double x1 = 0;
	public double y1 = 0;
	public double z1 = 0;
	
	public double x2 = 0;
	public double y2 = 0;
	public double z2 = 0;
	
	public double x3 = 0;
	public double y3 = 0;
	public double z3 = 0;
	
	public Triangle3D() {}
	
	public Triangle3D(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3) {
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
		this.x3 = x3;
		this.y3 = y3;
		this.z3 = z3;
	}
	
	public Triangle3D(Point3D p1, Point3D p2, Point3D p3) {
		this.x1 = p1.x;
		this.y1 = p1.y;
		this.z1 = p1.z;
		this.x2 = p2.x;
		this.y2 = p2.y;
		this.z2 = p2.z;
		this.x3 = p3.x;
		this.y3 = p3.y;
		this.z3 = p3.z;
	}

	public Point3D getPoint1() {
		return new Point3D(this.x1, this.y1, this.z1);
	}
	
	public Point3D getPoint2() {
		return new Point3D(this.x2, this.y2, this.z2);
	}
	
	public Point3D getPoint3() {
		return new Point3D(this.x3, this.y3, this.z3);
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

	public double getZ1() {
		return z1;
	}

	public void setZ1(double z1) {
		this.z1 = z1;
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

	public double getZ2() {
		return z2;
	}

	public void setZ2(double z2) {
		this.z2 = z2;
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

	public double getZ3() {
		return z3;
	}

	public void setZ3(double z3) {
		this.z3 = z3;
	}
	
	@Override
	public boolean equals(Object o) {
		Triangle3D t = (Triangle3D) o;
		return (this.getX1() == t.getX1() && this.getX2() == t.getX2() && this.getX3() == t.getX3() &&
				this.getY1() == t.getY1() && this.getY2() == t.getY2() && this.getY3() == t.getY3() &&
				this.getZ1() == t.getZ1() && this.getZ2() == t.getZ2() && this.getZ3() == t.getZ3());
	}
	
	@Override
	public String toString() {
		return "T3D[(" + MT.dRound(this.x1) + ", " + MT.dRound(this.y1) + ", " + MT.dRound(this.z1) + ") - (" + 
				MT.dRound(this.x2) + ", " + MT.dRound(this.y2) + ", " + MT.dRound(this.z2) + ") - (" + 
						MT.dRound(this.x3) + ", " + MT.dRound(this.y3) + ", " + MT.dRound(this.z3) + ")]";
	}
}
