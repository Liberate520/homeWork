package model.converter;

import model.familyRecords.FamilyRecords;
import model.member.Member;

public interface Converter<E extends Member> {
    public void save(FamilyRecords<E> records);
    public FamilyRecords<E> load();
    public boolean convertSuccess();
    public String convertStatus();
}
