package HW01.ui;


public class Validator {
    private String inputText;
//    private Menu menu;
    public Validator(String inputText) {
        this.inputText = inputText;
    }
    public Validator() {this ("");}

    public Integer checkInput (String inputText, Integer rowsValue){
        int point;
        boolean isNum = inputText.matches("[0-9]*");

        if (isNum){
            point = Integer.parseInt(inputText);
        }
        else {
            point = 0;
        }
        if (point < 0 || point >= rowsValue) {
            point = 0;
        }

        return point;
    }
}
