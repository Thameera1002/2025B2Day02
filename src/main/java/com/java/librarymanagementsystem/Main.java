package com.java.librarymanagementsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Library library = new Library();

//        LibraryItems book1 = new Book("Book1","Author1","B10001");
//        LibraryItems book2 = new Book("Book2","Author2","B10002");
//        LibraryItems book3 = new Book("Book3","Author3","B10003");
//
//        LibraryItems magazine1 = new Magazine("Magazine1","Author1","M10003");
//
//        library.addItem(book1);
//        library.addItem(book2);
//        library.addItem(book3);
//        library.addItem(magazine1);
//
//        User user1 = new User("Dasuni");
//        User user2 = new User("Nilupuli");
//
//        library.addUser(user1);
//        library.addUser(user2);

        List<LibraryItems> libraryItems = LibraryIO.loadItemsFromFile("itemList.lms");
        for (LibraryItems libraryItem : libraryItems) {
            library.addItem(libraryItem);
        }
//        libraryItems.forEach(library::addItem);

        List<User> users = LibraryIO.loadUsersFromFile("userList.lms");
        for (User user : users) {
            library.addUser(user);
        }

        Map<String, String> borrowedItems = LibraryIO.loadBorrowedItems("borrowedItemList.lms");
        for(Map.Entry<String,String> borrowedItem : borrowedItems.entrySet()){
            library.getBorrowedItems().put(borrowedItem.getKey(), borrowedItem.getValue());
        }


        System.out.println("----------Library Items-----------");
        library.getLibraryItems().forEach(item -> System.out.println(item.getTitle()+"\t"+item.getAuthor()+"\t"+item.getSerialNumber()));

        System.out.println("----------User Details-----------");
        library.getUserList().forEach(user -> System.out.println(user.getName()));

        System.out.println("----------Borrowed items-----------");
        library.getBorrowedItems().forEach((item,user) -> System.out.println(item+" : "+user));


        boolean exit = false;
        while (!exit) {
            System.out.println("\nEnter main menu option :\n");
            System.out.println("1. Create new item ");
            System.out.println("2. Create new user ");
            System.out.println("3. User need to borrow an item ");
            System.out.println("4. User need to return an item ");
            System.out.println("5. Exit");

            BufferedReader mainMenuOption = new BufferedReader(new InputStreamReader(System.in));
            int mainMenuOptionChoice;
            try {
                mainMenuOptionChoice = Integer.parseInt(mainMenuOption.readLine());
            } catch (IOException e) {
                System.out.println("Please enter a valid option" + e.getMessage());
                continue;
            }

            if (mainMenuOptionChoice == 1) {
                System.out.println("\n----------Create new item -----------\n");
                System.out.println("Which library item would you like to create ?\n");
                System.out.println("1. Create new Book");
                System.out.println("2. Create new Magazine");
                BufferedReader createdItemType = new BufferedReader(new InputStreamReader(System.in));
                int createdItemTypeChoice;
                try {
                    createdItemTypeChoice = Integer.parseInt(createdItemType.readLine());
                } catch (IOException e) {
                    System.out.println("Please enter a valid option" + e.getMessage());
                    continue;
                }
                if (createdItemTypeChoice == 1) {
                    System.out.println("\n----------Create new Book ----------\n");
                    System.out.println("Please enter the title of the book ");
                    String bookNameStr = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    System.out.println("Please enter the author of the book ");
                    String authorStr = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    System.out.println("Please enter the serial number of the book ");
                    String bookSerialNumberStr = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    for (LibraryItems libraryItem : library.getLibraryItems()) {
                        if(Objects.equals(libraryItem.getSerialNumber(), bookSerialNumberStr)){
                            System.out.println("This library item already exists");
                            continue;
                        }
                    }
                    LibraryItems createNewBook = new Book(bookNameStr, authorStr, bookSerialNumberStr);
                    library.addItem(createNewBook);
                }
            }else if(mainMenuOptionChoice == 5) {
                exit = true;
            }
        }

        LibraryIO.saveItemToFile(library.getLibraryItems(),"itemList.lms");

    }
}