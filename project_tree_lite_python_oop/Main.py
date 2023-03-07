from project_tree_lite_python_oop.gui import *
from project_tree_lite_python_oop.gui import ConsoleUI
from project_tree_lite_python_oop.model.Human import *
from project_tree_lite_python_oop.model.PrintHuman import PrintHuman
from project_tree_lite_python_oop.model.Tree import *
from project_tree_lite_python_oop.model.communication.SystemModelCommunication import SystemModelCommunication
from project_tree_lite_python_oop.model.file.File import TreeHandlerTXT
from project_tree_lite_python_oop.presenter.Presenter import Presenter


def main():
    #hum1 = Human("Вася Пупкин")
    #hum2 = Human("Дядя Федор")
    #hum3 = Human("Сосед Ежик")
    #hum4 = Human("Какой то человек")
#
    #tree = Tree("Лица")
    #tree.getBigFamily().append(hum1)
    #tree.getBigFamily().append(hum2)
    #tree.getBigFamily().append(hum3)
    #tree.getBigFamily().append(hum4)

    view = ConsoleUI.ConsoleUi()
    serv = SystemModelCommunication()
    presenter = Presenter(view, serv)

    view.start()


if __name__ == '__main__':
    main()
