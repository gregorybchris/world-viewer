package data;

import geometric.Triangle3D;

import java.util.ArrayList;

public class World {
	private ArrayList<Triangle3D> faces;

	public World() {
		faces = new ArrayList<Triangle3D>();
	}
	
	public World(ArrayList<Triangle3D> faces) {
		this.faces = faces;
	}

	public void addTriangle(Triangle3D t) {
		this.faces.add(t);
	}

	public ArrayList<Triangle3D> getFaces() {
		return faces;
	}

	public void setFaces(ArrayList<Triangle3D> faces) {
		this.faces = faces;
	}
	
	@Override
	public String toString() {
		String toReturn = "World{";
		for(Triangle3D t3D : faces)
			toReturn += t3D + ", ";
		return toReturn.substring(0, toReturn.length() - 2) + "}";
	}
}
