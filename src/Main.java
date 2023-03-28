// Не получается с детьми что-то никак и в выводе как сделать чтобы были только имена дейте не знаю

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree family = new FamilyTree();
        Human human1 = new Human("Александр Невский", Gender.Муж, 1263, null, null);
        Human human2 = new Human("Дмитрий", Gender.Муж, 1294, human1, null);
        Human human3 = new Human("Андрей", Gender.Муж, 1304, human1, null);
        Human human4 = new Human("Даниил", Gender.Муж, 1303, human1, null);
        Human human5 = new Human("Иван", Gender.Муж, 1302, human2, null);
        List<Human> humans = new ArrayList<>(Arrays.asList(human1, human2, human3, human4, human5));
        
        for (int i = 0; i < humans.size(); i++) {
            family.addMember(humans.get(i));
        }

        System.out.println(family);

    }
}
