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

    public String getItem() {
        return item;
    }

    public String getAction() {
        return action;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return id + " | " + mileage + " | " + item + " | " + action + " | " + status;
    }
}