package model.tree.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Human implements Serializable{
    private String name;
    private String patronymic;
    private String surname;
    private int dateBirth;
    private int dateDeath;

    private Human father;
    private Human mother;
    private List<Human> children = new ArrayList<>();
    private Scanner scanner;

    public Human() {
    }

    /**
     * 
     * @param name       // Input null if unknown
     * @param patronymic // Input null if unknown
     * @param surname    // Input null if unknown
     * @param dateBirth  // Input 0 if unknown
     * @param dateDeath  // Input 0 if unknown
     * @param father     // Input null if unknown
     * @param mother     // Input null if unknown
     */

    public Human(String name, String patronymic, String surname,
            int dateBirth, int dateDeath, Human father, Human mother) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.father = father;
        this.mother = mother;
    }

    public void setHuman(){
        scanner = new Scanner(System.in);

        System.out.println("Input name: ");
        name = scanner.nextLine();

        System.out.println("Input patronymic: ");
        patronymic = scanner.nextLine();

        System.out.println("Input surname: ");
        surname = scanner.nextLine();

        boolean loop = false;
        while(!loop){
            System.out.println("Input date of birth: ");
            String dateBirthString = scanner.nextLine();
            try{
                dateBirth = Integer.parseInt(dateBirthString);
                loop = true;
            }
            catch(NumberFormatException e) {
                System.out.println("Ошибка ввода Catch!");
            }
        }
        
        loop = false;
        while(!loop){
            System.out.println("Input date of death: ");
            String dateDeathString = scanner.nextLine();
            try{
                dateDeath = Integer.parseInt(dateDeathString);
                loop = true;
            }
            catch(NumberFormatException e) {
                System.out.println("Ошибка ввода Catch!");               
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (name != null)
            sb.append(name);
        if (patronymic != null)
            sb.append(" " + patronymic);
        if (surname != null)
            sb.append(" " + surname);
        if (dateBirth != 0)
            sb.append(" (" + dateBirth);
        else
            sb.append(" ( ??? ");
        if (dateDeath != 0)
            sb.append(" - " + dateDeath + ")");
        else
            sb.append(" - ??? )");

        return sb.toString();
    }

    public String getDescendants() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString() + "\nDescendants:\n");
        if (children.size() > 0) {
            for (Human human : children) {
                sb.append(human.toString() + "\n");
            }
        } else
            sb.append("Unknown!\n");
        return sb.toString();
    }

    public String getParents() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString() + "\nParents:");
        sb.append("\nFather:");
        if (father != null)
            sb.append("\n" + father.toString());
        else
            sb.append("\nUnknown!");

        sb.append("\nMother:");
        if (mother != null)
            sb.append("\n" + mother.toString());
        else
            sb.append("\nUnknown!\n");
        return sb.toString();
    }

    public void addChild(Human child){
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public int getBirthDate(){
        return dateBirth;
    }

    public Human getFather(){
        return father;
    }

    public Human getMother(){
        return mother;
    }

    public void setFather(Human f){
        father = f;
    }

    public void setMother(Human m){
        mother = m;
    }

}
