package HomeWork3;
import HomeWork3.comporator.HumanComporatorByAge; // компаратор лежит в отдельной папке !

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println(" 1 семинар: создание генеалогического древа");
        System.out.println("            -------------");

        FamilyFree familyFree = new FamilyFree();
        Human alex = new Human("Александр", "муж.", 35);

        Human anne = new Human("Аннет", "жен.", 18);
        Human mary = new Human("Мария", "жен.", 17);
        Human kate = new Human("Кейт", "жен.", 15);
        alex.addChild(mary);
        alex.addChild(anne);
        alex.addChild(kate);
        System.out.println(alex);               
        
        // инфо по объектам
     /* System.out.println(mary);
        System.out.println("-----------");
        System.out.println("-----------");
        System.out.println(anne);
        System.out.println("-----------");
        System.out.println(kate); */

        //System.out.println(alex.printChildren()); // показать детей объекта    

        // Тест отношений
        Human siri = new Human("Сири", "жен.", 29);
        Human alice = new Human("Алиса", "жен.", 17);
        siri.addChild(alice);

        System.out.println(siri);
        System.out.println(alice);

        alice.setAge(27);
        Human mika = new Human("Мика", "жен.", 5);
        alice.addChild(mika);
        System.out.println(alice);

        IO save = new IO();     
        alex.saveObj(save);     
        save.load("FreeFamily.data");            // загрузка данных (вывод в консоль если успешно!)


        System.out.println("\n\t 3 семинар: реализовать метод сортировки перед выводом");
        System.out.println("\t                  -------------");
        // переопределил метод toString() для familyFree для красивого вывода
        System.out.println(familyFree); // вывод всех членов семьи

        System.out.println("\nСортировка по имени=>");
        FamilyFree.getFamilyFree().sort(null);
        //сортировка использует метод compareTo в классе Human!
        //моя сортировка по умолчанию (по имени)  
        for (Human human : FamilyFree.getFamilyFree()) 
        {
             System.out.println(human); // вывод через цикл foreach
        }
        
        System.out.println("\nСортировка по возрасту=>");
        FamilyFree.getFamilyFree().sort(new HumanComporatorByAge());
        //в данном случае я создал class HumanComporatorByAge с реализацией Comparator<Human>
        // для сортировки по возрасту и передаю компаратор как аргумент.

        for (Human human : FamilyFree.getFamilyFree()) 
        {
             System.out.println(human);
        }

        System.out.println("\n\t 3 семинар: отработка комментариев");
        System.out.println("\t         -------------");

        System.out.println(familyFree.getByName("Аннет")); // getByName
        System.out.println(familyFree.getByName("кейт"));  // equalsIgnoreCase

        Human vik = new Human("Виктор", "муж.", 27);
        //теперь родителей можно добавлять переменными либо методом getByName !
        FamilyFree.addFamilyFree(new Human("Майк", "муж.", 3, anne, familyFree.getByName("виктор"))); 
        // используя полный конструктор и метод .addFamilyFree()
        System.out.println("\n" + familyFree.getByName("майк"));
        //родители добовлются автоматически ( и дети родителям тоже ) 
        System.out.println(vik);
        System.out.println(anne);
        System.out.println(familyFree.toString());

    }   
}
