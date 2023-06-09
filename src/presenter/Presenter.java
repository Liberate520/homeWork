package presenter;

import java.time.LocalDate;

import models.Service;
import models.members.Gender;

public class Presenter {

    Service service;

    public Presenter() {
        service = new Service("family.bin");
    }

    /** получение списка всех членов семьи */
    public String getAllMembers() {
        return service.getInfo((member) -> true);
    }

    /** получение имен мужчин */
    public String getMalesNames() {
        return service.getInfo((member) -> member.getGender() == Gender.Male);
    }

    /** получение имен женщин */
    public String getFemalesNames() {
        return service.getInfo((member) -> member.getGender() == Gender.Female);
    }

    /** получение списка гендеров */
    public String getGendersList() {
        return service.getGenderList();
    }

    /** получение гендера из списка */
    public String getGender(int index) {
        return service.getGenderBy(index).toString();
    }

    /** получение количества мужчин в семье */
    public int getMaleAmount() {
        return service.getAmountOfList((member) -> member.getGender() == Gender.Male);
    }

    /** получение имени мужчины по индексу из списка по условию */
    public String getMale(int index) {
        if (index == -1)
            return null;
        return service.getMemberName(index, (member) -> member.getGender() == Gender.Male);
    }

    /** получение количества женщин в семье */
    public int getFemaleAmount() {
        return service.getAmountOfList((member) -> member.getGender() == Gender.Female);
    }

    /** получение имени женщины по индексу из списка по условию */
    public String getFemale(int index) {
        return service.getMemberName(index, (member) -> member.getGender() == Gender.Female);
    }

    /** добавление нового члена семьи */
    public boolean addNewMember(String fullname, LocalDate date, int gender, int father, int mother) {
        return service.addNewMember(fullname, date, gender, father, mother);
    }

    /** получение количества членов семьи */
    public int getAllMembersAmount() {
        return service.getAmountOfList((member) -> true);
    }

    /** получение детально описания члена семьи */
    public String getMemberDetail(int index) {
        return service.getMemberDetail(index, (member) -> true);
    }

    /** получение имени члена семьи */
    public String getMemberName(int index) {
        return service.getMemberName(index, (member) -> true);
    }

    /** установить имя для члена семьи */
    public void setName(int input, String fullname) {
        service.setDifferentName(input, fullname, (member) -> true);
    }

    /** получение дня рождения для члена семьи */
    public String getMemberDate(int index) {
        return service.getMemberDate(index, (member) -> true);
    }

    /** установка пола для члена семьи */
    public void setGender(int input, int gender) {
        service.setGender(input, gender, (member) -> true);
    }

    /** установка дня рождения для члена семьи */
    public void setDate(int input, LocalDate date) {
        service.setBirthday(input, date, (member) -> true);
    }

    /** установка отца для члена семьи */
    public void setFather(int input, int father) {
        service.setFather(input, father);
    }

    /** установка матери для члена семьи */
    public void setMother(int input, int mother) {
        service.setMother(input, mother);
    }

    /** сохранение изменений */
    public void save() {
        service.save();
    }
}