package homeWork.src.finalProjectDiary.presenter;

import homeWork.src.finalProjectDiary.file.Service;
import homeWork.src.finalProjectDiary.model.Day;
import homeWork.src.finalProjectDiary.model.Diary;
import homeWork.src.finalProjectDiary.model.Record;
import homeWork.src.finalProjectDiary.ui.ConsoleUI;


public class Presenter {
    private Diary diary;
    private ConsoleUI consoleUI;

    private Service service;

    public Presenter(Service service) {
        this.service = service;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public void setConsoleUI(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public void printDiary(Diary diary) {
        getConsoleUI().printDiary(diary);
    }

    /*
    добавить запись
     */
    public void addRecord() {
        diary.addRecordToDay(consoleUI.getDay(), consoleUI.getRecord(true));
    }

    /*
    получить записи по запрошенному дню
     */
    public void getDayRecords() {
        int dayNum = consoleUI.getDay();
        Day day = diary.getDayRecords(dayNum);
        consoleUI.printDay(dayNum, day);
    }

    /*
    поиск записи по событию
     */
    public void findRecord() {
        Record record = consoleUI.getRecord(false);
        String event = record.getEvent();
        String findedRecord = diary.findRecord(event);
        if (findedRecord.length() == 0) {
            findedRecord = "Событие " + event + " не найдено";
        } else {
            findedRecord = "Нашёл:\n" + findedRecord;
        }
        consoleUI.printRecord(findedRecord);
    }

    /*
    удаление записи по событию
     */
    public void delRecord() {
        Record record = consoleUI.getRecord(false);
        String event = record.getEvent();
        String delRecord;
        int count = diary.delRecord(event);
        if (count == 0) {
            delRecord = "Событие " + event + " не найдено. Удалять нечего.";
        } else {
            delRecord = "Удалено " + count + " событий.";
        }
        consoleUI.printRecord(delRecord);
    }

    /*
    сохранение Diary
     */
    public void saveDiary() {
        service.saveDiary(diary);
    }

    /*
    чтение Diary
     */
    public Diary readDiary() {
        diary = service.readDiary();
        return diary;
    }
}
