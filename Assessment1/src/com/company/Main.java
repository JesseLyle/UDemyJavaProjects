package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String word = "ReverseMe";
        ArrayList<String> toReverse = new ArrayList<>();
        String[] hold = word.split("");
        int l = hold.length;


        for(int i = 0; i <= l; i++){
            toReverse.add("");

        }

        l--;
        for(String letter : hold){
            toReverse.set(l, letter);
            l--;

        }
        System.out.println(word);
        for(String letter : toReverse){
            System.out.print(letter);
        }
    }
}
