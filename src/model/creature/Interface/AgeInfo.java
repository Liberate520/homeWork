package model.creature.Interface;

import java.time.LocalDate;

public interface AgeInfo {
    int getPeriod(LocalDate dataBirth, LocalDate dataDeath);
    int getAge();
    LocalDate getDataBirth();
    void setDataBirth(LocalDate dataBirth);
    LocalDate getDataDeath();
    void setDataDeath(LocalDate dataDeath);
}
