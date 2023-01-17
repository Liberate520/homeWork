package presenter;

import model.allcommands.Command;

import view.View;

public class Presenter {
    private Command command;
    private View view;

    public Presenter(Command command, View view) {
        this.view = view;
        this.command = command;
        view.setPresenter(this);
    }

    public void prinComm(){
       command.printComand();
    }
  

    public void CreatyTreeHum() {
        command.creatTreeHum();
    }

    public void prntAll() {
        command.printAll();
    }
    }

