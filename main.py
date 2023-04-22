from file_manager.file_manager import FileManager
from content_processor.lowercase_processor import LowercaseProcessor
from content_processor.uppercase_processor import UppercaseProcessor
from transformers.file_transformer import FileTransformer

# Принцип разделения интерфейса и инверсии зависимостей
def main():
    file_manager = FileManager('test_file.txt')
    content_processor = LowercaseProcessor()  # или UppercaseProcessor()

    file_transformer = FileTransformer(file_manager, content_processor)
    file_transformer.transform_file()

if __name__ == "__main__":
    main()
