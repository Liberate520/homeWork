package homeWork.src.presenter;

import homeWork.src.model.member.FamilyMember;
import homeWork.src.model.service.Service;
import homeWork.src.view.View2;

public class Presenter2 {
    private View2 view2;
    private Service service;

    public Presenter2(Presenter presenter, View2 view2){
        this.view2 = view2;
        this.service = presenter.getService();
    }

    public void changeName(long familyMemberID, String name){
        service.changeName(familyMemberID, name);
    }

    public void changeSurname(long familyMemberID, String surname){
        service.changeSurname(familyMemberID, surname);
    }

    public void changePatronymicName(long familyMemberID, String pantonymicName){
        service.changePatronymicName(familyMemberID, pantonymicName);
    }

    public void changeGender(long familyMemberID, String gender){
        service.chnageGender(familyMemberID, gender);
    }

    public void changeBirthDate(FamilyMember member){
        service.changeBirthDate(member);
    }

    public void changeDeathDate(FamilyMember member){
        service.changeDeathDate(member);
    }

    public void changeSpouse(long familyMemberID, long spouseID){
        service.changeSpouse(familyMemberID, spouseID);
    }

    public void changeMother(long familyMemberID, long motherID){
        service.changeMother(familyMemberID, motherID);
    }

    public void changeFather(long familyMemberID, long fatherID){
        service.changeFather(familyMemberID, fatherID);
    }

    public FamilyMember getMember(long familyMemberID){
        return service.getFamilyMember(familyMemberID);
    }
}
