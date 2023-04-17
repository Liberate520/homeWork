package model.FamilyTree.AddIntoTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Persons.Gender;
import model.Persons.Human;

public class FillHuman<T extends Human> 
{
    private List<Human> list = new ArrayList<>();

    public List<Human> fillByHuman()
    {
        Human human1= new Human(1, "Иванов","Владмир", Gender.Male, LocalDate.of(1925, 10, 04), LocalDate.of(1987, 04, 01), null, null, null);
        Human human2= new Human(2, "Петров","Николай", Gender.Male, LocalDate.of(1928, 5, 10), LocalDate.of(1980, 03, 17), null, null,null);     
        Human human3= new Human(3, "Иванова","Екатерина", Gender.Female, LocalDate.of(1927, 7, 23), LocalDate.of(1984, 10, 2), null, null, null);
        Human human4= new Human(4, "Петрова", "Антонина", Gender.Female, LocalDate.of(1928,06, 11), LocalDate.of(1990, 01, 20), null,null,null);
        Human human5= new Human(5, "Михайлов","Роман",Gender.Male, LocalDate.of(1923, 10, 5), LocalDate.of(1990, 2, 4), null,null,null);
        Human human6= new Human(6,"Михайлова","Екатерина",Gender.Female, LocalDate.of(1925, 5, 8), LocalDate.of(1993, 10, 4), null,null, null);
        Human human7= new Human(7,"Матвеев","Антон",Gender.Male, LocalDate.of(1923, 5, 17), LocalDate.of(1995, 10, 9),null,null,null);
        Human human8= new Human(8,"Матвеева","Екатерина",Gender.Female,LocalDate.of(1928, 9, 28),LocalDate.of(1995, 03, 25),null,null, null);   
        Human human9 = new Human(9,"Иванов","Иван",Gender.Male,LocalDate.of(1950, 3, 25),null, human1,human3,null);
        Human human10 = new Human(10,"Петров", "Пётр",Gender.Male,LocalDate.of(1948, 11, 11), null, human2,human4,null);
        Human human11 = new Human(11,"Михайлова","Мария",Gender.Female,LocalDate.of(1953, 12, 30), null, human5,human6,null);
        Human human12 = new Human(12,"Матвеева","Елена",Gender.Female,LocalDate.of(1950, 9, 28), null,human7,human8,null);
        Human human13 = new Human(13,"Иванов","Антон",Gender.Male,LocalDate.of(1980, 5, 28) , null,human9,human11,null);
        Human human14 = new Human(14,"Петров","Кирилл",Gender.Male,LocalDate.of(1983, 11, 20),null, human10,human12,null);
        
        List<Human> listOfHuman = new ArrayList<>(Arrays.asList(human1, human2, human3, human4, human5, human6, human7, human8, human9, human10, human11, human12, human13, human14));
        return listOfHuman;
    }
}
