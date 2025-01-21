package Assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieTheatreSeating {

    int arr[][];
    Map<String, Integer[]> seatMap;

    public MovieTheatreSeating(int rows, int cols) {
        arr = new int[rows][cols];
        seatMap = new HashMap<>();

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                arr[row][col] = Integer.MIN_VALUE;

                String seatName = (char)('A' + row) + String.valueOf(col + 1);
                seatMap.put(seatName, new Integer[]{row, col});
            }
        }
    }

    public void display() {
        final String RESET = "\033[0m";
        final String GREEN = "\033[0;32m";
        final String RED =   "\033[0;31m";

        System.out.println("Seating Chart: ");
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                String seatName = (char)('A' + row) + String.valueOf(col + 1);
                if (arr[row][col] == Integer.MIN_VALUE) {
                    System.out.print(GREEN + seatName + "(AVAILABLE) " + RESET);
                } else {
                    System.out.print(RED + seatName + "(RESERVED)  " + RESET);
                }
            }
            System.out.println();
        }
    }

    public boolean isAvailable(String seatName) {
        if (seatMap.containsKey(seatName)) {
            Integer[] seat = seatMap.get(seatName);
            int row = seat[0];
            int col = seat[1];
            return arr[row][col] == Integer.MIN_VALUE;
        }
        return false;
    }

    public void listAvailableSeats() {
        final String RESET = "\033[0m";
        final String GREEN = "\033[0;32m";

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] == Integer.MIN_VALUE) {
                    String seatName = (char)('A' + row) + String.valueOf(col + 1);
                    System.out.print(GREEN + seatName + "(AVAILABLE) " + RESET);
                }
            }
            System.out.println();
        }

    }

    public void reserveSeat(String seatName) {
        if (isAvailable(seatName)) {
            Integer[] seat = seatMap.get(seatName);
            arr[seat[0]][seat[1]] = Integer.MAX_VALUE;
            System.out.println("Seat " + seatName + " successfully reserved");
        } else if (seatMap.containsKey(seatName)) {
            System.out.println("Sorry, seat " + seatName + " is already reserved");
            System.out.println("Please choose from one of the available seats: ");
            listAvailableSeats();
        } else {
            System.out.println("Invalid seat name. Please choose from one of the available seats: ");
            listAvailableSeats();
        }
    }

    public void cancelSeat(String seatName) {
        if (seatMap.containsKey(seatName)) {
            Integer[] seat = seatMap.get(seatName);
            if (arr[seat[0]][seat[1]] == Integer.MAX_VALUE) {
                arr[seat[0]][seat[1]] = Integer.MIN_VALUE;
                System.out.println("Seat " + seatName + " reservation successfully cancelled");
            } else {
                System.out.println("Seat " + seatName + " is not reserved");
            }
        } else {
            System.out.println("Invalid seat name.");
        }
    }

    public void options() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Please select an option: ");
            System.out.println("1. Reserve seat");
            System.out.println("2. Cancel seat");
            System.out.println("3. Display seats");
            System.out.println("4. Exit");
            System.out.println("Enter your choice (ex. 1): ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the seat name you would like to reserve (ex. A1): ");
                    String reserveSeatName = sc.nextLine().toUpperCase();
                    reserveSeat(reserveSeatName);
                    break;

                case 2:
                    System.out.println("Enter the seat name you would like to cancel (ex. A1): ");
                    String cancelSeatName = sc.nextLine().toUpperCase();
                    cancelSeat(cancelSeatName);
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid option. Please choose either 1, 2, 3, or 4. ");

            }
        }

    }


    public static void main(String[] args) {

        System.out.println();
        System.out.println("Welcome to the Movie Theatre Seating Program");
        MovieTheatreSeating movieTheatreSeating = new MovieTheatreSeating(4, 4);
        movieTheatreSeating.options();

    }


}
