package model;

public class SaveTo {
    private Output output = new Output();
    public void addToTxt(HumanList list, int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                SaveToTxt txt = new SaveToTxt();
                txt.saveAs(list.get(i).humanToString(list.get(i)));
                output.outputToConsole("записан в Txt: " + list.get(i).humanToString(list.get(i)) + "\n");
            }
        }
    }

    public void addToDoc(HumanList list,int idForMenu){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == idForMenu){
                SaveToDoc doc = new SaveToDoc();
                doc.saveAs(list.get(i).humanToString(list.get(i)));
                output.outputToConsole("записан в Doc: " + list.get(i).humanToString(list.get(i)) + "\n");
            }
        }
    }
}
