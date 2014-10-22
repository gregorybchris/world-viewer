package geometric;

import math.MT;

public class Point3D {
	public double x = 0;
	public double y = 0;
	public double z = 0;

	public Point3D() {}

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void translate(double dx, double dy, double dz) {
		this.x += dx;
		this.y += dy;
		this.z += dz;
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

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	@Override
	public boolean equals(Object o) {
		Point3D p = (Point3D) o;
		return (this.x == p.x && this.y == p.y && this.z == p.z);
	}

	@Override
	public String toString() {
		return "P3D(" + MT.dRound(this.x) + ", " + MT.dRound(this.y) + ", " + MT.dRound(this.z) + ")";
	}
}
