
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {
    Product oneP = new Product(1, "black pen", 200);
    Book oneB = new Book(123, "1984", 666, "Оруэл");
    Smartphone oneS = new Smartphone(11, "iФон", 66_666, "Джобс");

    @Test
    public void howManagerAdd() {
        // подготовка
        Repository repo = new Repository();
        Manager man = new Manager(repo);

        man.add(oneP);
        man.add(oneB);
        man.add(oneS);

        // тестируемое действие
        Product[] actual = repo.findAll();
        Product[] expected = {oneP, oneB, oneS};

        // проверка
        assertArrayEquals(expected, actual);
    }

    @Test
    public void howManagerSearchBy() {
        // подготовка
        Repository repo = new Repository();
        Manager man = new Manager(repo);

        repo.save(oneP);
        repo.save(oneB);
        repo.save(oneS);
        man.searchBy("1984");

        // тестируемое действие
        Product[] actual = man.searchBy("1984");
        Product[] expected = new Product[]{oneB};

        // проверка
        assertArrayEquals(expected, actual);
    }

    @Test
    public void howManagerMatch() {
        // подготовка
        Repository repo = new Repository();
        Manager man = new Manager(repo);

        repo.save(oneP);
        repo.save(oneB);
        repo.save(oneS);
        man.searchBy("i");

        // тестируемое действие
        Product[] actual = man.searchBy("i");
        Product[] expected = new Product[]{oneS};

        // проверка
        assertArrayEquals(expected, actual);
    }


}
