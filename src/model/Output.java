package model;

@SuppressWarnings("unused")
public class Output {

    public String outputString(String str){
        return str + "\n";
    }

    public String outputListToString(PersonList list){
        String result = "";
        result = list.personListToString();
        return result;
    }
}

