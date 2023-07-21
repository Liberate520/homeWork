package treeAPI.sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public interface Sample {
    void setFio(String fio);
    List<String> getFio();
    Boolean  getGender();
    Calendar getBirthDay();
    Calendar getDeathDay();
    Sample getMarried();
    List<? extends Sample> getChildren();
    List<? extends Sample> getParents();
    boolean addParent(Sample parent);
    boolean addChildren(Sample child);
    boolean addMarried(Sample humanMarried, boolean isMarried);
    String getNameString();
    int countChildren();

    default String print() {
        if (this != null) {
            return this.getFio().stream().map(Object::toString).collect(Collectors.joining(" "));
        } else {
            return "";
        }
    }

    default String birthPrint() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        if (getDeathDay() == null) {
            return this.print() + " " + dateFormat.format(this.getBirthDay().getTime());
        }else return this.print() + " " + dateFormat.format(this.getBirthDay().getTime()) + " " + dateFormat.format(this.getDeathDay().getTime());
    }

    default String printInfo() {
        if (this != null) {
            StringBuilder result = new StringBuilder();
            result.append(this.birthPrint() + "\n");
            if (this.getMarried() != null) {
                if (this.getGender().equals(true)) {
                    result.append("Жена ");
                } else {
                    result.append("Муж ");
                }
                result.append(this.getMarried().birthPrint()+"\n");
            }
            if (this.getChildren().size() > 0) {
                for (Sample sample : this.getChildren()) {
                    if (this.getGender().equals(true)){
                        result.append("Сын ");
                    }else{
                        result.append("Дочь ");
                    }
                    result.append(sample.birthPrint() +"\n");
                }
            }
            if (this.getParents().size() > 0) {
                for (Sample sample : this.getParents()) {
                    if (sample.getGender().equals(true)){
                        result.append("Отец ");
                    }else{
                        result.append("Мать ");
                    }
                    result.append(sample.birthPrint() +"\n");
                }
            }
            return result.toString();
        } else {
            return "";
        }
    }
}
