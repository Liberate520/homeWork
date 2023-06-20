package model.converter;

import model.member.Member;

import java.util.Arrays;
import java.util.List;

public class ConverterFactory<E extends Member> {
    // TODO: maybe change this to enum or use some kind of map for store converters or ...
    public Converter<E> getConverter() {
        return new BinaryConverter<E>();
    }
    public Converter<E> getConverter(String converterName) {
        switch (converterName) {
            case "csv":
                return (Converter<E>) new CSVConverter();
            case "bin":
            default:
                return getConverter();
        }
    }
    public List<String> getConverterNames() {
        return Arrays.asList("csv", "bin");
    }
    public String getConverterName(Converter<E> converter) {
        if (converter.getClass().equals(CSVConverter.class)) return "csv";
        if (converter.getClass().equals(BinaryConverter.class)) return "bin";
        return null;
    }
}
