package com.company;

import java.awt.image.DataBufferUShort;
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
        System.out.println("\n\nWould you like to play again? Y/N\n");
        boolean invalidR = true;
        boolean replay = false;
        String response = "";
        String Response = "";

        while (invalidR) {
            response = input.nextLine();
            Response = response.toUpperCase();
            if(Response.equals("Y")) {
                invalidR = false;
                replay = true;
            }else{
                if(Response.equals("N")){
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

    public static String getGuess(ArrayList<String> LetterGuesses, ArrayList<String> Display) {
        Scanner input = new Scanner(System.in);
        boolean invalidR = true;
        String guess = "";
        String Guess = "";
        while (invalidR) {
            System.out.println("\nGo ahead and guess a letter! ");
            guess = input.next();
            Guess = guess.toUpperCase();
            Guess += " ";
            if(LetterGuesses.contains(Guess) || Display.contains(Guess)){
                invalidR = true;
                System.out.println("You guessed [" + Guess + "] already. Try again");
            }else {
                if (Guess.length() == 2) {
                    invalidR = false;
                }else{
                    System.out.println("Invalid Input, Please Try Again. Single Letters Only.");
                }
            }

        }
        return Guess;
    }

    public static boolean testGuess(String Guess, ArrayList<String> Answer){  //Still working on -- Probably done now
        boolean badGuess = false;
                if (Answer.contains(Guess)) {
                    System.out.println("You guessed a letter correctly!");
                } else {
                    System.out.println("Your guess, [" + Guess + "] was a mistake.");
                    badGuess = true;
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
                break;
            case 4:
                System.out.println(" 0      |");
                System.out.println("~|~     |");
                System.out.println("        |");
                break;
            case 5:
                System.out.println(" 0      |");
                System.out.println("~|~     |");
                System.out.println("/       |");
                break;
            case 6:
                System.out.println(" 0      |");
                System.out.println("~|~     |");
                System.out.println("/ \\     |");
                break;
            default:
                System.out.println("An Error Occurred in the System.");
                break;
        }
        System.out.println("        |");
        System.out.println("   =========");
    }

    public static void wordUpdate(ArrayList<String> Display, ArrayList<String> LetterGuesses){  //Still working on, effectively Word Display Update
        System.out.println();
        for(String elem : Display){
            System.out.print(elem.toUpperCase());
        }
    }

    public static boolean winCondition(ArrayList<String> Answer, ArrayList<String> Display){
        if(Display.equals(Answer)){
            return true;
        }else{
            return false;
        }
    }



    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    //
    //                                  Oh Boy. . .
    //



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Hangman Game!\nWhat is your name? ");
        String name = input.nextLine();
        System.out.println("Pleasure to meet you " + name + ", I do hope you enjoy this session.");

        int gameRound = 1;
        int index;
        int badGuesses;
        boolean replay = true;
        boolean gameOn = true;
        boolean gameLose = false;
        boolean guessWrong = false;
        String theWord = "";
        String CH = "";
        String guess = "";
        ArrayList<String> Answer = new ArrayList<>();
        ArrayList<String> Display = new ArrayList<>();
        ArrayList<String> LetterGuesses = new ArrayList<>();



        Random randomize = new Random();
        int rand;


        //The Gaming System
        while(replay){
            System.out.println("\n\nChoosing a Word to use for the game.");
            rand = randomize.nextInt(22) + 1;
            theWord = wordGen(rand);
            badGuesses = 0;
            gameOn = true;

            //For Reset of Data
            Answer.removeAll(Answer);
            Display.removeAll(Display);
            LetterGuesses.removeAll(LetterGuesses);

            String[] wordHold = theWord.split("");
            for(String ch : wordHold){
                CH = ch.toUpperCase();
                CH += " ";
                Answer.add(CH);
            }

            for(String elem : Answer){
                Display.add("_ ");
            }

            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Start of Round: " + gameRound);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");

            eventUpdate(badGuesses);
            wordUpdate(Display, LetterGuesses);


            //The Game Round (Will always play at least once)
            while(gameOn){

                guess = getGuess(LetterGuesses, Display);
                guessWrong = testGuess(guess, Answer);

                if(guessWrong){
                    badGuesses++;
                    LetterGuesses.add(guess);
                }else{
                    index = 0;
                    for(String elem : Answer){
                        if(elem.equals(guess)){
                            Display.set(index, guess);
                        }
                        index++;
                    }
                }

                eventUpdate(badGuesses);
                wordUpdate(Display, LetterGuesses);
                System.out.println("\nYour Previous Guesses: ");
                for(String elem : LetterGuesses){
                    System.out.print(elem.toUpperCase());
                }

                if(badGuesses >= 6){
                    gameOn = false;
                    gameLose = true;
                    System.out.println("\n\n-=-=-=-=-\nUh Oh, seems like you've made your last guess. . .");
                }

                if(winCondition(Answer, Display)){
                    System.out.println("\n\nCongrats " + name + ", you won the round!");
                    System.out.println("The word was: ");
                    for(String elem : wordHold){
                        System.out.print(elem.toUpperCase());
                    }
                    gameOn = false;
                    gameLose = false;
                }
            }
            if(gameLose){
                System.out.println("That was a good try. And too bad, they seemed like a nice person.\n-=-=-=-=-\n");
            }
            replay = replayGame();
            if(replay){
                System.out.println("\nAlrighty! Preparing Systems for a new round!");
                gameRound++;
            }else{
                System.out.println("\nAww, well, it was nice playing with you!");
                System.out.println("You played " + gameRound + " rounds!");
            }
        }


    }
}