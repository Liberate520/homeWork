import java.io.IOException;

public class ComandSave implements Option {

    
    @Override
    public String dicription() {
        String save = "Сохранить ваше дерево";
        return save;
    }

    @Override
    public void execute() throws IOException {
        Tree<Human> tree = new Tree<>();
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree.getHumanlist());  
    }
    
}
