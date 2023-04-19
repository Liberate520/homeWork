package UI;

import presenter.Presenter;
import UI.interfaces.View;

import java.io.IOException;
import java.util.Scanner;

import Tree.Person;


public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        scanner = new Scanner(System.in, "ibm866");
        menu = new Menu(this);
        work = true;
        while (work){
            hello();
            Integer command = scanner.nextInt();
            if (checkInput(command)){
                menu.execute(command);
            }else{
                System.out.println("Ошибка ввода команды");
            }
        }
    }
    @Override
    public void print(String text){
        System.out.println(text);
    }
    private void hello(){
        System.out.println(menu.printMenu());
    }
    private boolean checkInput(Integer command){
        return (0 < command && command < 11);
    }
    public void finish() {
        work = false;
    }


    public void treeList() {
        System.out.println(presenter.treeList());
    }
    
    public void search() {
        System.out.println("Поиск по: \n" + 
        "1. Имени \n"+
        "2. Фамилии \n"+
        "3. Имени и фамилии \n"+
        "4. По дате рождения \n"+
        "5. По нахождение в живых \n"+ 
        "6. По дате смерти \n" +
        "Введите число: ");
        int i = scanner.nextInt();
        scanner.nextLine();
        if(i == 1){
            System.out.println("Введите имя: ");
            System.out.println(presenter.searchByFirstName(scanner.nextLine()));
        }
        if(i == 2){
            System.out.println("Введите фамилию: ");
            System.out.println(presenter.searchBySecondName(scanner.nextLine()));
        }
        if(i == 3){
            System.out.println("Введите имя и фамилию: ");
            System.out.println(presenter.searchByFullName(scanner.nextLine()));
        }
        if(i == 4){
            System.out.println("Введите дату рождения: ");
            System.out.println(presenter.searchByDateOfBirth(scanner.nextLine()));
        }
        if(i == 5){
            System.out.println("Выберите число: \n" + "1. Жив \n" + "2. Мертв \n" + "Введите число: ");
            System.out.println(presenter.searchByAliveOrNot(scanner.nextInt()));
        }
        if(i == 6){
            System.out.println("Введите дату смерти: ");
            System.out.println(presenter.searchByDateOfDeath(scanner.nextLine()));
        }
    }

    public void sorting() { 
        System.out.println("Сортировка по: \n" + 
        "1. Имени \n"+
        "2. Фамилии \n"+
        "3. По нахождение в живых \n"+ 
        "4. По количеству детей \n" +
        "Введите число: ");
        int i = scanner.nextInt();

        if(1 == i){
            System.out.println(presenter.sortByName());
        }
        
        if(2 == i){
            System.out.println(presenter.sortBySecondName());
        }
    

        if(3 == i){
            System.out.println(presenter.sortByAlive());
        }
    
        if(4 == i){
            System.out.println(presenter.sortByChild());
        }
    }

    public void newPerson(){
        Person new_person = new Person();
        System.out.println("Введите имя: ");
        new_person.setFirstName(scanner.next());
        System.out.println("Введите фамилию: ");
        new_person.setSecondName(scanner.next());
        System.out.println("Введите дату рождения: ");
        new_person.setDateOfBirth(scanner.next());
        System.out.println("Выберите жив или нет: ");
        System.out.println("1. Жив ");
        System.out.println("2. Мертв ");
        int answer = scanner.nextInt(); 
        System.out.println();
        while(answer < 1 || answer > 2){
            System.out.println("Выберите жив или нет: ");
            System.out.println("1. Жив ");
            System.out.println("2. Мертв "); 
            answer = scanner.nextInt(); 
            System.out.println();
        }
        if (answer == 1){
            new_person.setAlive(true);
            System.out.println();
        }
        if(answer == 2){
            new_person.setAlive(false);
            System.out.println("Введите дату смерти: ");
            new_person.setDateOfDeath(scanner.next());
            System.out.println();
        }
        presenter.add(new_person);
        System.out.println(new_person.getFullName() + " добавлен(а) в семейное древо ");
        answer = 0;
    }

    public void newFather(){
        System.out.println("Выберите человека для добавления отца: ");
        presenter.getAllPersonFromList();
        System.out.println("Введите номер человека: ");
        int child = scanner.nextInt();
        System.out.println("Выберите отца для человека: ");
        presenter.getAllPersonFromList();
        System.out.println("Введите номер человека: ");
        int father = scanner.nextInt();
        System.out.println(presenter.setFather(father, child));
    }

    public void newMother(){
        System.out.println("Выберите человека для добавления матери: ");
        presenter.getAllPersonFromList();
        System.out.println("Введите номер человека: ");
        int child = scanner.nextInt();
        System.out.println("Выберите мать для человека: ");
        presenter.getAllPersonFromList();
        System.out.println("Введите номер человека: ");
        int mother = scanner.nextInt();
        presenter.setMother(mother, child);
    }

    public void newChild(){
        System.out.println("Выберите человека для добавления ребенка: ");
        presenter.getAllPersonFromList();
        System.out.println("Введите номер человека: ");
        int person = scanner.nextInt();
        System.out.println("Выберите ребенка для человека: ");
        presenter.getAllPersonFromList();
        System.out.println("Введите номер человека: ");
        int child = scanner.nextInt();
        presenter.addChild(person, child);
    }

    public void save() throws IOException {
        presenter.save();
        System.out.println("Семейное древо успешно сохранено!");
        System.out.println();
    }
    public void read() throws IOException, ClassNotFoundException {
        System.out.println("Загрузка древа из файла");
        presenter.read();
        System.out.println();
    }

}
