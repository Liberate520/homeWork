package view;

import java.io.IOException;

public interface View {
	void start() throws IOException, ClassNotFoundException;
	void answer(String text);
}
