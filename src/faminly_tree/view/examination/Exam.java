package faminly_tree.view.examination;

import java.time.LocalDate;

public class Exam implements Examination {
    private final String NUMBER_ERROR = "Ведено не число";
    private final String YEAR_ERROR = "Введенный год больше нынешнего";
    private final String NEGATIVE_ERROR = "Число не может быть отрицательным";
    private final String MONTH_ERROR = "Значение месяца не может быть больше 12";
    private final String LEAP_FEB_ERROR = "Значение дня не может быть больше 29";
    private final String NOT_LEAP_FEB_ERROR = "Значение дня не может быть больше 28";
    private final String DAY_MORE_31_ERROR = "Значение дня не может быть больше 31";
    private final String DAY_MORE_30_ERROR = "Значение дня не может быть больше 30";
    @Override
    public int itsNumber(String line) {
        try {
            return Integer.parseInt(line);
        }
        catch (NumberFormatException e) {
            System.out.println(NUMBER_ERROR);
            return -1;
        }
    }
    @Override
    public boolean rightDate() {
        return false;
    }
    @Override
    public boolean rightGender(String sex) {
        if (sex.contains("м") || sex.contains("ж")) return true;
        return false;
    }
    private boolean leapYearExamination(int year){
        if (year % 4 != 0) return false;
        else{
            if (year % 100 != 0) return true;
            else {
                if (year % 400 != 0) return false;
                else return true;
            }
        }
    }
    @Override
    public boolean dayExamination(int day, int month, int year) {
        if (day < 0) {
            System.out.println(NEGATIVE_ERROR);
            return true;
        }
        boolean leapYear = leapYearExamination(year);
        if (leapYear && (month == 2) && (day > 29)){
            System.out.println(LEAP_FEB_ERROR);
            return true;
        }
        if (!leapYear && (month == 2) && (day > 28)) {
            System.out.println(NOT_LEAP_FEB_ERROR);
            return true;
        }
        if (((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) && day > 31){
            System.out.println(DAY_MORE_31_ERROR);
            return true;
        }
        if (((month == 2) || (month == 4) || (month == 6) || (month == 9) || (month == 11)) && day > 30){
            System.out.println(DAY_MORE_30_ERROR);
            return true;
        }
        return false;
    }
    @Override
    public boolean monthExamination(int month) {
        if (month > 12) {
            System.out.println(MONTH_ERROR);
            return true;
        }
        if (month < 0) {
            System.out.println(NEGATIVE_ERROR);
            return true;
        }
        return false;
    }
    @Override
    public boolean yearExamination(int year){
        if (year > LocalDate.now().getYear()) {
            System.out.println(YEAR_ERROR);
            return true;
        }
        if (year < 0) {
            System.out.println(NEGATIVE_ERROR);
            return true;
        }
        return false;
    }
}
