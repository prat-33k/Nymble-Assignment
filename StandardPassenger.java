package travelagency;
class StandardPassenger extends Passenger {
    private double balance;
    private List<Activity> activities;

    public StandardPassenger(String name, int number, double balance) {
        super(name, number);
        this.balance = balance;
        this.activities = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    }
}

