package Exercises;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExerciseData {
    public ExerciseData() {
        descriptions = new LinkedHashMap<>();
        descriptions.put("ДОМАШНЯЯ РАБОТА 1", Arrays.asList(
                "Задание 1: Генеалогическое древо."));

        linesCount = _TasksCount();
    }

    public Map<String, List<String>> descriptions;
    private int linesCount;

    public String GetTaskText(int index) {
        int count = 0;
        for (String keyWork : descriptions.keySet()) {
            int currentCount = descriptions.get(keyWork).size();
            if (count + currentCount <= index) {
                count += currentCount;
            } else {
                return descriptions.get(keyWork).get(index - count);
            }
        }
        return null;
    }

    private int _TasksCount() {
        int count = 0;
        for (List<String> tasks : descriptions.values()) {
            count += tasks.size();
        }
        return count;
    }

    public int getLinesCount() {
        return linesCount;
    }
}
