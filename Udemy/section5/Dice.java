// Section 5-1, 주사위로 이동 가능한 경우의 수 모두 구하기
// N칸의 보드게임에서 1~6의 눈금이 있는 주사위를 굴려 갈수 있는 모든 경우의 수를 반환하는 함수 구현
// 내가 구현한 방법 : 현재 상태에서 1칸 ~ 6칸 나아간 경우를 재귀로 돌려서 각각의 결과값을 더함.
// 1) countWays(N-n) 이 음수인 경우 -> 경우의 수 없는 것이므로 0 반환
// 2) 0이나 1인 경우 -> 경우의 수가 한 가지이므로 1 반환
// 해설이랑 똑같이 풀어서 만족!

public class Dice {
    public static int countWays(int n) {
        if(n < 0) {
            return 0;
        } else if(n == 0 || n == 1) {
            return 1;
        } else {
            return countWays(n-6) + countWays(n-5) + countWays(n-4) + countWays(n-3) + countWays(n-2) + countWays(n-1);
        }
    }
}