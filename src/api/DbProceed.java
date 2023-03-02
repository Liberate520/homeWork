package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DbProceed implements Db
{
    private static final String EMPTY_ERROR = "Ошибка ввода!\r";
    private Integer menu;

    private FamilyTree<Person> familyTree;

    private api.FileHandler fileHandler;

    public DbProceed() throws IOException, ClassNotFoundException
    {
        fileHandler = new api.FileHandler();
        familyTree = new FamilyTree<>();
        familyTree = (api.FamilyTree)fileHandler.read();

        //initData(familyTree);
        //fileHandler.save(familyTree);

    }

    public String printTree()
    {

        String result = "";
        result = familyTree.printAll();
        return result;
    }

    public String addPerson(
            boolean isTsar,
            String name,
            String middleName,
            String surname,
            Gender gender,
            Integer yearOfBirth,
            Integer yearOfDeath,
            Integer leaderNumber,
            Integer yearOfReignStart,
            Integer yearOfReignStop,
            String spouse,
            String father,
            String mother)
    {
        String result = "";
        Person person;
        if (isTsar)
        {
            person = new Tsar(
                    name,
                    middleName,
                    surname,
                    gender,
                    yearOfBirth,
                    yearOfDeath,
                    leaderNumber,
                    yearOfReignStart,
                    yearOfReignStop);
            result = "Добавлен правитель";
        }
        else
        {
            person = new Person(
                    name,
                    middleName,
                    surname,
                    gender,
                    yearOfBirth,
                    yearOfDeath);
            result = "Добавлена персона";
        }
        familyTree.add(person);

        List<Person> personList = new ArrayList<>();

        if (!spouse.isEmpty()) {
            personList = familyTree.searchPersonByName(spouse);
            person.addSpouse(personList.get(0));
            result += ", добавлен супруг/супруга";
        }

        if (!father.isEmpty()) {
            personList = familyTree.searchPersonByName(father);
            person.setFather(personList.get(0));
            result += ", добавлен отец";
        }

        if (!mother.isEmpty()) {
            personList = familyTree.searchPersonByName(father);
            person.setMother(personList.get(0));
            result += ", добавлена мать";
        }

        return result;
    }

    public String findPerson(String name)
    {
        String result = "";
        List<Person> personList = new ArrayList<>();
        personList = familyTree.searchPersonByName(name);
        for (int i=0;i<personList.size();i++) {
            result += personList.get(i).printAll();
            result += familyTree.searchChildrenByPerson(personList.get(i));
        }
        return result;
    }

    public String saveTree() throws IOException {
        String result = fileHandler.save(familyTree);
        return result;
    }

    public String sortTreeByName() {
        String result = "Дерево отсортировано по именам";
        familyTree.sortByName();
        return result;
    }

    public String sortTreeByDate() {
        String result = "Дерево отсортировано по датам рождения";
        familyTree.sortByDateOfBirth();
        return result;
    }

    public String get(String stringToParse) throws IOException, ClassNotFoundException
    {

        String answer = "";
        if (stringToParse.equals(""))
        {
            return EMPTY_ERROR;
        }

        try
        {
            String[] args = stringToParse.split(" ");

            menu = Integer.parseInt(args[0]);
            switch(menu) {
                case 1:
                {
                    if (args.length == 1)
                    {
                        answer = "\nВведите имя, например: Михаил Федорович\n> ";
                    }
                    else
                    {
                        //answer = familyTree.searchChildrenByFathersName(args[1] + " " + args[2]);
                    }
                    break;
                }
                case 2:
                {
                    answer = familyTree.printAll();
                    break;
                }
                case 3:
                {
                    // Print using Iterator
                    for (api.Person person: familyTree)
                    {
                        answer += person.toString();
                    }
                    answer += "\n";
                    break;
                }
                case 4:
                {
                    familyTree.sortByName();
                    fileHandler.save(familyTree);

                    answer = "Отсортировано по имени!\n";
                    break;
                }
                case 5:
                {
                    familyTree.sortByDateOfBirth();
                    fileHandler.save(familyTree);

                    answer = "Отсортировано по дате рождения!\n";
                    break;
                }
                case 6:
                {
                    //fileHandler = new api.FileHandler();
                    answer = fileHandler.save(familyTree);

                    break;
                }
                case 7:
                {
                    initData(familyTree);
                    fileHandler.save(familyTree);
                    familyTree = (api.FamilyTree)fileHandler.read();

                    answer = "Восстановление!\n";

                    break;
                }
                default:
                {
                    answer = "Ошибка ввода!\n";
                }
            }

            //String info = connection.getInfo(city);
            //Weather weather = formatter.parse(info);
            //String answer = weather.toString();

            return answer;
        }
        catch (NullPointerException e)
        {
            return "Ошибка ввода!\r";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public /*static*/ void initData(FamilyTree familyTree)
    {
        /*person 01*/
        Person person01 = new Tsar(
                "Михаил",
                "Федорович",
                "Романов",
                Gender.Male,
                1596,
                1645,
                1,
                1613,
                1645);

        /*person 02*/
        Person person02 = new Tsar(
                "Алексей",
                "Михайлович",
                "Романов",
                Gender.Male,
                1629,
                1676,
                2,
                1645,
                1676);
        person02.setFather(person01);

        /*person 03*/
        Person person03 = new Person(
                "Мария",
                "Ильинишна",
                "Милославская",
                Gender.Female,
                1625,
                1669);
        person03.addSpouse(person02);

        /*person 04*/
        Person person04 = new Person(
                "Наталья",
                "Кирриловна",
                "Нарышкина",
                Gender.Female,
                1651,
                1694);
        person04.addSpouse(person02);

        /*person 05*/
        Person person05 = new Tsar(
                "Федор",
                "Алексеевич",
                "Романов",
                Gender.Male,
                1661,
                1682,
                3,
                1676,
                1682);
        person05.setFather(person02);
        person05.setMother(person03);

        /*person 06*/
        Person person06 = new Tsar(
                "Иоанн 5",
                "Алексеевич",
                "Романов",
                Gender.Male,
                1666,
                1696,
                4,
                1682,
                1696);
        person06.setFather(person02);
        person06.setMother(person03);

        /*person 07*/
        Person person07 = new Person(
                "Софья",
                "Алексеевна",
                "Романова",
                Gender.Female,
                1657,
                1704);
        person07.setFather(person02);
        person07.setMother(person03);

        /*person 08*/
        Person person08 = new Tsar(
                "Петр 1",
                "Алексеевич",
                "Романов",
                Gender.Male,
                1672,
                1725,
                5,
                1696,
                1725);
        person08.setFather(person02);
        person08.setMother(person04);

        /*person 09*/
        Person person09 = new Tsar(
                "Екатерина 1",
                "Алексеевна",
                "Михайлова",
                Gender.Female,
                1684,
                1727,
                6,
                1725,
                10727);
        person09.addSpouse(person08);

        familyTree.add(person01);
        familyTree.add(person02);
        familyTree.add(person03);
        familyTree.add(person04);
        familyTree.add(person05);
        familyTree.add(person06);
        familyTree.add(person07);
        familyTree.add(person08);
        familyTree.add(person09);

    }
}
