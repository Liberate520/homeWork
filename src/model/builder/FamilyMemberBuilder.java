package homeWork.src.model.builder;

import homeWork.src.model.member.FamilyMember;
import homeWork.src.model.tree.FamilyTree;
import homeWork.src.model.tree.Gender;
import homeWork.src.model.tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class FamilyMemberBuilder {
    private long id = 1;

    public void assignID(List<? extends TreeItem<?>> familyMemberList){
        long maxID = 0;
        for(TreeItem<?> member: familyMemberList){
            if(maxID < member.getId()){
                maxID = member.getId();
            }
        }
        id = maxID + 1;
    }
    public FamilyMember build(String name, String surname, String patronymicName, Gender gender,
                        LocalDate birthDate) {
        return new FamilyMember(id++, name, surname, patronymicName,
                gender, birthDate, null, null, null);
    }

    public FamilyMember build(String name, String surname, String patronymicName, Gender gender,
                        LocalDate birthDate, LocalDate deathDate, FamilyMember father, FamilyMember mother){
        return new FamilyMember(id++, name, surname, patronymicName, gender, birthDate, null, father, mother);
    }

    public FamilyMember build(String name, String surname, String patronymicName, Gender gender,
                              LocalDate birthDate, LocalDate deathDate) {
        return new FamilyMember(id++, name, surname, patronymicName,
                gender, birthDate, deathDate);
    }

    public long getId(){return id;};

}
