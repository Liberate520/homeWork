public class Main {
    public static void main(String[] args) {
        Presenter sum = new Presenter(new ModelAmount(), new View());
        Presenter sub = new Presenter(new ModelSub(), new View());
        Presenter mult = new Presenter(new ModelMult(), new View());
        Presenter div = new Presenter(new ModelDiv(), new View());

        View c = new View(sum, sub, mult, div);

        c.ViewStart(sum, sub, mult, div);
    }
}