package ThreeFamily;
import Human.Human;
import java.io.*;
import java.util.ArrayList;

public class TreeFamily implements IThree {

    private ArrayList<Human> treeFamily = new ArrayList<>();
    public ArrayList<Human> getTreeFamily() {
        return treeFamily;
    }
    public void setTreeFamily(ArrayList<Human> treeFamily) {
        this.treeFamily = treeFamily;
    }
    @Override
    public void addTreeFamily(Human human){
        treeFamily.add(human);
    }
    @Override
    public void addChildren(Human baby, Human father, Human mother) {
        baby.setParent1(father);
        baby.setParent2(mother);
        father.addChildren(baby);
        mother.addChildren(baby);
    }
    @Override
    public void LoopHuman(String name) {
        ArrayList<Human> tList = getTreeFamily();
        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).getName() == name) {
                System.out.println(tList.get(i));
            }
            else {
                System.out.println("Такого не существует");
            }
        }
    }
    @Override
    public Human searchHuman(String name) {
        Human human = new Human(null,0);
        ArrayList<Human> tList = getTreeFamily();
        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).getName() == name) {
                human = tList.get(i);
            }
        }
        return human;
    }
    @Override
    public void allHuman(){
        ArrayList<Human> tList = getTreeFamily();
        for (int i = 0; i < tList.size(); i++) {
            System.out.println(tList.get(i));
        }
    }
    private void readeFile() {
        try {
            File file = new File("src/file.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            line.split(";");
            while (line != null) {
                line = reader.readLine().strip();
                line.split(";");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

