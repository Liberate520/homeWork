package model;

public class Output implements Outputable {

    @Override
    public String outputString(String str){
        return str + "\n";
    }

    @Override
    public String outputListToString(HumanList list){
        String result = "";
        result = list.humanListToString();
        return result;
    }
}

