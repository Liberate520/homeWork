package view;

import presenter.ToPresenter;

public class Menu {
    private View scn = new View();
    private String userSelect = "EMPTY";
    private ToPresenter pres = new ToPresenter();
    public void start(){
        while (!userSelect.equals("q")){
            userSelect = "EMPTY";
            userSelect = scn.inputKey(TextMenu.menu);
            pres.doSomething(userSelect);
        }
        scn.scn.close();
        System.out.println("Bye");
    }
}
