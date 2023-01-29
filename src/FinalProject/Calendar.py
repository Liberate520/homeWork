import Event
class Calendar:

    def __init__(self):
        self.events = {}
        self.calendar = dict()
        self.years = range(1921, 2100)
        self.months = {
            1:"Янв", 2:"Февр", 3:"Март",
            4:"Апр", 5:"Май", 6:"Июнь",
            7:"Июль", 8:"Авг", 9:"Сент",
            10:"Окт", 11:"Нояб", 12:"Дек"
        }
        self.days = {
          1:range(1,32), 2:range(1,29), 3:range(1,32),
          4:range(1,31), 5:range(1,32), 6:range(1,31),
          7:range(1,32), 8:range(1,32), 9:range(1,31),
          10:range(1,32), 11:range(1,31), 12:range(1,32)
        }
        self.weekDays = ['Пн', 'Вт', 'Ср', 'Чт', 'Пт', 'Сб', 'Вс']
        self.weekDayStart = 5
        self.weekDayStarts = 0
        self.buildCalendar()


    def isLeapYear(self, year):
        if year % 4 == 0:
            if year % 100 == 0:
                if year % 400 == 0:
                    return True
                else:
                    return False
            else:
                return True
        else:
            return False
        
    def buildCalendar(self):
        for year in self.years:
            if (self.isLeapYear(year)):
                self.days[2] = range(1,30)
            else:
                self.days[2] = range(1,29)
            self.calendar[year] = dict()
            for month_key in self.months:
                    self.calendar[year][month_key] = dict()
                    for day in self.days.get(month_key):
                        self.calendar[year][month_key] = (self.weekDays[self.weekDayStart], day)
                        self.weekDayStart += 1
                        if self.weekDayStart == 7:
                            self.weekDayStart = 0

    def calculateWeekDayStarts(self, lastDay, lastWeekDay):
        lastWD = 0
        monthRange = range(1, lastDay+1)
        lastWD = self.weekDays.index(lastWeekDay)
        for day in monthRange:
            if lastWD == 0:
                lastWD = 7
            elif lastWD == 7:
                lastWD = 0
            lastWD -= 1
        return lastWD+1



    def printMonth(self, year, month):
        print('{0} {1}'.format(self.months.get(month), year).center(40, '-'))
        print(''.join(['{0:<6}'.format(weekDay) for weekDay in self.weekDays]))
        tempMonths = dict(self.calendar.get(year))
        tempDays = tuple(tempMonths.get(month))
        self.weekDayStarts = self.calculateWeekDayStarts(tempDays[1],tempDays[0])
        if self.weekDayStarts == 7: self.weekDayStarts = 0
        print('{0:<6}'.format('') * self.weekDayStarts, end='')
        for day in range(1,tempDays[1]+1):
            print('{0:<6}'.format(day), end='')
            self.weekDayStarts +=1
            if self.weekDayStarts == 7:
                print()
                self.weekDayStarts = 0
        print('\n')

    def printYear(self, year):
        yearTemp = dict(self.calendar.get(year))
        print('{0}'.format(year).center(40, '='))
        for month in yearTemp.keys():
            monthTemp = tuple(yearTemp[month])
            print('{0}'.format(self.months.get(month).center(40, '~')))
            self.weekDayStarts = self.calculateWeekDayStarts(monthTemp[1], monthTemp[0])
            if self.weekDayStarts == 7: self.weekDayStarts = 0
            print(''.join(['{0:<6}'.format(weekDay) for weekDay in self.weekDays]))
            print('{0:<6}'.format('') * self.weekDayStarts, end='')
            for day in range(1, monthTemp[1]+1):
                print('{0:<6}'.format(day), end='')
                self.weekDayStarts += 1
                if self.weekDayStarts == 7:
                    print()
                    self.weekDayStarts = 0
            print('\n')