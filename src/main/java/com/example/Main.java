package com.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
      int countDays = scan.nextInt();
      int i = 0;
      int sum=0;
      int count = 0;
      while (i < countDays){
          int temp = scan.nextInt();
          if(temp>0){
              sum= sum+temp;
              count++;
          }
          i++;
      }
      double avgTemp = (double) sum / (double) count;
      System.out.println(avgTemp);
      System.out.println(count);
    }
}
