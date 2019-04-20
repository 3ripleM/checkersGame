package com.company;

import java.util.Scanner;

public class Helper {

    static private Scanner scanner = new Scanner(System.in) ;

    static String stringInput(String message){
        System.out.println(message);
        String ans = scanner.nextLine() ;
        return ans ;
    }

    static int intInput(String message){
        try {
            System.out.println(message);
            String ans = scanner.nextLine() ;
            int a = Integer.parseInt(ans) ;
            return a ;
        }catch (Exception e){
            return Helper.intInput("Invalid! \n pleas Enter a Number.") ;
        }
    }

    static void print(String s){
        System.out.print(s);
    }


}

