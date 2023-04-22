from abc import ABC, abstractmethod

# Принцип открытости/закрытости
class ContentProcessor(ABC):
    @abstractmethod
    def process(self, content):
        pass
