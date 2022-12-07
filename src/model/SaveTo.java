package model;

public class SaveTo {

    public String addToTxt(HumanList list, int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                SaveToTxt txt = new SaveToTxt();
                txt.saveAs(list.get(i).humanToString(list.get(i)));
                return "записан в Txt: " + list.get(i).humanToString(list.get(i)) + "\n";
            }
        }
        return "Совпадений нет";
    }

    public String addToDoc(HumanList list,int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                SaveToDoc doc = new SaveToDoc();
                doc.saveAs(list.get(i).humanToString(list.get(i)));
                return "записан в Doc: " + list.get(i).humanToString(list.get(i)) + "\n";
            }
        }
        return "Совпадений нет";
    }
}
