public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void onGetMember(String city){
        Mammal answer = service.getMember(city);
        view.print(answer.toString());
    }

    public void onGetTree(){
        FamilyTree answer = service.getTree();
        view.print(answer.toString());
    }
}