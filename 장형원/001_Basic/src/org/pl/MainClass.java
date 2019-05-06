package org.pl;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {

        int[] balls   = new int[45];        //로또 공 배열
        int[] lotto   = new int[6];         //로또 번호가 저장될 배열
        int   ballIdx = 0;                  //랜덤으로 정해질 로또 번호 
        int   temp    = 0;                  //공or로또 순서를 섞기 위한 임시 변수 

        for(int i = 0; i < balls.length; i++) {                     //로또 공 1 ~ 45 초기화
            balls[i] = i + 1;
        }

        for(int i = 0; i < 200; i++) {                              //임의의 공을 뽑아 0번째 공과 충분히 섞이도록 반복
            ballIdx = (int)((Math.random() * balls.length));

            temp           = balls[0];
            balls[0]       = balls[ballIdx];
            balls[ballIdx] = temp;
        }

        for(int i = 0; i < lotto.length; i++) {                     //로또 번호 배열의 공간 만큼 루프
            ballIdx = (int)(Math.random() * balls.length);          //45개의 공 중 1개를 랜덤으로 추출
            lotto[i] = balls[ballIdx];                              //로또 번호 배열에 공 번호 추가

            for(int j = ballIdx; j < balls.length - 1 - i; j++) {   //해당 공은 다음 뽑기에서 제외시키기 위해서 해당 인덱스부터 한 칸씩 앞으로 당겨옴
                balls[j] = balls[j + 1];
            }
        }

        for(int i = 0; i < lotto.length - 1; i ++) {                //로또 번호 배열 정렬
            for(int j = i + 1; j < lotto.length; j++) {
                if(lotto[i] > lotto[j]) {
                    temp     = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = temp;
                }
            }
        }

        System.out.println("--이번 주 로또 추천 번호-- ");                 //로똫 번호 출력 
        for(int i = 0; i < lotto.length; i++) {             
            System.out.printf(lotto[i] + " ");
        }
        System.out.println();
        System.out.println("---당첨을 기원합니다.---");

    }
}
