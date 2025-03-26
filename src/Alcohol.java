

public class Alcohol {
    private String name;
    private String type;
    private double price;
    private double volume;
    private int quantity;

    public Alcohol(String name, String type, double price, double volume, int quantity){

        this.name = name;
        this.type = type;
        this.price = price;
        this.volume = volume;
        this.quantity = quantity;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") - $" + price + ", " + volume + "ml, Qty: " + quantity;
    }
}
