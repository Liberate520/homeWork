package Service;

import Alive.Human;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HumanSerializer {

  public boolean humanWriter(Human human){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("human.dat")))
        {
            oos.writeObject(human);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return true;
    }
    public Human humanReader(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("human.dat")))
        {
            Human human;
           human = (Human) ois.readObject();
           return human;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return null;
    }
    public boolean humanListWriter(List<Human> humanList){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("humanList.dat")))
        {
            oos.writeObject(humanList);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return true;
    }
    public List<Human> humanListReader(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("humanList.dat")))
        {
            List<Human> humanList;
            humanList = (List<Human>) ois.readObject();
            return humanList;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return null;
    }

}
