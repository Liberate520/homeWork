from .content_processor import ContentProcessor

# Принцип открытости/закрытости
class UppercaseProcessor(ContentProcessor):
    def process(self, content):
        return content.upper()
