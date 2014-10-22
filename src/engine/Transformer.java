package engine;

import geometric.Triangle2D;
import geometric.Triangle3D;
import geometric.Vector3D;
import graphics.GV;

import java.util.ArrayList;

import data.View;
import math.MT;

public class Transformer {
	private View view;
	private ArrayList<Triangle3D> faces;

	public Transformer(View view, ArrayList<Triangle3D> faces) {
		this.view = view;
		this.faces = faces;
	}

	public ArrayList<Triangle2D> getTrianglesToDraw() {
		ArrayList<Triangle2D> toReturn = projectFor2DSpace(faces);
		translateForComputerScreen(toReturn);
		return toReturn;
	}

	private ArrayList<Triangle2D> projectFor2DSpace(ArrayList<Triangle3D> faces) {
		ArrayList<Triangle2D> toReturn = new ArrayList<Triangle2D>();
		for(Triangle3D t3D: faces) {
			if(View.INFINITE_DEPTH || (MT.distance(t3D.getPoint1(), view.getLocation()) < View.VIEW_MAX_DEPTH && 
					MT.distance(t3D.getPoint2(), view.getLocation()) < View.VIEW_MAX_DEPTH &&
					MT.distance(t3D.getPoint3(), view.getLocation()) < View.VIEW_MAX_DEPTH)) {

				Vector3D viewDirection = view.getDirection();
				Vector3D viewRotation = view.getRotation();

				Vector3D pointVector1 = new Vector3D(view.getLocation(), t3D.getPoint1());
				Vector3D pointVector2 = new Vector3D(view.getLocation(), t3D.getPoint2());
				Vector3D pointVector3 = new Vector3D(view.getLocation(), t3D.getPoint3());

				double pointAngle1 = MT.angleBetween(viewDirection, pointVector1);
				double pointAngle2 = MT.angleBetween(viewDirection, pointVector2);
				double pointAngle3 = MT.angleBetween(viewDirection, pointVector3);

				if(pointAngle1 < View.VIEW_MAX_ANGLE || pointAngle2 < View.VIEW_MAX_ANGLE || pointAngle3 < View.VIEW_MAX_ANGLE) {
					Triangle2D toAdd = new Triangle2D();

					double fractionDistance1 = pointAngle1 / View.VIEW_MAX_ANGLE;
					double fractionDistance2 = pointAngle2 / View.VIEW_MAX_ANGLE;
					double fractionDistance3 = pointAngle3 / View.VIEW_MAX_ANGLE;

					double radialDistance1 = fractionDistance1 * GV.MAIN_DIAGONAL / 2;
					double radialDistance2 = fractionDistance2 * GV.MAIN_DIAGONAL / 2;
					double radialDistance3 = fractionDistance3 * GV.MAIN_DIAGONAL / 2;

					Vector3D rightVector = MT.crossProduct(viewDirection, viewRotation);

					Vector3D pointRotationVectorTurned1 = MT.crossProduct(viewDirection, pointVector1);
					Vector3D pointRotationVector1 = MT.rotateVector(pointRotationVectorTurned1, viewDirection, -MT.PI / 2).getNormalized();
					Vector3D pointRotationVectorTurned2 = MT.crossProduct(viewDirection, pointVector2);
					Vector3D pointRotationVector2 = MT.rotateVector(pointRotationVectorTurned2, viewDirection, -MT.PI / 2).getNormalized();
					Vector3D pointRotationVectorTurned3 = MT.crossProduct(viewDirection, pointVector3);
					Vector3D pointRotationVector3 = MT.rotateVector(pointRotationVectorTurned3, viewDirection, -MT.PI / 2).getNormalized();

					double pointRotation1 = MT.angleBetween(pointRotationVector1, rightVector);
					if(pointRotationVectorTurned1.isZeroVector())
						pointRotation1 = 0;
					double pointRotation2 = MT.angleBetween(pointRotationVector2, rightVector);
					if(pointRotationVectorTurned2.isZeroVector())
						pointRotation2 = 0;
					double pointRotation3 = MT.angleBetween(pointRotationVector3, rightVector);
					if(pointRotationVectorTurned3.isZeroVector())
						pointRotation3 = 0;
					
					if(MT.angleBetween(viewRotation, pointRotationVector1) > MT.PI / 2)
						pointRotation1 = (MT.PI * 2) - pointRotation1;
					if(MT.angleBetween(viewRotation, pointRotationVector2) > MT.PI / 2)
						pointRotation2 = (MT.PI * 2) - pointRotation2;
					if(MT.angleBetween(viewRotation, pointRotationVector3) > MT.PI / 2)
						pointRotation3 = (MT.PI * 2) - pointRotation3;

					toAdd.x1 = MT.cos(pointRotation1) * radialDistance1;
					toAdd.y1 = MT.sin(pointRotation1) * radialDistance1;
					toAdd.x2 = MT.cos(pointRotation2) * radialDistance2;
					toAdd.y2 = MT.sin(pointRotation2) * radialDistance2;
					toAdd.x3 = MT.cos(pointRotation3) * radialDistance3;
					toAdd.y3 = MT.sin(pointRotation3) * radialDistance3;

					toReturn.add(toAdd);
				}
			}
		}
		return toReturn;
	}

	private void translateForComputerScreen(ArrayList<Triangle2D> triangles) {
		for(Triangle2D t2D : triangles) {
			t2D.x1 += GV.MAIN_WIDTH / 2;
			t2D.x2 += GV.MAIN_WIDTH / 2;
			t2D.x3 += GV.MAIN_WIDTH / 2;
			t2D.y1 = t2D.y1 * -1 + GV.MAIN_HEIGHT / 2;
			t2D.y2 = t2D.y2 * -1 + GV.MAIN_HEIGHT / 2;
			t2D.y3 = t2D.y3 * -1 + GV.MAIN_HEIGHT / 2;
		}
	}
}
