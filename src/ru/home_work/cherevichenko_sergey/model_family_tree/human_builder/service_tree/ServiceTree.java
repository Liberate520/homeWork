package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.service_tree;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Gender;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.FamilyTree;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Human;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.file_handler.FileHandler;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// Класс верхне уровнего программирования для создания человека и сразу добавления его в древо
public class ServiceTree  implements Serializable{
    private FamilyTree<Human> tree;
    private HumanBuilder builder;
    FileHandler fileHandler  = new FileHandler();

    public ServiceTree(FamilyTree<Human> tree){
        this.tree = tree;
    }

    public ServiceTree()  {
        tree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    // Создание человека и добавление в древо
    public void addHuman(String name, String lastName, Gender gender,
                         LocalDate birthDay, LocalDate dateDeath) {
        Human human = builder.build(name, lastName, gender, birthDay, dateDeath, new ArrayList<Human>(0));
          tree.addHuman(human);

    }
    // Добавление ребенка родителям
    public String addChildForFamily(String motherName, String motherLastName, String fatherName,
                                    String fatherLastName, String nameChild, String lastNameChild) {
        Human child = null;
        boolean findChild = false;
        boolean findFather = false;
        boolean findMother = false;
        StringBuilder br = new StringBuilder();
        for (Human human : tree) {
            if (findChild==false) {
                if (human.getName().equals(nameChild) && human.getLastName().equals(lastNameChild)) {
                    child = human;
                    br.append("Ребенок найден!");
                    findChild = true;
                }
            }
        }

        if (findChild==false) {
            br.append(" Ребенка с такими именем и фамилией нет в древе! Добавить? нажмите 1");
        } else if (findChild==true) {

            for (Human human : tree) {
                if (findFather==false) {
                    if (human.getName().equals(fatherName) && human.getLastName().equals(fatherLastName)
                            && human.getChildren().contains(child)) {
                        br.append(" Этот ребенок уже добавлен отцу!");
                        findFather = true;
                    } else if (human.getName().equals(fatherName) && human.getLastName().equals(fatherLastName)) {
                        human.getChildren().add(child);
                        br.append(" Ребенок успешно добавлен отцу!");
                        findFather = true;
                    }
                }

                if (findMother==false) {
                    if (human.getName().equals(motherName) && human.getLastName().equals(motherLastName)
                            && human.getChildren().contains(child)) {
                        br.append(" Этот ребенок уже добавлен матери!");
                        findMother = true;
                    } else if (human.getName().equals(motherName) && human.getLastName().equals(motherLastName)) {
                        br.append(" Этот ребенок успешно добавлен матери!");
                        human.getChildren().add(child);
                        findMother = true;

                    }
                }
            }
        }
            if (!findChild && findFather && !findMother) br.append(" Такой матери нет!");
            else if (!findChild && findMother && !findFather) br.append(" Такого отца нет");
            else if (!findMother && !findFather && findChild) br.append(" Таких родителей нет!");
            return br.toString();
        }


    // Вся информация о древе
    public String getHumanInfo() {
        StringBuilder builder = new StringBuilder();

        for (Human h : tree) {

            if (h.getChildren().isEmpty()) {
                builder.append("имя : ").append(h.getName()).append(" фамилия: ").append(h.getLastName())
                        .append(" пол: ").append(h.getGender());
                if (h.getDateDeath() == null) {
                    builder.append(" Возраст :")
                            .append(Period.between(h.getBirthDay(), LocalDate.now()).getYears())
                            .append(" лет").append("\n");

                } else {
                    builder.append(" умер в количестве: ")
                            .append(Period.between(h.getBirthDay(), h.getDateDeath()).getYears())
                            .append(" лет").append("\n");

                }

            } else {
                builder.append("имя : ").append(h.getName()).append(" фамилия: ").append(h.getLastName())
                        .append(" пол: ").append(h.getGender());
                if (h.getDateDeath() == null) {
                    builder.append(" Возраст :")
                            .append(Period.between(h.getBirthDay(), LocalDate.now()).getYears())
                            .append(" лет").append("\n");


                } else {
                    builder.append(" умер в количестве: ")
                            .append(Period.between(h.getBirthDay(), h.getDateDeath()).getYears())
                            .append(" лет").append("\n");

                }
                if (h.getGender().equals(Gender.MALE)) {
                    builder.append("ОТЕЦ: ");
                } else {
                    builder.append("МАТЬ: ");
                }

                builder.append("имя: ")
                        .append(h.getName())
                        .append(", Фамилия: ")
                        .append(h.getLastName())
                        .append(", возраст: ");
                if (h.getDateDeath() == null) {
                    builder.append(Period.between(h.getBirthDay(), LocalDate.now()).getYears()).append(" лет");
                } else {
                    builder.append(" умер в количестве: ")
                            .append(Period.between(h.getBirthDay(), h.getDateDeath()).getYears())
                            .append(" лет");
                }
                builder.append(", пол: ").append(h.getGender()).append(",дети: ");

                if (h.getChildren().isEmpty()) {
                    builder.append(",нет детей.").append("\n");

                } else {
                    for (Human ch : h.getChildren()) {
                        builder.append("\n").append("имя: ").append(ch.getName())
                                .append(" фамилия: ").append(ch.getLastName())
                                .append(" возраст:")
                                .append(Period.between(ch.getBirthDay(), LocalDate.now()).getYears()).append(" лет");
                    }
                }
            }
            builder.append("\n").append("--------------------------------").append("\n");
        }


        return builder.toString();
    }
    // Удаление человека (если есть в списке детей тоже удалиться
    public String removeHuman(String name, String lastName) {
        StringBuilder br = new StringBuilder();
        boolean find = false;
        boolean findChild = false;
        Iterator<Human> it = tree.iterator();
          while (it.hasNext()){
              Human itr = it.next();
            if (itr.getName().equals(name) && itr.getLastName().equals(lastName)) {
                it.remove();
                find = true;
            }
        }
        Iterator<Human> itr = tree.getHumans().iterator();
        while (itr.hasNext()) {
            List<Human> child = itr.next().getChildren();
            for (int i = 0; i < child.size(); i++) {
                if (child.get(i).getName().equals(name) && child.get(i).getLastName().equals(lastName)) {
                    child.remove(child.get(i));
                    findChild = true;
                }
            }
            }
        if(find && findChild) br.append("Удален успешно из родителя и списка детей!");
        else if(find && !findChild) br.append("Удален успешно!");
        else br.append("Такого человека нет в вашем списке!");

        return br.toString();
    }
    // Поиск ребенка по имени и фамилии
    public String findChildren(String name, String lastName) {
        StringBuilder br = new StringBuilder();
        boolean find = false;

        for (Human parents : tree) {

            for (Human child : parents.getChildren()) {

                if (child.getName().equals(name) && child.getLastName().equals(lastName)) {
                    if(!find) {
                        if (child.getGender().equals(Gender.MALE))
                            br.append("НАЙДЕН:").append("\n").append("СЫН: ");
                        else br.append("ДОЧЬ: ");


                        br.append("имя: ")
                                .append(child.getName()).append(", фамилия: ")
                                .append(child.getLastName()).append(", возраст: ");
                        if(child.getDateDeath()==null)
                            br.append(Period.between(child.getBirthDay(),LocalDate.now()).getYears())
                                    .append(" лет");
                        else br.append("Умер в количестве: ")
                                .append(Period.between(child.getBirthDay(),child.getDateDeath()).getYears())
                                .append(" лет");
                        br.append("\n")
                                .append("************************").append("\n");
                    }
                    if (parents.getGender().equals(Gender.MALE))
                        br.append("ОТЕЦ: ");

                    else br.append("МАТЬ: ");

                    br.append(" имя: ").append(parents.getName()).append(", фамилия: ")
                            .append(parents.getLastName()).append(" возраст: ");
                    if(parents.getDateDeath()==null)
                        br.append(Period.between(parents.getBirthDay(),LocalDate.now()).getYears()).append(" лет");
                    else
                        br.append(" умер в возрасте: ")
                                .append(Period.between(parents.getBirthDay(),parents.getDateDeath()).getYears())
                                .append("лет");
                    br.append("\n");
                    find = true;
                }
            }
        }
        if(!find)  br.append("Ребенок с таким именем и фамилией НЕ НАЙДЕН!");

        return br.toString();
    }
    public String addParentAndChildren(String nameParent,String lastNameParent,Gender gender,LocalDate birthDay,
                                       LocalDate dateDeath,String nameChild,String lastNameChild,Gender genderChild,
                                       LocalDate birthDayChild,LocalDate dateDeadChild){
        Human human = builder.build(nameParent,lastNameParent,gender,
                birthDay,dateDeath,new ArrayList<>(0));
        Human child = builder.build(nameChild,lastNameChild,genderChild,
                birthDayChild,dateDeadChild,new ArrayList<>(0));
        tree.addHuman(human);
        tree.addHuman(child);
        if(gender.equals(Gender.MALE))
            addChildForFamily(null,null,nameParent,lastNameParent,nameChild,lastNameChild);
        else
            addChildForFamily(nameParent,lastNameParent,null,null,nameChild,lastNameChild);
        return "Ребенок и родитель успешно добавлены в древо!";
    }

    // Сортировка по имени

    public void sortTreeByName(){
         tree.sortByName();
    }
    // Сортировка по возрасту
    public void sortTreeByAge(){
        tree.sortByAge();
    }
    // Сортировка по фамилии
    public void sortTreeByLastName(){
         tree.sortByLastName();

    }
    // Сортировка по количеству детей
    public void sortTreeByCountChildren(){
        tree.sortByCountChildren();
    }
    public void save() throws Exception {
        fileHandler.save(tree);
    }
    public void read() throws Exception{
      tree =(FamilyTree<Human>) fileHandler.readable();
    }
public String toString(){
        return getHumanInfo();
}



}



