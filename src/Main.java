import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Alcohol Inventory Menu ---");
            System.out.println("1. Add Alcohol Item");
            System.out.println("2. Remove Alcohol Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. View All Items");
            System.out.println("5. Search by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("ID (e.g., A001): ");
                    String id = sc.nextLine();
                    if (inventory.idExists(id)) {
                        System.out.println("ID already exists. Please use a unique ID.");
                        break;
                    }
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Type: ");
                    String type = sc.nextLine();
                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Volume (ml): ");
                    double volume = Double.parseDouble(sc.nextLine());
                    System.out.print("Quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine());

                    Alcohol newItem = new Alcohol(id, name, type, price, volume, quantity);
                    inventory.addItem(newItem);
                    System.out.println("Item added.");
                    break;

                case "2":
                    System.out.print("Enter ID to remove: ");
                    inventory.removeItem(sc.nextLine());
                    System.out.println("Item removed.");
                    break;

                case "3":
                    System.out.print("Enter ID to update quantity: ");
                    String updateId = sc.nextLine();
                    if (!inventory.idExists(updateId)) {
                        System.out.println("ID not found.");
                        break;
                    }
                    System.out.print("New quantity: ");
                    int newQuantity = Integer.parseInt(sc.nextLine());
                    inventory.updateQuantity(updateId, newQuantity);
                    System.out.println("Quantity updated.");
                    break;

                case "4":
                    inventory.listAllItems();
                    break;

                case "5":
                    System.out.print("Enter ID to search: ");
                    Alcohol found = inventory.getItem(sc.nextLine());
                    System.out.println(found != null ? found : "Item not found.");
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        }
        sc.close();

    }
}
