package com.pluralsight;

import java.util.Scanner;

public class LibraryApplication {
    public static void main(String[] args) {
        String[] books = {
                "1984", "The Lord of the Rings", "The Great Gatsby",
                "To kill a Mockingbird", "The Sun Also Rises", "Beloved",
                "Jane Eyre", "Harry Eyre", "Dune", "Of Mice and Men",
                "Fahrenheit 451", "Harry Potter", "The Giver",
                "Gone With the Wind", "Atomic Habit", "Emma",
                "Earth To Unknown", "The Number", "Dark New World",
                "The One After Mars"
        };

        Book[] bookArray = new Book[books.length];

        for (int i = 0; i < books.length; i++) {
            bookArray[i] = new Book(i, "isbn" + i, books[i], false, "");
        }

        homeScreen(bookArray);

    }

    public static void homeScreen(Book[] bookArray) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Charlotte Mecklenburg Library");
        System.out.println("How can we help you today?");
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Show available books");
            System.out.println("2. Show checked out books");
            System.out.println("3. Check out a book");
            System.out.println("4. Check in a book");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available books:");
                    for (Book book : bookArray) {
                        if (!book.isCheckedOut()) {
                            System.out.println(book.getTitle());
                        }
                    }
                    break;

                case 2:
                    System.out.println("Checked out books:");
                    for (Book book : bookArray) {
                        if (book.isCheckedOut()) {
                            System.out.println(book.getTitle());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter the title of the book you want to check out: ");
                    String titleName = scanner.next();

                    for (Book book : bookArray) {
                        if (book.getTitle().toLowerCase().equals(titleName)) {
                            book.setCheckedOut(true);
                            System.out.println("You've checked out: " + book.getTitle());
                            break;
                        }
                    }
                    break;

                case 4:
                    for (Book book : bookArray) {
                        if (book.isCheckedOut()) {
                            System.out.println("What book do you want to check in?: ");
                            String checkingIn = scanner.next();
                            if (checkingIn.equals(book.getTitle())) {
                                book.checkIn();
                                System.out.println("Your book is checked in!");
                            }
                        }
                    }
                    break;
                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}