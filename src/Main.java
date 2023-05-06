//import model.FileHandler;
import model.Datatable;
import model.TreeFamily.ServiceData;
import model.TreeFamily.ServiceTree;
import model.TreeFamily.TreeFamily;
import model.human.Human;
import presenter.Presenter;
import ui.Console;
import ui.Desktop;
import ui.View;

import java.io.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        TreeFamily<Human> tree = new TreeFamily<>();
        ServiceTree tr = new ServiceTree(tree);
        ServiceData data = new ServiceData();
        View desktopview = new Desktop();
        View consoleView = new Console();
        new Presenter(desktopview, tr, data);
        new Presenter(consoleView,tr, data);
        consoleView.start();
        desktopview.start();



        //   Human pa = new Human("Bazarov", "Alex", Human.Gender.Mail, LocalDate.parse("1949-01-07"));
 //       tr.sortByFamily();
//        for (Human human: tree){
//            System.out.println(human);
//        }
//        System.out.println();`
//
//
//        tr.sortByName();
//        for (Human human: tree) {
//            System.out.println(human);
//        }


    }


}
