import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void onGetMember(String name){
        Mammal answer = service.getMember(name);
        if (answer != null)
            view.print(answer.toString());
        else
            view.print("Member with name " + name + " not found");
    }

    public void onGetTree(){
        FamilyTree answer = service.getTree();
        if (answer != null)
            view.print(answer.toString());
        else
            view.print("Family tree not found");
    }

    public void onGetTree(String index){

        FamilyTree answer = service.getTree(index);
        if (answer != null)
            view.print(answer.toString());
        else
            view.print("Incorrect input");
    }

    public void onGetTreeNames(){
        List<String> answerList = service.getTreeNames();
        if (answerList != null)
            for (int i = 0; i < answerList.size(); i++) {
                view.print("\t" + String.format("%d", i + 1) + " - " +answerList.get(i));
            }
    }

    public void onSortTree(int sortType){
        service.sortTree(sortType);
        onGetTree();
    }

    public void onSaveTree(int fileType){
        String answer = service.saveTree(fileType);
        view.print(answer);
    }

    public void onLoadTree(int fileType){
        String answer = service.loadTree(fileType);
        view.print(answer);
    }
}