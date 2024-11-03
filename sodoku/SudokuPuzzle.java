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