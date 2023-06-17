package model.converter;

import model.familyRecords.FamilyRecords;
import model.member.Member;

public interface Converter<E extends Member> {
    void save(FamilyRecords<E> records);
    FamilyRecords<E> load();
    boolean convertSuccess();
    String convertStatus();
    String getPath();
    void setPath(String newPath);
}
