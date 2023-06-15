package FamilyTree.model.Family;

import java.time.LocalDate;
import java.util.List;

public interface FamilyItem {
    LocalDate getBirthdate();
    String getName();

    <T extends FamilyItem> List<T> getChildren();

//    String getFamilyInfo();
}