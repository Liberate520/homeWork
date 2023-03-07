from project_tree_lite_python_oop.model.Human import Human
from project_tree_lite_python_oop.model.Tree import Tree
from abc import ABC, abstractmethod


class FileManipulator(ABC):  # родительский класс с абстрактными методами
    def __init__(self):
        super().__init__()

    @abstractmethod
    def write(self, tree):
        pass

    @abstractmethod
    def read(self, name_file) -> Tree:
        pass


class TreeHandlerTXT (FileManipulator):   # класс наследник
    def __init__(self):
        super().__init__()

    def write(self, tree):
        print("запись..")
        with open("file.txt", "w", encoding="utf-8") as file_file:
            string_write = ""
            for i in tree.getBigFamily():
                string_write += i.getName() + ","

            file_file.write(tree.getNameFamily() + "\n")
            file_file.write(string_write[:-1])

    def read(self, name_file) -> Tree:
        with open(name_file, "r", encoding="utf-8") as file_file:
            nameTree = file_file.readline().rstrip()
            namesHuman = file_file.readline().split(",")

        tree = Tree(nameTree)
        for i in namesHuman:
            tree.getBigFamily().append(Human(i))

        return tree










