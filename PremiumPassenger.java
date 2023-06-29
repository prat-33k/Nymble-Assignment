package travelagency;
class PremiumPassenger extends Passenger {
    private List<Activity> activities;

    public PremiumPassenger(String name, int number) {
        super(name, number);
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
