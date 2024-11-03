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