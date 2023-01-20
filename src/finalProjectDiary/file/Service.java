package homeWork.src.finalProjectDiary.file;

import homeWork.src.finalProjectDiary.model.Diary;

public class Service {

    private final Writable writable;

    public Service(Writable writable) {
        this.writable = writable;
    }

    /*
    сохранить Diary
     */
    public void saveDiary(Diary diary) {
        writable.save(diary);
    }

    /*
    прочитать Diary
     */
    public Diary readDiary() {
        if (writable != null) {
// если Diary ещё не существует, то создаём новый и возвращаем
            if (writable.read() == null) {
                System.out.println("Diary в файле нет! Создаём новый Diary.");
                return new Diary();
            } else {
                System.out.println("Diary загружен из файла.");
                return (Diary) writable.read();
            }
        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
    }
}
