class Tree:
    def __init__(self, nameFamily=""):
        self.__nameFamily = nameFamily
        self.__bigFamily = []

    def getNameFamily(self):
        return self.__nameFamily

    def getBigFamily(self):
        return self.__bigFamily
