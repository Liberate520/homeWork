package WorkSeminar.model.Persona.Builder.CheckingIO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;



public class CheckIO {
    // Проверка гендора рабочая, но поискать альтернативы.
    public boolean checkGender(String gender){
        return gender.equals("Male") || gender.equals("Female");
    }

    public boolean checkString(String date) {
        if (date != " " && date != null) {
            return date.matches("[а-я А-Яa-zA-Z]+");
        } else {
            return false;
        }
    }


    public boolean checkDate(DateTimeFormatter format, String date) {
        try {
            LocalDate time = LocalDate.now();
            LocalDate trueDate = LocalDate.parse(date, format);
            if (trueDate.getDayOfMonth() > 31 | trueDate.getDayOfMonth() < 1
                    | trueDate.getMonthValue() < 1 | trueDate.getMonthValue() > 12
                    | trueDate.getYear() > time.getYear()) {
                return false;
            } else {
                return true;
            }

        } catch (RuntimeException ex) {
            return false;
        }
    }

    // Честно своровано с простоов интрента. Однако трайсер как будто лишний.
    // Оставил себе как пирмер.
    /*public boolean checkTime(String format, String value) {
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
    }*/
    /*
    Моё чудовище.
    Проверяет:
    - будет ли введёная дата парсится в соотвествии с форматом,
    - не введено ли неадекватноче число (13 месяцев, 40 тысячелетие, или -6 день.)
    - проверка на день допускает ошибки связанные с разным колиячеством дней в разные месяцы.
     */

}
