package HW01.ui;

public class Validator {
    private String inputText;
//    private Menu menu;
    public Validator(String inputText) {
        this.inputText = inputText;
    }
    public Validator() {this ("");}

    public Integer checkInput (String inputText, Integer rowsValue){
        Integer point;
        try {
            point = Integer.parseInt(inputText);
        }catch (Exception e)
        {
            point = 0;
        }
        if (point < 0 || point >= rowsValue) {
            point = 0;
        }

        return point;
    }
}
