package com.company;

import java.util.*;

public class Main {

/*
 HangMan game
 ask for name
 Loop Begins - Game Session
 Computer thinks of a word
    Loop Begins - Game Round
Player Guesses letter
Computer checks query to elements in word array
    If Letter matches, Print out letter in element spots (Maybe use another array to bring in elements from existing word)
    If Letter doesn't match, Print out next Hangman Part and Letter guessed so Player knows not to guess again
    If letter was already used in guesses and was wrong, (Use another Array to store guessed and wrong letters) Ask for another input
After 3 (Or however Many) Failed guesses, Player loses


*/
    //Methods needed
    //PlayAgain Input Receive
    //WordGenerator
    //LetterCheck
    //EventUpdate
    //Query Input Receive
    //
    public static String wordGen(int id){
        System.out.println("Computing. . .");
        String query = "";
        switch(id){
            case 1:
                query = "cannery";
                break;
            case 2:
                query = "quadrant";
                break;
            case 3:
                query = "jubilant";
                break;
            case 4:
                query = "architecture";
                break;
            case 5:
                query = "runaround";
                break;
            case 6:
                query = "hurdle";
                break;
            case 7:
                query = "astounding";
                break;
            case 8:
                query = "superb";
                break;
            case 9:
                query = "overt";
                break;
            case 10:
                query = "omit";
                break;
            case 11:
                query = "delayed";
                break;
            case 12:
                query = "uncouth";
                break;
            case 13:
                query = "sabotage";
                break;
            case 14:
                query = "relinquish";
                break;
            case 15:
                query = "revel";
                break;
            case 16:
                query = "caddywumpus";
                break;
            case 17:
                query = "onomatopoeia";
                break;
            case 18:
                query = "literature";
                break;
            case 19:
                query = "bibliophile";
                break;
            case 20:
                query = "vermillion";
                break;
            case 21:
                query = "tenacious";
                break;
            case 22:
                query = "melancholy";
                break;
            default:
                query = "nutterbutter";
                break;
        }
        System.out.println("WORD CHOSEN");
        return query;
    }

    public static boolean replayGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to play again? Y/N\n");
        boolean invalidR = true;
        boolean replay = false;
        while (invalidR) {
            String response = input.nextLine();

            if(response.equals("Y")) {
                invalidR = false;
                replay = true;
            }else{
                if(response.equals("N")){
                    invalidR = false;
                    replay = false;
                }else{
                    System.out.println("Response was INVALID. Please type Y/N: ");
                    invalidR = true;
                }
            }
        }

        return replay;
    }

    public static String getGuess() {
        Scanner input = new Scanner(System.in);
        boolean invalidR = true;

        while (invalidR) {
            String guess = input.next();
            guess.toUpperCase();
            if(guess.length() == 1){
                break;
            }

        }
    }

    public static boolean testGuess(String guess){  //Still working on
        boolean badGuess = false;
            if (guess.equals(/*Previous Guesses*/)) {
                System.out.println("You guessed [" + guess + "] already. Try again");
            } else {
                if (guess.equals(/*Correct Letter*/)) {
                    System.out.println("You guessed a letter correctly!");
                } else {
                    System.out.println("Your guess, [" + guess + "] was a mistake.");
                    badGuess = true;
                }
            }

        return badGuess;
    }

    public static void eventUpdate(int badguesses) {
        System.out.println(" T``````+");
        switch (badguesses) {
            case 0:
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("        |");
                break;
            case 1:
                System.out.println(" 0      |");
                System.out.println("        |");
                System.out.println("        |");

                break;
            case 2:
                System.out.println(" 0      |");
                System.out.println(" |      |");
                System.out.println("        |");

                break;
            case 3:
                System.out.println(" 0      |");
                System.out.println("~|      |");
                System.out.println("        |");
            case 4:
                System.out.println(" 0      |");
                System.out.println("~|~     |");
                System.out.println("        |");
            case 5:
                System.out.println(" 0      |");
                System.out.println("~|~     |");
                System.out.println("/       |");
            case 6:
                System.out.println(" 0      |");
                System.out.println("~|~     |");
                System.out.println("/ \\     |");
            default:
                System.out.println("An Error Occurred in the System.");
        }
        System.out.println("        |");
        System.out.println("   =========");
    }

    public static void wordUpdate(ArrayList<String> Aquery, ){  //Still working on


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Hangman Game!\nWhat is your name? ");
        String name = input.nextLine();
        System.out.println("Pleasure to meet you " + name + ", I do hope you enjoy this session.");

        int gameRound = 1;
        int badGuesses;
        boolean replay = true;
        boolean gameOn = true;
        boolean gameLose = false;
        String theWord = "";
        ArrayList<String> Answer = new ArrayList<>();
        ArrayList<String> Display = new ArrayList<>();


        Random randomize = new Random();
        int rand;

        while(replay){
            System.out.println("\n\nChoosing a Word to use for the game.");
            rand = randomize.nextInt(22) + 1;
            theWord = wordGen(rand);
            badGuesses = 0;

            String[] wordHold = theWord.split("");
            for(String ch : wordHold){
                ch += " ";
                Answer.add(ch);
            }

            for(String ch : Answer){
                Display.add("_ ");
            }

            while(gameOn){

                eventUpdate();
                wordUpdate();


            }
            replay = replayGame();
        }


    }
}