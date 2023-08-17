package homeWork.ProjectFamilyTree.View;

import homeWork.ProjectFamilyTree.Model.Gender;
import homeWork.ProjectFamilyTree.Presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Выберите действие: ");
        while (work){
            System.out.println(mainMenu.menu());
            String choice = scanner.nextLine();
            int choiceInt = Integer.parseInt(choice);
            mainMenu.execute(choiceInt);
        }
    }

    private void errorInput(){
        System.out.println("Введены неверные данные");
    }

    public void finish(){
        scanner.close();
        work = false;
    }
    public void sortByAge(){
        presenter.sortByAge();
    }
    public void sortByName(){
        presenter.sortByName();
    }
    public void getFamilyTreeInfo(){
        presenter.getFamilyTreeInfo();
    }
    public void addHuman(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения в формате: YYYY-MM-DD");
        LocalDate localDateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите дату смерти");
        LocalDate localDateofDeath;
        if (scanner.nextLine().isEmpty()){localDateofDeath = null;}
        else {localDateofDeath = LocalDate.parse(scanner.nextLine());}
        System.out.println("Введите пол (Male/Female)");
        Gender gender = Gender.valueOf(scanner.nextLine());
        presenter.addHuman(name, localDateOfBirth, localDateofDeath, gender);
    }
    public void setParentsAndChilds(){
        System.out.println("Введите id ребенка:");
        String childIdString = scanner.nextLine();
        int childId = Integer.parseInt(childIdString);
        System.out.println("Введите id одного родителя:");
        String parent1IdString = scanner.nextLine();
        int parent1Id = Integer.parseInt(parent1IdString);
        System.out.println("Введите id другого родителя:");
        String parent2IdString = scanner.nextLine();
        int parent2Id = Integer.parseInt(parent2IdString);
        presenter.setParentsAndChilds(childId, parent1Id, parent2Id);
    }
    public void siblings(){
        System.out.println("Введите id одного из братьев/сестер:");
        String human1IdString = scanner.nextLine();
        int human1Id = Integer.parseInt(human1IdString);
        System.out.println("Введите id другого из братьев/сестер:");
        String human2IdString = scanner.nextLine();
        int human2Id = Integer.parseInt(human2IdString);
        presenter.siblings(human1Id, human2Id);
    }
    public void Save() throws IOException {presenter.Save();}
    public void Load() throws IOException, ClassNotFoundException {presenter.Load();}

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
