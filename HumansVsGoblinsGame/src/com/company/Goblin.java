package com.company;
import java.util.*;
public class Goblin {
    private static Random rand;
    //static private int currentHP;
    static private int maxHP;
    static private int str = 2;
    static private int armor = 2;
    static String[] name = {"Geff", "Gobert", "Gibb", "Gobta", "Gilfred", "Guuf", "Gobson", "Gubbo"}; //There are 0-7 name selections
    //Random rand = new Random();
    //Base Stats for a regular Goblin [g]

    //Method for Generating Goblin name:
    static public String gobNameGen(){
        int i = rand.nextInt(8);
        String hName = name[i];
        return hName;
    }


    //Method for Generating new MaxHP: 3-8 + Battles won
    static public int getGoblinMaxHP(int battles){
        maxHP = rand.nextInt(4) + 3 + battles;
        return maxHP;
    }


    //Method for Generating Str: 0-2
    static public int getGoblinStr(){
        int newMaxHP = rand.nextInt(3);
        return newMaxHP;
    }


    //Method for Generating Armor: 0-3
    static public int getGoblinArmor(){
        return armor;
    }


    //Method for retrieving HP

    //Method for Altering HP
}
