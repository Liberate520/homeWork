package org.example.model.communication;

import org.example.model.Gender;
import org.example.model.Human;
import org.example.model.Tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SystemModelCommunication {
    private final Tree <Human> tree;


    public SystemModelCommunication(Tree<Human> tree) {
        this.tree = tree;
    }

    public  String superPrintHumanHC(ArrayList<Human> bigFamily, int indexH) {  // Создание строки для печати
        StringBuilder string = new StringBuilder(String.format("Ф.И.О.: %s, Пол: %s, Дата рождения: %s", bigFamily.get(indexH).getName(),
                bigFamily.get(indexH).getGender(),
                bigFamily.get(indexH).getDateOfBirth()));
        string.append(", ");

        if (bigFamily.get(indexH).getDateOfDeath() == null) {
            string.append("");
        } else {
            string.append(String.format("Дата смерти: %s, ", bigFamily.get(indexH).getDateOfDeath()));
        }
        string.append(bigFamily.get(indexH).getId()).append("\n");
        if(bigFamily.get(indexH).getMother() == null){
            string.append("Мама: не определенна\n");
        }else {
            string.append(String.format("Мама: %s", bigFamily.get(indexH).getMother().getName() + "\n"));
        }
        if(bigFamily.get(indexH).getFather() == null){
            string.append("Папа: не определен\n");
        }else {
            string.append(String.format("Папа: %s", bigFamily.get(indexH).getFather().getName())).append("\n");
        }
        if (bigFamily.get(indexH).getChildren().size() > 0){
            for (int i = 0; i < bigFamily.get(indexH).getChildren().size(); i++) {
                string.append(String.format("Сын/Дочь: %s", bigFamily.get(indexH).getChildren().get(i).getName() + "\n"));
            }
        }else if(bigFamily.get(indexH).getChildren().size() == 0){
            string.append("Дети: не определенны\n");
        }
        if (bigFamily.get(indexH).getBrothersAndSisters().size() > 0){
            for (int i = 0; i < bigFamily.get(indexH).getBrothersAndSisters().size(); i++) {
                string.append(String.format("Брат/Сестра: %s", bigFamily.get(indexH).getBrothersAndSisters().get(i).getName() + "\n"));
            }

            string.append("\n\n");
        } else if (bigFamily.get(indexH).getBrothersAndSisters().size() == 0){
            string.append("Братья/Сестры: не определенны\n\n");
        }
    return string.toString();
    }

    public ArrayList<Map<String, String>> getAListPrintHuman(){
        ArrayList <Map<String, String>> printHuman = new ArrayList<>();
        for (int i = 0; i < tree.getBigFamily().size(); i++) {
            printHuman.add(new HashMap<>(Map.of(tree.getBigFamily().get(i).getName(), superPrintHumanHC(tree.getBigFamily(), i))));
        }
    return printHuman;
    }

    public void addHuman(String name){
        Human human = new Human(name, this.tree);
        tree.addHuman(human);
    }

    public void setNameHuman(String name, Integer index){
        tree.getBigFamily().get(index).setName(name);
    }
    public void  setGenderHuman(String gender, Integer integer){
        if (gender.equals("1")){
            tree.getBigFamily().get(integer).setGender(Gender.male);
        } else {
            tree.getBigFamily().get(integer).setGender(Gender.female);
        }
    }

    public void setDateBirth(String date, Integer index){
        ArrayList<String> dateL = new ArrayList<>(Arrays.asList(date.split(" ")));
        tree.getBigFamily().get(index).setDateOfBirth(LocalDate.of(Integer.parseInt(dateL.get(2)),
                Integer.parseInt(dateL.get(1)), Integer.parseInt(dateL.get(0))));
    }

    public void setDateDeath(String date, Integer index){
        ArrayList<String> dateL = new ArrayList<>(Arrays.asList(date.split(" ")));
        tree.getBigFamily().get(index).setDateOfDeath(LocalDate.of(Integer.parseInt(dateL.get(2)),
                Integer.parseInt(dateL.get(1)), Integer.parseInt(dateL.get(0))));
    }

    public void setMother(Integer indexMother, Integer indexChildren){
        tree.getBigFamily().get(indexChildren).setMother(tree.getBigFamily().get(indexMother));
        tree.getBigFamily().get(indexMother).setChildren(tree.getBigFamily().get(indexChildren));
    }

    public void setFather(Integer indexFather, Integer indexChildren){
        tree.getBigFamily().get(indexChildren).setFather(tree.getBigFamily().get(indexFather));
        tree.getBigFamily().get(indexFather).setChildren(tree.getBigFamily().get(indexChildren));
    }

    public void setChildren(Integer indexChildren, Integer indexHuman) {
        tree.getBigFamily().get(indexHuman).setChildren(tree.getBigFamily().get(indexChildren));
        if (tree.getBigFamily().get(indexHuman).getGender().equals(Gender.male)){
            tree.getBigFamily().get(indexChildren).setFather(tree.getBigFamily().get(indexHuman));
        }else {
            tree.getBigFamily().get(indexChildren).setMother(tree.getBigFamily().get(indexHuman));
        }
    }

    public void setBrothersAndSisters(Integer broAndSis, Integer indexHuman) {
        tree.getBigFamily().get(indexHuman).setBrothersAndSisters(tree.getBigFamily().get(broAndSis));
        tree.getBigFamily().get(broAndSis).setBrothersAndSisters(tree.getBigFamily().get(indexHuman));
    }

    public void removeHuman(Integer index) {
        tree.getBigFamily().remove(((int)(index)));
    }
}
