import java.util.*;

public class Main {
    public static void main(String[] args) {
        //
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
        myMaze.printMaze(maze, Maze.makePath(maze, new ArrayList<Cell>(), new Cell(1, 1), new ArrayList<Cell>()));
    }

}

enum WallDirection {
    HORIZONTAL,
    VERTICAL
}

enum WallDirectionCardinal {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}