/**
 * Program to create and solve Sudoku puzzles
 * Lucas Delvoie
 * October 27th,2024
 */
import java.util.Random;
import java.util.Scanner;

public class SudokuPuzzle {
    // creates Sudoku grid size
    private static final int GRID_SIZE = 9;
    private static final int BOX_SIZE = 3;

    // import Random numbers for puzzle
    private static Random random = new Random();

    //  User input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choice = "";

        // Main Menu
        System.out.println("\nWelcome to the Sudoku Puzzle Generator!");
        while (!choice.equals("3")) {
            // Generate a full Sudoku grid
            int[][] fullGrid = createFullSudokuGrid();
            
            // Create a puzzle from the full grid
            int[][] puzzle = createSudokuPuzzle(fullGrid);
            
            // Print the puzzle
            System.out.println("Here's your newly generated Sudoku puzzle:");
            printSudoku(puzzle);
            // Menu options
            System.out.println("\nChoose an option:");
            System.out.println("1. Show solution");
            System.out.println("2. Generate new puzzle");
            System.out.println("3. Quit");
            
            choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                System.out.println("\nHere's the solution:");
                printSudoku(fullGrid);
            } else if (choice.equals("2")) {
                System.out.println("\nGenerating a new puzzle...");
            } else if (!choice.equals("3")) {
                System.out.println("\nInvalid choice. Please try again.");
            }
        }
        System.out.println("Closing the program...");
        scanner.close();  // Close the scanner when done
    }
    // Generate the random Sudoku grid
    public static int[][] createFullSudokuGrid() {
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        fillGrid(grid);
        return grid;
    }

    // Function to fill the grid
    private static boolean fillGrid(int[][] grid) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] == 0) {
                    for (int num = 1; num <= GRID_SIZE; num++) {
                        if (isValid(grid, row, col, num)) {
                            grid[row][col] = num;
                            if (fillGrid(grid)) {
                                return true;
                            }
                            grid[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Check the position is valid
    private static boolean isValid(int[][] grid, int row, int col, int num) {
        // Check row
        for (int x = 0; x < GRID_SIZE; x++) {
            if (grid[row][x] == num) {
                return false;
            }
        }
        // Check column
        for (int x = 0; x < GRID_SIZE; x++) {
            if (grid[x][col] == num) {
                return false;
            }
        }
        // Check box
        int boxRow = row - row % BOX_SIZE;
        int boxCol = col - col % BOX_SIZE;
        for (int i = boxRow; i < boxRow + BOX_SIZE; i++) {
            for (int j = boxCol; j < boxCol + BOX_SIZE; j++) {
                if (grid[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
    // Removing numbers from sukoku grid
    public static int[][] createSudokuPuzzle(int[][] fullGrid) {
        int[][] puzzle = new int[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            System.arraycopy(fullGrid[i], 0, puzzle[i], 0, GRID_SIZE);
        }