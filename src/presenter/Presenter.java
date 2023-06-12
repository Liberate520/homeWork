package presenter;

import java.time.LocalDate;

import models.Service;
import models.repository.FileHandler;

public class Presenter {

    Service service;

    public Presenter() {
        service = new Service(new FileHandler("family.data"));
    }

    /** получение списка всех членов семьи */
    public String getNamesAllMembers() {
        return service.getNamesAllMembers();
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

    /** получение гендера из списка */
    public String getGender(int index) {
        return service.getGenderBy(index).toString();
    }

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

    /** получение имени мужчины по индексу из списка по условию */
    public String getMaleName(int index) {
        return service.getMaleName(index);
    }

    /** получение имени женщины по индексу из списка по условию */
    public String getFemaleName(int index) {
        return service.getFemaleName(index);
    }
    
    /** получение имени члена семьи */
    public String getMemberName(int index) {
        return service.getMemberName(index);
    }

    /** добавление нового члена семьи */
    public boolean addNewMember(String fullname, LocalDate date, int gender, int father, int mother) {
        return service.addNewMember(fullname, date, gender, father, mother);
    }


    /** получение детально описания члена семьи */
    public String getMemberDetail(int index) {
        return service.getMemberDetail(index);
    }



    /** установить имя для члена семьи */
    public void setName(int input, String fullname) {
        service.setDifferentName(input, fullname);
    }

    /** получение дня рождения для члена семьи */
    public String getMemberDate(int index) {
        return service.getMemberDate(index);
    }

    /** установка пола для члена семьи */
    public void setGender(int input, int gender) {
        service.setGender(input, gender);
    }

    /** установка дня рождения для члена семьи */
    public void setBirthday(int input, LocalDate date) {
        service.setBirthday(input, date);
    }

    /** установка отца для члена семьи */
    public void setFather(int input, Integer father) {
        service.setFather(input, father);
    }

    /** установка матери для члена семьи */
    public void setMother(int input, Integer mother) {
        service.setMother(input, mother);
    }

    /** сохранение изменений */
    public void save() {
        service.save();
    }
}