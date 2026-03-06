import java.util.ArrayList;
import java.util.Scanner;

public class MaintenanceTracker {

    static ArrayList<MaintenanceTask> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==== Ninja 650 Maintenance Tracker ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Status");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addTask();
            } else if (choice == 2) {
                viewTasks();
            } else if (choice == 3) {
                updateTask();
            } else if (choice == 4) {
                deleteTask();
            } else if (choice == 5) {
                break;
            }
        }
    }

    static void addTask() {

        System.out.print("Mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Item: ");
        String item = scanner.nextLine();

        System.out.print("Action: ");
        String action = scanner.nextLine();

        MaintenanceTask task = new MaintenanceTask(nextId, mileage, item, action, Status.OPEN);
        tasks.add(task);
        nextId++;

        System.out.println("Task added.");
    }

    static void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }

        System.out.println("ID | Mileage | Item | Action | Status");

        for (MaintenanceTask task : tasks) {
            System.out.println(task);
        }
    }

    static void updateTask() {

        System.out.print("Enter task ID: ");
        int id = scanner.nextInt();

        for (MaintenanceTask task : tasks) {
            if (task.getId() == id) {

                System.out.println("1 OPEN");
                System.out.println("2 IN_PROGRESS");
                System.out.println("3 DONE");

                int choice = scanner.nextInt();

                if (choice == 1) task.setStatus(Status.OPEN);
                if (choice == 2) task.setStatus(Status.IN_PROGRESS);
                if (choice == 3) task.setStatus(Status.DONE);

                System.out.println("Status updated.");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    static void deleteTask() {

        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();

        for (MaintenanceTask task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                System.out.println("Task deleted.");
                return;
            }
        }

        System.out.println("Task not found.");
    }
}