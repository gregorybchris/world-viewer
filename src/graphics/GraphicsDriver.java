package graphics;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GraphicsDriver {
	private static GraphicsFrame f = new GraphicsFrame("World - Copyright 2014 © Chris Gregory");

	public static void main(String... args) {
		setFullScreen(true);
		setCursor(false);
	}

	public static void setFullScreen(boolean fs) {
		if(fs) {
			f.setVisible(false);
			f.dispose();
			f.setUndecorated(true);
			GV.GD.setFullScreenWindow(f);
			f.setVisible(true);
		}
		else {
			f.setVisible(false);
			f.dispose();
			f.setBounds(0, 0, (int) GV.MAIN_WIDTH, (int) GV.MAIN_HEIGHT);
			f.setLocationRelativeTo(null);
			f.setResizable(false);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setUndecorated(false);
			GV.GD.setFullScreenWindow(null);
			f.setVisible(true);
		}
	}

	public static void setCursor(boolean cs) {
		if(cs) {
			f.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		else {
			BufferedImage cursorImage = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
			Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
					cursorImage, new Point(0, 0), "blank cursor");
			f.getContentPane().setCursor(blankCursor);
		}
	}
}
