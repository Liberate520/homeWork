package model.creature.methods;

import model.creature.Interface.AgeInfo;

import java.time.LocalDate;
import java.time.Period;

public class Age implements AgeInfo {
    private LocalDate dataBirth;
    private LocalDate dataDeath;

    public int getPeriod(LocalDate dataBirth, LocalDate dataDeath) {
        Period diff = Period.between(dataBirth, dataDeath);
        return diff.getYears();
    }

    public int getAge() {
        if (dataDeath == null) {
            return getPeriod(dataBirth, LocalDate.now());
        } else {
            return getPeriod(dataBirth, dataDeath);
        }
    }

    public LocalDate getDataBirth() {
        return dataBirth;
    }

    public void setDataBirth(LocalDate dataBirth) {
        this.dataBirth = dataBirth;
    }

    public LocalDate getDataDeath() {
        return dataDeath;
    }

    public void setDataDeath(LocalDate dataDeath) {
        this.dataDeath = dataDeath;
    }
}
