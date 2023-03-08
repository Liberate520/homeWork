class Human:
    def __init__(self, name, gender=None, dateBirth=None, dateDeath=None):
        self.__name = name
        self.__gender = gender
        self.__dateBirth = dateBirth
        self.__dateDeath = dateDeath

    def getName(self):
        return self.__name

    def setName(self, name):
        self.__name = name
