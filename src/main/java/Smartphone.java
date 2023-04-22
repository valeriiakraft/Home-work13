public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String productName, int price, String manufacturer) {
        super(id, productName, price);
        this.manufacturer = manufacturer;
    }
}
