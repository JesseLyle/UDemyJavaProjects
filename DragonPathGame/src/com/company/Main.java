package com.company;

import java.util.*;

class DragonGame {

    public static void Intro() {
        //Print out the Introduction
        System.out.println("You are in a land full of dragons.' in front of you,");
        System.out.println("you see two caves. In one cave, the dragon is friendly\nand will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.\n\n");

    }

    //ChoiceEvent returns a string of event dialogue based on player choice
    public static String ChoiceEvent(int selection) {
        String event = "";

        switch (selection) {
            case 1:
                System.out.println("You have chosen.");
                event = "The cave opens brightly to a bounty of treasures!\n\nHowever, a low thrum starts behind you as you enter...\nsuddenly you are engulfed in flame and heat.";
                break;

            case 2:
                System.out.println("You have chosen.");
                event = "The cave opens to a dull room, two coins on the ground.\nA dragon clambers its way down from the ceiling...\n\"Would you like a share of my hoard?\", the dragon says smiling.";
                break;

            default:
                System.out.println("You have not chosen.");
                event = "You decided to leave the caves and go home...\nYou find a gold coin on the road!";
                break;
        }
        return event;
    }

    //DayEnds to return string ending based on player choice
    public static String DayEnds(int selection) {
        String ending = "";

        switch (selection) {
            case 1: //If player was eaten by Bad Dragon
                ending = "The day ends, not that you'd know.\nTHOU ART DEAD";
                break;
            case 2: //If player found the Nice Dragon
                ending = "The day ends, and you've gained a coin for your coffers\nand a new friend for tomorrow!";
                break;
            default: //If player gave an invalid answer
                ending = "The day ends, and you've gained a coin for your coffers.";
                break;
        }
        return ending;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;             //To store player response in integer form
        boolean in_test = true; //determine whether response is valid
        String event = "";      //Store Event script based on player choice
        String ending = "";     //Store Ending script based on player choice

        Intro();    //Call on Intro method to print the Intro

        //After Introduction, present player with question
        System.out.println("Which cave will you go in to? (1 or 2)\n");

        //Test to make sure the response is of some validity
        while (in_test) {
            choice = input.nextInt();
            if (choice % 1 == 0)
                in_test = false;
        }

        //Retrieve effect that takes place based on player choice
        event = ChoiceEvent(choice);

        //Call on the end of the day determined by player choice and event
        ending = DayEnds(choice);

        //Print out the effect of choice and then the ending of the day
        System.out.println(event);
        System.out.println();
        System.out.println(ending);

        //End the game

    }
}