package familyTreeApi.member;

import familyTreeApi.person.Person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public interface Member {
    List<String> getName();

    String getNameString();

    Calendar getBornDate();

    Boolean getGender();

    Member getMarried();

    List<? extends Member> getChildren();

    List<? extends Member> getParents();

    String getKind();

    boolean addChild(Member member);

    boolean addParent(Member parent);

    boolean addMarried(Member married, boolean isMarried);

    int countChildren();

    public default String print() {
        if (this != null) {
            return this.getName().stream().map(Object::toString).collect(Collectors.joining(" "));
        } else {
            return "";
        }
    }

    public default String printInfo() {
        if (this != null) {
            StringBuilder result = new StringBuilder();
            result.append(this.printWithBornDate() + "\n");
            if (this.getMarried() != null) {
                if (this.getGender().equals(true)) {
                    result.append("Жена ");
                } else {
                    result.append("Муж ");
                }
                result.append(this.getMarried().printWithBornDate()+"\n");
            }
            if (this.getChildren().size() > 0) {
                for (Member member : this.getChildren()) {
                    if (member.getGender().equals(true)){
                        result.append("Сын ");
                    }else{
                        result.append("Дочь ");
                    }
                    result.append(member.printWithBornDate() +"\n");
                }
            }
            if (this.getParents().size() > 0) {
                for (Member member : this.getParents()) {
                    if (member.getGender().equals(true)){
                        result.append("Отец ");
                    }else{
                        result.append("Мать ");
                    }
                    result.append(member.printWithBornDate() +"\n");
                }
            }
            return result.toString();
        } else {
            return "";
        }
    }

    public default String printWithBornDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return this.print() + " " + dateFormat.format(this.getBornDate().getTime());
    }

    void setName(String name);


}
