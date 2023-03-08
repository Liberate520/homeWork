from project_tree_lite_python_oop.gui.MenuButton import MenuMain


class View:
    def setPresenter(self, presenter):
        raise "Error, задайте метод"

    def start(self):
        raise "Error, задайте метод"


class ConsoleUi(View):
    def __init__(self):
        self.__printList = None
        self.__menu = MenuMain(self)
        self.__presenter = None

    def getPrintList(self):
        return self.__printList

    def setPrintList(self, printList):
        self.__printList = printList

    def getPresenter(self):
        return self.__presenter

    def start(self):
        self.__presenter.setCommandFromView("load", "", -1)
        self.setPrintList(self.getPresenter().getPrintList())
        flag = False
        while not flag:
            self.__menu.__str__()
            print("exit - выход")
            i_c = input("Введите: ")
            if i_c == "exit":
                flag = True
            else:
                self.__menu.getButtons()[int(i_c) - 1].action()

    def setPresenter(self, presenter):
        self.__presenter = presenter
        self.__printList = presenter.getPrintList()
