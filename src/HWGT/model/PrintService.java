package HWGT.model;

public class PrintService {
    private FamilyTree familyTree;
    public PrintService(FamilyTree familyTree){
        this.familyTree = familyTree;
    }
    public void printTree (FamilyTree familyTree){
        for (Object pers:familyTree){
            System.out.println(pers);
        }
    }
}
