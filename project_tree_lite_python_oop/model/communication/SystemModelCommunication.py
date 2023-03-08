from project_tree_lite_python_oop.model.AddHuman import AddHuman
from project_tree_lite_python_oop.model.EditingName import EditingName
from project_tree_lite_python_oop.model.PrintHuman import PrintHuman
from project_tree_lite_python_oop.model.Tree import Tree
from project_tree_lite_python_oop.model.file.File import TreeHandlerTXT


class Service:  # типа интерфейс
    def communicator(self, command, text, index):
        raise "Err, задайте метод"

    def getAListPrintHuman(self):
        raise "Err, задайте метод"


class SystemModelCommunication(Service):
    def __init__(self):
        self.__tree = Tree()

    def getAListPrintHuman(self):
        return PrintHuman(self.__tree).getAListPrintHuman()

    def communicator(self, command, text, index):
        if command == "load":
            self.__tree = TreeHandlerTXT().read("file.txt")
        elif command == "addH":
            AddHuman().addHuman(text, self.__tree)
            TreeHandlerTXT().write(self.__tree)
        elif command == "editName":
            EditingName().editingName(text, index, self.__tree)
