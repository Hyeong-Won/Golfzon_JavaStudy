package java01;

import java.util.Arrays;

public class ex01 {
	public static void main(String[] args) {
		
		 int[] arr = new int[5];
	      
		 //배열에 랜덤으로 값 넣기
	      for(int i=0; i<arr.length; i++) {
	         arr[i] = (int)(Math.random()*100);
	      }
	      
	      System.out.println("before :" + Arrays.toString(arr));
	      
	     //배열 복사하기
	     int[] arr2 = Arrays.copyOf(arr, 5);
	      
	     //버블정렬
	      for(int i=arr2.length; i>0; i--) {
	         for(int j=0; j<i-1; j++) {
	            if(arr2[j] > arr2[j+1]) {
	               int tmp = arr2[j];
	               arr2[j] = arr2[j+1];
	               arr2[j+1] = tmp;
	            }
	         }
	      }
	      
	      System.out.println("after :" + Arrays.toString(arr2));
	      
	}
}
