package math;

import geometric.Point2D;
import geometric.Point3D;
import geometric.Vector2D;
import geometric.Vector3D;

public class MT {
	// ~ ~ ~ ~ ~ //   CONSTANTS   // ~ ~ ~ ~ ~ //
	public static double PI = 3.14159265358979;
	public static double PHI = 1.61803398875;
	public static double SQRT_2 = 1.4142;
	public static double SQRT_3 = 1.7321;

	// ~ ~ ~ ~ ~ //   FUNCTIONS   // ~ ~ ~ ~ ~ //
	public static double distance(Point2D p1, Point2D p2) {
		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
	}

	public static double distance(Point3D p1, Point3D p2) {
		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y) + (p2.z - p1.z) * (p2.z - p1.z));
	}

	public static double abs(double v) {
		return Math.abs(v);
	}

	public static double degreesToRadians(double degrees) {
		return Math.toRadians(degrees);
	}

	public static double radiansToDegrees(double radians) {
		return Math.toDegrees(radians);
	}

	public static double cos(double angle) {
		return Math.cos(angle);
	}

	public static double acos(double v) {
		return Math.acos(v);
	}

	public static double sin(double angle) {
		return Math.sin(angle);
	}

	public static double ason(double v) {
		return Math.asin(v);
	}

	public static double atan(double dx, double dy) {
		return Math.atan2(dy, dx);
	}

	public static double sqrt(double v) {
		return Math.sqrt(v);
	}

	public static double round(double v) {
		return Math.round(v);
	}

	public static double dotProduct(Vector2D v1, Vector2D v2) {
		return v1.getX() * v2.getX() + v1.getY() * v2.getY();
	}

	public static double dotProduct(Vector3D v1, Vector3D v2) {
		return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
	}

	public static Vector3D crossProduct(Vector3D v1, Vector3D v2) {
		//v1 x v2 = v1y*v2z-v1z*v2y, v1z*v2x-v1x*v2z, v1x*v2y-v1y*v2x
		return new Vector3D(v1.getY() * v2.getZ() - v1.getZ() * v2.getY(), 
				v1.getZ() * v2.getX() - v1.getX() * v2.getZ(),
				v1.getX() * v2.getY() - v1.getY() * v2.getX());
	}

	public static double angleBetween(Vector2D v1, Vector2D v2) {
		return MT.abs(v2.getAngle() - v1.getAngle()) % (2 * MT.PI);
	}

	public static double angleBetween(Vector3D v1, Vector3D v2) {
		if(v1.isZeroVector() || v2.isZeroVector())
			return 0;
//		else if(v1.getNormalized().equals(v2.getNormalized()))
//			return 0;
//		else if(areOpposite(v1, v2))
//			return MT.PI;
//		else if(MT.abs(dotProduct(v1, v2) / (v1.getMagnitude() * v2.getMagnitude())) >= 1.0)
//			return 0;
//		else if(MT.acos(dotProduct(v1, v2) / (v1.getMagnitude() * v2.getMagnitude())) == Double.NaN)
//			return 0;
		//System.out.println("AngBetInAcos: " + MT.dRound(dotProduct(v1, v2) / (v1.getMagnitude() * v2.getMagnitude())));
		return MT.acos(dotProduct(v1, v2) / (v1.getMagnitude() * v2.getMagnitude()));
	}

	public static Vector2D addVectors(Vector2D v1, Vector2D v2) {
		return new Vector2D(v1.getX() + v2.getX(), v1.getY() + v2.getY());
	}

	public static Vector3D addVectors(Vector3D v1, Vector3D v2) {
		return new Vector3D(v1.getX() + v2.getX(), v1.getY() + v2.getY(), v1.getZ() + v2.getZ());
	}

	public static Matrix multiplyMatrices(Matrix m1, Matrix m2) {
		if(m1.getWidth() == m2.getHeight()) {
			int width = m2.getWidth();
			int height = m1.getHeight();
			Matrix toReturn = new Matrix(width, height);
			for(int i = 0; i < m1.getHeight(); i++) {
				for(int j = 0; j < m2.getWidth(); j++) {
					double sum = 0;
					for(int k = 0; k < m1.getWidth(); k++) {
						sum += m1.get(k, i) * m2.get(j, k);
					}
					toReturn.set(j, i, sum);
				}
			}
			return toReturn;
		}
		else
			return null;
	}

	public static Matrix addMatrices(Matrix m1, Matrix m2) {
		if(m1.getWidth() == m2.getWidth() && m1.getHeight() == m2.getHeight()) {
			Matrix toReturn = new Matrix(m1.getWidth(), m1.getHeight());
			for(int i = 0; i < m1.getWidth(); i++) {
				for(int j = 0; j < m1.getHeight(); j++) {
					toReturn.set(i, j, m1.get(i, j) + m2.get(i, j));
				}
			}
			return toReturn;
		}
		else
			return null;
	}

	public static double getDeterminant2x2(Matrix m) {
		if(m.getWidth() == 2 && m.getHeight() == 2) {
			double a = m.get(0, 0);
			double b = m.get(1, 0);
			double c = m.get(0, 1);
			double d = m.get(1, 1);
			return a * d - b * c;
		}
		else
			return -1;
	}

	public static double getDeterminant3x3(Matrix m) {
		if(m.getWidth() == 3 && m.getHeight() == 3) {
			double a = m.get(0, 0);
			double b = m.get(1, 0);
			double c = m.get(2, 0);
			double d = m.get(0, 1);
			double e = m.get(1, 1);
			double f = m.get(2, 1);
			double g = m.get(0, 2);
			double h = m.get(1, 2);
			double i = m.get(2, 2);
			return a * e * i + b * f * g + c * d * h - c * e * g - b * d * i - a * f * h;
		}
		else
			return -1;
	}

	public static Matrix getTranspose(Matrix m) {
		Matrix toReturn = new Matrix(m.getHeight(), m.getWidth());
		for(int j = 0; j < m.getHeight(); j++)
			for(int i = 0; i < m.getWidth(); i++)
				toReturn.set(j, i, m.get(i, j));
		return toReturn;
	}

	public static Matrix getIdentityMatrix(int size) {
		Matrix toReturn = new Matrix(size, size);
		for(int j = 0; j < size; j++)
			for(int i = 0; i < size; i++)
				if(i == j)
					toReturn.set(i, j, 1);
		return toReturn;
	}

	public static Matrix getCrossProductMatrix(Vector3D v) {
		Matrix toReturn = new Matrix(3, 3);
		toReturn.set(0, 0, v.getX() * v.getX());
		toReturn.set(1, 0, v.getX() * v.getY());
		toReturn.set(2, 0, v.getX() * v.getZ());
		toReturn.set(0, 1, v.getX() * v.getY());
		toReturn.set(1, 1, v.getY() * v.getY());
		toReturn.set(2, 1, v.getY() * v.getZ());
		toReturn.set(0, 2, v.getX() * v.getZ());
		toReturn.set(1, 2, v.getY() * v.getZ());
		toReturn.set(2, 2, v.getZ() * v.getZ());
		return toReturn;
	}

	public static Vector3D rotateVector(Vector3D v1, Vector3D v2, double angle) {
		//[v]' = [v]x{[i] + sin(a)/d*[L] + ((1 - cos(a))/(d*d)*([L]x[L]))}
		if(v1.isZeroVector() || v2.isZeroVector())
			return new Vector3D(0, 0, 0);
		Matrix v = new Matrix(new double[]{v1.getX(), v1.getY(), v1.getZ()}, 3, 1);
		Vector3D axis = v2.clone();
		Matrix identity = MT.getIdentityMatrix(3);
		Matrix L = new Matrix(new double[]{0, axis.getZ(), -axis.getY(), -axis.getZ(), 0, axis.getX(), axis.getY(), -axis.getX(), 0}, 3, 3);
		double d = axis.getMagnitude();
		double a = angle;
		Matrix rot = MT.addMatrices(MT.addMatrices(identity, L.multiplyGet((MT.sin(a) / d))), 
				(MT.multiplyMatrices(L, L)).multiplyGet(((1 - MT.cos(a)) / (d * d))));
		Matrix prime = MT.multiplyMatrices(v, rot);
		return new Vector3D(prime.get(0, 0), prime.get(1, 0), prime.get(2, 0));
	}

	public static double dRound(double v) {
		return nRound(v, 2);
	}
	
	public static double nRound(double v, int n) {
		boolean roundingOn = true;
		if(roundingOn) {
			if(Double.isNaN(v))
				return v;
			if(v < .0000000001 && v > -.0000000001)
				return 0;
			String vStr = v + "";
			if(vStr.length() - vStr.indexOf(".") > 1 + n) {
				String subnvStr = vStr.substring(0, vStr.indexOf(".") + 1 + n);
				return Double.parseDouble(subnvStr);
			}
			else
				return v;
		}
		else
			return v;
	}
}
