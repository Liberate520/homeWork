import human.Gender;
import human.Human;
import tree.FamilyTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileHandler implements Writeable{
    public FamilyTree load(FamilyTree familyTree, String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String str;
        while ((str = br.readLine()) != null) {
            String[] array = str.split(",");
            if (array[1].equals("Male")) {
                Human human = new Human(array[0], Gender.Male, new Date());
                familyTree.addMembers(human);

            } else {
                Human human = new Human(array[0], Gender.Female, new Date());
                familyTree.addMembers(human);
            }
        }

        BufferedReader br1 = new BufferedReader(new FileReader(path));
        String str1;
        while ((str1 = br1.readLine()) != null){
            String[] array = str1.split(",");
            if(!array[2].equals("null")) {

                familyTree.getByName(array[0]).setMother(familyTree.getByName(array[2]));
            }
        }
        BufferedReader br2 = new BufferedReader(new FileReader(path));
        String str2;
        while ((str2 = br2.readLine()) != null){
            String[] array = str2.split(",");
            if(!array[3].equals("null")) {
                familyTree.getByName(array[0]).setFather(familyTree.getByName(array[3]));
            }
        }
        for (Human child: familyTree.getMembers()
        ) {
            if (child.getMother() != null ) {
                for (Human parent: familyTree.getMembers()
                ) {
                    if (child.getMother().getName().equals(parent.getName()) ){
                        parent.addChild(child);
                    }
                }
            }
            if (child.getFather() != null ) {
                for (Human parent: familyTree.getMembers()
                ) {
                    if (child.getFather().getName().equals(parent.getName()) ){
                        parent.addChild(child);
                    }
                }
            }


        }
        return familyTree;
    }
    public void saveHuman(Human human, String path) {
        try(FileWriter fw = new FileWriter(path, true)) {
            fw.write(human.toString());
            fw.append('\n');
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
