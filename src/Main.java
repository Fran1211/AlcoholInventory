import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("\n--- Alcohol Inventory Menu ---");
            System.out.println("1. Add Alcohol Item");
            System.out.println("2. Remove Alcohol Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. View All Items");
            System.out.println("5. Search by Name");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            switch(choice){

                case "1":
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Type (e.g., beer, wine, liquor): ");
                    String type = sc.nextLine();
                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Volume (ml): ");
                    double volume = Double.parseDouble(sc.nextLine());
                    System.out.print("Quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine());

                    Alcohol alcohol = new Alcohol(name, type, price, volume, quantity);
                    inventory.addItem(alcohol);
                    System.out.println("Item Added");
                    break;

                case "2":
                    System.out.print("Enter the name of the item to remove: ");
                    String removeName = sc.nextLine();
                    inventory.removeItem(removeName);
                    System.out.println("Item removed (if it existed).");
                    break;

                case "3":
                    System.out.print("Enter the name of the item to update: ");
                    String updateName = sc.nextLine();
                    System.out.print("New quantity: ");
                    int newQuantity = Integer.parseInt(sc.nextLine());
                    inventory.updateQuantity(updateName, newQuantity);
                    System.out.println("Quantity updated.");
                    break;

                case "4":
                    inventory.listAllItems();
                    break;

                case "5":
                    System.out.print("Enter the name of the item to search: ");
                    String searchName = sc.nextLine();
                    Alcohol item = inventory.getItem(searchName);
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");

            }

            sc.close();






        }

    }
}
