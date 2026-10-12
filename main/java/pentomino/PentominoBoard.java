package pentomino;

public class PentominoBoard {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 6;
    private static final char EMPTY = '.';
    private final char[][] cells = new char[HEIGHT][WIDTH];
    public PentominoBoard() {
        for(int y = 0 ; y < HEIGHT ; y ++){
            for (int x = 0 ; x < WIDTH ; x ++) {
                // charの初期値ではなく'.'を明示する。
                cells[y][x] = EMPTY;
            }
        }
    }
    public boolean canPlace(Point[] shape,int offsetX,int offsetY) {
        for(Point point : shape) {
            int x = point.x + offsetX;
            int y = point.y + offsetY;
            if(x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) {
                return false;
            }
            if(cells[y][x] != EMPTY) {
                return false;
            }
        }
        return true;
    }

    public void place(Point[] shape,int offsetX ,int offsetY,char name) {
        for (Point point : shape) {
            int x = point.x + offsetX;
            int y = point.y + offsetY;
            cells[y][x] = name;
        }
        printBoard();
    }

    public void remove(Point[] shape,int offsetX ,int offsetY) {
        for (Point point : shape) {
            int x = point.x + offsetX;
            int y = point.y + offsetY;
            cells[y][x] = EMPTY;
        }
        printBoard();
    }

    public void printBoard() {
        for (int y = 0; y < HEIGHT; y++) {
            System.out.println(new String(cells[y]));
        }
        System.out.println();
    }
    public Point findFirstEmpty(){
        // 行を優先して盤面全体を走査する
        for(int y = 0 ;y < HEIGHT; y ++){
            for(int x = 0 ; x < WIDTH; x ++) {
                if(cells[y][x] == EMPTY) {
                    return new Point(x,y);
                }
            }
        }
        return null;
    }
}
