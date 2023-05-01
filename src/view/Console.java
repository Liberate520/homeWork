package view;

import presenter.Presenter;
import view.toChoose.ToChooseFormat;
import view.toChoose.ToChooseInterface;
import view.toChoose.ToChooseStart;

import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work = true;

    public Console() {
        scanner = new Scanner(System.in, "cp866");

    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
    @Override
    public void start() {
        while (work) {
            ToChooseStart start = new ToChooseStart();
            int choice = start.toChoose();
            switch (choice) {
                case 1:
                    ToChooseInterface choiceFormat = new ToChooseFormat();
                    if (choiceFormat.toChoose() == 1)
                        loadAllRecordsOS();
                    else
                        loadAllRecordsTXT();
                    break;

                case 2:
                    getAllRecord();
                    break;
                
                case 3:
                    addRecord();
                    break;

                case 4:
                    sortRecordsByName();
                    break;

                case 5:
                    sortRecordsId();
                    break;
                case 6:
                    findRecord();
                    break;

                case 7:
                    saveAllRecords();
                    break;

                case 8:
                    exit();
                    break;
                default:
                    System.out.println("Введите число!");
            }
        }
    }

    private void addRecord() {
        CollecterInfo collecterInfo = new CollecterInfo();
        collecterInfo = collecterInfo.getInfoFromUser();
        presenter.addRecord(collecterInfo);
    }

    private void findRecord() {
        System.out.println("Введите имя и фамилию.");
        String name = scanner.nextLine();
        presenter.findRecord(name);
    }

    private void loadAllRecordsOS() {
        presenter.loadRecordsOS();
    }

    private void loadAllRecordsTXT() {
        presenter.loadRecordsTXT();
    }

    private void getAllRecord() {
        presenter.getRecords();
    }
    private void sortRecordsByName() {
        presenter.sortRecordsByName();
    }

    private void sortRecordsId() {
        presenter.sortRecordsById();
    }

    private void saveAllRecords() {
        presenter.saveRecords();
    }

    private void exit() {
        System.out.println("Работа программы завершена.");
        scanner.close();
        work = false;
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}