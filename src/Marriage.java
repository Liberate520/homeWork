import java.time.LocalDate;

//Класс регистрации брака между двумя людьми
public class Marriage {
    private int id;
    private LocalDate startDate, endDate;
    private Human wife, husband;
    private static final int ageAdulthood = 18;     //возраст совершеннолетия
    private boolean isError = false;

    public Marriage(int id, LocalDate startDate, Human wife, Human husband){
        this.id = id;
        this.startDate = startDate;
        if(wife == null || wife.getGender() != Gender.Female
                || wife.getDateBirth().plusYears(ageAdulthood).compareTo(this.startDate) > 0    // не достигнут возраст совершеннолетия
                || wife.getMarriage() != null) {   //уже в браке
            isError = true;
            return;
        }
        if(husband == null || husband.getGender() != Gender.Male
                || husband.getDateBirth().plusYears(ageAdulthood).compareTo(this.startDate) > 0    // не достигнут возраст совершеннолетия
                || husband.getMarriage() != null) {   //уже в браке
            isError = true;
            return;
        }
        this.wife = wife;
        wife.setMarriage(this);
        this.husband = husband;
        husband.setMarriage(this);
    }
    public boolean getIsError(){ return isError; }

    public int getId() {
        return id;
    }

    public boolean finish(LocalDate endDate){
        if(endDate.compareTo(startDate) < 0) return false; //Попытка присвоить дату расторжения брака ранеее даты заключения
        this.endDate = endDate;
        wife.setMarriage(null);
        husband.setMarriage(null);
        return true;
    }

    public String getInfo(){
        return "{id: " + id
                + ", startDate: " + startDate.toString()
                + (endDate == null ? "" : ", endDate: " + endDate.toString())
                + ", \nСупруга: " + wife.getInfo()
                + ", \nСупруг: " + husband.getInfo()
                + "}";
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
