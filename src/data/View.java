package data;

import math.MT;
import geometric.Point3D;
import geometric.Vector3D;

public class View {
	public static final double VIEW_REGULAR_ANGLE = MT.PI / 3.5;
	public static final double VIEW_FISHEYE_ANGLE = MT.PI / 1.3;
	public static final double VIEW_360_ANGLE = MT.PI * 2;
	
	public static double VIEW_MAX_ANGLE = VIEW_REGULAR_ANGLE;
	public static final double VIEW_MAX_DEPTH = 1000;
	
	public static final double MOVE_SPEED = 25;
	public static final double TURN_SPEED = 15;
	
	public static boolean INFINITE_DEPTH = false;
	public static boolean FLYING = false;
	
	private Point3D location;
	private Vector3D direction;
	private Vector3D rotation;
	
	public View() {
		this.location = new Point3D(0, 0, 0);
		direction = new Vector3D(1, 0, 0);
		rotation = new Vector3D(0, 1, 0);
	}
	
	public View(Point3D location, Vector3D direction, Vector3D rotation) {
		this.location = location;
		this.direction = direction;
		this.rotation = rotation;
	}

	public Point3D getLocation() {
		return location;
	}

	public void setLocation(Point3D location) {
		this.location = location;
	}
	
	public Vector3D getDirection() {
		return this.direction;
	}

	public void setDirection(Vector3D direction) {
		this.direction = direction;
	}
	
	public Vector3D getRotation() {
		return rotation;
	}

	public void setRotation(Vector3D rotation) {
		this.rotation = rotation;
	}
	
	@Override
	public String toString() {
		return "View[Direction: " + direction + ", Location: " + location + "]"; 
	}
}
