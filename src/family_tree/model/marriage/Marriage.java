package family_tree.model.marriage;

import family_tree.model.Gender;
import family_tree.model.Reportable;
import family_tree.model.group.ItemFamilyTree;

import java.io.Serializable;
import java.time.LocalDate;

//Класс регистрации брака
public class Marriage<T extends ItemFamilyTree<T>> implements Serializable {
    //модификатор доступа полей по умолчанию для InformerMarriage:
    int id;
    LocalDate startDate, endDate;
    T wife, husband;
    private static final int ageAdulthood = 18;     //возраст совершеннолетия
    private boolean isError = false; //результат проверок в конструкторе
    private Reportable<Marriage<T>> reportable;

    public Marriage(int id, LocalDate startDate, T wife, T husband, Reportable<Marriage<T>> reportable){
        this.id = id;
        this.startDate = startDate;
        this.reportable = reportable;
        if(wife == null || wife.getGender() != Gender.Female
                || wife.getDateBirth().plusYears(ageAdulthood).compareTo(this.startDate) > 0    // не достигнут возраст совершеннолетия
                || wife.getSpouse() != null) {   //уже в браке
            isError = true;
            return;
        }
        if(husband == null || husband.getGender() != Gender.Male
                || husband.getDateBirth().plusYears(ageAdulthood).compareTo(this.startDate) > 0    // не достигнут возраст совершеннолетия
                || husband.getSpouse() != null) {   //уже в браке
            isError = true;
            return;
        }
        this.wife = wife;
        this.husband = husband;
        wife.setSpouse(husband);
        husband.setSpouse(wife);
    }
    public boolean getIsError(){ return isError; }

    public int getId() {
        return id;
    }

    public boolean stop(LocalDate endDate){
        if(endDate.compareTo(startDate) < 0) return false; //Попытка присвоить дату расторжения брака ранеее даты заключения
        if(this.endDate != null) return false;  //брак уже расторгнут
        this.endDate = endDate;
        wife.setSpouse(null);
        husband.setSpouse(null);
        return true;
    }

    public String getInfo(){
        return reportable.getInfo(this);
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
