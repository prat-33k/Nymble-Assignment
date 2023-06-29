package travelagency;
class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private List<Passenger> passengers;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public Destination getDestination() {
        return destination;
    }

    public boolean isFull() {
        return passengers.size() >= capacity;
    }

    public int getAvailableSpaces() {
        return capacity - passengers.size();
    }

    public double getPriceForPassenger(Passenger passenger) {
        if (passenger instanceof GoldPassenger) {
            return cost * 0.9;
        } else {
            return cost;
        }
    }

    public void addPassenger(Passenger passenger) {
        if (!isFull()) {
            passengers.add(passenger);
            if (passenger instanceof StandardPassenger) {
                double price = getPriceForPassenger(passenger);
                ((StandardPassenger) passenger).deductBalance(price);
            } else if (passenger instanceof GoldPassenger) {
                getPriceForPassenger(passenger);
                ((GoldPassenger) passenger).addActivity(this);
            }
            System.out.println("Passenger added to the activity successfully.");
        } else {
            System.out.println("Activity is already full. Cannot add more passengers.");
        }
    }
}
