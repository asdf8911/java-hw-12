import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Product oneP = new Product(1, "black pen", 200);
    Book oneB = new Book(123, "1984", 666, "Оруэл");
    Smartphone oneS = new Smartphone(11, "iФон", 66_666, "Джобс");
    Book twoB = new Book(124, "Скотный двор", 444, "Оруэл");

    @Test
    public void howRepoDeleteById() {
        // подготовка
        Repository repo = new Repository();
        repo.save(oneP);
        repo.save(oneB);
        repo.save(oneS);

        repo.deleteById(11);

        Product[] actual = repo.findAll();
        Product[] expected = {oneP, oneB};

        // проверка
        Assertions.assertArrayEquals(expected, actual);
    }

}