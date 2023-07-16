import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Writable{

    public void tryWriteFamilyTreeFile(String str){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FamilyTree.txt")))
        {
            oos.writeUTF(str);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

    }

    public void tryWriteHumanFile(ArrayList<Human> humanList){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("human.dat")))
        {

                oos.writeObject(humanList);

        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
    public ArrayList<Human> tryReedHumanFile(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("human.dat")))
        {
            ArrayList<Human> humanList = new ArrayList<>();
                humanList=((ArrayList<Human>) ois.readObject());

            return humanList;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
            return null;
        }
    }
}
