package notepadapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ServiceImpl implements Service {
    private final List<Note> repository = new ArrayList<>();

    @Override
    public List<Note> getRepo(){
        return this.repository;
    }
    @Override
    public int getSize(){
        return this.repository.size();
    }

    @Override
    public void createNote(String note) {
        final Note model = new Note(note);
        repository.add(model);
    }

    @Override
    public void showAllNotes() {
        if (!repository.isEmpty()){
            for (int i = 0; i < repository.size(); i++) {
                System.out.printf("%d. %s", i + 1, repository.get(i).toString());
                System.out.println();
            }
        }else{
            System.out.println("Notepad is empty.");
            System.out.println();
        }
    }


    @Override
    public void deleteNoteByNumber(int number) {
        repository.remove(number - 1);
    }
    @Override
    public void changeNoteByNumber(int index) {
        Scanner sc = new Scanner(System.in);
        String newText = sc.next();
        final Note model = new Note(newText);
        repository.set(index-1, model);
    }


}
