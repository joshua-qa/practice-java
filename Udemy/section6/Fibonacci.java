// Section 6-1, 주어진 값 N에 대해 피보나치 수열의 값을 구하기
// DP 기초 연습용 문제. 이미 알고 있는거라 그냥 아는대로 풀었음.
// fibonacci는 재귀, fibonacciFaster는 메모이제이션

public class Fibonacci {
    public int[] memo = new int[100];
    public int fibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }
    
    public int fibonacciFaster(int n) {
		if(n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else if (memo[n] != 0) {
            return memo[n];
        } else {
            memo[n] = fibonacciFaster(n-2) + fibonacciFaster(n-1);
            return memo[n];
        }
	}
}