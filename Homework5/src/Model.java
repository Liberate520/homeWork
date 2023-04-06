import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<String> notes;
    public Model() {
        notes = new ArrayList<String>();
    }
    // создать запись
    public boolean add(String note) {
        boolean flag = false;
        if (!notes.contains(note)) {
            notes.add(note);
            flag = true;
            System.out.println("Заметка добавлена");
        }
        return flag;
    }

    //получить записи
    public String getNotes() {
        if (notes.size() == 0) {
            return "Блокнот пуст";
        } else {
            System.out.println("\nБлокнот заметок:");
            String result = "";
            for (String note : notes) {
                result += note + "\n";
            }
            return result;
        }
    }
}
