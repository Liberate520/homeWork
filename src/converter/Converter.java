package converter;

import familyRecords.FamilyRecords;

public interface Converter {
    public void save(FamilyRecords records);
    public FamilyRecords load();
    public boolean convertSuccess();
    public String convertStatus();
}
