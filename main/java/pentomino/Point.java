package pentomino;

public class Point {
	int x;
	int y;
	
	public Point(int x,int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Point other = (Point) obj;

        return this.x == other.x && this.y == other.y;
	}
	
}
