package pjtTest;

import java.util.Arrays;
import java.util.Scanner;

//배열을 이용한 점수 관리
public class ScoreMgmtByArrayClass {
    public static void main(String[] args) {
        //1차원 배열
        /*
        int intCnt = 0;
        Scanner scan = new Scanner(System.in);
        
        String[] arrName  = new String[3];
        int[]    arrScore = new int[3];
        
        System.out.print("이름을 입력해주세요 : ");
        arrName[0]  = scan.next();
        System.out.print("점수를 입력해주세요 : ");
        arrScore[0] = scan.nextInt();
        
        System.out.print("이름을 입력해주세요 : ");
        arrName[1] = scan.next();
        System.out.print("점수를 입력해주세요 : ");
        arrScore[1] = scan.nextInt();
        
        System.out.print("이름을 입력해주세요 : ");
        arrName[2] = scan.next();
        System.out.print("점수를 입력해주세요 : ");
        arrScore[2] = scan.nextInt();

        double dblScoreAvg = (double)((arrScore[0] + arrScore[1] + arrScore[2]) / intCnt); 
        
        System.out.println("--------------------------------------------------");
        System.out.printf("%s \t점수 : %.2f\n", arrName[0], (double)arrScore[0]);
        System.out.printf("%s \t점수 : %.2f\n", arrName[1], (double)arrScore[1]);
        System.out.printf("%s \t점수 : %.2f\n", arrName[2], (double)arrScore[2]);
        System.out.printf("\t평점 : %.2f\n", dblScoreAvg);
        */

        //2차원 배열
        Scanner objScan  = new Scanner(System.in);

        System.out.print("몇 명인가요? : ");
        int intCnt = objScan.nextInt();

        Object[][] arrScoreMgmt = new Object[intCnt][4];

        for (int i = 0; i < intCnt; i++) {
            String[] arrScore = new String[3];

            System.out.print("이름을 입력해주세요 : ");
            arrScoreMgmt[i][0]  = objScan.next();

            System.out.print("국어,영어,수학 점수를 입력해주세요.(예: 100,100,100)");
            arrScore = objScan.next().split(",");

            double dblScoreSum = Double.parseDouble(arrScore[0]) + Double.parseDouble(arrScore[1]) + Double.parseDouble(arrScore[2]);

            arrScoreMgmt[i][1]  = arrScore;
            arrScoreMgmt[i][2]  = String.format("%.2f", dblScoreSum);
            arrScoreMgmt[i][3]  = String.format("%.2f", dblScoreSum / 3);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println("--------------------------------------------------");

        int j = 0;
        while (j < intCnt) {
            System.out.println(Arrays.deepToString(arrScoreMgmt[j]).replace(" ", "").replace("[", "").replace("]", "").replace(",", "\t"));
            j++;
        }
        System.out.println("--------------------------------------------------");

    }
    
}
