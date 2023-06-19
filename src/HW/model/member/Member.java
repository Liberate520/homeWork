package HW.model.member;


import java.time.LocalDate;
import java.util.List;

public interface Member {

    public String getName();

    public LocalDate getDateOfBirth();

    public String getSurname();

    public Member getFather();

    public Member getMother();

    public List<Member> getChildren();

    public void setChildren(Member human);

}
