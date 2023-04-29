package familyTree;

import familyTree.human.Gender;
import familyTree.saving.SaveAndLoad;
import familyTree.saving.Serial;

public class Main {
    public static void main(String[] args) {
        ServiceForTree service = new ServiceForTree("Петровы");
        SaveAndLoad saveLoad = new Serial();

        service.addToTree("Петровы","Петров Пётр Петрович", Gender.male,
                "31.03.1973", "",
                "Петрова Ольга Александровна", "Петров Пётр Иванович",
                "Петрова Анастасия Валерьевна",
                "Петров Константин Петрович");
        service.addToTree("Петровы", "Петров Константин Петрович", Gender.male,
                "04.11.1994", "",
                "Петрова Лидия Константиновна", "Петров Пётр Петрович",
                "Петрова Мария Фёдоровна",
                "");
        service.addToTree("Сидоровы", "Сидоров Максим Евгеньевич", Gender.male,
                "14.03.2013", "",
                "Сидорова Валентина Ивановна", "Сидоров Евгений Степанович",
                "Сидорова Ксения Александровна",
                "Сидорова Елена Максимовна");
        service.addToTree("Петровы", "Петрова Анастасия Валерьевна", Gender.female,
                "14.03.1975", "",
                "Иванова Мария Ивановна", "",
                "Петров Пётр Петрович",
                "Петров Константин Петрович");

        System.out.println(service.getAllInfo());

        System.out.println(service.getTree("Петровы")
                .searchHumanByFullName("Петров ... ...").getFullName());
        System.out.println(service.getTree("Петровы")
                .searchHumanByFullName("Петрова Анастасия Валерьевна").getNameParents());

        System.out.println("Сортировка по возрасту 1: ");
        service.getTree("Петровы").sortByAge();
        System.out.println("Сортировка по возрасту 2: ");
        service.getTree("Петровы").sortByAge2();
        System.out.println();
        System.out.println("Сортировка по имени: ");
        service.getTree("Петровы").sortByName();

        saveLoad.savingWork(service, "familyTree.ser");
    }
}
