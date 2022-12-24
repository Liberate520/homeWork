package FT;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tree implements Serializable{      

    private List<Human> members;

    private Writable writable;

    public Tree() {
        this.members = new ArrayList<>();
        this.writable = new FileHandler();
    }

   @Override
   public String toString() {
       StringBuilder familyMembers = new StringBuilder();
       System.out.printf("Всего людей в дереве - %d\n", members.size());
       int count = 0;
       for (Human member : this.members) {
           count++;
           familyMembers.append("Член семьи ").append(count).append(" - ").append(member.getName()).append("\n");
       }
       return familyMembers.toString();
   }

    public void addNewMember(Human member) {
        this.members.add(member); 
        if (!(member.getFather() == null)) {
            member.getFather().getChildren().add(member); 
        }
        if (!(member.getMother() == null)) {
            member.getMother().getChildren().add(member); 
        }
        if (member.getChildren().size() > 0) {  
            for (Human child : member.getChildren()) {
                if (member.getGender().equals("M")) {
                    child.setFather(member);
                } else if (member.getGender().equals("W")) {
                    child.setMother(member);
                }
            }
        }
        System.out.printf("Добавлен новый член семьи %s\n", member.getName());
    }

    public Human getByName(String name) {
        for (Human human : this.members) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }


    public void setWritable(Writable writable) {
        this.writable = writable;
    }


    public void saveFamilyTree() {
                
        writable.save(this);

    }


    public Tree readFamilyTree() {

        if (writable != null) {
            if (writable instanceof FileHandler) {
                if (writable.read() == null) {
                    return new Tree();
                } else {
                    return (Tree) writable.read();
                }
            }
        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
        return null;
    }

}

