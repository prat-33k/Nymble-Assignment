import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import travelagency.TravelPackage;
import travelagency.Destination;
import travelagency.Passenger;
import travelagency.StandardPassenger;
import travelagency.GoldPassenger;
import travelagency.PremiumPassenger;
import travelagency.Activity;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create travel package
        System.out.print("Enter travel package name: ");
        String packageName = scanner.nextLine();
        System.out.print("Enter passenger capacity: ");
        int passengerCapacity = scanner.nextInt();
        scanner.nextLine();

        TravelPackage travelPackage = new TravelPackage(packageName, passengerCapacity);

        // Create destinations
        System.out.print("Enter number of destinations: ");
        int numDestinations = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numDestinations; i++) {
            System.out.print("Enter destination name " + i + ": ");
            String destinationName = scanner.nextLine();
            Destination destination = new Destination(destinationName);

            // Create activities
            System.out.print("Enter number of activities for destination " + i + ": ");
            int numActivities = scanner.nextInt();
            scanner.nextLine();

            for (int j = 1; j <= numActivities; j++) {
                System.out.print("Enter activity name " + j + " for destination " + i + ": ");
                String activityName = scanner.nextLine();
                System.out.print("Enter activity description " + j + " for destination " + i + ": ");
                String activityDescription = scanner.nextLine();
                System.out.print("Enter activity cost " + j + " for destination " + i + ": ");
                double activityCost = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter activity capacity " + j + " for destination " + i + ": ");
                int activityCapacity = scanner.nextInt();
                scanner.nextLine();

                Activity activity = new Activity(activityName, activityDescription, activityCost, activityCapacity, destination);
                destination.addActivity(activity);
            }

            travelPackage.addDestination(destination);
        }

        // Create passengers
        System.out.print("Enter number of passengers: ");
        int numPassengers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numPassengers; i++) {
            System.out.print("Enter passenger name " + i + ": ");
            String passengerName = scanner.nextLine();
            System.out.print("Enter passenger number " + i + ": ");
            int passengerNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Select passenger type (1: Standard, 2: Gold, 3: Premium): ");
            int passengerType = scanner.nextInt();
            scanner.nextLine();

            Passenger passenger;

            switch (passengerType) {
                case 1:
                    System.out.print("Enter passenger balance " + i + ": ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();
                    passenger = new StandardPassenger(passengerName, passengerNumber, balance);
                    break;
                case 2:
                    passenger = new GoldPassenger(passengerName, passengerNumber);
                    break;
                case 3:
                    passenger = new PremiumPassenger(passengerName, passengerNumber);
                    break;
                default:
                    System.out.println("Invalid passenger type. Setting passenger as Standard.");
                    passenger = new StandardPassenger(passengerName, passengerNumber, 0.0);
                    break;
            }

            travelPackage.addPassenger(passenger);
        }

        // Perform operations based on user input
        boolean exit = false;

        while (!exit) {
            System.out.println();
            System.out.println("Select an operation:");
            System.out.println("1. Print Itinerary");
            System.out.println("2. Print Passenger List");
            System.out.println("3. Print Passenger Details");
            System.out.println("4. Print Available Activities");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    travelPackage.printItinerary();
                    break;
                case 2:
                    travelPackage.printPassengerList();
                    break;
                case 3:
                    System.out.print("Enter passenger number: ");
                    int passengerNumber = scanner.nextInt();
                    scanner.nextLine();
                    Passenger selectedPassenger = null;

                    for (Passenger passenger : travelPackage.getPassengers()) {
                        if (passenger.getNumber() == passengerNumber) {
                            selectedPassenger = passenger;
                            break;
                        }
                    }

                    if (selectedPassenger != null) {
                        travelPackage.printPassengerDetails(selectedPassenger);
                    } else {
                        System.out.println("Passenger not found.");
                    }

                    break;
                case 4:
                    travelPackage.printAvailableActivities();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
