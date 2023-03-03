package org.example.model.file;

import org.example.model.Gender;
import org.example.model.Human;
import org.example.model.Tree;
import org.example.model.add_remove_human.AddHuman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TreeHandlerTXT extends FileManipulator {

    @Override
    public void write(Tree<Human> tree) throws IOException {
        System.out.println("запись...");
        File file = new File("File.txt");
        FileWriter fW = new FileWriter(file, false);
        fW.write(String.format("starVer888Tree %s\n", tree.getNameFamily()));
        for (int i = 0; i < tree.getBigFamily().size(); i++) {
            Human hm = tree.getBigFamily().get(i);
            fW.append(String.format("HumanVer888,%s,%s,%s,%s,%s\n", hm.getName(), hm.getGender(), hm.getDateOfBirth(), hm.getDateOfDeath(), hm.getId()));
        }
        for (int i = 0; i < tree.getBigFamily().size(); i++) {
            Human hm = tree.getBigFamily().get(i);
            if (hm.getMother() == null) {
                fW.append(String.format("CommunicationsVer888,%s", hm.getMother()));
            } else {
                fW.append(String.format("CommunicationsVer888,%s", hm.getMother().getId()));
            }
            if (hm.getFather() == null) {
                fW.append(String.format(",%s", hm.getFather()));
            } else {
                fW.append(String.format(",%s", hm.getFather().getId()));
            }
            if (hm.getChildren().size() == 0) {
                fW.append(",null");
            } else {
                fW.append(",");
                for (Human human : hm.getChildren()) {
                    fW.append(human.getId());
                    fW.append(" ");
                }
            }
            if (hm.getBrothersAndSisters().size() == 0) {
                fW.append(",null");
                fW.append("\n");
            } else {
                fW.append(",");
                for (Human human : hm.getBrothersAndSisters()) {
                    fW.append(human.getId());
                    fW.append(" ");
                }
                fW.append("\n");
        }
    }
        fW.close();

}

    @Override
    public Tree<Human> read(String nameFile) throws FileNotFoundException {
        System.out.println("чтение..");
        Tree <Human> tree = new Tree<>();
        File file = new File(nameFile);
        Scanner scanner = new Scanner(file);
        int counter = 0;
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            if (new ArrayList<>(Arrays.asList(str.split(" "))).get(0).equals("starVer888Tree")){
                tree.setNameFamily(Arrays.asList(str.split(" ")).get(1));
            }else if (new ArrayList<>(Arrays.asList(str.split(","))).get(0).equals("HumanVer888")){
                ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                if (list.get(2).equals("male")){
                   new AddHuman().addHuman(list.get(1), Gender.male, localDateInStr(list.get(3)), localDateInStr(list.get(4)), list.get(5), tree);
                } else if(list.get(2).equals("female")){
                    new AddHuman().addHuman(list.get(1), Gender.female, localDateInStr(list.get(3)), localDateInStr(list.get(4)), list.get(5), tree);
                } else {
                    new AddHuman().addHuman(list.get(1), null, localDateInStr(list.get(3)), localDateInStr(list.get(4)), list.get(5), tree);
                }
            }else if (new ArrayList<>(Arrays.asList(str.split(","))).get(0).equals("CommunicationsVer888")){   ////////--------------=========++++++++
                ArrayList<String> listStr = new ArrayList<>(Arrays.asList(str.split(",")));
                if (!listStr.get(1).equals("null")){
                    String IdMami = listStr.get(1);
                    for (int i = 0; i < tree.getBigFamily().size(); i++) {
                        if (tree.getBigFamily().get(i).getId().equals(IdMami)){
                            tree.getBigFamily().get(counter).setMother(tree.getBigFamily().get(i));
                        }
                    }
                }
                if (!listStr.get(2).equals("null")){
                    String IdPapi = listStr.get(2);
                    for (int i = 0; i < tree.getBigFamily().size(); i++) {
                        if (tree.getBigFamily().get(i).getId().equals(IdPapi)){
                            tree.getBigFamily().get(counter).setFather(tree.getBigFamily().get(i));
                        }
                    }
                }
                if (!listStr.get(3).equals("null")){
                    ArrayList<String> listChId = new ArrayList<>(Arrays.asList(listStr.get(3).split(" ")));
                    for (String IdCh : listChId) {
                        for (int j = 0; j < tree.getBigFamily().size(); j++) {
                            if (tree.getBigFamily().get(j).getId().equals(IdCh)) {
                                tree.getBigFamily().get(counter).setChildren(tree.getBigFamily().get(j));
                            }
                        }
                    }
                }
                if (!listStr.get(4).equals("null")) {
                    ArrayList<String> listBroSis = new ArrayList<>(Arrays.asList(listStr.get(4).split(" ")));
                    for (String IdBrSt : listBroSis) {
                        for (int j = 0; j < tree.getBigFamily().size(); j++) {
                            if (tree.getBigFamily().get(j).getId().equals(IdBrSt)) {
                                tree.getBigFamily().get(counter).setBrothersAndSisters(tree.getBigFamily().get(j));
                            }
                        }
                    }
                }
                counter++;
            }
        }
        scanner.close();
        return tree;
    }
}
