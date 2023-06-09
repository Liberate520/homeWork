package presenter;
import java.time.LocalDate;

import models.Service;
import models.members.Gender;

public class Presenter {

    Service service;
    
    public Presenter(){
        service = new Service("family.bin");
    }

    public String getAllMembers() {
        return service.getInfo((member) -> true);
    } 
   
    public String getMalesNames(){
        return service.getInfo((member)-> member.getGender() == Gender.Male);
    }
    
    public String getFemalesNames(){
        return service.getInfo((member)-> member.getGender() == Gender.Female);
    }

    public String getGendersList() {
        return service.getGenderList();
    }

    public String getGender(int index) {
        return service.getGenderBy(index).toString();
    }

    public int getMaleAmount() {
        return service.getAmount((member)-> member.getGender() == Gender.Male);
    }

    public String getMale(int index) {
        if(index == -1) return null;
        return service.getMemberName(index, (member)-> member.getGender() == Gender.Male);
    }

    public int getFemaleAmount() {
        return service.getAmount((member)-> member.getGender() == Gender.Female);
    }

    public String getFemale(int index) {
        return service.getMemberName(index, (member)-> member.getGender() == Gender.Female);
    }

    public boolean addNewMember(String fullname, LocalDate date, int gender, int father, int mother) {
        return service.addNewMember(fullname, date, gender, father, mother);
    }

    public int getAllMembersAmount() {
        return service.getAmount((member)-> true);
    }

    public String getMemberDetail(int index) {
        return service.getMemberDetail(index, (member)-> true);
    }

    public String getMemberName(int index) {
        return service.getMemberName(index, (member)-> true);
    }

    public void setName(int input, String fullname) {
        service.setDifferentName(input, fullname);
    }

    public String getMemberDate(int index) {
        return service.getMemberDate(index, (member)-> true);
    }

    public void setGender(int input, int gender) {
        service.setGender(input, gender);
    }

    public void setDate(int input, LocalDate date) {
        service.setBirthday(input, date);
    }
}
