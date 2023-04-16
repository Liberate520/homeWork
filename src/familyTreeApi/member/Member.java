package familyTreeApi.member;

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
        return this.getName().stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    public default String printInfo() {
        StringBuilder result = new StringBuilder();
        result.append(this.printAllInfo() + "\n");
        if (this.getMarried() != null) {
            if (this.getGender().equals(true)) {
                result.append("Жена ");
            } else {
                result.append("Муж ");
            }
            result.append(this.getMarried().printAllInfo() + "\n");
        }
        if (this.getChildren().size() > 0) {
            for (Member member : this.getChildren()) {
                if (member.getGender().equals(true)) {
                    result.append("Сын ");
                } else {
                    result.append("Дочь ");
                }
                result.append(member.printAllInfo() + "\n");
            }
        }
        if (this.getParents().size() > 0) {
            for (Member member : this.getParents()) {
                if (member.getGender().equals(true)) {
                    result.append("Отец ");
                } else {
                    result.append("Мать ");
                }
                result.append(member.printAllInfo() + "\n");
            }
        }
        return result.toString();
    }

    public default String printAllInfo() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return this.print() + ", дата рождения: " + dateFormat.format(this.getBornDate().getTime()) + ", раса (порода): " + this.getKind();
    }

    void setName(String name);
}
