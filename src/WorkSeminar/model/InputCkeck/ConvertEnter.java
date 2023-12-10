package WorkSeminar.model.InputCkeck;
/*
* Метод конверсии строкового ввода в валидное число.
 */
public class ConvertEnter {
    private String element;
    private int size;

    public ConvertEnter(String input, int size) {
        this.element = input;
        this.size = size;
    }
    public Integer convertEnter(){

        if(checkNumber()){
            int enterTrue = convertString();
            if(checkOption(enterTrue, size)){
                return enterTrue;
            }
        }
        return null;
    }


    // Метод первичной проверки.
    // Проверяем, можно ли введёный символ преобразовать в целое число.
   public boolean checkNumber(){
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException ex){
            System.out.println("Ошибка ввода! Введены не коректные символы.");
            return false;
        }
    }
    // Конверитруем число.
   public int convertString(){
        return Integer.parseInt(element);
    }
    // Проверяем число на соответсвие диапозону команд нашего меню.
   public boolean checkOption(int element, int size){
        if(element <= 0 | element > size){
            System.out.println("Ошибка ввода! Введена не коректный номер команды.");
            return false;
        } else {
            return true;
        }
    }




}
