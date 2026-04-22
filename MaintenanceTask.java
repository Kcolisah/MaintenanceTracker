public class MaintenanceTask {

    private int id;
    private int mileage;
    private String item;
    private String action;
    private Status status;

    public MaintenanceTask(int id, int mileage, String item, String action, Status status) {
        this.id = id;
        this.mileage = mileage;
        this.item = item;
        this.action = action;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-10d %-20s %-25s %-15s", id, mileage, item, action, status);
    }
}