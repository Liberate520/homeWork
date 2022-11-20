public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
    }
    public void onClick(){
       model.setText(view.getText());
       String res = model.execute();
       view.print(res);
    }
}
