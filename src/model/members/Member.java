package model.members;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

public interface Member extends Serializable {
    public String getName();

    public Year getYearOfBirth();

    public Gender getGender();

    public Member getFather();

    public void setFather(Member father);

    public Member getMother();

    public void setMother(Member mother);

    public void addChild(Member child);

    public List<Member> getChildren();


}
