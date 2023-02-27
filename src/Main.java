import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();//Создание семьи
        Human mihailHuman = new Human("Михаил", "qwer", Sex.Male , "1613", "1645");
        familyTree.addHuman(mihailHuman);//Создали и добавили отца
        //Human mihailHuman2 = new Human("Михаил", "qwer", Sex.Male , "1613", "1645"); //Для теста equals()
        Human katyaHuman = new Human("Екатерина", "qwer", Sex.Female , "1650", "1680");
        familyTree.addHuman(katyaHuman);//Мать
        Human alexHuman = new Human("Алексей", "qwer", Sex.Male , "1645", "1676");
        familyTree.addHuman(alexHuman, mihailHuman, katyaHuman);//Сын
        Human fyodorHuman = new Human("Фёдор", "qwer", Sex.Male , "1676", "1682");
        familyTree.addHuman(fyodorHuman, mihailHuman, katyaHuman);//Малдшый сын
        Human ivan5Human = new Human("Иван", "qwer", Sex.Male , "1682", "1696");
        familyTree.addHuman(ivan5Human,alexHuman);//Внук
        System.out.println(familyTree.getFamilyTree());

        System.out.println(familyTree.getHuman("Фёдор", "qwer"));// Поиск работает

        FileHandler FileHandler = new FileHandler();
        FileHandler.save(familyTree);//Сохраняем
        FamilyTree familyTreeNew = FileHandler.download();//Загружаем
        System.out.println(familyTreeNew.getFamilyTree());
        System.out.println(familyTreeNew.getHuman("Фёдор"));// Почему поиск не находит, получаю null? Хотя в семье он есть

    }
}
