package view;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface ViewLight {
    void start() throws JSONException, IOException, ParseException; //старт программы
}
