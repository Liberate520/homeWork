package HomeWork.familyTree.homeWork22_10_23.src;

import HomeWork.familyTree.homeWork22_10_23.src.human.Children;
import HomeWork.familyTree.homeWork22_10_23.src.human.Human;
import HomeWork.familyTree.homeWork22_10_23.src.human.Parent;
import HomeWork.familyTree.homeWork22_10_23.src.tree.FamilyTree;

import java.time.LocalDate;
import java.util.List;



import HomeWork.familyTree.homeWork22_10_23.src.human.Children;
import HomeWork.familyTree.homeWork22_10_23.src.human.Human;
import HomeWork.familyTree.homeWork22_10_23.src.human.Parent;
import HomeWork.familyTree.homeWork22_10_23.src.tree.FamilyTree;

import java.time.LocalDate;
import java.util.List;


    public class Main {
        public static void main(String[] args) {

            FamilyTree familyTree = new FamilyTree();
            Human father = new Human("Василенко Алексей Юроевич", LocalDate.parse("1980-10-06"), null, Gender.man, Parent.father);
            Human son = new Children("Василенко Артем Алексеевич", LocalDate.parse("2005-02-12"), null, Gender.man, Baby.son);
            Human mother = new Human("Василенко Галина Сергеевна", LocalDate.parse("1983-03-20"), null, Gender.woman, Parent.mom);
            Human father2 = new Human("Василенко Артем Алексеевич", LocalDate.parse("2005-08-25"), null, Gender.man, Parent.father);
            Human daughter = new Children("Василенко Анна Алексеевна", LocalDate.parse("2010-09-03"), null, Gender.woman, Baby.daughter);
            Human father3 = new Human("Козлов Алексей Юроевич", LocalDate.parse("1980-10-06"), null, Gender.man, Parent.father);
            Human son2 = new Children("Козлов Артем Алексеевич", LocalDate.parse("2005-02-12"), null, Gender.man, Baby.son);
            Human mother2 = new Human("Гончарова Галина Сергеевна", LocalDate.parse("1983-03-20"), null, Gender.woman, Parent.mom);
            Human father4 = new Human("Сидоров Артем Алексеевич", LocalDate.parse("2005-08-25"), null, Gender.man, Parent.father);
            Human daughter2 = new Children("Иванова Анна Алексеевна", LocalDate.parse("2010-09-03"), null, Gender.woman, Baby.daughter);
            Human son3 = new Children("Козлов Артем Алексеевич", LocalDate.parse("2005-02-12"), null, Gender.man, Baby.son);
            Human mother3 = new Human("Гончаренко Галина Сергеевна", LocalDate.parse("1983-03-20"), null, Gender.woman, Parent.mom);

            familyTree.addHuman(father);
            familyTree.addHuman(son);
            familyTree.addHuman(mother);
            familyTree.addHuman(father2);
            familyTree.addHuman(mother2);
            familyTree.addHuman(daughter2);
            familyTree.addHuman(daughter);
            familyTree.addHuman(father3);
            familyTree.addHuman(son2);
            familyTree.addHuman(father4);
            familyTree.addHuman(son3);
            familyTree.addHuman(mother3);


            father.setChildrenList((Children) son);
            mother.setChildrenList((Children)daughter);
            father.setChildrenList((Children) daughter);
            mother.setChildrenList((Children)son);
            father2.setChildrenList((Children) son2);
            mother2.setChildrenList((Children)daughter2);
            father2.setChildrenList((Children) daughter2);
            mother2.setChildrenList((Children)son2);
            mother3.setChildrenList((Children)son3);
            father3.setChildrenList((Children) son3);

            son.setParentList(father);
            son.setParentList(mother);
            daughter.setParentList(father);
            daughter.setParentList(mother);
            son.setParentList(father2);
            son.setParentList(mother2);
            daughter.setParentList(father2);
            daughter.setParentList(mother2);
            son.setParentList(father3);
            son.setParentList(mother3);

            System.out.println("-----------");

            System.out.println(familyTree.getHumanListInfo());
            System.out.println("-----------");
            System.out.println(familyTree.getHumanChildrenListInfo("Василенко Галина Сергеевна"));
            System.out.println("-----------");
            System.out.println(familyTree.getHumanChildrenListInfo("Василенко Артем Алексеевич"));
            System.out.println("-----------");
            System.out.println(familyTree.getHumanChildrenListInfo("Гончарова Галина Сергеевна"));
            System.out.println("-----------");
            System.out.println("-----------");

            System.out.println(familyTree.getHumanListInfo());
            System.out.println("-----------");
            List<Human> parents = familyTree.searchForParents("Василенко Артем Алексеевич");
            if(parents!=null){
                for(Human parent:parents){
                    System.out.println(parent.getName());
                }
            } else {
                System.out.println("Родители не найдены.");
            }

            System.out.println("-----------");

            familyTree.removeHuman("Василенко Артем Алексеевич");
            System.out.println(familyTree.getHumanListInfo());

            System.out.println(familyTree.getDayOfDeadInfo("Василенко Артем Алексеевич"));
        }

    }

}
