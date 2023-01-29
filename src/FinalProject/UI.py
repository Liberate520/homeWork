from Calendar import Calendar
from Event import Event
import os

class UserInterface:

    def __init__(self):
        self.events = Event()
        self.calendar = Calendar()
        self.year = int()
        self.month = int()
        self.day = int()
        self.eventID = int()


    def clearConsole(self):
        command = 'clear'
        if os.name in ('nt', 'dos'):  # Если компьютер работает под управлением Windows, используйте cls
            command = 'cls'
        os.system(command)

    def mainMenu(self):
        print('\n~~~~Добро пожаловать в ваш личный органайзер~~~~\n')
        print('~~~ 1 - Печать годового календаря  (1921 - 2100)')
        print('~~~ 2 - Печать месячного календаря (1 - 12)')
        print('~~~ 3 - Печать всех мероприятий')
        print('~~~ 4 - Печать месяца с мероприятиями')
        print('~~~ 5 - Печать дней с мероприятиями')
        print('~~~ 6 - Выход')

        option = int(input('\nВведите команду: '))

        if option == 1:
            self.printYear()
        elif option == 2:
            self.printMonth()
        elif option == 3:
            self.printAllEvents()
        elif option == 4:
            self.printMonthEvent()
        elif option == 5:
            self.printDayEvent()
        elif option == 6:
            return
        else:
            self.clearConsole()
            self.mainMenu()

    def eventMenu(self):
        print('>> 1 - Добавить новое мероприятие?')
        print('>> 2 - Обновить мероприятие?')
        print('>> 3 - Удалить мероприятие?')
        print('>> 0 - Возврат в главное меню')
        option = int(input('\n Выбери команду: '))
        if option == 1:
            self.addNewEvent()
        elif option == 2:
            self.updateEvent()
        elif option == 3:
            self.removeEvent()
        elif option == 0:
            self.mainMenu()

    def eventsMenu(self):
        print('>> 1 - Изменить мероприятие?')
        print('>> 0 - ВОзврат в главное меню')
        opt = int(input('\nВыбери команду: '))
        if opt == 0:
            self.mainMenu()
        elif opt == 1:
            self.eventMenu()
        else:
            print('Неправильный выбор! Пожалуйста, внимательно проверьте и повторите попытку!')
            self.eventsMenu()

    def printYear(self):
        year = int(input('\nВведите год (1921 - 2100): \n'))
        self.calendar.printYear(int(year))
        self.backToMainMenu()

    def printMonth(self):
        year = int(input('\nВведите год (1921 - 2100): \n'))
        month = int(input('\nВведите месяц (1 - 12): \n'))
        self.calendar.printMonth(int(year), int(month))
        self.backToMainMenu()

    def printDayEvent(self):
        self.events.getAllEventsDatesByDay()
        self.year = int(input('\nВведите год (1921 - 2100): \n'))
        self.month = int(input('\Введите месяц (1 - 12): \n'))
        self.day = int(input('\nВведите число: \n'))
        self.events.printEventsbyDay(int(self.year),int(self.month),int(self.day))
        self.eventsMenu()

    def printMonthEvent(self):
        self.events.getAllEventsDatesByMonth()
        self.year = int(input('\nВведите год (1921 - 2100): \n'))
        self.month = int(input('\nВведите месяц (1 - 12): \n'))
        self.events.printEventsbyMonth(int(self.year), int(self.month))
        self.eventsMenu()
        self.eventMenu()
    
    def addNewEvent(self):
        year = int(input('\nВведите год нового мероприятия (1921 - 2100): \n'))
        month = int(input('\nВведите месяц нового мероприятия (1 - 12): \n'))
        day = int(input('\nВведите день нового мероприятия: \n'))
        time = str(input('\nВведите время нового мероприятия: \n'))
        type = str(input('\nВведите тип нового мероприятия: \n'))
        duration = str(input('\nВведите продолжитеьность нового мероприятия: \n'))
        descr = str(input('\nВведите описание нового мероприятия: \n'))
        self.events.addNewEvent(eventYear=int(year),eventMonth=int(month),
                                eventDay=int(day), eventTime= str(time),eventType=str(type),
                                eventDuration=str(duration),eventDescription=str(descr))
        print('Мероприятияе добавлено успешно!\n')
        self.backToMainMenu()
    
    def updateEvent(self):
        eventID = int(input('\nПожалуста введите ID мероприятия: '))
        eventList = list(self.events.getEventByID(eventID))
        print('>> 1 - Редактировать год, месяц или день?')
        print('>> 2 - Редактировать время?')
        print('>> 3 - Редактировать тип?')
        print('>> 4 - Редактировать описание?')
        print('>> 5 - Редактировать продолжительность?')
        print('>> 6 - Редактировать все элементы мероприятия?')
        print('>> 0 - Возврат в главное меню')
        option = int(input('\nВведите число: '))
        if option == 1:
            year = int(input('\nВведите новый год (1921 - 2100): '))
            month = int(input('\nВведите новй месяц (1 - 12): '))
            day = int(input('\nВведите новый день: '))
            self.events.updateEvent(eventID=eventID,evYear=year, evMonth=month,
                                    evDay=day, evType=eventList[4], evTime=eventList[3],
                                    evDuration=eventList[5], evDescription=eventList[6])
            print('Мероприятие успешно обновлено!')
            self.backToMainMenu()
        elif option == 2:
            time = str(input('\nВведите новое время: '))
            self.events.updateEvent(eventID=eventID,evYear=eventList[0], evMonth=eventList[1],
                                    evDay=eventList[2], evType=eventList[4], evTime=time,
                                    evDuration=eventList[5], evDescription=eventList[6])
            print('Мероприятие успешно обновлено!')
            self.backToMainMenu()
        elif option == 3:
            type = str(input('\nВведите новый тип: '))
            self.events.updateEvent(eventID=eventID,evYear=eventList[0], evMonth=eventList[1],
                                    evDay=eventList[2], evType=type, evTime=eventList[3],
                                    evDuration=eventList[5], evDescription=eventList[6])
            print('Мероприятие успешно обновлено!')
            self.backToMainMenu()
        elif option == 4:
            duration = str(input('\nВведите новое описание: '))
            self.events.updateEvent(eventID=eventID,evYear=eventList[0], evMonth=eventList[1],
                                    evDay=eventList[2], evType=eventList[4], evTime=eventList[3],
                                    evDuration=duration, evDescription=eventList[6])
            print('Мероприятие успешно обновлено!')
            self.backToMainMenu()
        elif option == 5:
            description = str(input('\nВведите новую продолжительность: '))
            self.events.updateEvent(eventID=eventID,evYear=eventList[0], evMonth=eventList[1],
                                    evDay=eventList[2], evType=eventList[4], evTime=eventList[3],
                                    evDuration=eventList[5], evDescription=description)
            print('Мероприятие успешно обновлено!!')
            self.backToMainMenu()
        elif option == 6:
            year = int(input('\nВведите новый год (1921 - 2100): '))
            month = int(input('\nВведите новый месяц (1 - 12): '))
            day = int(input('\nВведите новый день: '))
            time = str(input('\nВведите новое время: '))
            type = str(input('\nВведите новый тип: '))
            duration = str(input('\nВведите новое описание: '))
            description = str(input('\nВведите новую продолжительность: '))
            self.events.updateEvent(eventID=eventID,evYear=year, evMonth=month, evDay=day,
                                    evDescription=description, evDuration=duration,
                                    evTime=time, evType=type)
            print('Мероприятие успешно обновлено!')
            self.backToMainMenu()
        else:
            self.backToMainMenu()

    def printAllEvents(self):
        if len(self.events.getEvents()) == 0:
            print('В системе пока нет мероприятий!')
            print('Хотите добавить новое мероприятие?')
            print('\n >> 1 - Да'
                  '\n >> 2 - Нет'
                  '\n >> 0 - Возврат в главное меню')
            option = int(input('\n Сделайте выбор: '))
            if option == 0:
                return self.mainMenu()
            elif option == 1:
                return self.addNewEvent()
            else:
                self.backToMainMenu()
        else:
            self.events.printAllEvents()
            self.backToMainMenu()

    def removeEvent(self):
        self.events.printAllEvents()
        eventID = int(input('Введите ID мероприятия для удаления: '))
        self.events.removeEventByID(eventID)
        self.backToMainMenu()

    def backToMainMenu(self):
        print('Нажмите 0, затем Enter для возврата в главное меню')
        userIn = int(input('\n >> 0 = Возврат в главное меню\n'))
        if userIn == 0:
            self.clearConsole()
            self.mainMenu()
        else:
            print('Неправильный выбор!\n')
            self.backToMainMenu()