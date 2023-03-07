from project_tree_lite_python_oop.gui.MenuButton import MenuMain


class View:
    def setPresenter(self, presenter):
        raise "Error, задайте метод"

    def start(self):
        raise "Error, задайте метод"


class ConsoleUi(View):
    def __init__(self):
        self.__printList = None
        self.menu = MenuMain(self)
        self.presenter = None

    def getPrintList(self):
        return self.__printList

    def setPrintList(self, printList):
        self.__printList = printList

    def getPresenter(self):
        return self.presenter

    def start(self):
        self.presenter.setCommandFromView("load", "", -1)
        self.setPrintList(self.getPresenter().getPrintList())
        flag = False
        while not flag:

            self.menu.__str__()
            print("exit - выход")
            i_c = input("Введите: ")
            if i_c == "exit":
                flag = True
            else:
                self.menu.getButtons()[int(i_c) - 1].action()

    def setPresenter(self, presenter):
        self.presenter = presenter
        self.__printList = presenter.getPrintList()
