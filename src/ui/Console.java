package ui;

import presenter.Presenter;
import ui.commands.Command;
import ui.questions.Question;

import javax.sound.midi.Soundbank;
import java.net.InterfaceAddress;
import java.util.List;
import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public Console(){
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }
    @Override
    public void start() {
        while(work){
            menu.print(this);
            String choice = scanner.nextLine();
            if(check(choice)){
                menu.execute(Integer.parseInt(choice));
            }else {
                fail();
            }
        }
    }
    private boolean check(String text){
        return text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize() && Integer.parseInt(text) > 0;
    }
    private void finish() {
        work = false;
    }
    private void fail(){
        System.out.println("Неверный ввод");
    }
    public void getFamilyTree() {
        presenter.getFamilyTree();
    }
    public void addHuman() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию человека");
        String surname = scanner.nextLine();
        System.out.println("Введите дату рождения форматом дд.мм.уууу");
        String bday = scanner.nextLine();
        System.out.println("Введите имя отца");
        String fatherName = scanner.nextLine();
        System.out.println("Введите фамилию отца");
        String fatherSurname = scanner.nextLine();
        System.out.println("Введите имя матери");
        String motherName = scanner.nextLine();
        System.out.println("Введите фамилию матери");
        String motherSurname = scanner.nextLine();
        presenter.addHuman(name,surname,bday,fatherName,fatherSurname,motherName,motherSurname);
    }
    public void printMenu(List<Command> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < list.size(); i++){
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
    public void sortByName(){
        presenter.sortByName();
    }
    public void sortByBirthDay(){
        presenter.sortByBirthDay();
    }
    public void getHuman(){
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию человека");
        String surname = scanner.nextLine();
        presenter.getHuman(name,surname);
    }
    public String getAnswerRepeatHuman(Question question){
        System.out.println(question.getDescription());
        String answer = scanner.nextLine();
        return answer;
    }
    public void saveToFile(){
        presenter.saveToFile();
    }
    public void readToFile(){
        presenter.readToFile();
    }
}