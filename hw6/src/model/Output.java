package model;

public class Output {
    public String outputStr(String str){
        return str + "\n";
    }

    public String outputPrintList(HumanList list){
        String result = "";
        result = list.printHumanList();
        return result;
    }
}
