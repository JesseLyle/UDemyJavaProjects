package com.company;
import java.util.*;


public class Main {


    public static void displayUpdate(String[][] gameboard, ArrayList<Integer> playerMoves, ArrayList<Integer> cpuMoves, int psymbolkey, int cpusymbolkey){
        String psymbol = "";
        String cpusymbol = "";
        if(psymbolkey == 1 && cpusymbolkey == 0){
            psymbol = "X";
            cpusymbol = "O";
        }else{
            psymbol = "O";
            cpusymbol = "X";
        }

        //Refreshing game board with Player Moves and Symbols
        for(int move : playerMoves){
            switch(move){
                case 1:
                    gameboard[0][1] = psymbol;
                    break;
                case 2:
                    gameboard[0][3] = psymbol;
                    break;
                case 3:
                    gameboard[0][5] = psymbol;
                    break;
                case 4:
                    gameboard[2][1] = psymbol;
                    break;
                case 5:
                    gameboard[2][3] = psymbol;
                    break;
                case 6:
                    gameboard[2][5] = psymbol;
                    break;
                case 7:
                    gameboard[4][1] = psymbol;
                    break;
                case 8:
                    gameboard[4][3] = psymbol;
                    break;
                case 9:
                    gameboard[4][5] = psymbol;
                    break;
                default:
                    break;
            }
        }

        //Refreshing gameboard with CPU moves and symbols
        for(int move : cpuMoves){
            switch(move){
                case 1:
                    gameboard[0][1] = cpusymbol;
                    break;
                case 2:
                    gameboard[0][3] = cpusymbol;
                    break;
                case 3:
                    gameboard[0][5] = cpusymbol;
                    break;
                case 4:
                    gameboard[2][1] = cpusymbol;
                    break;
                case 5:
                    gameboard[2][3] = cpusymbol;
                    break;
                case 6:
                    gameboard[2][5] = cpusymbol;
                    break;
                case 7:
                    gameboard[4][1] = cpusymbol;
                    break;
                case 8:
                    gameboard[4][3] = cpusymbol;
                    break;
                case 9:
                    gameboard[4][5] = cpusymbol;
                    break;
                default:
                    break;
            }
        }

        //Printing out the refreshed gameboard
        for(String[] row : gameboard){
            for(String section : row){
                System.out.print(section);
            }
            System.out.println();
        }
    }

    public static void displayReset(String[][] gameboard){
        gameboard[0][1] = "1";
        gameboard[0][3] = "2";
        gameboard[0][5] = "3";
        gameboard[2][1] = "4";
        gameboard[2][3] = "5";
        gameboard[2][5] = "6";
        gameboard[4][1] = "7";
        gameboard[4][3] = "8";
        gameboard[4][5] = "9";
    }

    public static void finalScore(String pName, int pscore, int cscore, int rplayed, int cscratch){
        int namelength = pName.length();
        String pSpacing = "";
        for(int i = 0; i < namelength; i++){
            pSpacing += " ";
        }
        System.out.println("///////////////////////////////////////////////\n");
        System.out.println("Rounds Played:     " + rplayed + " Rounds");
        System.out.println("Final Tallies-     " + pName + "(You)     Olaf(CPU)");
        System.out.println("Total Wins:        " + pscore + "" + pSpacing + "         " + cscore);
        System.out.println("Cat Scratches:     " + cscratch + " Games\n");
        System.out.println("///////////////////////////////////////////////");
    }

    public static int playerSymbol() {
        Scanner input = new Scanner(System.in);
        int psymbolkey = 1;
        String response = "";
        String Response = "";
        boolean badinput = true;
        while(badinput) {
            try {
                System.out.println("\n\nWhat would you like to play as, X's or O's? ");
                response = input.next();
                Response = response.toUpperCase();
            } catch (Exception e) {
                System.out.println("[EXECEPTION] Improper Input, Please Enter [X] or [O]\n");
                badinput = true;
            }

            if (Response.equals("X")) {
                psymbolkey = 1;
                badinput = false;
            } else {
                if (Response.equals("O")) {
                    psymbolkey = 0;
                    badinput = false;
                }else{
                    System.out.println("[IF] Improper Input, Please Enter [X] or [O]\n");
                }
            }
        }
        return psymbolkey;
    }

    public static int testWinCondition(ArrayList<Integer> playerMoves, ArrayList<Integer> cpuMoves, int turn, int psymbolkey, int cpusymbolkey){
        for(int num : playerMoves){
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num : cpuMoves){
            System.out.print(num + " ");
        }



        boolean p1 = playerMoves.contains(1);       //WinKey = 0 - O, 1 - X, 3 - CS, 4, Keep Playing
        boolean p2 = playerMoves.contains(2);       //Win Combos: 1, 2, 3  :  1, 5, 9  : 4, 5, 6  :
        boolean p3 = playerMoves.contains(3);       //Did this in a very stretched out manner, damn, but it'll work. Hopefully.
        boolean p4 = playerMoves.contains(4);
        boolean p5 = playerMoves.contains(5);
        boolean p6 = playerMoves.contains(6);
        boolean p7 = playerMoves.contains(7);
        boolean p8 = playerMoves.contains(8);
        boolean p9 = playerMoves.contains(9);

        System.out.println(p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5 + " " + p6 + " " + p7 + " " + p8 + " " + p9);
        boolean c1 = cpuMoves.contains(1);
        boolean c2 = cpuMoves.contains(2);
        boolean c3 = cpuMoves.contains(3);
        boolean c4 = cpuMoves.contains(4);
        boolean c5 = cpuMoves.contains(5);
        boolean c6 = cpuMoves.contains(6);
        boolean c7 = cpuMoves.contains(7);
        boolean c8 = cpuMoves.contains(8);
        boolean c9 = cpuMoves.contains(9);
        System.out.println(c1 + " " + c2 + " " + c3 + " " + c4 + " " + c5 + " " + c6 + " " + c7 + " " + c8 + " " + c9);

        //Player Win con
        if(p1 && p2 && p3){
            return psymbolkey;
        }
        if(p4 && p5 && p6){
            return psymbolkey;
        }
        if(p7 && p8 && p9){
            return psymbolkey;
        }
        if(p1 && p4 && p7){
            return psymbolkey;
        }
        if(p2 && p5 && p8){
            return psymbolkey;
        }
        if(p3 && p6 && p9){
            return psymbolkey;
        }
        if(p1 && p5 && p9){
            return psymbolkey;
        }
        if(p3 && p5 && p7){
            return psymbolkey;
        }

        //CPU Win con
        if(c1 && c2 && c3){
            return cpusymbolkey;
        }
        if(c4 && c5 && c6){
            return cpusymbolkey;
        }
        if(c7 && c8 && c9){
            return cpusymbolkey;
        }
        if(c1 && c4 && c7){
            return cpusymbolkey;
        }
        if(c2 && c5 && c8){
            return cpusymbolkey;
        }
        if(c3 && c6 && c9){
            return cpusymbolkey;
        }
        if(c1 && c5 && c9){
            return cpusymbolkey;
        }
        if(c3 && c5 && c7){
            return cpusymbolkey;
        }

        //CatScratch condition
        if(turn == 9){
            return 3;   //By Turn 9, if no one has returned as winner, it's a Cat Scratch
        }

        //Resume game
        return 4;
    }

    public static boolean replay(){
        boolean badinput = true;
        Scanner input = new Scanner(System.in);
        String response = "";
        String Response = "";
        while(badinput) {
            try {
                response = input.next();
                Response = response.toUpperCase();
                if (Response.equals("Y") || Response.equals("N")) {
                    badinput = false;
                }else{
                    System.out.println("Improper Input, Please Enter [Y] or [N]\n");
                }
            } catch (Exception e) {
                System.out.println("Improper Input, Please Enter [Y] or [N]\n");
            }
        }
        if (Response.equals("Y")){
            return false;
        }else{
            if(Response.equals("N")){
                return true;
            }
        }

        return true;
    }

    public static int playerMove(ArrayList<Integer> openPos, ArrayList<Integer> playerMoves){
        Scanner input = new Scanner(System.in);
        String rbridge = "";
        int response = 0;
        int index = 0;
        boolean badinput = true;
        boolean found = false;

        while(badinput){
            try{
                //Display Options
                System.out.println("Where would you like to place your mark?\nOpen Positions: [1-9]");
                for(int spot : openPos){
                    System.out.print(spot + " ");
                }
                rbridge = input.next();
                if(rbridge.equals("1"))
                    response = 1;
                if(rbridge.equals("2"))
                    response = 2;
                if(rbridge.equals("3"))
                    response = 3;
                if(rbridge.equals("4"))
                    response = 4;
                if(rbridge.equals("5"))
                    response = 5;
                if(rbridge.equals("6"))
                    response = 6;
                if(rbridge.equals("7"))
                    response = 7;
                if(rbridge.equals("8"))
                    response = 8;
                if(rbridge.equals("9"))
                    response = 9;
                if(response <= 9 || response >= 1)
                    badinput = false;
            }catch(Exception e){
                System.out.println("[EXCEPTION] Bad input, please select one of the Open Positions... [1-9]\n\n");
                badinput = true;
                //response = 1;
            }
            found = openPos.contains(response);
            if(!found || response == 0){
                badinput = true;
                System.out.println(" [IF] Bad input, please select one of the Open Positions... [1-9]\n\n");
            }else{
                if(openPos.contains(response)){
                    System.out.println("[VERIFIED]");
                    badinput = false;
                    break;
                }
            }
        }

        //This bit of code edits the board information so Display will be correct
        //Add new move to Player Move Log
        //Remove the move option from the Open Position Log
        //Return the Move Choice to the game
        index = openPos.indexOf(response);
        openPos.remove(index);
        playerMoves.add(response);
        return response;
    }

    public static int cpuMove(ArrayList<Integer> openPos, ArrayList<Integer> cpuMoves){
        Random rand = new Random();
        int response = 1;
        int index = 0;
        boolean badinput = true;

        System.out.println("Olaf is choosing where to make a move now...\n");

        while(badinput){
            response = rand.nextInt(9) + 1;
            if(openPos.contains(response)){
               badinput = false;
            }
        }

        System.out.println("Move Made!");

        index = openPos.indexOf(response);
        openPos.remove(index);
        cpuMoves.add(response);
        return response;
    }

    public static boolean playerGoesFirst(){
        boolean first = true;
        Random rand = new Random();
        int coin = rand.nextInt(2) + 1; //Flipping coin

        System.out.println("Flipping a coin to see who goes first!");

        if(coin == 1) {
            first = true;
            System.out.println("Looks like it's Tails! That means you go first!");
        }else{
            first = false;
            System.out.println("Well, looks like it's Heads! That means Olaf will go first!\n\n");
        }
        return first;
    }




    public static void main(String[] args) {
	// write your code here


        Scanner input = new Scanner(System.in);
        boolean endgame = true;
        boolean gameOn = true;
        boolean playerFirst = true;
        int playerscore= 0;
        int cpuscore = 0;
        int catscratch = 0;
        int roundsplayed = 0;
        int turn = 1;
        int winkey = 4;     //Win condition Key, 0 = O wins, 1 = X wins, 3 = CatScratch, 4 = No win Condition so keep playing
        int psymbolkey = 1;
        int cpusymbolkey = 0;
        int move = 0;

        ArrayList<Integer> playerMoves = new ArrayList<>();
        ArrayList<Integer> cpuMoves = new ArrayList<>();
        ArrayList<Integer> openPos = new ArrayList<>();

        //Key Positions that need to be tested and changed for the game
        String[][] gameboard = {{" ", "1", " | ", "2", " | ", "3", " "},    //[0][1],     [0][3],      [0][5]
                {"-", "-", "-|-", "-", "-|-", "-", "-"},    //
                {" ", "4", " | ", "5", " | ", "6", " "},    //[2][1],     [2][3],      [2][5]
                {"-", "-", "-|-", "-", "-|-", "-", "-"},    //
                {" ", "7", " | ", "8", " | ", "9", " "}};   //[4][1],     [4][3],      [4][5]

        System.out.println("Welcome to Noughts and Crosses!\nWhat's your name? ");
        String playerName = input.nextLine();
        System.out.println("\n\nWell " + playerName + ", it looks like you'll be playing against a me today! My name is Olaf.");



//----------------------------------------------------------------------------------------------------------------------
        //Start if Session - Duration of Whole Program after prerequisites
        while(true){
            openPos.add(0,1);
            openPos.add(1,2);
            openPos.add(2,3);
            openPos.add(3,4);
            openPos.add(4,5);
            openPos.add(5,6);
            openPos.add(6,7);
            openPos.add(7,8);
            openPos.add(8,9);

            gameOn = true;

            //Select Symbol
            //We've removed the ability to change symbol Mid-Game. Was breaking things and I didn't want to figure out why
            psymbolkey = playerSymbol();

            if(psymbolkey == 1){
                cpusymbolkey = 0;
                System.out.println("You have chosen [X], Olaf will be [O]\n");
            }else{
                if(psymbolkey == 0){
                    cpusymbolkey = 1;
                    System.out.println("You have chosen [O], Olaf will be [X]\n");
                }
            }

            //Start of Round and turns, The actual game
            //playerSymbol();
            displayUpdate(gameboard, playerMoves, cpuMoves, psymbolkey, cpusymbolkey);    //Run here for making sure the game board gets either wiped and/or displays properly
            playerFirst = playerGoesFirst();
//----------------------------------------------------------------------------------------------------------------------
            while(gameOn){
                //This is during a game round, iterating through turns
                //Tests to see who's turn it is and which turn it is to retrieve move choices, update board, and test for a winner.


                //If player goes first, testing for CPU of Player Turn
                if(playerFirst && turn % 2 != 0){
                    move = playerMove(openPos, playerMoves);
                    System.out.println("You've made a move on spot [" + move + "]!");
                    //displayUpdate(gameboard, playerMoves, cpuMoves, psymbolkey, cpusymbolkey);
                }
                if(playerFirst && turn % 2 == 0){
                    move = cpuMove(openPos, cpuMoves);
                    System.out.println("Olaf choose to make a move on spot [" + move + "]!");
                    //displayUpdate(gameboard, playerMoves, cpuMoves, psymbolkey, cpusymbolkey);
                }

                //If player Doesn't go first, testing for CPU or Player Turn
                if(!playerFirst && turn % 2 != 0){
                    move = cpuMove(openPos, cpuMoves);
                    System.out.println("Olaf choose to make a move on spot [" + move + "]!");
                    //displayUpdate(gameboard, playerMoves, cpuMoves, psymbolkey, cpusymbolkey);
                }
                if(!playerFirst && turn % 2 == 0){
                    move = playerMove(openPos, playerMoves);
                    System.out.println("You've made a move on spot [" + move + "]!");
                    //displayUpdate(gameboard, playerMoves, cpuMoves, psymbolkey, cpusymbolkey);
                }

                displayUpdate(gameboard, playerMoves, cpuMoves, psymbolkey, cpusymbolkey);


                //testing for game end or winner and game end
                if(turn >= 1){
                    winkey = testWinCondition(playerMoves, cpuMoves, turn, psymbolkey, cpusymbolkey);
                }
                //end of turn, start prepping for next turn
                turn++;
                switch(winkey){
                    case 0:
                    case 1:
                        if(winkey == cpusymbolkey){
                            System.out.println("Olaf has won this round!\n");
                            cpuscore++;

                        }else{
                            if(winkey == psymbolkey){
                                System.out.println(playerName + " is the winner for this round!\n");
                                playerscore++;
                            }
                        }
                        gameOn = false;
                        break;
                    case 3:
                        System.out.println("Oh dear, looks like the cat ruined this game. . .\n");
                        catscratch++;
                        gameOn = false;
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Man, something really went wrong, we'll be right back! Goodbye for now though!");
                        gameOn = false;
                        break;
                }
            }
//----------------------------------------------------------------------------------------------------------------------
            //Wiping the Board
            openPos.removeAll(openPos);
            playerMoves.removeAll(playerMoves);
            cpuMoves.removeAll(cpuMoves);
            displayReset(gameboard);
            roundsplayed++;
            turn = 1;
            winkey = 4;

            //checking for next round game
            System.out.println("Would you like to play another round? Y/N\n");
            endgame = replay();
            if(endgame)
                break;
        }
//----------------------------------------------------------------------------------------------------------------------
        System.out.println("\nAwww, it was nice playing with you, see you next time!");

        //Print out final Session Game Tallies and end program.
        finalScore(playerName, playerscore, cpuscore, roundsplayed, catscratch);
    }
}
