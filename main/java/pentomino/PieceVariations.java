package pentomino;

import java.util.List;

public class PieceVariations {
	char name;
	List<Point[]> variations;
	public PieceVariations(char name, List<Point[]> variations) {
		super();
		this.name = name;
		this.variations = variations;
	}
}
