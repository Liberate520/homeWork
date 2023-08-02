import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Family_tree {
    public static void main(String[] args) throws IOException{
        Person me = new Person();
        Person myDad = new Person();
        Person myMom = new Person();
        ArrayList<Person> list = new ArrayList<>();
        FamilyList mytree = new FamilyList(list);
    
        my_File myfile = new myFile(new File("FamilyList.txt"));
        myfile.file();
        String[] params;
        params = myfile.read();
        me.buildperson(params[0], myMom, myDad, Integer.valueOf(params[1]), new ArrayList<String>());
        params = myfile.read();
        myDad.buildperson(params[0], null, null, Integer.valueOf(params[1]), new ArrayList<String>());
        params = myfile.read();
        myMom.buildperson(params[0], null, null, Integer.valueOf(params[1]), new ArrayList<String>());
            
        mytree.add(myDad);
        mytree.add(myMom);
        mytree.add(me);
        for(Person human:mytree){
            System.out.println(human.getName());
        }
        mytree.sort_by_name();
        mytree.sort_by_age();

        mytree.print();
    }
}

