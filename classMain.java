package homeWork;
import homeWork.src.Gender;
import homeWork.src.human;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class classMain
{
    public static void main(String[] args) 
    {   
        ArrayList<human> people = new ArrayList<>();
        Set<StringBuilder> children = new HashSet();
        Set<StringBuilder> aaa = new HashSet<>();

        human Human1= new human();
        Human1.setId(1);
        Human1.setFirstName("Иванов");
        Human1.setLastName("Владимир");
        Human1.setGender(Gender.Male);
        Human1.setDataBirth(1925);
        Human1.setFather(null);
        Human1.setMather(null);
        Human1.setChildren(children);
        people.add(Human1);
        // System.out.println(Human1 + "\n");

        human Human2= new human();
        Human2.setId(2);
        Human2.setFirstName("Петров");
        Human2.setLastName("Николай");
        Human2.setGender(Gender.Male);
        Human2.setDataBirth(1921);
        Human2.setFather(null);
        Human2.setMather(null);
        Human2.setChildren(children);
        people.add(Human2);
        // System.out.println(Human2 + "\n");

        human Human3= new human();
        Human3.setId(3);
        Human3.setFirstName("Иванова");
        Human3.setLastName("Екатерина");
        Human3.setGender(Gender.Female);
        Human3.setDataBirth(1927);
        Human3.setFather(null);
        Human3.setMather(null);
        Human3.setChildren(children);
        people.add(Human3);
        // System.out.println(Human3 + "\n");

        human Human4= new human();
        Human4.setId(4);
        Human4.setFirstName("Петрова");
        Human4.setLastName("Антонина");
        Human4.setGender(Gender.Female);
        Human4.setDataBirth(1928);
        Human4.setFather(null);
        Human4.setMather(null);
        Human4.setChildren(children);
        people.add(Human4);
        // System.out.println(Human4 + "\n");

        human Human5= new human();
        Human5.setId(5);
        Human5.setFirstName("Михайлов");
        Human5.setLastName("Роман");
        Human5.setGender(Gender.Male);
        Human5.setDataBirth(1923);
        Human5.setFather(null);
        Human5.setMather(null);
        Human5.setChildren(children);
        people.add(Human5);
        // System.out.println(Human5 + "\n");

        human Human6= new human();
        Human6.setId(6);
        Human6.setFirstName("Иванова");
        Human6.setLastName("Екатерина");
        Human6.setGender(Gender.Female);
        Human6.setDataBirth(1925);
        Human6.setFather(null);
        Human6.setMather(null);
        Human6.setChildren(children);
        people.add(Human6);
        // System.out.println(Human6 + "\n");

        human Human7= new human();
        Human7.setId(7);
        Human7.setFirstName("Матвеев");
        Human7.setLastName("Антон");
        Human7.setGender(Gender.Male);
        Human7.setDataBirth(1923);
        Human7.setFather(null);
        Human7.setMather(null);
        Human7.setChildren(children);
        people.add(Human7);
        // System.out.println(Human7 + "\n");

        human Human8= new human();
        Human8.setId(8);
        Human8.setFirstName("Иванова");
        Human8.setLastName("Екатерина");
        Human8.setGender(Gender.Female);
        Human8.setDataBirth(1928);
        Human8.setFather(null);
        Human8.setMather(null);
        Human8.setChildren(children);
        people.add(Human8);
        // System.out.println(Human8 + "\n");
            


        human Human9 = new human();
        Human9.setId(9);
        Human9.setFirstName("Иванов");
        Human9.setLastName("Иван");
        Human9.setGender(Gender.Male);
        Human9.setDataBirth(1950);
        Human9.setFather(Human1);
        Human9.setMather(Human3);
        Human9.setChildren(children);
        people.add(Human9);
        // System.out.println(Human9 + "\n");

        human Human10 = new human();
        Human10.setId(10);
        Human10.setFirstName("Петров");
        Human10.setLastName("Пётр");
        Human10.setGender(Gender.Male);
        Human10.setDataBirth(1948);
        Human10.setFather(Human2);
        Human10.setMather(Human4);
        Human10.setChildren(children);
        people.add(Human10);
        // System.out.println(Human10 + "\n");

        human Human11 = new human();
        Human11.setId(11);
        Human11.setFirstName("Иванова");
        Human11.setLastName("Мария");
        Human11.setGender(Gender.Female);
        Human11.setDataBirth(1953);
        Human11.setFather(Human5);
        Human11.setMather(Human6);
        Human11.setChildren(children);
        people.add(Human11);
        // System.out.println(Human11 + "\n");

        human Human12 = new human();
        Human12.setId(12);
        Human12.setFirstName("Петрова");
        Human12.setLastName("Елена");
        Human12.setGender(Gender.Female);
        Human12.setDataBirth(1950);
        Human12.setFather(Human7);
        Human12.setMather(Human8);
        Human12.setChildren(children);
        people.add(Human12);
        // System.out.println(Human12 + "\n");

        //   //


        human Human13 = new human();
        Human13.setId(13);
        Human13.setFirstName("Иванов");
        Human13.setLastName("Антон");
        Human13.setGender(Gender.Male);
        Human13.setDataBirth(1980);
        Human13.setFather(Human9);
        Human13.setMather(Human11);
        Human13.setChildren(children);
        people.add(Human13);
        // System.out.println(Human13 + "\n"); 

        human Human14 = new human();
        Human14.setId(14);
        Human14.setFirstName("Петров");
        Human14.setLastName("Кирилл");
        Human14.setGender(Gender.Male);
        Human14.setDataBirth(1983);
        Human14.setFather(Human10);
        Human14.setMather(Human12);
        Human14.setChildren(children);
        people.add(Human14);
        // System.out.println(Human14 + "\n");
        StringBuilder sb = new StringBuilder();
        for(human Human : people)
        {
                
            if(Human.getFather()!= null)
            {
                sb.append("[").append(Human.getFather().getId()).append(" ").append(Human.getFather().getFirstName()).append(" ").append(Human.getFather().getLastName()).append(" ").append(Human.getFather().getDataBirth()).append("] ");
                children.add(sb);
                     if(!Human.getFather().getChildren().contains(sb))
                         {
                             Human.getFather().setChildren(children);
                         }
            }
            else if((Human.getMather()!= null))
            {     
                 sb.append("[").append(Human.getMather().getId()).append(" ").append(Human.getMather().getFirstName()).append(" ").append(Human.getMather().getLastName()).append(" ").append(Human.getMather().getDataBirth()).append("] ");
                 children.add(sb);
                    if(!Human.getMather().getChildren().contains(sb))
                        {
                            Human.getMather().setChildren(children);  
                        }         
            } 
        }           
        System.out.println("Список всех людей:\n" + people);    
    }   
}