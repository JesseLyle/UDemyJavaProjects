package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        /*
        Purpose:
        Everything must be coded as an object {Goblins, Humans, THE LAND, etc}
        Must @override toString method to represent each of the objects?
        create a grid for the game world, and update each turn
            Player turn, then goblin turn, update each time
            Turn Based movement, have a Compass Rose to reference (N/E/S/W)
        Collision of H and G/g means combat start
            Use random to determine outcome of each combat
        Extra needs
            Player inventory system
            Monster Drops
            Stat changes from equipment
            Goblins also Chase the Human

        Add some story, some win conditions, multi win, like YOU WIN for CLEARING the Field, but
        you failed to get enough coin to pay for a potion to save your son of some shit like that




        */

        //F

        //enemy goblin = new enemy();

        String hobName = Hobgoblin.hobNameGen();

        Random rand = new Random();

        char[][] map = {{'/','/','/','/','/'},      //Array Coordinates are as Designated [y] [x] in reverse values
                    {'\\', '\\', '\\', '\\', '\\'},
                    {'/','/','/','/','/'},
                    {'\\', '\\', '\\', '\\', '\\'},
                    {'/','/','/','/','/'}};

        char[][] map2 = {{'~', '~', '~', '~', '~'},
                    {'~', '~', '~', '~', '~'},
                    {'~', '~', '~', '~', '~'},
                    {'~', '~', '~', '~', '~'},
                    {'~', '~', '~', '~', '~'},};

        int x = 1;
        int y = 4;
        int r = 0;

        map[y][x] = 'P';

        System.out.println("  0 1 2 3 4 ");

        for(char[] row : map){
            System.out.print(r + " ");
            for(char piece : row){
                System.out.print(piece + " ");
            }
            r++;
            System.out.println();
        }

        map = map2;

        System.out.println("  0 1 2 3 4 ");
        r = 0;
        for(char[] row : map){
            System.out.print(r + " ");
            for(char piece : row){
                System.out.print(piece + " ");
            }
            r++;
            System.out.println();
        }
    }
}
