public class Repository {
    protected Product[] items = new Product[0];
    public void save(Product item) { // МЕТОД, позволяющий сохранять Product'ы
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }
    public Product[] findAll() { // МЕТОД, позволяющий получать все сохранённые Product'ы
        return items;
    }

    public void deleteById(int id) { // МЕТОД, похволяющий удалять по id
        int length = items.length - 1; // длина нового массива на один меньше
        Product[] tmp = new Product[length]; // тот самый новый массив
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}
