namespace GeekBrains;

public class Output: Outputable {

    public String outputString(String str){
        return str + "\n";
    }

    public String outputListToString(ItemList list){
        String result = "";
        result = list.itemListToString();
        return result;
    }
}

