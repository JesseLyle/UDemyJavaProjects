package com.company;

import java.util.*;

class NumberGuessGame {

    //Game must pick a random number between 1 and 20
    //Player has 6 tries to guess the number
    //Whenever a guess is made, Game gives a hint about number (Guessed too low/high)
    //
    //Want to add a Name method, and maybe separate these functions into other methods
    //Possible Methods - NameWrong null, MakeGuesses return boolean, WinOrLose null
    //Crap, forgot to do replayability...

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random thinkNum = new Random();

        int secret, guess, numguesses, guessesmade;
        numguesses = 6;

        //Keep loop going
        boolean guessloop = true;

        //Player hasn't won yet
        boolean playerwin = false;

        //While loop here for the Multi-gameplaya
        System.out.println("Thinking of a number from 1-20...");
        secret = thinkNum.nextInt(20) + 1;

        System.out.println("Make a guess... you have 6 tries to win.");

        //---------------------------------

        while(guessloop){
            //Retrieve Player guess
            guess = input.nextInt();

            //Test guess against Secret Number
            if (guess == secret){   //Win?
                guessloop = false;  //Exit Loop
                playerwin = true;   //Set Win to true
            }else{
                //Give hint if no win
                if(guess > secret)
                    System.out.println("Almost, but your guess was too high!\n");
                if(guess < secret)
                    System.out.println("Almost, but your guess was too low!\n");
            }

            if(numguesses != 0) {   //Remove 1 from guesses remaining, effective countdown
                numguesses--;       //Also let player know how many tries are left
                System.out.print(numguesses + " guesses left.");
            }

            //Out of guesses?
            if(numguesses == 0)                           //Exit if out of guesses
                guessloop = false;
            if(numguesses != 0 && playerwin == false)     //Request another guess if at least 1 try left
                System.out.println(" Make another guess... ");
        }

        //---------------------------------------

        System.out.println("\n\n");
        guessesmade = 6 - numguesses;

        if(playerwin == true){
            System.out.println("Congratulations! You guess my number!");                                //Winner Text
            System.out.println("It took you " + guessesmade + " tries to guess " + secret + "!");       //
            System.out.println("You WON!");                                                             //
        }else{
            System.out.println("You couldn't get it in 6 tries? Better luck next time.");               //Loser Text
            System.out.println("Don't trip trying to guess where the stairs are...");                   //
        }
    }
}
