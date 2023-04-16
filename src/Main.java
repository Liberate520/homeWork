import presenter.Presenter;
import service.Service;
import service.human.Human;
import view.Console;
import view.View;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new Console();
        Service service = new Service();
        Presenter p =new Presenter(view,service);
        view.setPresenter(p);
        view.start();
    }
}

//      Human member1 = new Person (1685, 1728, "ИванПетровичТолстой", Gender.Male,null, null);
//         Person  member2 = new Person (1693, 1748, "ПрасковьяМихайловнаРтищева",
//         Gender.Female, null, null);
//         Person  member3 = new Person (1727, 1811, "АлександраИвановнаЩетинина",
//         Gender.Female, member1, member2);
//         Person  member4 = new Person (1721, 1803, "АндрейИвановичТолстой",
//         Gender.Male, member1, member2);
//         Person  member5 = new Person (1724, 1811, "НиколайИвановичГорчаков",
//         Gender.Male, member1, member2);
//         Person  member6 = new Person (1757, 1820, "ПрасковьяВасильевнаТолстая",
//         Gender.Female, null, null);
//         Person  member7 = new Person (1757, 1820, "ИльяАндреевичТолстой",
//         Gender.Male, member4, null);
//         Person  member8 = new Person (1757, 1820, "ПолагеяНиколаевнаГорчакова",
//         Gender.Female, member5, null);
////familyTolstoy.addAllMember(family);