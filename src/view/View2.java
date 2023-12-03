package homeWork.src.view;

import homeWork.src.model.member.FamilyMember;

public interface View2 {
    void start();
    void answer(String prompt);
    void changeName();
    void changeSurname();
    void changePatronymicName();
    void changeGender();
    void changeBirthDate();
    void changeDeathDate();
    void changeSpouse();
    void changeMother();
    void changeFather();
    void exit();
}
