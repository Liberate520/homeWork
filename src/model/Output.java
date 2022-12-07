package model;

public class Output {

    public String outputString(String str){
        return str + "\n";
    }

    public String outputListToString(HumanList list){
        String result = "";
        result = list.humanListToString();
        return result;
    }
}

