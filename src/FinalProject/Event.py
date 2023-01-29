class Event:
    def __init__(self):
        self.events = dict()
        self.evID = 0

    def addNewEvent(self, eventYear, eventMonth, eventDay,
                    eventTime, eventType, eventDuration,
                    eventDescription):
        event = [eventYear, eventMonth, eventDay,
                 eventTime, eventType,eventDuration,
                 eventDescription]
        self.events[self.evID] = event
        self.evID += 1


    def printEventsbyMonth(self, eventYear, eventMonth):
        if len(self.events) == 0:
            print('Нет никаких событий!\n')
            return
        print('{0} {1}'.format('Мероприятия: ', self.getMonthNameByNumber
            (
            month=eventMonth,
            year=eventYear
            )).center(30, '~'))
        for key, evlist in self.events.items():
            if isinstance(evlist, list):
                if evlist[0] == eventYear and evlist[1] == eventMonth:
                    print('ID Мероприятия-{0}: {1} на {2}/{3}/{4} в {5} продолжительностью {6}.'
                          .format(key, evlist[4],
                                  evlist[0], evlist[1],
                                  evlist[2], evlist[3],
                                  evlist[5]
                                  ))
                    print('Описание: {0}'.format(evlist[6]))
                    print('\n')


    def printEventsbyDay(self, eventYear, eventMonth, eventDay):
        if len(self.events) == 0:
            print('Там нет никакого события!\n')
            return
        print('{0} {1} {2}'.format('Мероприятия: ', self.getMonthNameByNumber
            (
            month=eventMonth, year=eventYear
            ),
                                   eventDay).center(30, '~'))
        for key, evlist in self.events.items():
            if isinstance(evlist, list):
                if evlist[0] == eventYear and evlist[1] == eventMonth and evlist[2] == eventDay:
                    print('ID Мероприятия-{0}: {1} на {2}/{3}/{4} в {5} продолжительностью {6}.'
                          .format(key, evlist[4],
                                evlist[0], evlist[1],
                                evlist[2], evlist[3],
                                evlist[5]))
                    print('Мероприятия: {0}'.format(evlist[6]))
                    print('\n')

    def removeEvent(self, eventYear, eventMonth, eventDay, eventTime, eventDuration):
        if len(self.events) == 0:
            print('Там нет никакого события!\n')
            return
        print('Удаление мероприятия...')
        for key, evlist in self.events.items():
            if isinstance(evlist, list):
                if evlist[0] == eventYear and evlist[1] == eventMonth and evlist[2] == eventDay:
                    if evlist[3] == eventTime and evlist[5] == eventDuration:
                        self.events.pop(key)
                        print('Удаление успешно!')
                        break

    def removeEventByID(self, eventID):
        if len(self.events) == 0:
            print('Там нет никакого события!\n')
            return
        if self.events.get(eventID) != None:
            self.events.pop(eventID)
        else:
            print('ID мероприятия некорректен или не существует')

    # Used for updating event in the user interface
    def getEventByID(self, eventID):
        if self.events.get(eventID) == None: return 'ID мероприятия некорректен или не существует'
        return list(self.events.get(eventID))

                
    def updateEvent(self, eventID, evYear, evMonth, evDay, evTime, evType, evDuration, evDescription):
        if len(self.events) == 0:
            print('Там нет никакого события!\n')
            return 
        self.events[eventID] = [evYear, evMonth, evDay, evTime, evType, evDuration, evDescription]

    def updateEventByDay(self, eventYear, eventMonth, eventDay, eventTime, eventDuration):
        if len(self.events) == 0:
            print('Там нет никакого события!\n')
            return
        for key in self.events.keys():
            if isinstance(self.events.get(key), list):
                evList = list(self.events.get(key))
                if evList[0] == eventYear and evList[1] == eventMonth and evList[2] == eventDay:
                    self.printEventsbyDay(eventYear,eventMonth,eventDay)
                    eventID = int(input('Введите ID мероприятия: '))
                    if key+1 == eventID:
                        evList[0] = int(input('Обновить год: '))
                        evList[1] = int(input('Обновить месяц: '))
                        evList[2] = int(input('Обновить день: '))
                        evList[3] = str(input('Обновить время: '))
                        evList[4] = str(input('Обновить тип: '))
                        evList[5] = str(input('Обновить длительность: '))
                        evList[6] = str(input('Обновить описание: '))

    def getMonthNameByNumber(self, year, month):
        from Calendar import Calendar
        cal = Calendar()
        cal.printMonth(month= month, year= year)
        return cal.months[month]

    def getAllEventsDatesByDay(self):
        if len(self.events) == 0:
            print('Там нет никакого события!\n')
            return
        print('Все даты с мероприятиями ГГГГ/ММ/ДД')
        months = set()
        for key, evlist in self.events.items():
            months.add((evlist[0], evlist[1], evlist[2]))
        for year, month, day in months:
            print('>> {0}/{1}/{2}\n'.format(year, month, day) )

    def getAllEventsDatesByMonth(self):
        if len(self.events) == 0:
            print('Там нет никакого события!!\n')
            return
        print('Все даты с мероприятиями ГГГГ/ММ/ДД')
        months = set()
        for key, evlist in self.events.items():
            months.add((evlist[0], evlist[1]))
        for year, month in months:
            print('>> {0}/{1}\n'.format(year, month))

    def printAllEvents(self):
        if len(self.events) == 0:
            print('Там нет никакого события!!\n')
            return
        print('Все мероприятия')
        for key, evlist in self.events.items():
            print('ID мероприятия-{0}: {1} на {2}/{3}/{4} в {5} продолжительностью {6}.'
                  .format(key, evlist[4],
                        evlist[0], evlist[1],
                        evlist[2], evlist[3],
                        evlist[5]))
            print('Описание: {0}'.format(evlist[6]))
            print('\n')
            
    def isEmpty(self):
        isEmpty = False
        if len(self.events != 0): 
            isEmpty = False 
        else: 
            isEmpty = True
        return isEmpty
    
    def getEvents(self):
        return self.events