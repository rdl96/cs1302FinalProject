package maze;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Tulin Kilinc 1/19/2017.
 * KSU Programming Principles II
 */

public class Maze {

    private char direction;
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private int stepCounter = 0;
    private boolean exitFound = false;
    int[][] maze;
    int[][] map;


    public Maze(int[][] arrMaze) {
        this.maze = arrMaze;
        this.map = arrMaze;
        r = maze.length - 1;
        c = 0;
    }

    //Prints out the maze without solution
    public void displayMaze() {
        for (int i = 0; i < maze.length; i++) {

            for (int n = 0; n < maze[i].length; n++) {
                if (maze[i][n] == 0) {
                    System.out.print('#');
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    //displays the Maze with the path taken
    public void displayPath() {
        for (int i = 0; i < maze.length; i++) {

            for (int n = 0; n < maze[i].length; n++) {
                if (i == r && n == c) {
                    System.out.print('@');
                } else if (maze[i][n] == 3) {
                    System.out.print('~');
                } else if (maze[i][n] == 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }

    }


    public boolean takeStep() throws ArrayIndexOutOfBoundsException{
        Scanner scan = new Scanner(System.in);
        System.out.println("would you like to go up, down, left or right?");
        String direction = scan.nextLine();
        direction = direction.toLowerCase();
        switch (direction){
            case "up": moveNorth(); break;
            case "right": moveEast(); break;
            case "down": moveSouth(); break;
            case "left": moveWest(); break;
            default: {System.out.println("Direction does not exist.");}
        }

        displayPath();
        if(stepCounter < 3){
            return false;
        }
        else {
            return isAnExit();
        }
    }

    private void moveNorth() {
        if (r - 1 < 0 || maze[r-1][c]==0) {
            return;
        }
        maze[r][c] = 3;
        r--;
        stepCounter++;
    }

    private void moveSouth() {
        if ((r + 1 > maze.length - 1) || maze[r+1][c] == 0) {
            return;
        }
        maze[r][c] = 3;
        r++;
        stepCounter++;
    }

    private void moveEast() {
        if (c + 1 > maze[r].length || maze[r][c+1]==0) {
            return;
        }
        maze[r][c] = 3;
        c++;
        stepCounter++;
    }

    private void moveWest() {
        if (c - 1 < 0 || maze[r][c-1]==0) {
            return;
        }
        maze[r][c] = 3;
        c--;
        stepCounter++;
    }


    private boolean isAnExit() {
        if ((r == 0 || c == 0 || c == maze[r].length-1 || r == maze.length-1)&& r < maze.length-1 && c > 0) {
            exitFound = true;
        } else {
            exitFound = false;
        }

        return exitFound;
    }

    public void findExit() {
        findExitRecursion(r,c);
        displayPath();
    }
    public boolean findExitRecursion(int r, int c) {
        if (isAnExit()) {
            return true;
        }

        maze[r][c]=3;
        this.r =r;
        this.c=c;
        if (withinParameter(r - 1,c)&& findExitRecursion(r - 1, c)){
            return true;
        }
        if (withinParameter(r + 1,c) && findExitRecursion(r+1,c)){
            return true;
        }
        if (withinParameter(r ,c+1) && findExitRecursion(r,c+1)){
            return true;
        }
        if (withinParameter(r ,c-1) && findExitRecursion(r,c-1)){
            return true;
        }

        maze[r][c]=1;
        return false;

    }

    public boolean withinParameter(int r, int c){
        if(r >= 0 && r < maze.length && c >= 0 && c < maze[r].length && (maze[r][c] == 1||isAnExit())){
            return true;
        }
        return false;
    }
}
