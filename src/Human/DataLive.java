package Human;


import java.time.LocalDate;

/**
 * Класс времени жизни человека.
 */
public class DataLive {
    private LocalDate birthday, dayded;
    
    public void setBirthday(LocalDate value){
        this.birthday = value;
    }
    
    public void setTimeLive(LocalDate value1, LocalDate value2){
        this.birthday = value1;
        this.dayded = value2;
    }

    public LocalDate getBirthday(){
        return this.birthday;
    }

    public LocalDate getDayded(){
        return this.dayded;
    }
}
