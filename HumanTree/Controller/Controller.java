package Controller;

import Model.HumanTreeOperation;
import View.View;

public class Controller {
    View view;
    HumanTreeOperation humanTreeOperation;

    public Controller(View view, HumanTreeOperation humanTreeOperation) {
        this.view = view;
        this.humanTreeOperation = humanTreeOperation;
    }

    public void printConsole() {
        humanTreeOperation.printConsole();
    }

    public void printFile() {
        humanTreeOperation.printFile();
    }

    public void printFirst() {
        humanTreeOperation.printFirst();
    }

    public void printFirstChild() {
        humanTreeOperation.printFirstChild();
    }

    public void printLast() {
        humanTreeOperation.printLast();
    }

    public void printLastFather() {
        humanTreeOperation.printLastFather();
    }

    public void printLastMother() {
        humanTreeOperation.printLastMother();
    }

    public void printLastSistBroth() {
        humanTreeOperation.printLastSistBroth();
    }
}
