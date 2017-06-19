/**
 * Created by Joshua on 2017-06-19.
 */
public class Blob {
    private static int BACKGROUND_COLOR = 0;
    private static int IMAGE_COLOR = 1;
    private static int ALREADY_COUNTED = 2;

    public static void main(String[] args) {
        new Blob().run();
    }

    public void run() {
        int[][] map = {{1,0,0,0,0,0,0,1},
                    {0,1,1,0,0,1,0,0},
                    {1,1,0,0,1,0,1,0},
                    {0,0,0,0,0,1,0,0},
                    {0,1,0,1,0,1,0,0},
                    {0,1,0,1,0,1,0,0},
                    {1,0,0,0,1,0,0,1},
                    {0,1,1,0,0,1,1,1}};

        System.out.print(countCells(map, 2, 4));
    }

    private int countCells(int[][] map, int x, int y) {
        if(x < 0 || y < 0 || x >= map.length || y >= map.length) {
            return 0;
        }
        if(map[x][y] != IMAGE_COLOR) {
            return 0;
        } else {
            map[x][y] = ALREADY_COUNTED;
            return 1 + countCells(map, x-1, y-1) + countCells(map, x-1, y) +
                    countCells(map, x-1, y+1) + countCells(map, x, y-1) +
                    countCells(map, x, y+1) + countCells(map, x+1, y-1) +
                    countCells(map, x+1, y) + countCells(map, x+1, y+1);
        }
    }
}
