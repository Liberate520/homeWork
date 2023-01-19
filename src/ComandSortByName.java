import java.io.IOException;

public class ComandSortByName implements Option {

    @Override
    public String dicription() {
        String sort = "Сортировка по имени";
        return sort;
    }

    @Override
    public void execute() throws IOException {
        Tree<Human> tree = new Tree<>();
        tree.sortByName();
    }
    
}
