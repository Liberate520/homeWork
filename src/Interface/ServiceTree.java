package Interface;

import java.text.ParseException;
// import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.FamilyTree;
import model.Person;

public class ServiceTree  implements Service {
    private Integer menu;
    private FamilyTree familyTree;
    private static FileSaveLoad db; 


    public ServiceTree(Integer menu, FamilyTree familyTree) {
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
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public String ShowAllPerson(){
        return familyTree.ShowAllPerson();
    }
    @Override
    public void addFater(Integer curPer, Integer fatPer) {
        // TODO Auto-generated method stub
        // Iterator<Person> human = Ancestry.iterator();
        // while  (human.hasNext()){
        //     sb.append(++count+". "+human.next()+'\n');
        // }

        // return sb.toString();
        familyTree.setFather(curPer, familyTree.getByIndex(fatPer));
        System.out.println("cur---------"+ curPer+" "+ familyTree.getByIndex(curPer) );
        System.out.println("fat---------"+ fatPer+" "+ familyTree.getByIndex(fatPer) );
    }
    
}
