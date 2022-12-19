package model;


public class Output implements IOutputable {

    @Override
    public String outputString(String str){
        return str + "\n";
    }
    @Override
    public String outputListToString(PersonList list){
        String result;
        result = list.itemListToString();
        return result;
    }
}

