package familyApi;

import human.Gender;
import human.Human;
import iterAndComp.HumanComparatorByDateBirth;
import iterAndComp.HumanComparatorByName;
import save.FileHandlerOut;
import tree.Family;
import tree.FamilyTree;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Service {
        private Family family;
        private FamilyTree<Human> familyTree;
        private String pathSave = "familyTree.out";

    public Service(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }
    public String showAll(){
        StringBuilder info = new StringBuilder();
        for (Human member:this.familyTree.getMembers()
             ) {
            info.append(member.getAllInfo());
            info.append("\n");
        }
        return info.toString();

    }
    public String findByName(String name){
        Human member = familyTree.getByName(name);
        if(member != null) {
            return member.getAllInfo();
        }else {
            return "Такого члена семьи нет";
        }
    }
    public void addMember(String name, String gender, String dateBirth, String nameMother, String nameFather) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateBirth1;
        try{
            dateBirth1 = df.parse(dateBirth);
            switch (gender) {
                case "Male":
                    Human memberM = new Human(name, Gender.Male, dateBirth1);
                    familyTree.addMother(memberM, nameMother);
                    familyTree.addFather(memberM, nameFather);
                    familyTree.addMembers(memberM);

                    break;
                case "Female":
                    Human memberW = new Human(name, Gender.Female, dateBirth1);
                    familyTree.addMother(memberW, nameMother);
                    familyTree.addFather(memberW, nameFather);
                    familyTree.addMembers(memberW);

                    break;
                default:
                    System.out.println("Неправильно введен пол");
                    break;
            }
        } catch (ParseException e){
            e.printStackTrace();
        }
    }
    public void saveChanges(){
        FileHandlerOut fileHandlerOut = new FileHandlerOut();
        fileHandlerOut.save(familyTree, pathSave);
    }


    public Service(Family family) {
            this.family = family;
        }

        public void sortByName(){
           familyTree.getMembers().sort(new HumanComparatorByName());
        }

        public void sortByDateBirth(){
            familyTree.getMembers().sort(new HumanComparatorByDateBirth());
        }
    }

