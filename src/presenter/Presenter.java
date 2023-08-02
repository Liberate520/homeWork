package presenter;

import model.Service;
import view.View;

public class Presenter {
  private View view;
  private Service service;

  public Presenter(View view) {
    service = new Service();
    this.view = view;
  }

  public void addHuman(String name, String gender, String birthDate, long idFather, long idMother) {
    String answer = service.addHuman(name, gender, birthDate, idFather, idMother);
    view.print(answer);
  }

  public String getHumanList() {
    return service.getHumanList();
  }
}
