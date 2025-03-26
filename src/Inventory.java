import java.util.HashMap;

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


}
