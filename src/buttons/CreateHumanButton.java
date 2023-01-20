package buttons;

import menu.ButtonView;
import menu.Controller;
import tree.Cat;
import tree.Gender;

public class CreateHumanButton extends MenuButton<CreateHumanButton> {
//    subMenuButtons = new ArrayList<buttons.MenuButton>();
    public CreateHumanButton(MenuButton parent) {
        this.parent = parent;
        this.buttonName = "Создать человека";
        this.addChildToParent();
    }

    private void addChildToParent(){
        if (this.parent.subMenuButtons.size() == 0){
            this.parent.subMenuButtons.add(new ExitButton(this.parent.parent));
        }
        this.parent.subMenuButtons.add(this);
    }

    public void execute() {
        if (getSubMenuButtons().size() == 0){
            Gender genderType = null;
            ButtonView buttonView = new ButtonView();
            String name = buttonView.getInfo("Имя");
            String gender = buttonView.getInfo("Пол (м/ж)");
            if (gender.equalsIgnoreCase("м")){
                genderType = Gender.Male;
            } else if (gender.equalsIgnoreCase("ж")) {
                genderType = Gender.Female;
            }
            else {
                gender = buttonView.getInfo("Имя");
            }
            Integer age = Integer.parseInt(buttonView.getInfo("Возраст"));

            System.out.println("\nСоздан человек:\n" + new Cat(name, genderType, age) + "\n");
        } else {
            for (int i = 0; i < getSubMenuButtons().size(); i++) {
                System.out.println("\n" + i + getSubMenuButtons().get(i));
            }
        }
    }

    @Override
    public String toString() {
        return getButtonName();
    }
}