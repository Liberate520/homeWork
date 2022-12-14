package model;

public class Output implements Outputable {

    @Override
    public String outputString(String str){
        return str + "\n";
    }

    @Override
    public String outputListToString(ItemList list){
        String result = "";
        result = list.itemListToString();
        return result;
    }
}

