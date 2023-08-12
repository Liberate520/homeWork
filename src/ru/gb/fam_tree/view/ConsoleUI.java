package ru.gb.fam_tree.view;

import ru.gb.fam_tree.model.family_tree.all_tree_items.human.Gender;
import ru.gb.fam_tree.model.family_tree.all_tree_items.human.Human;
import ru.gb.fam_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "You entered an incorrect value";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private boolean flag;
    public boolean flag2;
    private MainMenu menu;
    private EditMenu editMenu;

    public ConsoleUI(){
        editMenu = new EditMenu(this);
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        flag = true;;
        flag2 = false;
        menu = new MainMenu(this);
        editMenu = new EditMenu(this);
    }


    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish(){
        System.out.println("We will always be glad to see you back.");
        work = false;
    }

    public void addHuman(){
        boolean flag1 = true;
        boolean flag2 = true;
        Gender gender = null;
        LocalDate birthDate = null;

        System.out.println("Enter firstname:");
        String name = scanner.nextLine();
        while (flag1){
            String genf = "f";
            String genm = "m";
            System.out.println("Enter gender(f - female; m - male):");
            String gend = scanner.nextLine();
            if(gend.equals(genf)){
                gender = Gender.Female;
                flag1 = false;
            } else if (gend.equals(genm)) {
                gender = Gender.Male;
                flag1 = false;
            } else {
                System.out.println(INPUT_ERROR);
            }
        }
        while (flag2) {
            System.out.println("Enter birthdate(dd-mm-yyyy):");
            String bdate = scanner.nextLine();
            try {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                birthDate = LocalDate.parse(bdate, dateTimeFormatter);
                flag2 = false;
            }
            catch(DateTimeParseException e){
                System.out.println(INPUT_ERROR);
            }
        }
        Human human = new Human(name, gender, birthDate);
        presenter.addHuman(human);
    }

    public void getHumansInfo(){
        presenter.getHumansInfo();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    private void hello(){
        System.out.println("Welcome!");
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
            if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand < (menu.getSize()+1)){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void loadFromFile(){
        System.out.println("Enter file path: ");
        String path = scanner.nextLine();
        presenter.LoadFromFile(path);
    }

    public void saveToFile(){
        System.out.println("Enter file path: ");
        String path = scanner.nextLine();
        presenter.SaveToFile(path);
    }

    public void editHuman(){
        while (flag){
            long id = getId();
            printEditMenu();
            editMenuExecute(id);
        }
    }

    public void printEditMenu(){
        System.out.println(editMenu.menu());
    }

    public void editMenuExecute(long id){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommandEditMenu(numCommand)){
                editMenu.execute(numCommand, id);
            }
        }
    }

    public long getId(){
        flag2 = true;
        long id = -1;
        while (flag2){
            presenter.getHumansInfo();
            System.out.println("Enter the id of the person you want to edit:");
            String line = scanner.nextLine();
            if (checkTextForInt(line)){
                id = Long.parseLong(line);
                if(id < getLastId() && id > -1){
                    flag2 = false;

                }
                else{
                    System.out.println(INPUT_ERROR);
                }
            }
        }
        return id;
    }

    public long getLastId(){
        return presenter.getLastid();
    }

    public void ChangeName(long id){
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        presenter.setName(id, name);
    }

    public void setGender(long id){
        boolean genderFlag = true;
        Gender gender= null;
        String genf = "f";
        String genm = "m";
        while (genderFlag){
            System.out.println("Enter gender(f-female/ m- male):");
            String gend = scanner.nextLine();
            if(gend.equals(genf)){
                gender = Gender.Female;
                genderFlag = false;
                presenter.setGender(id, gender);
            } else if (gend.equals(genm)) {
                gender = Gender.Male;
                genderFlag = false;
                presenter.setGender(id, gender);
            } else {
                System.out.println(INPUT_ERROR);
            }
        }

    }

    public void setBirthDate(long id){
        LocalDate birthDate = null;
        boolean bdateflag = true;
        while (bdateflag) {
            System.out.println("Enter birthdate(dd-mm-yyyy):");
            String bdate = scanner.nextLine();
            try {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                birthDate = LocalDate.parse(bdate, dateTimeFormatter);
                bdateflag = false;
            } catch (DateTimeParseException e) {
                System.out.println(INPUT_ERROR);
            }
        }
        presenter.setBirthDate(id, birthDate);
    }

    public void setDeathDate(long id){
        LocalDate deathDate = null;
        boolean ddateflag = true;
        while (ddateflag) {
            System.out.println("Enter death date(dd-mm-yyyy):");
            String ddate = scanner.nextLine();
            try {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                deathDate = LocalDate.parse(ddate, dateTimeFormatter);
                if (presenter.getBirthDate(id).isBefore(deathDate)) {
                    ddateflag = false;
                }
            } catch (DateTimeParseException e) {
                System.out.println(INPUT_ERROR);
            }
        }
        presenter.setDeathDate(id, deathDate);
    }

    public Gender getGender(long id){
        return presenter.getGender(id);
    }

    public Human getMother(long id){
        return presenter.getMother(id);
    }

    public void setMother(long idChild){
        boolean motherFlag = true;
        long idMother = -1;
        while (motherFlag) {
            System.out.println("Enter mother's ID:");
            String line = scanner.nextLine();
            if (checkTextForInt(line)) {
                idMother = Long.parseLong(line);
                if (idMother < getLastId() && idMother > -1) {
                    if (getGender(idMother) == Gender.Female && getMother(idChild) == null) {
                        presenter.setMother(idChild, idMother);
                        motherFlag = false;
                    } else{
                            System.out.println(INPUT_ERROR);
                    }
                } else {
                    System.out.println(INPUT_ERROR);
                }
            }else {
                System.out.println(INPUT_ERROR);
            }
        }
    }

    public Human getFather(long id){
        return presenter.getFather(id);
    }

    public void setFather(long idChild){
        boolean fatherFlag = true;
        long idFather = -1;
        while (fatherFlag) {
            System.out.println("Enter father's ID:");
            String line = scanner.nextLine();
            if (checkTextForInt(line)) {
                idFather = Long.parseLong(line);
                if (idFather < getLastId() && idFather > -1) {
                    if (getGender(idFather) == Gender.Male && getFather(idChild) == null) {
                        presenter.setFather(idChild, idFather);
                        fatherFlag = false;
                    } else{
                        System.out.println(INPUT_ERROR);
                    }
                } else {
                    System.out.println(INPUT_ERROR);
                }
            }else {
                System.out.println(INPUT_ERROR);
            }
        }
    }

    public void setChild(long idParent){
        boolean childFlag = true;
        long idChild = -1;
        while (childFlag) {
            System.out.println("Enter child's ID:");
            String line = scanner.nextLine();
            if (checkTextForInt(line)) {
                idChild = Long.parseLong(line);
                if (idChild < getLastId() && idChild > -1) {
                    presenter.setChild(idParent, idChild);
                    childFlag = false;
                    }else {
                        System.out.println(INPUT_ERROR);
                    }
                } else {
                    System.out.println(INPUT_ERROR);
                }
            }
        }

    public void setWedding(long id1){
        boolean weddingFlag = true;
        long id2 = -1;
        while (weddingFlag) {
            System.out.println("Enter spouce ID:");
            String line = scanner.nextLine();
            if (checkTextForInt(line)) {
                id2 = Long.parseLong(line);
                if (id2 < getLastId() && id2 > -1){
                    if(getSpouce(id1) == null && getSpouce(id2) == null) {
                        presenter.setWedding(id1, id2);
                        weddingFlag = false;
                    }else {
                        System.out.println(INPUT_ERROR);
                    }
                }else {
                    System.out.println(INPUT_ERROR);
                }
            }else {
                System.out.println(INPUT_ERROR);
            }
        }
    }

    public Human getSpouce(long id){
        return presenter.getSpouce(id);
    }

    public Human getHuman(long id){
        return presenter.getHuman(id);
    }

    public void setDivorce(long id1){
        boolean divorceFlag = true;
        long id2 = -1;
        while (divorceFlag) {
            System.out.println("Enter spouce ID:");
            String line = scanner.nextLine();
            if (checkTextForInt(line)) {
                id2 = Long.parseLong(line);
                if (id2 < getLastId() && id2 > -1){
                    presenter.setDivorce(id1, id2);
                    divorceFlag = false;
                } else {
                    System.out.println(INPUT_ERROR);
                }
            }else {
                System.out.println(INPUT_ERROR);
            }
        }
    }

    public void finishEditMenu(){
        System.out.println("Back to main menu...");
        flag = false;
    }

    private boolean checkCommandEditMenu(int numCommand){
        if (numCommand < (editMenu.getSize()+1)){
            return true;
        } else {
            inputError();
            return false;
        }
    }
}
