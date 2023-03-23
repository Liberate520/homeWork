package ui;

public class Validator {
    private String inputText;
    public Validator(String inputText){
        this.inputText=inputText;
    }
    public Validator() {this ("");}
    public Integer checkInput(String inputText, Integer rowValue){
        int point;
        boolean isNum = inputText.matches("[0-9]*");
        if (isNum){
            point = Integer.parseInt(inputText);
        }
        else {
            point=0;
        }
        if (point <0 || point >=rowValue){
            point=0;
        }
        return point;
    }
}
