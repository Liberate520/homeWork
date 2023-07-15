package GenerationTree.ui;

import GenerationTree.Presenter.Presenter;

public class ConsoleUI implements View {

    private Presenter presenter;
    private ConsoleManager cmdManager;

    public ConsoleUI() {
        cmdManager = new ConsoleManager();
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        String sename = scan();
        presenter.setTreeService(sename);
    }

    private String scan() {
        return cmdManager.inputText("Введите фамилию семьи: ");
    }

    @Override
    public void print(String text) {
        cmdManager.PrintText(text);
    }
}