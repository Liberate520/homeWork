package service.tree.AddToTree;

import service.Persons.Gender;
import service.Persons.Human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FillHuman<T extends Human>
{
    private List<Human> list = new ArrayList<>();

    public List<Human> fillByHuman()
    {
        Human human0 = new Human("Ярослав Всеволодович", null, 0, null, null, null);
        Human human1 = new Human("Александр Невский", Gender.Male, 1263, human0, null, null);
        Human human2 = new Human("Дмитрий", Gender.Male, 1294, human1, null, null);
        Human human3 = new Human("Андрей", Gender.Male, 1304, human1, null, null);
        Human human4 = new Human("Даниил", Gender.Male, 1303, human1, null, null);
        Human human5 = new Human("Иван", Gender.Male, 1302, human2, null, null);
        Human human6 = new Human("Юрий", Gender.Male, 1325, human4, null, null);
        Human human7 = new Human("Иван Калита", Gender.Male, 1340, human4, null, null);
        Human human8 = new Human("Семен Гордый", Gender.Male, 1353, human7, null, null);
        Human human9 = new Human("Иван II Красный", Gender.Male, 1359, human7, null, null);
        Human human10 = new Human("Андрей", Gender.Male, 1353, human7, null, null);
        Human human11 = new Human("Дмитрий Донской", Gender.Male, 1389, human9, null, null);
        Human human12 = new Human("Владимир Храбрый", Gender.Male, 1410, human10, null, null);

        List<Human> listOfHuman = new ArrayList<>(Arrays.asList(human1, human2, human3, human4, human5, human6, human7, human8, human9, human10, human11, human12));
        return listOfHuman;
    }
}
