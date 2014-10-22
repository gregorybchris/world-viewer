package engine;

import data.Setup;
import data.View;
import data.World;
import geometric.Triangle2D;
import geometric.Vector3D;

import java.util.ArrayList;

import math.MT;

public class Manager {
	private Setup setup;
	private World world;
	private Transformer transformer;
	private PlayerPhysics playerPhysics;
	private View view;

	public Manager() {
		this.setup = new Setup();
		this.world = new World();
		this.world.setFaces(setup.getFaces());
		this.view = new View(setup.getViewLocation(), setup.getViewDirection(), setup.getViewRotation());
		this.playerPhysics = new PlayerPhysics(view);
		this.transformer = new Transformer(this.view, this.world.getFaces());
	}

	public ArrayList<Triangle2D> getTrianglesToDraw() {
		return transformer.getTrianglesToDraw();
	}

	public View getView() {
		return this.view;
	}
	
	public void playerUpdate() {
		playerPhysics.updatePlayer();
	}
	
	public void playerJump() {
		playerPhysics.jump();
	}

	public void moveTranslate(double dx, double dy, double dz) {
		view.getLocation().translate(dx, dy, dz);
	}

	public void moveTranslateVector(Vector3D direction, double distance) {
		double oldMagnitude = direction.getMagnitude();
		double newMagnitude = distance;
		view.getLocation().translate(direction.getX() * newMagnitude / oldMagnitude, 
				direction.getY() * newMagnitude / oldMagnitude, 
				direction.getZ() * newMagnitude / oldMagnitude);
	}
	
	public void moveTranslateVectorPlane(Vector3D direction, double distance) {
		double dX = distance * direction.getX() / (MT.abs(direction.getX()) + MT.abs(direction.getZ()));
		double dZ = distance * direction.getZ() / (MT.abs(direction.getX()) + MT.abs(direction.getZ()));
		view.getLocation().translate(dX, 0, dZ);
	}

	public void moveRotateYaw(double angle) {
		view.setDirection(MT.rotateVector(view.getDirection(), view.getRotation(), angle));
	}

	public void moveRotateRoll(double angle) {
		Vector3D newVector = MT.rotateVector(view.getRotation(), view.getDirection(), angle);
		if(newVector.getY() >= 0)
			view.setRotation(newVector);
	}

	public void moveRotatePitch(double angle) {
		moveRotateRoll(-MT.PI / 2);
		moveRotateYaw(angle);
		moveRotateRoll(MT.PI / 2);
	}

	public void moveRotatePlane(double angle) {
		Vector3D yAxis = new Vector3D(0, 1, 0);
		view.setDirection(MT.rotateVector(view.getDirection(), yAxis, angle));
		view.setRotation(MT.rotateVector(view.getRotation(), yAxis, angle));
	}
}
