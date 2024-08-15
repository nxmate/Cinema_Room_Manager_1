package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    static Scanner scanner = new Scanner(System.in);
    static char[][] seats;
    static int purchasedTickets = 0;
    static int tenDollarTickets = 0;
    static int eightDollarTickets = 0;
    static int currentIncome = 0;
    static double percentage;
    static int profit = 0;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numOfSeats = scanner.nextInt();

        seats = new char[rows][numOfSeats];
        initializeSeats();
        start();
    }

    public static void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            Arrays.fill(seats[i], 'S');
        }
    }

    public static void printSeats(int rows, int seatsPerRows) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for(int i = 0; i < seatsPerRows; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for(int i = 0; i < seats.length; i++) {
            System.out.print((i + 1) + " ");
            for (char c : seats[i]) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void calculateTheProfit(int rows1, int numOfSeats1) {
        int totalNumOfSeats = rows1 * numOfSeats1;
        int frontRowsPrice = 0;
        int backRowsPrice = 0;

        if (totalNumOfSeats <= 60) {
            profit = 10 * totalNumOfSeats;
            System.out.println("Total income: $" + profit);
        } else if (totalNumOfSeats > 60) {
            if (rows1 % 2 != 0) {
                frontRowsPrice = 10 * (((rows1 - 1) / 2) * numOfSeats1);
                backRowsPrice = 8 * (((rows1 + 1) / 2) * numOfSeats1);
                profit = frontRowsPrice + backRowsPrice;
                System.out.println("Total income: $" + profit);
            } else {
                frontRowsPrice = 10 * ((rows1 / 2) * numOfSeats1);
                backRowsPrice = 8 * ((rows1 / 2) * numOfSeats1);
                profit = frontRowsPrice + backRowsPrice;
                System.out.println("Total income: $" + profit);
            }
        }

    }
        public static void setTheTicketPrice() {
            int chosenTicketPrice = 10;
            int totalSeats = seats.length * seats[0].length;

            System.out.println("Enter a row number:");
            int rows3 = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();

            if(rows3 < 1 || rows3 > seats.length || seat < 1 || seat > seats[0].length) {
                System.out.println("Wrong input!");
                setTheTicketPrice();
                return;
            }
            if (seats[rows3 - 1][seat - 1] == 'S') {
                if (totalSeats > 60) {
                    int mid = seats.length / 2;
                    if (rows3 <= mid) {
                        chosenTicketPrice = 10;
                        tenDollarTickets += 10;
                    } else {
                        chosenTicketPrice = 8;
                        eightDollarTickets += 8;
                    }
                } else {
                    chosenTicketPrice = 10;
                    tenDollarTickets += 10;
                }

                seats[rows3 - 1][seat - 1] = 'B';
                System.out.println();
                System.out.println("Ticket price: $" + chosenTicketPrice);
                purchasedTickets++;
                currentIncome = tenDollarTickets + eightDollarTickets;
                percentage = 100 * ((double) purchasedTickets / totalSeats);
            } else {
                System.out.println();
                System.out.println("That ticket has already been purchased!");
                setTheTicketPrice();
            }
    }

    public static void statistics() {
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
        System.out.println("Current income: $" + currentIncome);
        calculateTheProfit(seats.length, seats[0].length);
    }

    public static void start() {

        for(;;) {

            System.out.println("\n" +
                    "1. Show the seats.\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");

            int input = scanner.nextInt();

            if (input == 0) {
                break;
            } else if (input == 1) {
                System.out.println();
                printSeats(seats.length, seats[0].length);
            } else if (input == 2) {
                System.out.println();
                setTheTicketPrice();
            } else if (input == 3) {
                System.out.println();
                statistics();
            }
        }
    }
}