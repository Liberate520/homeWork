class PrintHuman:
    def __init__(self, tree):
        self.__tree = tree

    def getTree(self):
        return self.__tree

    def getAListPrintHuman(self):
        human_list = ""
        for i in range(len(self.__tree.getBigFamily())):
            human_list += f'{i + 1} - {self.__tree.getBigFamily()[i].getName()}\n'
        return human_list
