package engine;

import data.View;

public class PlayerPhysics {
	private View view;

	private double velocityY;
	private double accelerationY;

	public PlayerPhysics(View view) {
		this.view = view;
		velocityY = 0;
		accelerationY = -6;
	}

	public void updatePlayer() {
		if(view.getLocation().y < 0) {
			velocityY = 0;
			view.getLocation().y = 0;
		}
		else {
			view.getLocation().y += velocityY;
			if(view.getLocation().y >= -accelerationY) {
				velocityY += accelerationY;
			}
		}
	}

	public void jump() {
		velocityY += 50 / (view.getLocation().y + 1);
	}
}
