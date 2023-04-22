public class Repository {
    private Product[] products = new Product[0];

    public void saveProducts(Product product) {
        Product[] temp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            temp[i] = products[i];
        }
        temp[temp.length - 1] = product;
        products = temp;
    }

    public Product[] getProducts() {
        return products;
    }

    public void deleteById(int id) {
        Product[] temp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                temp[index] = product;
                index++;
            }

        }
        products = temp;
    }
}
