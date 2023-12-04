package WorkSeminar.model.Persona.Builder.CheckingIO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class CheckIO {
    // Проверка гендора рабочая, но поискать альтернативы.
    public boolean checkGender(String gender){
        if(gender.equals("Male") || gender.equals("Female")){
            return true;
        } return false;
    }

    // Честно своровано с простоов интрента. Однако трайсер как будто лишний.
    // Стоит сюда переместит сообщение о неверном формате даты?
    public boolean checkTime(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

}
