package maze;

import java.util.Scanner;

/**
 * Created by Tulin Kilinc 1/19/2017.
 * KSU Programming Principles II
 */

public class Maze {

    private char direction;
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private boolean exitFound = false;
    int[][] maze;




    public Maze(int[][] arrMaze) {
        this.maze=arrMaze;
        r=maze.length-1;
        c=0;
     }

    //Prints out the maze without solution
    public void displayMaze() {
        for (int i=0; i< maze.length; i++) {

            for (int n = 0; n<maze[i].length; n++){
                if (maze[i][n]==0){
                    System.out.print('#');
                }
                else{System.out.print(" ");}
            }
            System.out.println();
        }

    }

    //displays the Maze with the path taken
    public void displayPath() {
        for (int i=0; i< maze.length; i++) {

            for (int n = 0; n<maze[i].length; n++){
                if (i==r && n==c){
                    System.out.print('@');
                }
                else if(maze[i][n]==3){
                    System.out.print('~');
                }
                else if(maze[i][n]==1) {
                    System.out.print(" ");
                }
                else {System.out.print("#");}
            }
            System.out.println();
        }

    }


    public boolean takeStep() {
        Scanner scan = new Scanner(System.in);
        System.out.println("would you like to go up, down, left or right?");
        String direction= scan.nextLine();

        if (direction.equalsIgnoreCase("up")){
            moveNorth();
        }
        else if (direction.equalsIgnoreCase("down")){
            moveSouth();
        }
        else if (direction.equalsIgnoreCase("left")){
            moveWest();
        }
        else if (direction.equalsIgnoreCase("right")){
            moveEast();
        }
        else {
            System.out.println("Direction does not exist. Please try again");
            takeStep();
        }
        displayPath();
        return isAnExit();
    }

    private void moveNorth() {
        if (r-1<0){
            System.out.println("cannot move any further in this direction\n please try again");
            takeStep();
        }
        else if(maze[r-1][c]!= 0){
            maze[r][c] =3;
            r--;
        }

    }

    private void moveSouth() {
        if (r+1>maze.length-1){
            System.out.println("cannot move any further in this direction\nplease try again");
            takeStep();
        }
        else if(maze[r+1][c]!= 0){
            maze[r][c] =3;
            r++;
        }
    }

    private void moveEast() {
        if(c+1>maze[r].length){
            System.out.println("cannot move any further in this direction\nplease try again");
            takeStep();
        }
        else if(maze[r][c+1]!= 0){
            maze[r][c] =3;
            c++;
        }

    }

    private void moveWest() {
        if(c-1<0){
            System.out.println("cannot move any further in this direction\nplease try again");
            takeStep();
        }
        else if(maze[r][c-1]!= 0){
            maze[r][c] =3;
            c--;
        }

    }


    private boolean isAnExit() {
        //complete the code here
        return exitFound;
    }

    //finds the path without stopping at every step
    public void findExit() {
        //complete the code here

    }
}