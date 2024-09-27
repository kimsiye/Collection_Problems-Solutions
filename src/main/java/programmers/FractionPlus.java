package programmers;

import java.util.ArrayList;

// 분수의 덧셈
public class FractionPlus {
    public static void main(String[] args) {

//        문제 설명
//        첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1,
//        두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
//        두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을
//        return 하도록 solution 함수를 완성해보세요.

//        제한사항
//        0 <numer1, denom1, numer2, denom2 < 1,000

//        입출력 예
//        numer1	denom1	numer2	denom2	result
//        1	2	3	4	[5, 4]
//        9	2	1	3	[29, 6]

//        입출력 예 설명
//        입출력 예 #1
//        1 / 2 + 3 / 4 = 5 / 4입니다. 따라서 [5, 4]를 return 합니다.
//        입출력 예 #2
//        9 / 2 + 1 / 3 = 29 / 6입니다. 따라서 [29, 6]을 return 합니다.

        int numer1 = 2;
        int denom1 = 8;
        int numer2 = 2;
        int denom2 = 8;

        int[] answer = {0, 0};
        ArrayList<Integer> denomMeasure = new ArrayList<>();

        if (denom1 == denom2) {
            answer[0] = numer1 + numer2;
            answer[1] = denom1;

        }

        if (denom1 != denom2 && denom1 % denom2 != 0 && denom2 % denom1 != 0) {
            answer[0] = (numer1 * denom2) + (numer2 * denom1);
            answer[1] = denom1 * denom2;

        }

        if (denom1 > denom2 && denom1 % denom2 == 0) {
            answer[0] = numer2 * denom2 + numer1;
            answer[1] = denom1;

        }

        if (denom1 < denom2 && denom2 % denom1 == 0) {
            answer[0] = numer1 * denom1 + numer2;
            answer[1] = denom2;

        }

        if (answer[1] != 0) {
            for (int i = 0; i <= answer[1]; i++) {
                if (answer[1] % i == 0) {
                    denomMeasure.add(i);
                }
            }
        }

//        if(answer[0]%answer[1] == 0){
//            answer[0] = answer[0] / answer[1];
//            answer[1] = answer[1] / answer[1];
//        }



        System.out.printf("분자 : %s, 분모 : %s", answer[0], answer[1]);


    }
}

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {0, 0};

        if (denom1 == denom2) {
            answer[0] = numer1 + numer2;
            answer[1] = denom1;
        }

        if (denom1 > denom2 || denom1 < denom2) {
            if (denom1 > denom2) {
                if (denom1 % denom2 == 0) {
                    answer[0] = numer2 * denom2 + numer1;
                    answer[1] = denom1;
                } else {
                    answer[0] = numer2 * denom1 + numer1 * denom2;
                    answer[1] = denom1 * denom2;
                }
            } else {
                if (denom2 % denom1 == 0) {
                    answer[0] = numer1 * denom1 + numer2;
                    answer[1] = denom2;
                } else {
                    answer[0] = numer2 * denom1 + numer1 * denom2;
                    answer[1] = denom1 * denom2;
                }
            }
        }

        return answer;
    }
}


