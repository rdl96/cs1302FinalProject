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
       +

    //finds the path without stopping at every step
    public void findExit() {
        //complete the code here
 int i = stack.peek().getRow();
		int n = stack.peek().getCol();
		map[n][j] = 1;
		
		if (!bottom(i, n) && !right(i, n) && !up(i, n) && !left(i, n)) {
			if (exitFound()) {
				if (steps < numSteps) {
					numSteps = steps;
					copyPath();
				}
			}
			stack.pop();
			return;
		}

		if (exitFound()) {
			if (steps < numSteps) {
				numSteps = steps;
				copyPath();
			}
			stack.pop();
			return;
		}
		else {
			//Go down
			if (bottom(i, n)) {
				stack.push(new Coordinate(i+1, n));
				findExit(steps+1);
			}
			//Go right
			if (right(i, n)) {
				stack.push(new Coordinate(i, n+1));
				findExit(steps+1);
			}
			//Go up
			if (up(i, n)) {
				stack.push(new Coordinate(i-1, n));
				findExit(steps+1);
			}
			//Go left
			if (left(i, n)) {
				stack.push(new Coordinate(i, n-1));
				findExit(steps+1);
			}
			
			//Explored all the possible directions
			stack.pop();
		}
		
		if (stack.empty()) return;
}
        return exitFound;
        
        public boolean exitFound() {
		if (stack.peek().getCol() == size-1 || stack.peek().getRow() == 0 || stack.peek().getRow() == size-1)
			return true;
return false;
    }
    }
}
