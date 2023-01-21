package file;

import model.Calendar;

public class BackupAndRead {

    private Writable writable;

    public BackupAndRead(Writable writable) {
        this.writable = writable;
    }

    public void saveCalendar(Calendar calendar) {
        writable.save(calendar);
    }

    public Calendar read() {

        if (writable != null) {
            return (Calendar) writable.read();

        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
    }

}
