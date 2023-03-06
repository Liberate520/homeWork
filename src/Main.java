import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree= new FamilyTree();
        
        Human andrey =new Human("Andrey","Sergeevich", "1982", Gender.муж);
        Human olga =new Human("Olga", "Olegovna","1961", Gender.жен);
        Human anny= new Human("Anny", "Sergeevna", "2003", null, Gender.жен, 
                    null, null,null );
        Human anna= new Human("Anna", "Andreevna", "1980", "2022", Gender.жен, 
                        andrey, olga, anny);
        familyTree.add(andrey);
        familyTree.add(olga);
        familyTree.add(anny);
        familyTree.add(anna);


System.out.println(familyTree.getInfo());

IO save = new IO();      
        andrey.saveObj(save);     
        save.load("Family.txt"); 


    }
}