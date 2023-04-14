// public model.People.Person(String firstName, String lastName, String birthDate,
// String deathDate, model.People.Gender gender, int idMather, int idFather)

import model.Data.DataRepository;
import model.Dragons.Dragon;
import model.People.Gender;
import model.People.Person;
import model.Service;
import model.Tree.FamilyTree;
import presenter.Presenter;
import ui.Console;
import ui.View;


public class Main {
    public static void main(String[] args) {

        FamilyTree<Person> targariens = new FamilyTree();
        FamilyTree targariensThrone = new FamilyTree();
        Service service = new Service(targariensThrone);
//        Service service = new Service();
        FamilyTree<Dragon> targarienDragons = new FamilyTree<>();

        Person personA = new Person("JEHAELIS", "Targarien",
                "17.05.134", "24.12.200", Gender.male);
        Person personB = new Person("ALISANNA", "Targarien",
                "03.11.145", "20.08.233", Gender.female);
        Person personC = new Person("BELION", "Targarien",
                "24.01.158", "19.06.240", Gender.male, personB, personA);
        Person personD = new Person("ALISSA", "Targarien",
                "13.09.161", "18.04.248", Gender.female, personB, personA);
        Person personE = new Person("VIZERIS I", "Targarien",
                "22.12.179", "01.03.274", Gender.male, personD, personC);
        Person personF = new Person("DAEMON", "Targarien",
                "18.04.166", "12.08.283", Gender.male, personD, personC);
        Person personG = new Person("ALISERNTA", "Hightower",
                "12.03.179", "31.01.275", Gender.female);
        Person personH = new Person("REINIRA", "Targarien",
                "14.05.201", "08.09.294", Gender.female, personG, personE);
        Person personI = new Person("HELEINA", "Targarien",
                "07.11.203", "08.05.299", Gender.female, personG, personE);

        Dragon dragonA = new Dragon("TERRAX", "DRAGON",
                "19.08.142", "11.11.244", Gender.male);
        Dragon dragonB = new Dragon("BALERION", "DRAGON",
                "01.02.153", "12.08.301", Gender.male);
        Dragon dragonC = new Dragon("MARAXES", "Dragon",
                "24.03.161", "18.12.401", Gender.male);

        targariens.addPerson(personA);
        targariens.addPerson(personB);
        targariens.addPerson(personC);
        targariens.addPerson(personD);
        targariens.addPerson(personE);
        targariens.addPerson(personF);
        targariens.addPerson(personG);
        targariens.addPerson(personH);
        targariens.addPerson(personI);

        service.addTargarien(personA);
        service.addTargarien(personB);
        service.addTargarien(personC);
        service.addTargarien(personD);
        service.addTargarien(personE);
        service.addTargarien(personF);
        service.addTargarien(personG);
        service.addTargarien(personH);
        service.addTargarien(personI);

        targarienDragons.addPerson(dragonA);
        targarienDragons.addPerson(dragonB);
        targarienDragons.addPerson(dragonC);

        service.setWritable(new DataRepository());
        service.dataOutput();
        service.deserialization();

        View view = new Console();
        Presenter presenter = new Presenter(view, service);

        view.start();
    }
}
