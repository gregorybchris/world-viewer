package math;

public class Matrix {
	private double[][] data;
	private int width;
	private int height;

	public Matrix(int width, int height) {
		this.data = new double[width][height];
		this.width = width;
		this.height = height;
		for(int j = 0; j < height; j++)
			for(int i = 0; i < width; i++)
				data[i][j] = 0;
	}

	public Matrix(double[][] data) {
		this.data = data;
		this.width = data.length;
		this.height = data[0].length;
	}

	public Matrix(double[] data, int width, int height) {
		this.data = new double[width][height];
		this.width = width;
		this.height = height;
		int counter = 0;
		for(int j = 0; j < height; j++) {
			for(int i = 0; i < width; i++) {
				this.data[i][j] = data[counter];
				counter++;
			}
		}
	}

	public double get(int i, int j) {
		return data[i][j];
	}

	public void set(int i, int j, double v) {
		data[i][j] = v;
	}

	public void multiply(double v) {
		for(int j = 0; j < height; j++)
			for(int i = 0; i < width; i++)
				data[i][j] *= v;
	}
	
	public Matrix multiplyGet(double v) {
		Matrix toReturn = this.clone();
		for(int j = 0; j < height; j++)
			for(int i = 0; i < width; i++)
				toReturn.set(i, j, toReturn.get(i, j) * v);
		return toReturn;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		String toReturn = "";
		for(int j = 0; j < height; j++) {
			for(int i = 0; i < width; i++) {
				toReturn += "[" + MT.dRound(data[i][j]) + "]";
			}
			toReturn += "\n";
		}
		return toReturn;
	}

	@Override
	public Matrix clone() {
		Matrix toReturn = new Matrix(this.width, this.height);
		for(int j = 0; j < height; j++)
			for(int i = 0; i < width; i++)
				toReturn.set(i, j, this.get(i, j));
		return toReturn;
	}
}
