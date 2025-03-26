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
        Alcohol alcohol = inventory.get(name);
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


}
