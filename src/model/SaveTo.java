package model;


public class SaveTo {

    public String addToTxt(PersonList list, int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                SaveToTxt txt = new SaveToTxt();
                txt.saveAs(list.get(i).itemToString());
                return "записан в Txt: " + list.get(i).itemToString() + "\n";
            }
        }
        return "Совпадений нет";
    }

    public String addToCsv(PersonList list, int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                SaveToCSV csv = new SaveToCSV();
                csv.saveAs(list.get(i).itemToString());
                return "записан в Doc: " + list.get(i).itemToString() + "\n";
            }
        }
        return "Совпадений нет";
    }
}
