package geometric;

import math.MT;

public class Vector3D {
	private double x = 0;
	private double y = 0;
	private double z = 0;

	public Vector3D() {}

	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3D(Point3D p1, Point3D p2) {
		this.x = p2.x - p1.x;
		this.y = p2.y - p1.y;
		this.z = p2.z - p1.z;
	}

	public double getMagnitude() {
		return MT.sqrt(x * x + y * y + z * z);
	}

	public Vector3D getNormalized() {
		double magnitude = this.getMagnitude();
		return new Vector3D(this.x / magnitude, this.y / magnitude, this.z / magnitude);
	}
	
	public Vector3D getMultipliedBy(double scalar) {
		return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
	}
	
	public void multiplyBy(double scalar) {
		this.x *= scalar;
		this.y *= scalar;
		this.z *= scalar;
	}

	public boolean isZeroVector() {
		return x == 0 && y == 0 && z == 0;
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
		Vector3D v = (Vector3D) o;
		return this.getX() == v.getX() && this.getY() == v.getY() && this.getZ() == v.getZ();
	}
	
	@Override
	public Vector3D clone() {
		Vector3D toReturn = new Vector3D(this.x, this.y, this.z);
		return toReturn;
	}

	@Override
	public String toString() {
		return "V3D(" + MT.dRound(this.x) + ", " + MT.dRound(this.y) + ", " + MT.dRound(this.z) + ")";
	}
}
