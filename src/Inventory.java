import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Inventory {
    private HashMap<String, Alcohol> inventory;

    public Inventory(){
        inventory = new HashMap<>();
    }

    public void addItem(Alcohol item){
        inventory.put(item.getId(), item);
    }

    public Alcohol getItem(String id){
        return inventory.get(id);
    }
    public void removeItem(String id){
        inventory.remove(id);
    }

    public void updateQuantity(String id, int quantity){
        Alcohol alcohol = inventory.get(id);
        if(alcohol != null){
            alcohol.setQuantity(quantity);
        }
    }
    public void listAllItems(){
        if(inventory.isEmpty()){
            System.out.println("Inventory is empty");
            return;
        }
        for(Alcohol alcohol: inventory.values()){
            System.out.println(alcohol);
        }
    }
    public boolean idExists(String id) {
        return inventory.containsKey(id);
    }

    public void saveToFile(String filename){
        try(PrintWriter writer = new PrintWriter(new FileWriter("inventory.txt"))){
            for(Alcohol item: inventory.values()){
                writer.printf("%s,%s,%s,%.2f,%.2f,%d\n",
                        item.getId(),
                        item.getName(),
                        item.getType(),
                        item.getPrice(),
                        item.getVolume(),
                        item.getQuantity());
            }
            System.out.println("Inventory saved to file");
        }catch(IOException e){
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String Filename){
        try(BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 6){
                    String id = parts[0];
                    String name = parts[1];
                    String type = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    double volume = Double.parseDouble(parts[4]);
                    int quantity = Integer.parseInt(parts[5]);

                    Alcohol item = new Alcohol(id, name, type, price, volume, quantity);
                    inventory.put(id, item);
                }
            }
            System.out.println("Inventory loaded from file");

        }catch(IOException e){
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }


}
