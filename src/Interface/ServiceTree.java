package Interface;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.FamilyTree;
import model.Person;

public class ServiceTree<T extends Person>  implements Service {
    private FamilyTree<T> familyTree;
    private static FileSaveLoad db; 


    public ServiceTree( FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
        this.db = new FileSaveLoad("tree");
    }
    public ServiceTree() {
        this(new FamilyTree<T>());
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
                familyTree.add((T)(new Person("BaidenFather", "male",sdf.parse("1917-09-20"),sdf.parse("2017-09-20"), null, null)));
                familyTree.add((T)(new Person("BaidenMather", "female",sdf.parse("1919-07-20"),sdf.parse("2015-09-20"),null, null)));
                familyTree.add((T)(new Person("Baiden", "male",sdf.parse("1947-09-20"),familyTree.getByName("BaidenMather"),familyTree.getByName("BaidenFather"))));
                familyTree.add((T)(new Person("BaidenWife", "female",sdf.parse("1947-09-20"),familyTree.getByName("BaidenMather"),familyTree.getByName("BaidenFather"))));
                familyTree.add((T)(new Person("BaidenChildren2", "male",sdf.parse("1990-09-20"))));
                familyTree.add((T)(new Person("BaidenChildren1", "female",sdf.parse("1991-09-20"))));
                familyTree.add((T)(new Person("BaidenChildren3", "male",sdf.parse("1992-09-20"))));
                familyTree.add((T)(new Person("BaidenChildren4", "male",sdf.parse("1993-09-20"))));
                familyTree.add((T)(new Person("BaidenGrandFazer", "male",sdf.parse("1894-09-20"),sdf.parse("1998-09-20"), null, null)));
                familyTree.add((T)(new Person("BaidenGrandMother", "female",sdf.parse("1896-09-20"),sdf.parse("1998-09-20"), null, null)));
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
    public void addChild(Integer curPer, Integer chil, Integer delChil) {
            if (chil!=null){
                familyTree.addChild(curPer, familyTree.getByIndex(chil));
                if (familyTree.getByIndex(curPer).getSex()=="male"){
                    familyTree.setFather(chil, familyTree.getByIndex(curPer));
                }
                if (familyTree.getByIndex(curPer).getSex()=="female"){
                    familyTree.setMother(chil, familyTree.getByIndex(curPer));
                }
            }else {
                familyTree.delChild(curPer, delChil);
            } 
        }
}
