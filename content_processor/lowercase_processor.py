from .content_processor import ContentProcessor

# Принцип открытости/закрытости
class LowercaseProcessor(ContentProcessor):
    def process(self, content):
        return content.lower()
