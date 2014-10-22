package data;

import engine.MapGenerator;
import geometric.Point3D;
import geometric.Triangle3D;
import geometric.Vector3D;

import java.util.ArrayList;

public class Setup {
	//private Random r;
	//private Solids solids;
	private ArrayList<Triangle3D> faces;
	private Point3D viewLocation;
	private Vector3D viewDirection;
	private Vector3D viewRotation;
	private MapGenerator mapGenerator;

	public Setup() {
		//r = new Random(5);
		//solids = new Solids();

		faces = new ArrayList<Triangle3D>();
		viewLocation = new Point3D(-10, 0, 0);
		viewDirection = new Vector3D(1.001, 0.001, 0.001);
		viewRotation = new Vector3D(0, 1, 0);
		mapGenerator = new MapGenerator();
		addToWorld();
	}

	public ArrayList<Triangle3D> getFaces() {
		return faces;
	}

	public void setFaces(ArrayList<Triangle3D> faces) {
		this.faces = faces;
	}

	private void addToWorld() {
		//		{
		//			double s = 12;
		//			double n = 40;
		//			for(int i = 0; i < n; i++)
		//				faces.add(new Triangle3D(0, 0, 0, n * s - i * s, 0, i * s, 0, i * s, i * s));
		//		}
		//		
		//		int numDodecahedrons = 500;
		//		for(int i = 0; i < numDodecahedrons; i++)
		//		{
		//			int s = 30;
		//			int x = (r.nextInt(40) - 20) * 200;
		//			int y = (r.nextInt(40) - 20) * 200;
		//			int z = (r.nextInt(40) - 20) * 200;
		//
		//			for(Triangle3D t3D : solids.getDodecahedronTriangles(s, x, y, z))
		//				faces.add(t3D);
		//		}
		//
		//		int numIcosahedrons = 1000;
		//		for(int i = 0; i < numIcosahedrons; i++)
		//		{
		//			int s = 60;
		//			int x = (r.nextInt(40) - 20) * 200;
		//			int y = (r.nextInt(40) - 20) * 200;
		//			int z = (r.nextInt(40) - 20) * 200;
		//
		//			for(Triangle3D t3D : solids.getIcosahedronTriangles(s, x, y, z))
		//				faces.add(t3D);
		//		}
		//
		//		int numTetrahedrons = 500;
		//		for(int i = 0; i < numTetrahedrons; i++)
		//		{
		//			int s = 20;
		//			int x = (r.nextInt(40) - 20) * 200;
		//			int y = (r.nextInt(40) - 20) * 200;
		//			int z = (r.nextInt(40) - 20) * 200;
		//
		//			for(Triangle3D t3D : solids.getTetrahedronTriangles(s, x, y, z))
		//				faces.add(t3D);
		//		}
		//
		//		int numCubes = 800;
		//		for(int i = 0; i < numCubes; i++)
		//		{
		//			int s = 70;
		//			int x = (r.nextInt(80) - 40) * 200;
		//			int y = -250;
		//			int z = (r.nextInt(80) - 40) * 200;
		//
		//			for(Triangle3D t3D : solids.getCubeTriangles(s, x, y, z))
		//				faces.add(t3D);
		//		}

//		for(int i = 0; i < 50; i++) {
//			for(int j = 0; j < 50; j++) {
//				int s = 50;
//				int b = -1000;
//				int x = b + i * s * 2 + s * (j % 2);
//				int y = -130;
//				int z = b + j * s;
//				faces.add(new Triangle3D(x, y, z, x + s, y, z, x, y, z + s));
//				faces.add(new Triangle3D(x + s, y, z + s, x + s, y, z, x, y, z + s));
//				if(i % 5 == 0 && j == 20) {
//					faces.add(new Triangle3D(x, y + 50, z, x + s, y + 50, z, x, y + 50, z + s));
//					faces.add(new Triangle3D(x + s, y + 50, z + s, x + s, y + 50, z, x, y + 50, z + s));
//				}
//			}
//		}
		
		for(Triangle3D t3D : mapGenerator.get())
			faces.add(t3D);
	}

	public Point3D getViewLocation() {
		return viewLocation;
	}

	public void setViewLocation(Point3D viewLocation) {
		this.viewLocation = viewLocation;
	}

	public Vector3D getViewDirection() {
		return viewDirection;
	}

	public void setViewDirection(Vector3D viewDirection) {
		this.viewDirection = viewDirection;
	}

	public Vector3D getViewRotation() {
		return viewRotation;
	}

	public void setViewRotation(Vector3D viewRotation) {
		this.viewRotation = viewRotation;
	}
}
