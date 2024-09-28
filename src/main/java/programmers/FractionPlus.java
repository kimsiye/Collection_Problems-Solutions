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

        Solution s1 = new Solution();
        int[] value = s1.solution(2,8,2,8);
        System.out.printf("분자 : %s, 분모 : %s", value[0], value[1]);


    }
}

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {0, 0};

        answer[0] = (numer1 * denom2) + (numer2 * denom1);
        answer[1] = denom1 * denom2;

        for (int i = answer[1]; i >= 1; i--) {
            if (answer[1] % i == 0) {
                if (answer[0] % i == 0) {
                    answer[0] = answer[0] / i;
                    answer[1] = answer[1] / i;
                }

            }
        }
        return answer;
    }
}

/*
class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {

        int[] answer = {0, 0};

        if (denom1 == denom2) {
            answer[0] = numer1 + numer2;
            answer[1] = denom1;

        }

        if (denom1 != denom2 && denom1 % denom2 != 0 && denom2 % denom1 != 0) {
            answer[0] = (numer1 * denom2) + (numer2 * denom1);
            answer[1] = denom1 * denom2;

        }

        if (denom1 > denom2) {
            answer[0] = numer2 * denom2 + numer1;
            answer[1] = denom1;

        }

        if (denom1 < denom2) {
            answer[0] = numer1 * denom1 + numer2;
            answer[1] = denom2;

        }

        for(int i = answer[1] ; i >= 1; i--){
            if(answer[1]  % i == 0){
                if(answer[0] % i == 0){
                    answer[0] = answer[0] / i;
                    answer[1]  = answer[1]  / i;
                }

            }
        }

        return answer;
    }
}
*/
/* 3차 풀이

       // 2차 풀이가 너무 코드의 양이 많아 하드코딩 인것 같아서 줄이고자 함
        int numer1 = 2;
        int denom1 = 8;
        int numer2 = 2;
        int denom2 = 8;

        int[] answer = {0, 0};

            answer[0] = (numer1 * denom2) + (numer2 * denom1);
            answer[1] = denom1 * denom2;


        for (int i = answer[1]; i >= 1; i--) {
            if (answer[1] % i == 0) {
                if (answer[0] % i == 0) {
                    answer[0] = answer[0] / i;
                    answer[1] = answer[1] / i;
                }

            }
        }

        System.out.printf("분자 : %s, 분모 : %s", answer[0], answer[1]);

        // 어차피 전체적으로 약분이 진행되기 때문에 유형별로 나누어서 생각할 필요가 없다는 것을 알게됨
        // 그래서 분자는 다른 분모끼리 곱해서 더하고
        // 분모는 분모끼리 곱하셔 결과를 구해서
        // 약분을 진행함 더 깔끔해진것 같음

 */
/*2차 풀이
        int numer1 = 2;
        int denom1 = 8;
        int numer2 = 2;
        int denom2 = 8;

        int[] answer = {0, 0};

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

        for(int i = answer[1] ; i >= 1; i--){
            if(answer[1]  % i == 0){
                if(answer[0] % i == 0){
                    answer[0] = answer[0] / i;
                    answer[1]  = answer[1]  / i;
                }

            }
        }

        System.out.printf("분자 : %s, 분모 : %s", answer[0], answer[1]);


//        if (answer[1] != 0) {
//            for (int i = 0; i <= answer[1]; i++) {
//                if (answer[1] % i == 0) {
//                    denomMeasure.add(i);
//                }
//            }
//        }


//        if(answer[0]%answer[1] == 0){
//            answer[0] = answer[0] / answer[1];
//            answer[1] = answer[1] / answer[1];
//        }





        // ----
        // 분모의 약수를 구해서 분모와 공통 약수를 분자에 나누고, 그 약수를 분모도 나눌수 있게 하기
        // 임의로 분모 분자로 숫자를 만들어서 결과 내보기


        int ja = 4;
        int mo = 8;


// 1. 분모의 약수 구하기// 결과 : 1,2,4,8(성공)
// 2. 분모의 약수를 분자가 나눌 수 있다면 나누기


        for(int i = 1; i >= mo; i++){
            if(mo % i == 0){
                if(ja % i == 0){
                    ja = ja / i;
                    mo = mo / i;
                }
                //  System.out.print(i);
            }
        }

        System.out.printf("분자 : %s, 분모 : %s", ja, mo);

        이 경우 = 1, 2, 4, 8로 나누어지기 때문에 작은 약수로 더 나눌 수 있을 때 큰약수로 변하기 때문에 약분이 충분히
        되지 않아 반대로 8,4,2,1 순서대로 하게함


        for(int i = mo; i >= 1; i--){
            if(mo % i == 0){
              if(ja % i == 0){
                  ja = ja / i;
                  mo = mo / i;
              }
               //  System.out.print(i);
            }
        }

        System.out.printf("분자 : %s, 분모 : %s", ja, mo);
*/
/* 1차 풀이
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
 */

