package pentomino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		PentominoBoard board = new PentominoBoard();
		PieceVariations tVars = PieceFactory.createTVariations();
		Point empty = board.findFirstEmpty();

		if (empty != null) {
			// 最初の空きへ各向きの基準点を合わせる
			for (Point[] shape : tVars.variations) {
				Point anchor = shape[0];
				int offsetX = empty.x - anchor.x;
				int offsetY = empty.y - anchor.y;

				if (board.canPlace(shape, offsetX, offsetY)) {
					// 試行: 置く → 状態確認 → 同じ5マスを戻す
					board.place(
						shape, offsetX, offsetY, 'T'
					);

					System.out.println(
						"placed " + tVars.name
						+ " at (" + offsetX
						+ ", " + offsetY + ")"
					);

					board.remove(shape, offsetX, offsetY);
				}
			}
		}
		Point point = new Point(1,2);
//		System.out.println(point.getX() + "," + point.getY());
		
		Piece lPiece = new Piece(
				'L',
				new Point[] {
					new Point(0,0),
					new Point(0,1),
					new Point(0,2),
					new Point(0,3),
					new Point(1,3)
				}
		);
		Piece fPiece = new Piece(
		        'F',
		        new Point[] {
		            new Point(1, 0), new Point(2, 0),
		            new Point(0, 1), new Point(1, 1),
		            new Point(1, 2)
		        }
		    );

		    Piece iPiece = new Piece(
		        'I',
		        new Point[] {
		            new Point(0, 0),
		            new Point(0, 1),
		            new Point(0, 2),
		            new Point(0, 3),
		            new Point(0, 4)
		        }
		    );

		    Piece pPiece = new Piece(
		        'P',
		        new Point[] {
		            new Point(0, 0), new Point(1, 0),
		            new Point(0, 1), new Point(1, 1),
		            new Point(0, 2)
		        }
		    );

		    Piece nPiece = new Piece(
		        'N',
		        new Point[] {
		            new Point(0, 0), new Point(1, 0),
		            new Point(1, 1), new Point(2, 1),
		            new Point(3, 1)
		        }
		    );

		    Piece tPiece = new Piece(
		        'T',
		        new Point[] {
		            new Point(0, 0), new Point(1, 0),
		            new Point(2, 0), new Point(1, 1),
		            new Point(1, 2)
		        }
		    );

		    Piece uPiece = new Piece(
		        'U',
		        new Point[] {
		            new Point(0, 0), new Point(2, 0),
		            new Point(0, 1), new Point(1, 1),
		            new Point(2, 1)
		        }
		    );

		    Piece vPiece = new Piece(
		        'V',
		        new Point[] {
		            new Point(0, 0),
		            new Point(0, 1),
		            new Point(0, 2), new Point(1, 2),
		            new Point(2, 2)
		        }
		    );

		    Piece wPiece = new Piece(
		        'W',
		        new Point[] {
		            new Point(0, 0),
		            new Point(0, 1), new Point(1, 1),
		            new Point(1, 2), new Point(2, 2)
		        }
		    );

		    Piece xPiece = new Piece(
		        'X',
		        new Point[] {
		            new Point(1, 0),
		            new Point(0, 1), new Point(1, 1),
		            new Point(2, 1), new Point(1, 2)
		        }
		    );

		    Piece yPiece = new Piece(
		        'Y',
		        new Point[] {
		            new Point(0, 0),
		            new Point(0, 1), new Point(1, 1),
		            new Point(0, 2),
		            new Point(0, 3)
		        }
		    );

		    Piece zPiece = new Piece(
		        'Z',
		        new Point[] {
		            new Point(0, 0), new Point(1, 0),
		            new Point(1, 1),
		            new Point(1, 2), new Point(2, 2)
		        }
		    );
			printPieceVariations2(generateVariations(zPiece));
		}
		public static Point[] rotate90(Point[] points) {
			Point[] rotated = new Point[5];
			
			for(int i = 0;i < 5; i ++) {
				Point point = points[i];
				rotated[i] = new Point(-point.y,point.x);
				
			}
			
			return rotated;
		}
		
		public static Point[] reflect(Point[] points) {
			Point[] reflect = new Point[5];
			
			for(int i = 0;i < 5; i ++) {
				Point point = points[i];
				reflect[i] = new Point(-point.x,point.y);
				
			}
			
			return reflect;
		}
		public static void printCandidates(List<Piece> candidates) {
		    for (int i = 0; i < candidates.size(); i++) {
		        Piece piece = candidates.get(i);

		        System.out.println("候補 " + (i + 1) + " : " + piece.name);

		        for (Point point : piece.points) {
		            System.out.println("(" + point.x + ", " + point.y + ")");
		        }

		        System.out.println();
		    }
		}
		public static Point[] normalize(Point[] points) {
			Point[] normalized = Arrays.copyOf(points, points.length);
			Arrays.sort(normalized,Comparator.comparingInt((Point p) -> p.y).thenComparingInt(p -> p.x));
			
			Point base = normalized[0];//最も左上
			
			for(int i = 0;i < normalized.length; i ++) {
				Point point = normalized[i];
				normalized[i] = new Point(
					point.x - base.x,
					point.y - base.y
				);//最も左上に動いた分だけ全てのポイントから引く
			}
			return normalized;
		}
		public static void printPieceVariations(PieceVariations pieceVariations) {
		    System.out.println("Piece: " + pieceVariations.name);

		    for (int i = 0; i < pieceVariations.variations.size(); i++) {
		        Point[] variation = pieceVariations.variations.get(i);

		        System.out.println("Variation " + (i + 1));

		        for (Point point : variation) {
		            System.out.println("(" + point.x + ", " + point.y + ")");
		        }

		        System.out.println();
		    }
		}
		public static void printPieceVariations2(PieceVariations pieceVariations) {

		    System.out.println("Piece: " + pieceVariations.name);

		    for (int i = 0; i < pieceVariations.variations.size(); i++) {

		        Point[] variation = pieceVariations.variations.get(i);

		        System.out.println("Variation " + (i + 1));

		        // 最小座標を求める
		        int minX = Integer.MAX_VALUE;
		        int minY = Integer.MAX_VALUE;

		        for (Point point : variation) {
		            minX = Math.min(minX, point.x);
		            minY = Math.min(minY, point.y);
		        }

		        // 9×9で表示
		        for (int y = 0; y < 9; y++) {
		            for (int x = 0; x < 9; x++) {

		                boolean exists = false;

		                for (Point point : variation) {

		                    // 表示するときだけ左上へ移動
		                    int displayX = point.x - minX;
		                    int displayY = point.y - minY;

		                    if (displayX == x && displayY == y) {
		                        exists = true;
		                        break;
		                    }
		                }

		                if (exists) {
		                    System.out.print("■");
		                } else {
		                    System.out.print("・");
		                }
		            }

		            System.out.println();
		        }

		        System.out.println();
		    }
		}
		public static PieceVariations generateVariations(Piece piece) {
			List<Point[]> candidates = new ArrayList<>();//回転、反転のパターンを格納
			Point[] current = piece.points;//ピースを回転、反転させるためのワーク変数
			for(int i = 0;i < 4;i ++) {
				candidates.add(normalize(current));//正規化後に回転、反転、その後追加
				current = rotate90(current);
			}
			current = reflect(current);
			for(int i = 0;i < 4;i ++) {
				candidates.add(normalize(current));
				current = rotate90(current);
			}
			List<Point[]> variations = new ArrayList<>(); // 重複なしの結果

		    for (Point[] candidate : candidates) { // 候補を1つずつ確認
		        boolean duplicated = false; // 重複が見つかったか

		        for (Point[] variation : variations) { // 登録済みと比較
		            if (Arrays.equals(candidate,variation)) { // 座標配列が同じ
		                duplicated = true;
		                break; // 見つかったので比較終了
		            }
		        }

		        if (!duplicated) { // 重複していない場合だけ追加
		            variations.add(candidate);
		        }
		    }
		    return new PieceVariations(piece.name, variations); // 重複除外後の結果
		}
	}
