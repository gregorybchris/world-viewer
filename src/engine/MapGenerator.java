package engine;

import geometric.Triangle3D;

import java.util.ArrayList;
import java.util.Random;

public class MapGenerator {
	public static final double TILE_SIZE = 50;

	private Random r;

	public MapGenerator() {
		r = new Random(10);
	}

	public ArrayList<Triangle3D> get() {
		ArrayList<Triangle3D> toReturn = new ArrayList<Triangle3D>();
		int mapWidth = 100;
		int mapHeight = 100;

		int[][] heights = new int[mapWidth][mapHeight];

		for(int i = 0; i < mapWidth; i++) {
			for(int j = 0; j < mapHeight; j++) {
				int a = 0;
				int heightRand = r.nextInt(10);
				if(heightRand < 9)
					a = -3;
				else if(heightRand < 10)
					a = -4;

				heights[i][j] = a;
				addSquare(i, j, a, 'u', toReturn);
			}
		}

		for(int i = 0; i < mapWidth; i++) {
			for(int j = 0; j < mapHeight; j++) {
				if(i < mapWidth - 1 && heights[i][j] != heights[i + 1][j]) {
					boolean dir = heights[i][j] > heights[i + 1][j];
					if(dir)
					for(int a = heights[i][j]; a != heights[i + 1][j]; a--)
						addSquare(i, j, a, 'r', toReturn);
					else
						for(int a = heights[i][j]; a != heights[i + 1][j]; a++)
							addSquare(i, j, a + 1, 'r', toReturn);
				}
				if(j < mapHeight - 1 && heights[i][j] != heights[i][j + 1]) {
					boolean dir = heights[i][j] > heights[i][j + 1];
					if(dir)
						for(int a = heights[i][j]; a != heights[i][j + 1]; a--)
							addSquare(i, j, a, 'b', toReturn);
					else
						for(int a = heights[i][j]; a != heights[i][j + 1]; a++)
							addSquare(i, j, a + 1, 'b', toReturn);
				}
			}
		}

		return toReturn;
	}

	private void addSquare(int i, int j, int a, char s, ArrayList<Triangle3D> triangles) {
		double l = TILE_SIZE;
		double x = i * l;
		double y = a * l;
		double z = j * l;

		if(s == 'u') {
			triangles.add(new Triangle3D(x, y, z, x + l, y, z, x, y, z + l));
			triangles.add(new Triangle3D(x + l, y, z + l, x + l, y, z, x, y, z + l));
		}
		else if(s == 'r') {
			triangles.add(new Triangle3D(x + l, y, z, x + l, y - l, z, x + l, y, z + l));
			triangles.add(new Triangle3D(x + l, y - l, z + l, x + l, y - l, z, x + l, y, z + l));
		}
		else if(s == 'f') {
			triangles.add(new Triangle3D(x, y, z, x + l, y, z, x, y - l, z));
			triangles.add(new Triangle3D(x + l, y - l, z, x + l, y, z, x, y - l, z));
		}
		else if(s == 'b') {
			triangles.add(new Triangle3D(x, y, z + l, x + l, y, z + l, x, y - l, z + l));
			triangles.add(new Triangle3D(x + l, y - l, z + l, x + l, y, z + l, x, y - l, z + l));
		}
	}
}
