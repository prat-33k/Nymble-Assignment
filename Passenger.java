package travelagency;
abstract class Passenger {
    private String name;
    private int number;

    public Passenger(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public abstract List<Activity> getActivities();
}
