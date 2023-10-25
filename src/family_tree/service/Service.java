package family_tree.service;

import java.io.Serializable;
import java.time.LocalDate;

import family_tree.builder.HumanBuilder;
import family_tree.family_trees.FamilyTree;
import family_tree.human.Human;
import family_tree.human.types_enum.Gender;

public class Service implements Serializable{
    private FamilyTree ftree;
    private HumanBuilder builder;

    public Service() {
        ftree = new FamilyTree();
        builder = new HumanBuilder();
    }

    public Human addHuman(String name, LocalDate birthDay, LocalDate deadDay, Human mother, Human father, Gender gender){
        Human human = builder.build(name, birthDay, deadDay, mother, father, gender);
        ftree.addHuman(human);

        return human;
    }

    public String getFamilyTreeHumansListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");

//        Iterator<Student> iterator = group.iterator();
//        while (iterator.hasNext()){
//            Student student = iterator.next();
//            stringBuilder.append(student);
//            stringBuilder.append("\n");
//        }

        for (Human human: ftree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        ftree.sortByName();
    }

    public void sortByAge(){
        ftree.sortByAge();
    }
}
