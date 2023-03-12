package Interface;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collection;

import Comparator.CompareByDateOfBirth;
import Comparator.CompareByName;
import model.FamilyTree;
import model.Person;

public class ServiceTree  implements Service {
    private Integer menu;
    private FamilyTree<Person> familyTree;
    private static FileSaveLoad db; 


    public ServiceTree(Integer menu, FamilyTree<Person> familyTree) {
        this.menu = menu;
        this.familyTree = familyTree;
        this.db = new FileSaveLoad("tree");
    }
    public ServiceTree() {
        this(-1,new FamilyTree());
    }
    
    @Override
    public void save(){
        db.SaveAs(familyTree);
    }

    @Override
    public void load() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Object temp=db.LoadAs();
        if (temp!=null) {
            familyTree=(FamilyTree)(temp);
        }else{
            try {
                familyTree.add(new Person("BaidenFather", "male",sdf.parse("1917-09-20"),sdf.parse("2017-09-20"), null, null));
                familyTree.add(new Person("BaidenMather", "female",sdf.parse("1919-07-20"),sdf.parse("2015-09-20"),null, null));
                familyTree.add(new Person("Baiden", "male",sdf.parse("1947-09-20"),familyTree.getByName("BaidenMather"),familyTree.getByName("BaidenFather")));
                familyTree.add(new Person("BaidenChildren2", "male",sdf.parse("1990-09-20")));
                familyTree.add(new Person("BaidenChildren1", "female",sdf.parse("1991-09-20")));
                familyTree.add(new Person("BaidenChildren3", "male",sdf.parse("1992-09-20")));
                familyTree.add(new Person("BaidenChildren4", "male",sdf.parse("1993-09-20")));
                familyTree.add(new Person("BaidenGrandFazer", "male",sdf.parse("1894-09-20"),sdf.parse("1998-09-20"), null, null));
                familyTree.add(new Person("BaidenGrandMother", "female",sdf.parse("1896-09-20"),sdf.parse("1998-09-20"), null, null));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public String showAllPerson(){
        return familyTree.showAllPerson();
    }

    @Override
    public void sortByDateOfBirth() {
        familyTree.CompareByDateOfBirth();
    }
    @Override
    public void sortByName() {
        System.out.println("service name "+familyTree.getClass() );
        familyTree.CompareByName();

    }

    public String showPerson(Integer cur) {
        return familyTree.showPerson(cur);
    }

    public String сhildrentoSring(Integer cur) {
        return familyTree.сhildrentoSring(cur);
    }

    @Override
    public void addFater(Integer curPer, Integer fatPer) {
        if (fatPer!=null){
            familyTree.setFather(curPer, familyTree.getByIndex(fatPer));
        }else {
            familyTree.setFather(curPer, null);
        }
    }
    
    @Override
    public void addMother(Integer curPer, Integer motPer) {
        if (motPer!=null){
            familyTree.setMother(curPer, familyTree.getByIndex(motPer));
        }else {
            familyTree.setMother(curPer, null);
        }
    }
    @Override
    public void addChild(Integer curPer, Integer chil) {
        if (chil!=null){
            familyTree.addChild(curPer, familyTree.getByIndex(chil));
        }else {
            familyTree.addChild(curPer, null);
        }
        
    }

    
}
