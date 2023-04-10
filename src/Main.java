import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Human humanKrivenkoP = new Human("Павел","Кривенко","12.06.1971") ;
        Human humanKrivenkoS = new Human("Светлана","Кривенко","27.10.1973");
        Human humanKrivenkoAy = new Human("Андрей","Кривенко","19.10.1994",humanKrivenkoS,humanKrivenkoP);
        Human humanKrivenkoAt = new Human("Антон","Кривенко","23.07.2003",humanKrivenkoS,humanKrivenkoP);
        Human humanKrivenkoO = new Human("Ольга","Кривенко","06.08.1998");
        FamilyTree<Human> familyKrivenko = new FamilyTree();
        FamilyTree<Human> familyKrivenko2 = new FamilyTree();
        LoadUnloadFiles loadUnloadFiles = new LoadUnloadFiles();

        familyKrivenko.addFamilyTree(humanKrivenkoP);
        familyKrivenko.addFamilyTree(humanKrivenkoS);
        familyKrivenko.addFamilyTree(humanKrivenkoAy);
        familyKrivenko.addFamilyTree(humanKrivenkoAt);

        familyKrivenko2.addFamilyTree(humanKrivenkoAy);
        familyKrivenko2.addFamilyTree(humanKrivenkoO);

        String fileAddress = "fileTree.out";
        loadUnloadFiles.save(familyKrivenko,fileAddress);

        FamilyTree<Human> familyKrivenkoFile =  loadUnloadFiles.read(fileAddress);
        familyKrivenkoFile.sortName();

        for(Human human: familyKrivenkoFile){
            System.out.println(human);
        }

        System.out.println();
        familyKrivenkoFile.sortbDay();
        for(Human human: familyKrivenkoFile){
            System.out.println(human);
        }

        System.out.println();

        List<Human> children = humanKrivenkoAy.getMother().getChildren();
        children.remove(humanKrivenkoAy);
        System.out.println(children);



    }


}