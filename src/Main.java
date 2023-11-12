package HomeWork.familyTree.homeWork22_10_23.src;

import HomeWork.familyTree.homeWork22_10_23.src.Servyce.Service;
import HomeWork.familyTree.homeWork22_10_23.src.human.Human;
import HomeWork.familyTree.homeWork22_10_23.src.tree.FamilyTree;
import HomeWork.familyTree.homeWork22_10_23.src.write.FileHandler;

import java.time.LocalDate;

    public class Main {
        public static void main(String[] args)  {

//            FamilyTree tree = loadTree();
//            System.out.println(tree.getHumanListInfo());

//            save(tree);
//            FamilyTree tree = load();
//            System.out.println(tree.getHumanListInfo());

            Service service = new Service();
            service.addHuman("Бобров"," Иван"," Иванович",LocalDate.parse("1979-03-12"),Gender.man);
            service.addHuman("Василенко"," Алексей"," Юрьевич ", LocalDate.parse("1980-10-06"),Gender.man);
            service.addHuman("Кирюшина"," Оксана"," Юрьевна ", LocalDate.parse("1980-05-20"),Gender.woman);
            service.addHuman("Кирюшин"," Николай"," Романович ", LocalDate.parse("2010-05-22"),Gender.man);
            service.addHuman("Кирюшина"," Ольга"," Романовна ",LocalDate.parse("2005-12-12"),Gender.woman);
            service.addHuman("Василенко", " Валентина", " Петровна ",LocalDate.parse("1961-06-28"),Gender.woman);
            service.addHuman("Василенко", " Юрий", " Васильевич ", LocalDate.parse("1959-09-04"),Gender.man);

            System.out.println(service);
            service.sortBySurname();
            System.out.println(service);
            service.sortByName();
            System.out.println(service);
            service.sortByAge();
            System.out.println(service);

        }

        private static FamilyTree load(){
            FileHandler fileHandler = new FileHandler();
            String filePath = "HomeWork/familyTree/homeWork22_10_23/src/write/familyTree.txt";
            return (FamilyTree) fileHandler.readObject(filePath);

        }
        private static void save(FamilyTree tree){
            FileHandler fileHandler = new FileHandler();
            String filePath = "HomeWork/familyTree/homeWork22_10_23/src/write/familyTree.txt";
            fileHandler.writeObject( tree, filePath);
        }
        public static FamilyTree loadTree() {
            FamilyTree familyTree = new FamilyTree();
            Human lexa = new Human("Василенко"," Алексей"," Юрьевич ", LocalDate.parse("1980-10-06"),Gender.man);
            Human oksana = new Human("Кирюшина"," Оксана"," Юрьевна ", LocalDate.parse("1980-05-20"),Gender.woman);
            Human kolya = new Human("Кирюшин"," Николай"," Романович ", LocalDate.parse("2010-05-22"),Gender.man);
            Human olya = new Human("Кирюшина"," Ольга"," Романовна ",LocalDate.parse("2005-12-12"),Gender.woman);
            Human valya = new Human("Василенко", " Валентина", " Петровна ",LocalDate.parse("1961-06-28"),Gender.woman);
            Human yara = new Human("Василенко", " Юрий", " Васильевич ", LocalDate.parse("1959-09-04"),Gender.man);
            familyTree.addHuman(lexa);
            familyTree.addHuman(oksana);
            familyTree.addHuman(kolya);
            familyTree.addHuman(olya);
            familyTree.addHuman(valya);
            familyTree.addHuman(yara);

            yara.setDayOfDeath(LocalDate.parse("2017-10-17"));

            oksana.addChildren(kolya);
            oksana.addChildren(olya);
            oksana.addChildren(kolya);
            oksana.addChildren(olya);
            valya.addChildren(lexa);
            yara.addChildren(lexa);

            lexa.addParent(valya);
            lexa.addParent(yara);

            lexa.addChildren(kolya);
//            System.out.println("-----------");
//            System.out.println(familyTree.getHumanListInfo());
//            System.out.println("-----------");
//            System.out.println(oksana.getChildrenInfo());
//            System.out.println("-----------");
//            System.out.println(lexa.getChildrenInfo());
//            System.out.println("-----------");
//            System.out.println(lexa.getParentInfo());
            return familyTree;
        }
    }


