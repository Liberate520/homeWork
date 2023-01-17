package model.allcommands;

import model.treeWork.ElementTree;
import model.treeWork.FamilyTree;
import model.treeWork.Human;


import java.util.List;

public class CreateTreeHuman implements Option {

    private Human human;

    private FamilyTree<ElementTree> familyTreeHuman;
;
        
   
    public CreateTreeHuman(Human human) {
        this.human = human;
        
    }
    public CreateTreeHuman() {
        
    }

    public FamilyTree<ElementTree> getFamilyTreeHuman() {
        return familyTreeHuman;
    }

     public void creaty() {
        familyTreeHuman = new FamilyTree();

    }

    public void addHumans() {
         
        
        ElementTree<Human> h1 = new Human("Ivan", "Male", 66);
        ElementTree<Human> h2 = new Human("Ola", "FeMale", 62);
        ElementTree<Human> h3 = new Human("Sana", "Male", 44, (Human) h1, (Human) h2);
        ElementTree<Human> h4 = new Human("Kola", "Male", 45, (Human) h1, (Human) h2);
        ElementTree<Human> h5 = new Human("Tana", "FeMale", 23, (Human) h1, (Human) h2);
        ElementTree<Human> h6 = new Human("Dasha", "FeMale", 6, (Human) h3, (Human) h5);
        familyTreeHuman.addElement((Human) h1);
        familyTreeHuman.addElement((Human) h2);
        familyTreeHuman.addElement((Human) h3);
        familyTreeHuman.addElement((Human) h4);
        familyTreeHuman.addElement((Human) h5);
        familyTreeHuman.addElement((Human) h6);
        
        

    }

    public List getFam() {
        return familyTreeHuman.getFamTree();

    }




    @Override
    public void execute() {

        CreateTreeHuman work = new CreateTreeHuman();
        work.creaty();
        work.addHumans();
              
         System.out.println(work.getFam().toString());
        
    }

    @Override
    public String discription() {
        return "Создать древо Людей ";
    }
}
