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
        clsField();
        String sename = cmdManager.inputText("Введите фамилию семьи: ");
        presenter.setTreeService(sename);
        var treeF = true;
        while (treeF) {

        }
    }

    @Override
    public void print(String text) {
        cmdManager.PrintText(text);
    }

    private void clsField() {
        String header = "ПРОГРАММА: Генеалогическое древо семьи. Версия 0.000.00 pre-Alpha";
        cmdManager.consoleClear();
        cmdManager.PrintText(header);
        cmdManager.PrintText("=".repeat(header.length()));

    }
}