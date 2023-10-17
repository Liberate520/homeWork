package presenter;

import java.security.Provider.Service;

import javax.swing.text.View;

import model.service.FamilyTreeService;

public class Presenter {
   private View view;
   private FamilyTreeService service;

   public Presenter (View view) {
      this.view = view;
      service = new FamilyTreeService();
   }

    public void addHuman(String name, String firstName, String lastName, String genderString, String birthDate, long idFather, long idMother) {
      String answer = service.addHuman(name, firstName, lastName, genderString, birthDate, idFather, idMother);
      view.print(answer);
  }

   public void getHumanList() {
   String answer = service.getHumanList();
   view.print(answer);
   }
   
   public void sortByName(){
      service.sortByName();
   }

   public void sortBirthDay(){
      service.sortBirthDay();
   }
}
