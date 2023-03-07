import abc


class Button(abc.ABC):
    def __init__(self):
        super().__init__()

    @abc.abstractmethod
    def action(self):
        pass


class ButtonEditingName:             # кнопка
    def __init__(self, consoleUI):
        self.__text = "Изменить данные о имени фамилии и отчестве"
        self.consoleUI = consoleUI

    def getText(self):
        return self.__text

    def action(self):
        print("Кому имя поменять выбери")
        print(self.consoleUI.getPrintList())
        input_command_human = int(input("Введи: ")) - 1
        input_command = input("Введите новое Ф.И.О.:\n ")
        self.consoleUI.getPresenter().setCommandFromView("editName", input_command, input_command_human)
        self.consoleUI.setPrintList(self.consoleUI.getPresenter().getPrintList())
        print(self.consoleUI.getPrintList())


class ButtonAddHuman:             # кнопка
    def __init__(self, consoleUI):
        self.__text = "Добавить человека"
        self.consoleUI = consoleUI

    def getText(self):
        return self.__text

    def action(self):
        input_command = input("Введите Ф.И.О.\n")
        self.consoleUI.getPresenter().setCommandFromView("addH", input_command, -1)
        self.consoleUI.setPrintList(self.consoleUI.getPresenter().getPrintList())
        print(self.consoleUI.getPrintList())

# ----------------------------------------------------------------------------------------------------
class Menu(abc.ABC):
    def __init__(self):
        super().__init__()

    @abc.abstractmethod
    def addButtons(self):
        pass



class MenuMain:                                     # меню
    def __init__(self, consoleUI):
        self.consoleUI = consoleUI
        self.__buttons = []
        self.addButton()

    def getButtons(self):
        return self.__buttons

    def addButton(self):
        self.getButtons().append(ButtonEditingName(self.consoleUI))
        self.getButtons().append(ButtonAddHuman(self.consoleUI))

    def __str__(self):
        for i in range(len(self.__buttons)):
            print(f"{i + 1} - {self.__buttons[i].getText()}")