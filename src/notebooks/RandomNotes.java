package Seminar6.src.notebooks;

import java.util.ArrayList;
import java.util.List;

public class RandomNotes implements Notes {

    private final List<String> moduleList;

    public RandomNotes() {
        this.moduleList = new ArrayList<>();
    }

    public List<String> getRandomNotes() {
        return moduleList;
    }
    @Override
    public void addNotes(String st) {
        moduleList.add(st);
    }
}
