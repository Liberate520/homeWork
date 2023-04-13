public class Date {

    Integer day;
    Integer month;
    Integer year; 

    public Date (Integer day, Integer month, Integer year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override

    public String toString(){
        return "дата рождения:" + day+"."+month+"."+year;
    }
    
} 


