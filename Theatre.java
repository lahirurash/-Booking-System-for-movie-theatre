
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

        public class Theatre {
            static Scanner input = new Scanner(System.in);
            static int[] row1 = new int[12]; // array for row 1 seats
            static int[] row2 = new int[16]; // array for row 2 seats
            static int[] row3 = new int[20]; // array for row 3 seats
            static ArrayList<Ticket> ticketsList = new ArrayList<>();


            public static void main(String[] args) {
                System.out.println("Welcome to the New Theatre");

                for (int i = 0; i < row1.length; i++) {
                    row1[i] = 0;
                }
                for (int i = 0; i < row2.length; i++) {
                    row2[i] = 0;
                }
                for (int i = 0; i < row3.length; i++) {
                    row3[i] = 0;
                }

                String choice;
                do {
                    System.out.println("\nPlease select an option");
                    System.out.println("1) Buy a ticket");
                    System.out.println("2) Print seating area");
                    System.out.println("3) Cancel ticket");
                    System.out.println("4) List available seats");
                    System.out.println("5) Save to file ");
                    System.out.println("6) Load from file");
                    System.out.println("7) Print ticket information and total price ");
                    System.out.println("8) Sort tickets by price");
                    System.out.println("0) Quit\n");
                    System.out.println("Enter an option :");
                    choice = input.next();
                    input.nextLine();
                    switch (choice) {
                        case "1" -> buy_ticket();
                        case "2" -> print_seating_area();
                        case "3" -> cancel_ticket();
                        case "4" -> show_available();
                        case "5" -> save();
                        case "6" -> load();
                        case "7" -> show_tickets_info();
                        case "8" -> sort_tickets();
                        case "0" -> {
                            System.exit(0);
                            System.out.println("Good bye!");
                        }
                        default -> System.out.println("invalid option please try again !!\n");
                    }
                } while (choice != "0");
            }
            public static void buy_ticket() {
                try {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter Your Name : ");
                    String name = input.nextLine();
                    System.out.print("Enter Your Surname : ");
                    String surname = input.nextLine();
                    System.out.print("Enter Your Email : ");
                    String email = input.nextLine();
                    Person person = new Person(name, surname, email);
                    System.out.println("input a row number(1 to 3) ==>");
                    int rowNumber;
                    do {
                        rowNumber = input.nextInt();
                        if (rowNumber < 1 || rowNumber > 3) {
                            System.out.println("This row number does not exist. Please select 1-3 :");
                        }
                    } while (rowNumber < 1 || rowNumber > 3);

                    int numOfSeats = 0;
                    int[] selectedRow = new int[0];

                    switch (rowNumber) {
                        case 1 -> {
                            selectedRow = row1;
                            numOfSeats = 12;
                        }
                        case 2 -> {
                            selectedRow = row2;
                            numOfSeats = 16;
                        }
                        case 3 -> {
                            selectedRow = row3;
                            numOfSeats = 20;
                        }
                        default -> {
                        }
                    }

                    System.out.println("Enter seat number ==>");
                    int seatNumber;
                    String check = "0";
                    do {
                        seatNumber = input.nextInt();
                        if (seatNumber < 1 || seatNumber > numOfSeats) {
                            System.out.println("Invalid seat number. please re enter :");

                        }
                        if (selectedRow[seatNumber - 1] == 1) {
                            System.out.println("This seat is already booked.");


                        } else {
                            // Mark the seat as occupied
                            selectedRow[seatNumber - 1] = 1;
                            check = "1";
                        }

                    } while (seatNumber < 1 || seatNumber > numOfSeats );

                    System.out.println("Enter price ==>");
                    int price = input.nextInt();
                    if (check == "1") {
                        Ticket ticketObj = new Ticket(rowNumber, seatNumber, price, person);// create an object name as
                        // ticketObj.
                        ticketsList.add(ticketObj); // add values for the array list.
                        System.out.println("successfully!");
                    } else {
                        System.out.println("try again with a different seat..");
                    }

                } catch (Exception e) {
                    System.out.println("Enter an integer !!!");
                }

            }

            public static void print_seating_area() {

                System.out.println("  \t\t\t\t\t\t\t\t *************************");
                System.out.println();
                System.out.println("  \t\t\t\t\t\t\t\t *         STAGE         *");
                System.out.println();
                System.out.println("  \t\t\t\t\t\t\t\t *************************");
                for (int i = 0; i < row1.length; i++) {
                    if (i == 0) {
                        System.out.print("\t\t\t\t\t");
                    }
                    if (i == 6) {
                        System.out.print("\t");
                    }

                    if (row1[i] == 0) {
                        System.out.print("\tO");
                    }

                    if (row1[i] == 1) {
                        System.out.print("\tX");
                    }

                }
                System.out.println();
                for (int i = 0; i < row2.length; i++) {
                    if (i == 0) {
                        System.out.print("\t\t\t");
                    }
                    if (i == 8) {
                        System.out.print("\t");
                    }
                    if (row2[i] == 0) {
                        System.out.print("\tO");
                    }
                    if (row2[i] == 1) {
                        System.out.print("\tX");
                    }
                }
                System.out.println();
                for (int i = 0; i < row3.length; i++) {
                    if (i == 0) {
                        System.out.print("\t");
                    }
                    if (i == 10) {
                        System.out.print("\t");
                    }
                    if (row3[i] == 0) {
                        System.out.print("\tO");
                    }
                    if (row3[i] == 1) {
                        System.out.print("\tX");
                    }


                }
                System.out.println();

            }

            public static void cancel_ticket() {
                try {
                    Scanner input = new Scanner(System.in);
                    // get seat details from user
                    System.out.print("Enter row number (1-3): ");
                    int rowNumber = input.nextInt();
                    System.out.print("Enter seat number: ");
                    int seatNumber = input.nextInt();
                    // check row number
                    if (rowNumber < 1 || rowNumber > 3) {
                        System.out.println("invalid row number,please try again...");
                    } else {
                        int numOfSeats5 = 0;
                        int[] selectedRow5 = new int[0];
                        switch (rowNumber) {
                            case 1 -> {
                                selectedRow5 = row1;
                                numOfSeats5 = 12;
                            }
                            case 2 -> {
                                selectedRow5 = row2;
                                numOfSeats5 = 16;
                            }
                            case 3 -> {
                                selectedRow5 = row3;
                                numOfSeats5 = 20;
                            }
                            default -> System.out.println();
                        }
                        if (seatNumber < 1 || seatNumber > numOfSeats5) {
                            System.out.println("Invalid seat number, Please try again...");
                        } else if (selectedRow5[seatNumber - 1] == 0) {
                            System.out.println("This seat is not booked, Please select correct seat...");
                        } else {
                            selectedRow5[seatNumber - 1] = 0;
                            Iterator<Ticket> iterator = ticketsList.iterator();
                            while (iterator.hasNext()) {
                                Ticket t = iterator.next();
                                if (t.getRow() == rowNumber && t.getSeat() == seatNumber) {
                                    iterator.remove();
                                    //he error "java.util.ConcurrentModificationException" is thrown because the program is trying
                                    // to modify the ticketsList while doing for-each loop iterations over it.
                                    //To fix this issue, you can either use an Iterator instead of a for-each loop or create a new
                                    // ArrayList to store the tickets to be removed and then remove them after the iteration is complete.
                                }
                            }
                            System.out.println("Ticket cancelled successfully!");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Enter an integer !!!!");
                }
            }

            static void show_available() {
                for (int i = 0; i < row1.length; i++) {
                    if (row1[i] == 0) {
                        System.out.print(i + 1 + ",");
                    }
                }
                System.out.println();

                for (int i = 0; i < row2.length; i++) {
                    if (row2[i] == 0) {
                        System.out.print(i + 1 + ",");
                    }
                }
                System.out.println();

                for (int i = 0; i < row3.length; i++) {
                    if (row3[i] == 0) {
                        System.out.print(i + 1 + ",");
                    }
                }
                System.out.println();


            }

            public static void save() {
                try {
                    FileWriter writer = new FileWriter("file.txt");

                    writer.write("row 1 : ");
                    for (int l = 0; l < row1.length; l++) {
                        writer.write(row1[l] + " ");
                    }
                    System.out.println("row 1 details saved to file.");
                    writer.write("\n");

                    writer.write("row 2 : ");
                    for (int j = 0; j < row2.length; j++) {
                        writer.write(row2[j] + " ");
                    }
                    System.out.println("row 2 details saved to file.");
                    writer.write("\n");

                    writer.write("row 3 : ");
                    for (int k = 0; k < row3.length; k++) {
                        writer.write(row3[k] + " ");
                    }
                    System.out.println("row 3 details saved to file.");
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error saving arrays to file: " + e.getMessage());
                }

                // enhanced loop is much suitable for arrays and collections.but I didn't use it
                // because error comes and I failed
                // fix it.
                // but for loop is provide opportunity to control looping process.
            }


            public static void load() {

                try {
                    File file = new File("file.txt");
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String[] split = data.split("\\s+");

                        for (int i = 3; i < split.length; i++) {
                            switch (split[1]) {
                                case "1":
                                    row1[i - 3] = Integer.parseInt(split[i]);
                                    break;
                                case "2":
                                    row2[i - 3] = Integer.parseInt(split[i]);
                                    break;
                                case "3":
                                    row3[i - 3] = Integer.parseInt(split[i]);
                                    break;
                                default:
                                    break;
                            }
                        }

                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();

                }
                System.out.println("Loading complete....");
                System.out.println("row 1 : " + Arrays.toString(row1));
                System.out.println("row 2 : " + Arrays.toString(row2));
                System.out.println("row 2 : " + Arrays.toString(row3));
            }
            public static void show_tickets_info() {
                double totalPrice = 0.0;

                for (Ticket t : ticketsList) {
                    t.print();
                    totalPrice = totalPrice + t.getPrice();
                }

                System.out.println("\nTotal Price: " + totalPrice);
            }

            // https://www.geeksforgeeks.org/how-to-sort-an-arraylist-of-objects-by-property-in-java/
            public static ArrayList<Ticket> sort_tickets() { //create an array.
                ArrayList<Ticket> sortedTickets = ticketsList;

                sortedTickets.sort((t1, t2) -> Double.compare(t1.getPrice(), t2.getPrice()));

                for (int i = 0; i < sortedTickets.size(); i++) {
                    Ticket ticket = sortedTickets.get(i); // i used normal for loop because i try to fix issue.
                    ticket.print();// this print method is from ticket.java class
                }
                return sortedTickets;
                // firstly I used method from lecture slide.but after i found some kind of another bubble sort
                //method from geeeksforgeeks.it is so easy then i used it
            }

        }
