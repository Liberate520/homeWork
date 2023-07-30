package GenerationTree.View;

public interface View {
    void startup();

    boolean fileExist(String name);

    void print(String text);
}
