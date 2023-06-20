package model.converter;

import model.member.Member;
import model.memberFactory.AbstractMemberFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConverterFactory<E extends Member> {
    private Map<String, Converter<E>> converterNamingMap;
    private final String defaultConverterName = "bin";
    public ConverterFactory(AbstractMemberFactory<E> memberFactory) {

        converterNamingMap = new HashMap<>();
        converterNamingMap.put("bin", new BinaryConverter<E>());
        converterNamingMap.put("csv", new CSVConverter<E>(memberFactory));
    }
    public Converter<E> getConverter() {
        return converterNamingMap.get(defaultConverterName);
    }
    public Converter<E> getConverter(String converterName) {
        Converter<E> result = converterNamingMap.get(converterName);
        if (result == null) return getConverter();
        return result;
    }
    public List<String> getConverterNames() {
        return new ArrayList<>(converterNamingMap.keySet());
    }
    public String getConverterName(Converter<E> converter) {
        if (converter.getClass().equals(CSVConverter.class)) return "csv";
        if (converter.getClass().equals(BinaryConverter.class)) return "bin";
        return null;
    }
}
