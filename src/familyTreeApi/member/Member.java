package familyTreeApi.member;

import familyTreeApi.person.Person;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public interface Member {
    List<String> getName();

    String getNameString();

    Calendar getBornDate();

    Boolean getGender();

    ThreadLocal<Object> getChildren();

    ThreadLocal<Object> getParents();

    String getKind();

    boolean addChild(Member member);

    boolean addParent(Member parent);

    boolean addMarried(Member married, boolean isMarried);

    int countChildren();

    public default String print() {
        return this.getName().stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    public default String printWithBornDate() {
        return this.toString() + " " + this.getBornDate();
    }

    void setName(String name);
}
