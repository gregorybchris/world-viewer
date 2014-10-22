package graphics;

import java.awt.AWTException;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JPanel;

import math.MT;
import data.View;
import engine.Manager;
import geometric.Point3D;
import geometric.Triangle2D;
import geometric.Vector3D;


public class GraphicsPanel extends JPanel implements KeyListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;

	private Manager manager;
	private Robot robot;

	private HashSet<Integer> keys;
	private Point mouseLocation;

	private String fontName = "CamptonBold.otf";
	private Font font;

	public GraphicsPanel() {
		this.setFocusable(true);
		this.addKeyListener(this);
		this.addMouseMotionListener(this);
		manager = new Manager();
		keys = new HashSet<Integer>();
		mouseLocation = new Point((int) (GV.MAIN_WIDTH / 2), (int) (GV.MAIN_HEIGHT / 2));

		try {
			robot = new Robot();
			font = Font.createFont(Font.TRUETYPE_FONT, 
					GraphicsPanel.class.getClassLoader().getResourceAsStream(fontName));
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void makeUpdate(double delta) {
		updateData(delta);
		repaint();
	}

	private void updateData(double delta) {
		if(!View.FLYING)
			manager.playerUpdate();
		moveFromKeys();
		moveFromMouse();
	}

	private void moveFromMouse() {
		int dX = mouseLocation.x - (int) (GV.MAIN_WIDTH / 2);
		int dY = mouseLocation.y - (int) (GV.MAIN_HEIGHT / 2);
		manager.moveRotatePlane(-(View.TURN_SPEED * dX) / 3000);
		manager.moveRotatePitch((View.TURN_SPEED * dY) / 3000);

		robot.mouseMove((int) (GV.MAIN_WIDTH / 2), (int) (GV.MAIN_HEIGHT / 2));
	}

	private void moveFromKeys() {
		if(keys.contains(KeyEvent.VK_W))
			manager.moveTranslateVectorPlane(manager.getView().getDirection(), View.MOVE_SPEED);
		if(keys.contains(KeyEvent.VK_S))
			manager.moveTranslateVectorPlane(manager.getView().getDirection().getMultipliedBy(-1), View.MOVE_SPEED);

		if(keys.contains(KeyEvent.VK_A))
			manager.moveTranslateVector(MT.rotateVector(manager.getView().getDirection(), 
					manager.getView().getRotation(), MT.PI / 2), View.MOVE_SPEED);
		if(keys.contains(KeyEvent.VK_D))
			manager.moveTranslateVector(MT.rotateVector(manager.getView().getDirection(), 
					manager.getView().getRotation(), -MT.PI / 2), View.MOVE_SPEED);

		if(View.FLYING) {
			if(keys.contains(KeyEvent.VK_SHIFT))
				manager.moveTranslateVector(new Vector3D(0, -1, 0), View.MOVE_SPEED);
			if(keys.contains(KeyEvent.VK_SPACE))
				manager.moveTranslateVector(new Vector3D(0, 1, 0), View.MOVE_SPEED);
		}
		else {
			if(keys.contains(KeyEvent.VK_SPACE))
				manager.playerJump();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.clearRect(0, 0, (int)GV.MAIN_WIDTH, (int)GV.MAIN_HEIGHT);

		g2.setStroke(GV.PEN_STROKES[1]);

		g2.setColor(GV.COL_BACKGROUND);
		g2.fillRect(0, 0, (int)GV.MAIN_WIDTH, (int)GV.MAIN_HEIGHT);

		ArrayList<Triangle2D> triangles = manager.getTrianglesToDraw();
		for(Triangle2D t2D : triangles) {
			if(GV.FACES) {
				g2.setStroke(GV.PEN_STROKES[1]);
				g2.setColor(GV.COL_FACE);
				Polygon p = new Polygon(new int[]{(int)t2D.x1, (int)t2D.x2, (int)t2D.x3}, 
						new int[]{(int)t2D.y1, (int)t2D.y2, (int)t2D.y3}, 3);
				g2.fill(p);
			}
			if(GV.LINES) {
				g2.setStroke(GV.PEN_STROKES[GV.LINE_WIDTH]);
				g2.setColor(GV.COL_LINE);
				g2.drawLine((int)t2D.x1, (int)t2D.y1, (int)t2D.x2, (int)t2D.y2);
				g2.drawLine((int)t2D.x2, (int)t2D.y2, (int)t2D.x3, (int)t2D.y3);
				g2.drawLine((int)t2D.x3, (int)t2D.y3, (int)t2D.x1, (int)t2D.y1);
			}
			if(GV.POINTS) {
				g2.setStroke(GV.PEN_STROKES[1]);
				g2.setColor(GV.COL_POINT);
				g2.fillOval((int)t2D.x1 - GV.POINT_RADIUS, (int)t2D.y1 - GV.POINT_RADIUS, 
						GV.POINT_RADIUS * 2, GV.POINT_RADIUS * 2);
				g2.fillOval((int)t2D.x2 - GV.POINT_RADIUS, (int)t2D.y2 - GV.POINT_RADIUS, 
						GV.POINT_RADIUS * 2, GV.POINT_RADIUS * 2);
				g2.fillOval((int)t2D.x3 - GV.POINT_RADIUS, (int)t2D.y3 - GV.POINT_RADIUS, 
						GV.POINT_RADIUS * 2, GV.POINT_RADIUS * 2);
			}
		}

		String header1 = "World Viewer";
		String header2 = "Chris Gregory";
		Point3D loc = manager.getView().getLocation();
		String footer = "[" + MT.dRound(loc.x / 100) + ", " + MT.dRound(loc.y / 100) + ", " + MT.dRound(loc.z / 100) + "]";
		g2.setColor(GV.COL_TEXT);
		g2.setFont(font.deriveFont(20f));
		g2.drawString(header1, 20, 30);
		g2.drawString(header2, (int)(GV.MAIN_WIDTH - 160), 30);
		g2.drawString(footer, 20, (int)(GV.MAIN_HEIGHT - 20));
		g2.drawString(getCardinalDirection(manager.getView().getDirection()), 
				(int)(GV.MAIN_WIDTH - 60), (int)(GV.MAIN_HEIGHT - 20));
	}
	
	private String getCardinalDirection(Vector3D dir) {
		String[] directions = {"E", "NE", "N", "NW", "W", "SW", "S", "SE"};
		double angle = MT.atan(-dir.getX(), dir.getZ());
		int octant = (int) (MT.round(8 * angle / (2 * MT.PI) + 8) % 8);
		return directions[octant];
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		mouseLocation = me.getPoint();
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		int kc = ke.getKeyCode();
		if(checkKey(kc))
			if(!keys.contains(kc))
				keys.add(kc);
		
		if(kc == KeyEvent.VK_ESCAPE)
			System.exit(0);
		else if(kc == KeyEvent.VK_1)
			GV.POINTS = !GV.POINTS;
		else if(kc == KeyEvent.VK_2)
			GV.LINES = !GV.LINES;
		else if(kc == KeyEvent.VK_3)
			GV.FACES = !GV.FACES;
		else if(kc == KeyEvent.VK_4)
			GV.COL_FACE = GV.COL_FACE_RED;
		else if(kc == KeyEvent.VK_5)
			GV.COL_FACE = GV.COL_FACE_ORANGE;
		else if(kc == KeyEvent.VK_6)
			GV.COL_FACE = GV.COL_FACE_YELLOW;
		else if(kc == KeyEvent.VK_7)
			GV.COL_FACE = GV.COL_FACE_GREEN;
		else if(kc == KeyEvent.VK_8)
			GV.COL_FACE = GV.COL_FACE_BLUE;
		else if(kc == KeyEvent.VK_9)
			GV.COL_FACE = GV.COL_FACE_VIOLET;
		else if(kc == KeyEvent.VK_0) {
			if(View.VIEW_MAX_ANGLE == View.VIEW_FISHEYE_ANGLE)
				View.VIEW_MAX_ANGLE = View.VIEW_REGULAR_ANGLE;
			else 
				View.VIEW_MAX_ANGLE = View.VIEW_FISHEYE_ANGLE;
		}
		else if(kc == KeyEvent.VK_EQUALS) {
			View.FLYING = !View.FLYING;
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		int kc = ke.getKeyCode();
		if(checkKey(kc))
			if(keys.contains(kc))
				keys.remove(kc);
	}

	private boolean checkKey(int kc) {
		return (kc == KeyEvent.VK_W || kc == KeyEvent.VK_A || 
				kc == KeyEvent.VK_S || kc == KeyEvent.VK_D ||
				kc == KeyEvent.VK_SPACE || kc == KeyEvent.VK_SHIFT ||
				kc == KeyEvent.VK_1 || kc == KeyEvent.VK_2 ||
				kc == KeyEvent.VK_3 || kc == KeyEvent.VK_4);
	}

	@Override
	public void keyTyped(KeyEvent ke) {}

	@Override
	public void mouseDragged(MouseEvent me) {}
}