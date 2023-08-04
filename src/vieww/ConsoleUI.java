package vieww;

import presenterr.Presenter;

public class ConsoleUI implements View {
    private Presenter presenter;

    public ConsoleUI() {
        presenter = new Presenter(this);
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        presenter.loadTreeFromFile();
        getHumanList();
        presenter.sortByName();
        getHumanList();
        presenter.sortByBirthDate();
        getHumanList();
    }
    
    public void getHumanList(){
        presenter.getHumanList();
    }
}
