package ru.gb.Tree.View;

import ru.gb.Tree.Presenter.Presenter;

public class ConsoleUI implements View{
    private Presenter presenter;
    private  InputData data;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        presenter = new  Presenter(this);
        data = new InputData();
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Привет!!!");
        while (work){
            System.out.println(" ");
            System.out.println(menu.menu());
            System.out.print("Выберите действие от 1 до " + menu.getMenuSize() + ": ");
            int choice = data.inputMenuChoice(menu.getMenuSize()+1);
            menu.execute(choice);
        }
    }

    @Override
    public void printAnswers(String text) {
        System.out.println(text);
    }

    public void addPersonUI() {
        String name = data.inputName();
        presenter.addPerson(name, data.inputGender(), data.inputBirthDate(), data.inputDeathDate(), data.inputMotherId(), data.inputFatherId());
        printAnswers( name + " добавлен(а) в семейное древо");
    }

    public void finish(){
        System.out.println("Спасибо! До новых встреч!");
        work = false;
    }

    public void sortByAgeUI(){
        presenter.sortByAge();
    }

    public void sortByNameUI(){
        presenter.sortByName();
    }

    public void sortByBirthDateUI(){
        presenter.sortByBirthDate();
    }

    public void getSavedFileUI(){
        presenter.getSavedInfo();
    }

    public void addNewWeddingUI(){
        System.out.println("Укажите ID первого супруга");
        int firstSpouseId = data.inputDigits();
        System.out.println("Укажите ID второго супруга");
        int secondSpouseId = data.inputDigits();
        presenter.addNewWedding(firstSpouseId, secondSpouseId);
        printAnswers("Связь между супругами установлена");
    }

    public void addNewChildUI(){
        System.out.println("Укажите ID родителя");
        int parentId = data.inputDigits();
        System.out.println("Укажите ID ребенка");
        int childId = data.inputDigits();
        presenter.addNewChild(parentId, childId);
        printAnswers("Дети добавлены");
    }
}
