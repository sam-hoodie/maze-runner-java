import java.util.*;

public class Maze {


    public static ArrayList<Cell> makePath(int[][] maze, ArrayList<Cell> path, Cell currentPos, ArrayList<Cell> visited) {
        int x = currentPos.getX();
        int y = currentPos.getY();
        // if value in maze at current position is 3, we have reached the end
        if (maze[y][x] == 3) {
            return path;
        }
        // If the next cell in any of the four directions is available, the method calls itself recursively and updates all needed parameters
        if (canGo(maze, Direction.UP, currentPos) && !containsCell(visited, new Cell(x, y - 1))) {

            return makePath(maze, appendCell(path, new Cell(x, y - 1)), new Cell(x, y - 1), appendCell(visited, currentPos));
        }
        if (canGo(maze, Direction.DOWN, currentPos) && !containsCell(visited, new Cell(x, y + 1))) {
            return makePath(maze, appendCell(path, new Cell(x, y + 1)), new Cell(x, y + 1), appendCell(visited, currentPos));
        }
        if (canGo(maze, Direction.LEFT, currentPos) && !containsCell(visited, new Cell(x - 1, y))) {
            return makePath(maze, appendCell(path, new Cell(x - 1, y)), new Cell(x - 1, y), appendCell(visited, currentPos));
        }
        if (canGo(maze, Direction.RIGHT, currentPos) && !containsCell(visited, new Cell(x + 1, y))) {
            return makePath(maze, appendCell(path, new Cell(x + 1, y)), new Cell(x + 1, y), appendCell(visited, currentPos));
        }
        // If we cannot go in direction, we backtrack by one cell and the method calls itself recursively.
        // Each time we backtrack, we check if there is a new direction we can go.
        List<Cell> subPath = path.subList(0, path.size() - 1);
        ArrayList<Cell> newSubPath = new ArrayList<>(subPath);
        return makePath(maze, newSubPath, path.get(path.size() - 2), appendCell(visited, currentPos));
    }

    //  containsCell checks if a given cell in a given list of cells

    public static Boolean containsCell(ArrayList<Cell> toCheck, Cell target) {
        for (Cell current : toCheck) {
            if (current.getX() == target.getX() && current.getY() == target.getY()) {
                return true;
            }
        }
        return false;
    }

    // appendCell adds a new cell to an arraylist of cells

    public static ArrayList<Cell> appendCell(ArrayList<Cell> list, Cell c) {
        ArrayList<Cell> newList = new ArrayList<>();
        newList.addAll(list);
        newList.add(c);
        return newList;
    }

    // canGo uses the maze, direction desired, and current position to check if the next position in the given direction is available

    public static Boolean canGo(int[][] maze, Direction direction, Cell position) {
        int x = position.getX();
        int y = position.getY();
        if (direction == Direction.UP) {
            if (y == 0) {
                return false;
            }
            if (maze[y - 1][x] == 1) {
                return false;
            }
        }
        if (direction == Direction.DOWN) {
            if (y == maze.length - 1) {
                return false;
            }
            if (maze[y + 1][x] == 1) {
                return false;
            }
        }
        if (direction == Direction.LEFT) {
            if (x == 0) {
                return false;
            }
            if (maze[y][x - 1] == 1) {
                return false;
            }
        }
        if (direction == Direction.RIGHT) {
            if (x == maze[0].length - 1) {
                return false;
            }
            if (maze[y][x + 1] == 1) {
                return false;
            }
        }
        return true;
    }

    // Prints the maze given the maze layout, and a path is applicable

    public void printMaze(int[][] maze, ArrayList<Cell> path) {
        for (int row = 0; row < maze.length; row++) {
            for (int column = 0; column < maze[row].length; column++) {
                Cell current = new Cell(column, row);
                // If the current cell is part of the path, an x is printed to indicate this
                if (containsCell(path, current)) {
                    System.out.print(" x ");
                    continue;
                }

                // Based on the current portion of the maze, a different output is given
                switch (maze[row][column]) {
                    case 0:
                        System.out.print("   ");
                        break;
                    case 1, 4:
                        System.out.print("|||");
                        break;
                    case 2:
                        System.out.print(" s ");
                        break;
                    case 3:
                        System.out.print(" e ");
                        break;
                }
            }
            System.out.println();
        }
    }
}
