import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepoTest {

    @Test
    public void AddProducts() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Product Book1 = new Product(134, "Мятная сказка", 524);
        Product Phone1 = new Product(224, "Honor 11S", 25000);
        Product Phone2 = new Product(413, "Honor 9S", 15000);
        Product Book2 = new Product(777, "Мастер и Маргарита", 657);
        manager.add(Book1);
        manager.add(Phone1);
        manager.add(Book2);
        manager.add(Phone2);
        Product[] exp = {Book1, Phone1, Book2, Phone2};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(exp, actual);

    }


    @Test
    public void deleteOneProductByID() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Product Book1 = new Product(134, "Мятная сказка", 524);
        Product Phone1 = new Product(224, "Honor 11S", 25000);
        Product Phone2 = new Product(413, "Honor 9S", 15000);
        Product Book2 = new Product(777, "Мастер и Маргарита", 657);
        manager.add(Book1);
        manager.add(Phone1);
        manager.add(Book2);
        manager.add(Phone2);
        repo.deleteById(224);
        Product[] exp = {Book1, Book2, Phone2};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(exp, actual);

    }

    @Test
    public void deleteALLProductsByID() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Product Book1 = new Product(134, "Мятная сказка", 524);
        Product Phone1 = new Product(224, "Honor 11S", 25000);
        Product Phone2 = new Product(413, "Honor 9S", 15000);
        Product Book2 = new Product(777, "Мастер и Маргарита", 657);
        manager.add(Book1);
        manager.add(Phone1);
        manager.add(Book2);
        manager.add(Phone2);
        repo.deleteById(134);
        repo.deleteById(224);
        repo.deleteById(413);
        repo.deleteById(777);
        Product[] exp = {};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(exp, actual);

    }

    @Test
    public void searchByCorrectName() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Product Book1 = new Product(134, "Мятная сказка", 524);
        Product Phone1 = new Product(224, "Honor 11S", 25000);
        Product Phone2 = new Product(413, "Honor 9S", 15000);
        Product Book2 = new Product(777, "Мастер и Маргарита", 657);
        manager.add(Book1);
        manager.add(Phone1);
        manager.add(Book2);
        manager.add(Phone2);
        Product[] exp = {Book2};
        Product[] actual = manager.searchBy("Мастер");
        Assertions.assertArrayEquals(exp, actual);

    }

    @Test
    public void searchByInCorrectName() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Product Book1 = new Product(134, "Мятная сказка", 524);
        Product Phone1 = new Product(224, "Honor 11S", 25000);
        Product Phone2 = new Product(413, "Honor 9S", 15000);
        Product Book2 = new Product(777, "Мастер и Маргарита", 657);
        manager.add(Book1);
        manager.add(Phone1);
        manager.add(Book2);
        manager.add(Phone2);
        Product[] exp = {};
        Product[] actual = manager.searchBy("Белка");
        Assertions.assertArrayEquals(exp, actual);

    }

    @Test
    public void searchBySeveralCorrectName() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Product Book1 = new Product(134, "Мятная сказка", 524);
        Product Phone1 = new Product(224, "Honor 11S", 25000);
        Smartphone Phone2 = new Smartphone(413, "Honor 9S", 15000, "Xiaomi");
        Book Book2 = new Book(777, "Мастер и Маргарита", 657, "Булгаков");
        manager.add(Book1);
        manager.add(Phone1);
        manager.add(Book2);
        manager.add(Phone2);
        Product[] exp = {Phone1, Phone2};
        Product[] actual = manager.searchBy("Honor");
        Assertions.assertArrayEquals(exp, actual);

    }

}