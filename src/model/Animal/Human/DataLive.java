package Animal.Human;


import java.io.Serializable;
import java.time.LocalDate;

/**
 * Класс времени жизни человека.
 */
public class DataLive implements Serializable {
    private LocalDate birthday, dayded;

    public DataLive(int year_bd, int m_bd, int day_bd){
        this.birthday = LocalDate.of(year_bd, m_bd, day_bd);
    }
    public DataLive(){
        this(12,12,12);
    }
    
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

    public int getYear(){
        return this.birthday.getYear();
    }

    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append(" Дата рождения:"+ this.birthday.getDayOfMonth()+
                  "."+this.birthday.getMonthValue()+"."+this.birthday.getYear());
        if (dayded != null){
            sb.append("; Дата смерти:"+ this.dayded.getDayOfMonth()+
                  "."+this.dayded.getMonthValue()+"."+this.dayded.getYear());
        }
        return sb.toString();
    }
}
