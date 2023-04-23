import presenter.Presenter;
import service.Service;
import tree.FamilyTree;
import view.View;
import view.Console;


public class Main {
    public static void main(String[] args) {
        FamilyTree test = new FamilyTree();
    
        Service service = new Service(test);
    
        View view = new Console();
        Presenter presenter = new Presenter(view, service);
        view.start();
        }
}

        // Person member1 = new Person(1685, 1728, "КуницинАлексей", Gender.Male, null, null);

        // Person member2 = new Person(1693, 1748, "ЕвгаповаНадежда", Gender.Female, null, null);

        // Person member3 = new Person(1727, 1811, "ЕвгаповаНина", Gender.Male, member1, member2);

        // Person member4 = new Person(1721, 1803, "ЕвгаповаОлеся", Gender.Female, member1, member2);

        // Person member5 = new Person(1724, 1811, "ЕвгаповаАнастасия", Gender.Female, member1, member2);

        // Person member6 = new Person(1757, 1820,, "КуликовКонстантин", Gender.Male, member4, null);

        // Person member7 = new Person(1757, 1820, "КуликовИван", Gender.Male, member5, null);
        
        