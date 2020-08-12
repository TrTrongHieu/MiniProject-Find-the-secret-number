package com.main;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 100;
    final static int MAX_SCORE = 100;
    final static int MAX_GUESS = 4;
    static int numberGuessRemaining = MAX_GUESS;
    static int score = 0;
    static int secrectNumber = 0;

    public static void main(String[] args) {
        secrectNumber = initGame();
        startGame();

    }

   public static int initGame(){
        Random random = new Random();

        int secrectNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER) + MIN_NUMBER;
        System.out.println(secrectNumber);

        return secrectNumber;
   }

   public static void startGame(){
        int yourNumber = 0;
        Scanner sc = new Scanner(System.in);

        while (secrectNumber!=yourNumber){
            if (numberGuessRemaining<=0) break;

            System.out.println(String.format("Secrect number:(%d-%d)",MIN_NUMBER,MAX_NUMBER));
            System.out.println("Number of guesses remaining: " + numberGuessRemaining);
            System.out.print("Enter your number: ");
            yourNumber = sc.nextInt();

            if(yourNumber>secrectNumber){
                System.out.println("Greater than!\n");
                MAX_NUMBER = yourNumber;

            }else if(yourNumber<secrectNumber){
                System.out.println("Less than!\n");
                MIN_NUMBER = yourNumber;

            }else{
                System.out.println("You won!");
                break;
            }

            numberGuessRemaining--;

        }
        if (numberGuessRemaining==0){
            System.out.println("You Lose!");
        }
        score = numberGuessRemaining*(MAX_SCORE/MAX_GUESS);
        System.out.println("Your score: " + score);

   }
}
