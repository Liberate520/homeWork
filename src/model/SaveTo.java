package model;

@SuppressWarnings("ALL")
public class SaveTo {

    public String addToTxt(PersonList list, int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                SaveToTxt txt = new SaveToTxt();
                txt.saveAs(list.get(i).personToString(list.get(i)));
                return "записан в Txt: " + list.get(i).personToString(list.get(i)) + "\n";
            }
        }
        return "Совпадений нет";
    }

    public String addToCSV(PersonList list, int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                SaveToCSV csv = new SaveToCSV();
                csv.saveAs(list.get(i).personToString(list.get(i)));
                return "записан в Csv: " + list.get(i).personToString(list.get(i)) + "\n";
            }
        }
        return "Совпадений нет";
    }
}
