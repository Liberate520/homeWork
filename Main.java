

public class Main { 

    public static void main(String[] args) {

        FamilyTree myTree = new FamilyTree(); 

        Date birth1 = new Date(28, 04, 1960);
       
        Person person1 = new Person(Gender.Male,"Владимир","Сергеевич","Раткин",birth1);

    
        myTree.addPerson(person1);

        System.out.println(myTree);
        
    }
    
} 
