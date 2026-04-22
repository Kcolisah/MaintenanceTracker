import java.util.ArrayList;
import java.util.Scanner;

public class MaintenanceTracker {

    static ArrayList<MaintenanceTask> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==== Motorcycle Tracker ====");

            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Status");
            System.out.println("4. Edit Task");
            System.out.println("5. Delete Task");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    editTask();
                    break;
                case 5:
                    deleteTask();
                    break;
                case 6:
                    System.out.println("Exiting tracker...");
                    return;
                default:
                    System.out.println("Invalid option.");
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

        System.out.printf("%-5s %-10s %-20s %-25s %-15s%n", "ID", "Mileage", "Item", "Action", "Status");
        System.out.println("--------------------------------------------------------------------------");

        for (MaintenanceTask task : tasks) {
            System.out.println(task);
        }
    }

    static void updateTask() {

        System.out.print("Enter task ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        MaintenanceTask task = findTaskById(id);

        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        System.out.println("1. OPEN");
        System.out.println("2. IN_PROGRESS");
        System.out.println("3. DONE");
        System.out.print("Choose new status: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            task.setStatus(Status.OPEN);
            System.out.println("Status updated.");
        } else if (choice == 2) {
            task.setStatus(Status.IN_PROGRESS);
            System.out.println("Status updated.");
        } else if (choice == 3) {
            task.setStatus(Status.DONE);
            System.out.println("Status updated.");
        } else {
            System.out.println("Invalid status choice.");
        }
    }

    static void editTask() {

        System.out.print("Enter task ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        MaintenanceTask task = findTaskById(id);

        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        System.out.print("New mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New item: ");
        String item = scanner.nextLine();

        System.out.print("New action: ");
        String action = scanner.nextLine();

        task.setMileage(mileage);
        task.setItem(item);
        task.setAction(action);

        System.out.println("Task updated.");
    }

    static void deleteTask() {

        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                System.out.println("Task deleted.");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    static MaintenanceTask findTaskById(int id) {
        for (MaintenanceTask task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}