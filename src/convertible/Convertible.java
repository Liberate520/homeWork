package convertible;

import familyRecords.FamilyRecords;

public interface Convertible {
    public void save(FamilyRecords records);
    public FamilyRecords load();
    public boolean convertSuccess();
    public String convertStatus();
}
