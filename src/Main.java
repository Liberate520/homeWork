import model.familyTree.FamilyTree;
import model.human.gender.Gender;
import model.human.Human;
import model.writer.FileHandler;

import java.time.LocalDate;
/*
TODO разобраться со всеми id - что где задействовано и нужно ли

 */
public class Main {
    /*
    Всё, я всё сломала(
    1. Определённо на данный момент не соблюдаю принцип единственной ответственности - он
    заявлен, но не реализован.
    2. Принцип открытости-закрытости вроде соблюдён
    3. Принцип подстановки Барбары Лисков вроде бы и негде нарушать
    4. Принцип разделения интерфейсов вроде тоже пока негда нарушать (пока не начнём создавать собачек)
    5. Принцип инверсии зависимостей вроде тоже соблюдён

     */
    public static void main(String[] args) {
        FamilyTree tree = testTree();
//        FamilyTree tree = load();
        System.out.println(tree);
//        save(tree);

        //Блок сортировки проверила, без загрузки в файл работает. С загрузкой
        //нужно понять, в каком виде пишем - оставлю пока неактивным, чтобы
        //там не мусорить. Не каждую же сортировку в файл писать, наверное?
//        tree.sortByName();
//        System.out.println(tree);
//        tree.sortByAge();
//        System.out.println(tree);
    }

    private static FamilyTree load() {
        String filePath = "src/model.writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        //мне непонятна эта форма записи: "объекту класса ФэмилиТри под названием три присвоить значение класса ФэмилиТри,
        // считанное из файла, расположенного по указанному пути"? Так? Меня смущает запись вида (FamilyTree)
        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        return tree;
    }

    private static void save(FamilyTree tree) {
        String filePath = "src/model.writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }


    static FamilyTree testTree(){

        int id = -1;
        FamilyTree familyTree = new FamilyTree();//TODO настроить формат даты
        Human adam = new Human("Адам", Gender.Male, LocalDate.of(1, 1, 1));
        Human eva = new Human("Ева", Gender.Female, LocalDate.of(1, 1, 2));
        Human olga = new Human("Ольга", Gender.Female, LocalDate.of(1997, 5, 13));
        Human vika = new Human("Вика", Gender.Female, LocalDate.of(1998, 3, 19));
        Human nadya = new Human("Надя", Gender.Female, LocalDate.of(1976, 12, 21));
        Human vaness = new Human("Ваня", Gender.Male, LocalDate.of(2014, 1, 19), nadya, adam);
        Human nina = new Human("Нина Михайловна", Gender.Female, LocalDate.of(1955, 8, 31));
        Human andrey = new Human("Андрей", Gender.Male, LocalDate.of(1977, 8, 13), eva, adam);


        familyTree.addObject(adam);
        familyTree.addObject(eva);
        familyTree.addObject(olga);
        familyTree.addObject(vika);
        familyTree.addObject(nadya);
        familyTree.addObject(vaness);
        familyTree.addObject(nina);
        familyTree.addObject(andrey);

//        andrey.setChildren(vika); //попробую иначе:
        familyTree.addChild(andrey, vika); // ЕЕЕЕ! Сработало! Сейчас на маме попробуем ещё:
        familyTree.addChild(nina, nadya); // да, "детский" блок я более-менее довела
        //Блок ниже не работает

        familyTree.addMother(olga, eva);
        System.out.println(olga.getMotherInfo());
        System.out.println(eva.getChildrenInfo());





//        model.familyTree.addChild(andrey, human4); //TODO настроить вывод только имён детей
        //TODO настроить


//        System.out.println(model.familyTree.getFamilyTree());
        return familyTree;

    }

}