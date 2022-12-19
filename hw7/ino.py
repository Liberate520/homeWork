import pygame

class Ino(pygame.sprite.Sprite):
    """класс одного вражеского корабля"""

    def __init__(self, screen):
        """инициализируем и задаем начальную позицию"""
        super(Ino, self).__init__()
        self.screen = screen
        self.image = pygame.image.load('images/spaceship2.png')
        self.rect = self.image.get_rect()
        self.rect.x = self.rect.width
        self.rect.y = self.rect.height
        self.x = float(self.rect.x)
        self.y = float(self.rect.y)

    def draw(self):
        """вывод враж корабля на экран"""
        self.screen.blit(self.image, self.rect)

    def update(self):
        """перемещает вражеские корабли"""
        self.y += 0.1
        self.rect.y = self.y