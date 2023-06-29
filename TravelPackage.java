package travelagency;
class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
            System.out.println("Passenger added successfully.");
        } else {
            System.out.println("The travel package is already full. Cannot add more passengers.");
        }
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        System.out.println("Itinerary:");
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Activities:");
            for (Activity activity : destination.getActivities()) {
                System.out.println("- Name: " + activity.getName());
                System.out.println("  Cost: " + activity.getCost());
                System.out.println("  Capacity: " + activity.getCapacity());
                System.out.println("  Description: " + activity.getDescription());
            }
            System.out.println();
        }
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        System.out.println("Passenger List:");
        for (Passenger passenger : passengers) {
            System.out.println("- Name: " + passenger.getName());
            System.out.println("  Number: " + passenger.getNumber());
        }
    }

    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Details:");
        System.out.println("Name: " + passenger.getName());
        System.out.println("Number: " + passenger.getNumber());
        if (passenger instanceof StandardPassenger) {
            System.out.println("Balance: " + ((StandardPassenger) passenger).getBalance());
        }
        System.out.println("Activities Signed Up:");
        for (Activity activity : passenger.getActivities()) {
            System.out.println("- Destination: " + activity.getDestination().getName());
            System.out.println("  Price Paid: " + activity.getPriceForPassenger(passenger));
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Activities with Available Spaces:");
            for (Activity activity : destination.getActivities()) {
                if (!activity.isFull()) {
                    System.out.println("- Name: " + activity.getName());
                    System.out.println("  Available Spaces: " + activity.getAvailableSpaces());
                }
            }
            System.out.println();
        }
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}