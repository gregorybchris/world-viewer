package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import math.MT;

public class GV {
	// ~ ~ ~ ~ ~ //   SCREEN   // ~ ~ ~ ~ ~ //
		public static final GraphicsDevice GD = 
				GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
		public static final Toolkit TK = Toolkit.getDefaultToolkit();
	
	// ~ ~ ~ ~ ~ //   SIZES   // ~ ~ ~ ~ ~ //
	public static final double MAIN_WIDTH = TK.getScreenSize().getWidth();
	public static final double MAIN_HEIGHT = TK.getScreenSize().getHeight();
	public static final double MAIN_DIAGONAL = MT.sqrt(MAIN_WIDTH * MAIN_WIDTH + MAIN_HEIGHT * MAIN_HEIGHT);
	
	public static final int FPS = 80;
	
	public static final int POINT_RADIUS = 2;
	public static final int LINE_WIDTH = 1;
	
	public static boolean FACES = true;
	public static boolean LINES = false;
	public static boolean POINTS = false;
	
	// ~ ~ ~ ~ ~ //   COLORS   // ~ ~ ~ ~ ~ //
	public static final Color COL_BACKGROUND = new Color(30, 30, 30);
	
	public static final Color COL_TEXT = new Color(.95f, .95f, .95f, .1f);
	
	public static final Color COL_FACE_RED = new Color(.9f, .3f, .3f, .4f);
	public static final Color COL_FACE_ORANGE = new Color(.9f, .6f, .3f, .4f);
	public static final Color COL_FACE_YELLOW = new Color(.9f, .9f, .3f, .4f);
	public static final Color COL_FACE_GREEN = new Color(.3f, .9f, .3f, .4f);
	public static final Color COL_FACE_BLUE = new Color(.3f, .3f, .9f, .4f);
	public static final Color COL_FACE_VIOLET = new Color(.5f, .2f, .9f, .4f);
	
	public static final Color COL_POINT = new Color(200, 200, 200);
	public static final Color COL_LINE = new Color(0, 0, 0);//new Color(120, 120, 120);
	public static Color COL_FACE = COL_FACE_VIOLET;
	
	// ~ ~ ~ ~ ~ //   STROKES   // ~ ~ ~ ~ ~ //
	public static final BasicStroke[] PEN_STROKES = new BasicStroke[] {
		new BasicStroke(0), new BasicStroke(1), new BasicStroke(2), new BasicStroke(3), 
		new BasicStroke(4), new BasicStroke(5), new BasicStroke(6), new BasicStroke(7), 
		new BasicStroke(8), new BasicStroke(9), new BasicStroke(10), new BasicStroke(11)
	};
}
