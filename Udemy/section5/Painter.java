// Section 5-2, 이미지에서 닫힌 영역 단색 칠하기
// 재귀 호출 연습용 문제. 네 방향으로 재귀를 돌린다는 점과 조건 검사하는 것이 중요.

public class Painter {
    public static void paint(int[][] image, int x, int y, int newC) {
        paintRec(image, x, y, newC, image[y][x]); // 행렬 x y 주의하기
    }

    public static void paintRec(int[][] image, int x, int y, int newC, int targetC) {
        if(x < 0 || y < 0 || x >= image[0].length || y >= image.length) {
            return;
        }
        if(image[y][x] != targetC) {
            return;
        }

        image[y][x] = newC;

        paintRec(image, x-1, y, newC, targetC);
        paintRec(image, x, y-1, newC, targetC);
        paintRec(image, x+1, y, newC, targetC);
        paintRec(image, x, y+1, newC, targetC);
    }
}