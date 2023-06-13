package presenter;

import java.time.LocalDate;

import models.Service;
import models.repository.BinaryKeeper;

public class Presenter {

    Service service;

    public Presenter() {
        service = new Service(new BinaryKeeper("family.bin"));
    }

    /** получение списка всех членов семьи */
    public String getMembersNames() {
        return service.getMembersNames();
    }

    /** получение имен мужчин */
    public String getMalesNames() {
        return service.getMaleNames();
    }

    /** получение имен женщин */
    public String getFemalesNames() {
        return service.getFemaleNames();
    }

    /** получение списка гендеров */
    public String getGendersList() {
        return service.getGenderList();
    }

    //////////////////////////////////////////////////////////////
    /** получение количества мужчин в семье */
    public int getMaleAmount() {
        return service.getMaleAmount();
    }

    /** получение количества женщин в семье */
    public int getFemaleAmount() {
        return service.getFemaleAmount();
    }

    /** получение количества членов семьи */
    public int getAllMembersAmount() {
        return service.getAllAmount();
    }

    /////////////////////////////////////////////////////////////
    /** получение гендера из списка */
    public String getGender(int index) {
        return service.getGenderBy(index);
    }

    /** получение имени мужчины по индексу из списка по условию */
    public String getMaleName(int index) {
        return service.getMaleName(index);
    }

    /** получение имени женщины по индексу из списка по условию */
    public String getFemaleName(int index) {
        return service.getFemaleName(index);
    }

    ////////////////////////////////////////////////////////////////
    /** получение детально описания члена семьи */
    public String getMemberDetail(int index) {
        return service.getMemberDetail(index);
    }

    /** сохранение изменений */
    public void save() {
        service.save();
    }

    /** обновление данных  */
    public void updateMember(Integer index, String name, LocalDate date, Integer gender, Integer fatherIndex, Integer motherIndex) {
        service.updateMember(index, name, date, gender, fatherIndex, motherIndex);
    }

    /** добавление нового члена семьи */
    public void addNewMember(String fullName, LocalDate date, int gender, int father, int mother) {
        service.addNewMember(fullName, date, gender, father, mother);
    }
}