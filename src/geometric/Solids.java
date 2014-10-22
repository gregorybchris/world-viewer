package geometric;

import java.util.ArrayList;

import math.MT;

public class Solids {
	public Solids() {}
	
	public ArrayList<Triangle3D> getDodecahedronTriangles(int s, int x, int y, int z) {
		ArrayList<Triangle3D> toReturn = new ArrayList<Triangle3D>();

		Point3D[] ps = new Point3D[20];
		
		ps[0] = new Point3D(x + s, y + s, z + s);
		ps[1] = new Point3D(x - s, y + s, z + s);
		ps[2] = new Point3D(x + s, y - s, z + s);
		ps[3] = new Point3D(x + s, y + s, z - s);
		ps[4] = new Point3D(x - s, y - s, z + s);
		ps[5] = new Point3D(x + s, y - s, z - s);
		ps[6] = new Point3D(x - s, y + s, z - s);
		ps[7] = new Point3D(x - s, y - s, z - s);
		
		ps[8] = new Point3D(x, y + s / MT.PHI, z + s * MT.PHI);
		ps[9] = new Point3D(x, y - s / MT.PHI, z + s * MT.PHI);
		ps[10] = new Point3D(x, y + s / MT.PHI, z - s * MT.PHI);
		ps[11] = new Point3D(x, y - s / MT.PHI, z - s * MT.PHI);
		
		ps[12] = new Point3D(x + s / MT.PHI, y + s * MT.PHI, z);
		ps[13] = new Point3D(x - s / MT.PHI, y + s * MT.PHI, z);
		ps[14] = new Point3D(x + s / MT.PHI, y - s * MT.PHI, z);
		ps[15] = new Point3D(x - s / MT.PHI, y - s * MT.PHI, z);
		
		ps[16] = new Point3D(x + s * MT.PHI, y, z + s / MT.PHI);
		ps[17] = new Point3D(x - s * MT.PHI, y, z + s / MT.PHI);
		ps[18] = new Point3D(x + s * MT.PHI, y, z - s / MT.PHI);
		ps[19] = new Point3D(x - s * MT.PHI, y, z - s / MT.PHI);
		
		toReturn.add(new Triangle3D(ps[9], ps[4], ps[14]));
		toReturn.add(new Triangle3D(ps[9], ps[2], ps[14]));
		toReturn.add(new Triangle3D(ps[4], ps[15], ps[14]));
		
		toReturn.add(new Triangle3D(ps[9], ps[4], ps[1]));
		toReturn.add(new Triangle3D(ps[9], ps[8], ps[1]));
		toReturn.add(new Triangle3D(ps[4], ps[17], ps[1]));
		
		toReturn.add(new Triangle3D(ps[19], ps[17], ps[15]));
		toReturn.add(new Triangle3D(ps[17], ps[4], ps[15]));
		toReturn.add(new Triangle3D(ps[19], ps[7], ps[15]));
		
		toReturn.add(new Triangle3D(ps[19], ps[17], ps[13]));
		toReturn.add(new Triangle3D(ps[19], ps[6], ps[13]));
		toReturn.add(new Triangle3D(ps[17], ps[1], ps[13]));
		
		toReturn.add(new Triangle3D(ps[8], ps[0], ps[13]));
		toReturn.add(new Triangle3D(ps[8], ps[1], ps[13]));
		toReturn.add(new Triangle3D(ps[0], ps[12], ps[13]));
		
		toReturn.add(new Triangle3D(ps[8], ps[0], ps[2]));
		toReturn.add(new Triangle3D(ps[8], ps[9], ps[2]));
		toReturn.add(new Triangle3D(ps[0], ps[16], ps[2]));
		
		toReturn.add(new Triangle3D(ps[3], ps[10], ps[5]));
		toReturn.add(new Triangle3D(ps[3], ps[18], ps[5]));
		toReturn.add(new Triangle3D(ps[10], ps[11], ps[5]));
		
		toReturn.add(new Triangle3D(ps[3], ps[10], ps[13]));
		toReturn.add(new Triangle3D(ps[3], ps[12], ps[13]));
		toReturn.add(new Triangle3D(ps[10], ps[6], ps[13]));
		
		toReturn.add(new Triangle3D(ps[18], ps[16], ps[12]));
		toReturn.add(new Triangle3D(ps[18], ps[3], ps[12]));
		toReturn.add(new Triangle3D(ps[16], ps[0], ps[12]));
		
		toReturn.add(new Triangle3D(ps[18], ps[16], ps[14]));
		toReturn.add(new Triangle3D(ps[18], ps[5], ps[14]));
		toReturn.add(new Triangle3D(ps[16], ps[2], ps[14]));
		
		toReturn.add(new Triangle3D(ps[7], ps[11], ps[6]));
		toReturn.add(new Triangle3D(ps[7], ps[19], ps[6]));
		toReturn.add(new Triangle3D(ps[11], ps[10], ps[6]));
		
		toReturn.add(new Triangle3D(ps[7], ps[11], ps[14]));
		toReturn.add(new Triangle3D(ps[7], ps[15], ps[14]));
		toReturn.add(new Triangle3D(ps[11], ps[5], ps[14]));
		
		return toReturn;
	}
	
	public ArrayList<Triangle3D> getCubeTriangles(int s, int x, int y, int z) {
		ArrayList<Triangle3D> toReturn = new ArrayList<Triangle3D>();
		
		Point3D p1 = new Point3D(x + s / 2, y + s / 2, z + s / 2);
		Point3D p2 = new Point3D(x - s / 2, y + s / 2, z + s / 2);
		Point3D p3 = new Point3D(x - s / 2, y + s / 2, z - s / 2);
		Point3D p4 = new Point3D(x + s / 2, y + s / 2, z - s / 2);
		
		Point3D p5 = new Point3D(x + s / 2, y - s / 2, z + s / 2);
		Point3D p6 = new Point3D(x - s / 2, y - s / 2, z + s / 2);
		Point3D p7 = new Point3D(x - s / 2, y - s / 2, z - s / 2);
		Point3D p8 = new Point3D(x + s / 2, y - s / 2, z - s / 2);
		
		toReturn.add(new Triangle3D(p1, p2, p3));
		toReturn.add(new Triangle3D(p1, p3, p4));
		
		toReturn.add(new Triangle3D(p3, p4, p8));
		toReturn.add(new Triangle3D(p3, p7, p8));
		
		toReturn.add(new Triangle3D(p1, p4, p8));
		toReturn.add(new Triangle3D(p1, p5, p8));
		
		toReturn.add(new Triangle3D(p2, p3, p7));
		toReturn.add(new Triangle3D(p2, p6, p7));
		
		toReturn.add(new Triangle3D(p5, p6, p7));
		toReturn.add(new Triangle3D(p5, p7, p8));
		
		toReturn.add(new Triangle3D(p1, p2, p5));
		toReturn.add(new Triangle3D(p2, p5, p6));
		
		return toReturn;
	}
	
	public ArrayList<Triangle3D> getTetrahedronTriangles(int s, int x, int y, int z) {
		ArrayList<Triangle3D> toReturn = new ArrayList<Triangle3D>();
		
		Point3D p1 = new Point3D(x, y, z);
		Point3D p2 = new Point3D(x, y + 2 * s, z + 3 * s);
		Point3D p3 = new Point3D(x - MT.SQRT_3 * s, y - s, z + 3 * s);
		Point3D p4 = new Point3D(x + MT.SQRT_3 * s, y - s, z + 3 * s);

		Triangle3D t1 = new Triangle3D(p1, p2, p3);
		Triangle3D t2 = new Triangle3D(p1, p3, p4);
		Triangle3D t3 = new Triangle3D(p1, p2, p4);
		Triangle3D t4 = new Triangle3D(p2, p3, p4);

		toReturn.add(t1);
		toReturn.add(t2);
		toReturn.add(t3);
		toReturn.add(t4);
		
		return toReturn;
	}
	
	public ArrayList<Triangle3D> getIcosahedronTriangles(int s, int x, int y, int z) {
		ArrayList<Triangle3D> toReturn = new ArrayList<Triangle3D>();
		
		Point3D[] ps = new Point3D[12];

		ps[0] = new Point3D(x, y + -(s / 2), z + (s / 2) * -MT.PHI);
		ps[1] = new Point3D(x, y + (s / 2), z + (s / 2) * -MT.PHI);
		ps[2] = new Point3D(x, y + -(s / 2), z + (s / 2) * MT.PHI);
		ps[3] = new Point3D(x, y + (s / 2), z + (s / 2) * MT.PHI);

		ps[4] = new Point3D(x + -(s / 2), y + (s / 2) * -MT.PHI, z);
		ps[5] = new Point3D(x + (s / 2), y + (s / 2) * -MT.PHI, z);
		ps[6] = new Point3D(x + -(s / 2), y + (s / 2) * MT.PHI, z);
		ps[7] = new Point3D(x + (s / 2), y + (s / 2) * MT.PHI, z);

		ps[8] = new Point3D(x + (s / 2) * -MT.PHI, y, z + -(s / 2));
		ps[9] = new Point3D(x + (s / 2) * -MT.PHI, y, z + (s / 2));
		ps[10] = new Point3D(x + (s / 2) * MT.PHI, y, z + -(s / 2));
		ps[11] = new Point3D(x + (s / 2) * MT.PHI, y, z + (s / 2));

		toReturn.add(new Triangle3D(ps[0], ps[4], ps[5]));
		toReturn.add(new Triangle3D(ps[0], ps[4], ps[8]));
		toReturn.add(new Triangle3D(ps[0], ps[1], ps[8]));
		toReturn.add(new Triangle3D(ps[0], ps[1], ps[10]));
		toReturn.add(new Triangle3D(ps[0], ps[5], ps[10]));
		
		toReturn.add(new Triangle3D(ps[1], ps[7], ps[10]));
		toReturn.add(new Triangle3D(ps[5], ps[10], ps[11]));
		toReturn.add(new Triangle3D(ps[2], ps[4], ps[5]));
		toReturn.add(new Triangle3D(ps[4], ps[8], ps[9]));
		toReturn.add(new Triangle3D(ps[1], ps[6], ps[8]));
		
		toReturn.add(new Triangle3D(ps[1], ps[6], ps[7]));
		toReturn.add(new Triangle3D(ps[2], ps[4], ps[9]));
		toReturn.add(new Triangle3D(ps[6], ps[8], ps[9]));
		toReturn.add(new Triangle3D(ps[2], ps[5], ps[11]));
		toReturn.add(new Triangle3D(ps[7], ps[10], ps[11]));
		
		toReturn.add(new Triangle3D(ps[3], ps[6], ps[7]));
		toReturn.add(new Triangle3D(ps[2], ps[3], ps[9]));
		toReturn.add(new Triangle3D(ps[3], ps[6], ps[9]));
		toReturn.add(new Triangle3D(ps[2], ps[3], ps[11]));
		toReturn.add(new Triangle3D(ps[3], ps[7], ps[11]));
		
		return toReturn;
	}
}
