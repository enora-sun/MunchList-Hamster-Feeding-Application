package ui;

import model.MunchItem;
import model.MunchList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

// MunchMaster application
public class MunchMaster {
    private MunchItem munchItem;
    private MunchList munchList;
    private Scanner input;

    // EFFECTS: runs the teller application
    public MunchMaster() {
        runMunchMaster();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runMunchMaster() {
        boolean keepGoing = true;
        String command = null;
        initialize();
        munchList = new MunchList();
        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("end")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("Happy Hamster Feeding!");
    }

    // MODIFIES: this
    // EFFECTS: initializes MunchMaster
    private void initialize() {
        munchItem = new MunchItem();

        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("Select from:");
        System.out.println("add -> add MunchItem");
        System.out.println("remove -> remove MunchItem");
        System.out.println("view -> view MunchList");
        System.out.println("oa -> analyze overall MunchList");
        System.out.println("end -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("add")) {
            this.addMunchItem();
        } else if (command.equals("remove")) {
            this.removeMunchItem();
        } else if (command.equals("view")) {
            System.out.println(munchList.viewMunchList());
        } else if (command.equals("oa")) {
            this.overallAnalyze();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // REQUIRES: name!="", amount is a positive integer,
    // category must be one out of vegetable, fruit, meat, nut, carb.
    // MODIFIES: this
    // EFFECTS: add one MunchItem to MunchList
    private MunchList addMunchItem() {
        munchItem = new MunchItem();
        System.out.print("Enter MunchItem name: ");
        String name = input.next();
        System.out.print("Enter MunchItem amount(g): ");
        int amount = Integer.parseInt(input.next());
        System.out.print("Enter MunchItem category(vegetable, fruit, meat, nut, carb): ");
        String category = input.next();
        munchItem.setMunchItem(name, amount, category);
        this.munchList.addMunchItem(munchItem);
        System.out.println("Addition successful!");
        return this.munchList;
    }

    // MODIFIES: this
    // EFFECTS: remove one MunchItem to MunchList
    private MunchList removeMunchItem() {

        System.out.print("Enter MunchItem name: ");
        String name = input.next();
        System.out.print("Enter MunchItem amount(g): ");
        int amount = input.nextInt();
        this.munchList.removeMunchItem(name, amount);
        return this.munchList;
    }

    // EFFECTS: allow users to view MunchList.
    private void printMunchList() {
        System.out.print(this.munchList);
    }

    // REQUIRES: input must be one of "v","f","n","m","c"
    // EFFECTS: display menu for users to choose what category to calculate
    private String displayCategoryMenu() {
        String chosenCategory = new String();
        System.out.println("Select from:");
        System.out.println("v -> vegetable");
        System.out.println("f -> fruit");
        System.out.println("n -> nut");
        System.out.println("m -> meat");
        System.out.println("c -> carb");
        String command = input.next();
        if (command.equals("v")) {
            chosenCategory = "vegetable";
        } else if (command.equals("f")) {
            chosenCategory = "fruit";
        } else if (command.equals("n")) {
            chosenCategory = "nut";
        } else if (command.equals("m")) {
            chosenCategory = "meat";
        } else if (command.equals("c")) {
            chosenCategory = "carb";
        }
        return chosenCategory;
    }

    // REQUIRES: input cannot be ""
    // EFFECTS: display menu for users to choose what type to calculate
    private String displayTypeMenu() {
        String chosenType = new String();
        System.out.println("Input MunchItem type:");
        chosenType = input.next();
        return chosenType;
    }

    // REQUIRES: MunchList cannot be empty
    // EFFECTS: calculate the percentage of feeding in chosen category compared to overall feeding.
    private void overallAnalyze() {
        System.out.println(this.munchList.overallAnalyzeList(displayCategoryMenu()));
    }
}
