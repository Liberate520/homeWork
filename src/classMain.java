
import java.util.ArrayList;

public class classMain
{
    public static void main(String[] args) 
    {   
        ArrayList<Human> people = new ArrayList<>();
        ArrayList<Human> childrens = new ArrayList<>();
        

        Human human1= new Human();
        human1.setId(1);
        human1.setFirstName("Иванов");
        human1.setLastName("Владимир");
        human1.setGender(Gender.Male);
        human1.setDataBirth(1925);
        human1.setFather(null);
        human1.setMather(null);
        human1.setChildrens(childrens);
        people.add(human1);
        // System.out.println(Human1 + "\n");

        Human human2= new Human();
        human2.setId(2);
        human2.setFirstName("Петров");
        human2.setLastName("Николай");
        human2.setGender(Gender.Male);
        human2.setDataBirth(1921);
        human2.setFather(null);
        human2.setMather(null);
        human2.setChildrens(childrens);
        people.add(human2);
        // System.out.println(Human2 + "\n");

        Human human3= new Human();
        human3.setId(3);
        human3.setFirstName("Иванова");
        human3.setLastName("Екатерина");
        human3.setGender(Gender.Female);
        human3.setDataBirth(1927);
        human3.setFather(null);
        human3.setMather(null);
        human3.setChildrens(childrens);
        people.add(human3);
        // System.out.println(Human3 + "\n");

        Human human4= new Human();
        human4.setId(4);
        human4.setFirstName("Петрова");
        human4.setLastName("Антонина");
        human4.setGender(Gender.Female);
        human4.setDataBirth(1928);
        human4.setFather(null);
        human4.setMather(null);
        human4.setChildrens(childrens);
        people.add(human4);
        // System.out.println(Human4 + "\n");

        Human human5= new Human();
        human5.setId(5);
        human5.setFirstName("Михайлов");
        human5.setLastName("Роман");
        human5.setGender(Gender.Male);
        human5.setDataBirth(1923);
        human5.setFather(null);
        human5.setMather(null);
        human5.setChildrens(childrens);
        people.add(human5);
        // System.out.println(Human5 + "\n");

        Human human6= new Human();
        human6.setId(6);
        human6.setFirstName("Иванова");
        human6.setLastName("Екатерина");
        human6.setGender(Gender.Female);
        human6.setDataBirth(1925);
        human6.setFather(null);
        human6.setMather(null);
        human6.setChildrens(childrens);
        people.add(human6);
        // System.out.println(Human6 + "\n");

        Human human7= new Human();
        human7.setId(7);
        human7.setFirstName("Матвеев");
        human7.setLastName("Антон");
        human7.setGender(Gender.Male);
        human7.setDataBirth(1923);
        human7.setFather(null);
        human7.setMather(null);
        human7.setChildrens(childrens);
        people.add(human7);
        // System.out.println(Human7 + "\n");

        Human human8= new Human();
        human8.setId(8);
        human8.setFirstName("Иванова");
        human8.setLastName("Екатерина");
        human8.setGender(Gender.Female);
        human8.setDataBirth(1928);
        human8.setFather(null);
        human8.setMather(null);
        human8.setChildrens(childrens);
        people.add(human8);
        // System.out.println(Human8 + "\n");
            


        Human human9 = new Human();
        human9.setId(9);
        human9.setFirstName("Иванов");
        human9.setLastName("Иван");
        human9.setGender(Gender.Male);
        human9.setDataBirth(1950);
        human9.setFather(human1);
        human9.setMather(human3);
        human9.setChildrens(childrens);
        people.add(human9);
        // System.out.println(Human9 + "\n");

        Human human10 = new Human();
        human10.setId(10);
        human10.setFirstName("Петров");
        human10.setLastName("Пётр");
        human10.setGender(Gender.Male);
        human10.setDataBirth(1948);
        human10.setFather(human2);
        human10.setMather(human4);
        human10.setChildrens(childrens);
        people.add(human10);
        // System.out.println(human10 + "\n");

        Human human11 = new Human();
        human11.setId(11);
        human11.setFirstName("Иванова");
        human11.setLastName("Мария");
        human11.setGender(Gender.Female);
        human11.setDataBirth(1953);
        human11.setFather(human5);
        human11.setMather(human6);
        human11.setChildrens(childrens);
        people.add(human11);
        // System.out.println(human11 + "\n");

        Human human12 = new Human();
        human12.setId(12);
        human12.setFirstName("Петрова");
        human12.setLastName("Елена");
        human12.setGender(Gender.Female);
        human12.setDataBirth(1950);
        human12.setFather(human7);
        human12.setMather(human8);
        human12.setChildrens(childrens);
        people.add(human12);
        // System.out.println(human12 + "\n");

        //   //


        Human human13 = new Human();
        human13.setId(13);
        human13.setFirstName("Иванов");
        human13.setLastName("Антон");
        human13.setGender(Gender.Male);
        human13.setDataBirth(1980);
        human13.setFather(human9);
        human13.setMather(human11);
        human13.setChildrens(childrens);
        people.add(human13);
        // System.out.println(human13 + "\n"); 

        Human human14 = new Human();
        human14.setId(14);
        human14.setFirstName("Петров");
        human14.setLastName("Кирилл");
        human14.setGender(Gender.Male);
        human14.setDataBirth(1983);
        human14.setFather(human10);
        human14.setMather(human12);
        human14.setChildrens(childrens);
        people.add(human14);
        // System.out.println(human14 + "\n");
        
        for(Human human : people)
        {    
            if(human.getFather()!= null)
            {
                if(!childrens.contains(human))
                {
                    childrens.add(human);
                    human.getFather().setChildrens(childrens);
                }
            }
    
             else if((human.getMather()!= null))
             {     
                if(!childrens.contains(human))
                {
                    childrens.add(human);
                    human.getMather().setChildrens(childrens);  
                }         
            } 
       }
        // System.out.println(childrens);
        System.out.println("Список всех людей:\n" + people);    
    }   
}