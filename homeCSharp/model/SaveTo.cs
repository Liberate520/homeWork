namespace GeekBrains;

public class SaveTo {

    public String addToTxt(ItemList list, int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                SaveToTxt txt = new SaveToTxt();
                txt.saveAs(list.get(i).itemToString());
                return "записан в Txt: " + list.get(i).itemToString() + "\n";
            }
        }
        return "Совпадений нет";
    }

    public String addToDoc(ItemList list,int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                SaveToDoc doc = new SaveToDoc();
                doc.saveAs(list.get(i).itemToString());
                return "записан в Doc: " + list.get(i).itemToString() + "\n";
            }
        }
        return "Совпадений нет";
    }
}
