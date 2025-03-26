import java.util.HashMap;

public class Inventory {
    private HashMap<String, Alcohol> inventory;

    public Inventory(){
        inventory = new HashMap<>();
    }

    public void addItem(Alcohol item){
        inventory.put(item.getName(), item);
    }

    public Alcohol getItem(String name){
        return inventory.get(name);
    }
    public void removeItem(String name){
        inventory.remove(name);
    }

    public void updateQuantity(String name, int quantity){
        inventory.get(name).setQuantity(quantity);
    }

    public search(){
        Alcohol item = inventory.get(name);
    }


}
