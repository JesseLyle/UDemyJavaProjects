package com.company;
import java.util.*;
public class Hobgoblin {
    private static Random rand;
    static private int currentHP;
    static private int maxHP;
    static private int str;
    static private int armor;
    static String[] name = {"Heinz", "Heinrick", "Henry", "Hobo", "Higfried", "Hank", "Hobson", "Huebert"}; //There are 0-7 name selections
    //Base Stats for a regular Hobgoblin [G]
    //Random rand = new Random();

    //Method for generating Hobgoblin name: NamE
    static public String hobNameGen(){
        int i = rand.nextInt(8);
        String hName = name[i];
        return hName;
    }


    //Method for generating new MaxHP: 10-17 + Battles won
    static public int getGoblinMaxHP(int battles){
        maxHP = rand.nextInt(8) + 10 + battles;
        currentHP = maxHP;
        return maxHP;
    }


    //Method for Generating Str: 3-5
    static public int getHobgoblinStr(){
        str = rand.nextInt(3) + 3;
        return str;
    }


    //Method for Generating Armor: 2-5
    static public int getHobgoblinArmor(){
        armor = rand.nextInt(4) + 2;
        return armor;
    }


    //Method for retrieving currentHP

    //Method for Altering currentHP
}
