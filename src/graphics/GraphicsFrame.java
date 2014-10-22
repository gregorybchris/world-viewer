package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class GraphicsFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private GraphicsPanel panel;

	public GraphicsFrame(String title) {
		super(title);
		this.panel = new GraphicsPanel();
		this.getContentPane().add(panel);
		Timer gameTimer = new Timer(1000 / GV.FPS, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.makeUpdate(0);
			}
		});
		gameTimer.start();
	}
}