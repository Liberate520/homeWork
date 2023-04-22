# Принцип подстановки Лисков
class FileTransformer:
    def __init__(self, file_manager, content_processor):
        self.file_manager = file_manager
        self.content_processor = content_processor

    def transform_file(self):
        content = self.file_manager.read_file()
        new_content = self.content_processor.process(content)
        self.file_manager.write_file(new_content)
