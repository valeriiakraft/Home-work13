public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }


    public void add(Product product) {
        repository.saveProducts(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.getProducts()) {
            if (matches(product, text)) {
                Product[] temp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    temp[i] = result[i];
                }
                temp[temp.length - 1] = product;
                result = temp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
