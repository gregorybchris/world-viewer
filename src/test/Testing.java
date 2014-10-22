package test;

import java.awt.Toolkit;


public class Testing {
	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = (int) tk.getScreenSize().getWidth(); 
		int ySize = (int) tk.getScreenSize().getHeight();
		System.out.println(xSize);
		System.out.println(ySize);
	}
}
