public class Presenter {
    View view = new View();
    Controller controller = new Controller();
    public void start() {
        boolean exx = true;
        while (exx) {
            switch (view.menu()) {
                case 1:
                    String text = view.addTextMenu();
                    controller.addText(text);
                    break;
                case 2:
                    view.messageYourDocument();
                    controller.printText();
                    break;
                case 3:
                    int del = view.dellMenu();
                    controller.delText(del);
                    break;
                case 0:
                    System.out.println("СПАСИБО ЗА РАБОТУ\n" +
                        "ДО НОВЫХ ВСТРЕЧ");
                    exx = false;
            }
        }
    }
}
