package pentomino;

public class PieceFactory {
    /** Tピースの回転・反転から、重複しない向きを生成する。 */
    public static PieceVariations createTvariations() {
        Piece tPiece = new Piece(
            'T',
            new Point[] {
                new Point(0, 0), new Point(1, 0),
                new Point(2, 0), new Point(1, 1),
                new Point(1, 2)
            }
        );
        return Main.generateVariations(tPiece);
    }

    /** Mainの既存の呼び出しに対応する。 */
    public static PieceVariations createTVariations() {
        return createTvariations();
    }
}
