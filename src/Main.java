import java.util.*;

public class Main {
    public static void main(String[] args) {
        // This is where the maze you want to solve is created
        // 2 indicates the start of the maze, and 3 indicates the end of the maze. Only one of each  can be added into the maze.
        // 1 indicates a wall. The maze must be surrounded by 1's completely.
        // 0 indicates an empty space, and there must be a line of consecutive (non-diagonal) 0's for the program to find a solution
        // An outline for an example maze has been provide below.
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 3, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        Maze myMaze = new Maze();
        // Before running the code, change the third parameter of printMaze call to your starting cell position.
        // The cell class uses an x/y format. The first portion of the cell is x, which starts at 0 and increases rightward.
        // The second portion of the cell is y, which starts at 0 and increases downwards.
        myMaze.printMaze(maze, Maze.makePath(maze, new ArrayList<>(), new Cell(1, 1), new ArrayList<>()));

        // To run the code, simply click run on whichever application/website you are using to run the code.
        // The result will appear in the console.
    }

}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}