package menu;

import buttons.*;

//контроллер для инициализации
public class LoadMenu {

    public static MenuButton execute(){
        MainButton mainButton = new MainButton();
        CreateButton createButton = new CreateButton(mainButton);
        SaveButton saveButton = new SaveButton(mainButton);

        CreateHumanButton createHumanButton = new CreateHumanButton(createButton);
        CreateCatButton createCatButton = new CreateCatButton(createButton);

        SavePdfButton savePdfButton = new SavePdfButton(saveButton);
        SaveXlsButton saveXlsButton = new SaveXlsButton(saveButton);

//        setMainButton(mainButton);
        return mainButton;
    }
}
