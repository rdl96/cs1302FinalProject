package maze;

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
        r= maze.length-1;
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
                else if(maze[i][n]==1) {
                    System.out.print(" ");
                }
                else {System.out.print("#");}
            }
            System.out.println();
        }

    }


    public boolean takeStep() {
        //complete the code here

        return isAnExit();
    }

    private void moveNorth() {
        //complete the code here

    }

    private void moveSouth() {
        //complete the code here

    }

    private void moveEast() {
        //complete the code here

    }

    private void moveWest() {
        //complete the code here

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