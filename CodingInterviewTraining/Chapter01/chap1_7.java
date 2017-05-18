package com.joshua.Chapter01;

/**
 * Created by Joshua on 2017-05-18.
 * M X N 행렬을 순회하면서 0인 원소를 발견하면, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘 작성
 */
public class chap1_7 {

    // 이 코드도 책의 해답에 근접은 했으나, 시간복잡도 면에서 좋은 코드는 아님.
    public static void convertMatrix(int[][] input) {
        int[][] temp = new int[input.length][input[0].length];

        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[0].length; j++) {
                if(input[i][j] == 0) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = 0;
                }
            }
        }

        for(int m = 0; m < input.length; m++) {
            for(int n = 0; n < input[0].length; n++) {
                if(temp[m][n] == 1) {
                    fill(input, m, n);
                }
            }
        }
    }

    public static void fill(int[][] input, int m, int n) {
        for(int i = 0; i < input[0].length; i++) {
            input[m][i] = 0;
        }
        for(int j = 0; j < input.length; j++) {
            input[j][n] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 2, 3},
                          {1, 1, 1, 1},
                          {2, 2, 2, 2},
                          {0, 1, 3, 4}};

        convertMatrix(matrix);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
