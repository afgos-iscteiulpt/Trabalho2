package languageModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import FileReader.DataProcessor;

public class TextFileProcessor {

	public static void readNewQuestionsFile(File filesPair, File novasQuestoes) {
		LanguageModelProcessor processor = new LanguageModelProcessor(filesPair);
		try (BufferedReader br = new BufferedReader(new FileReader(novasQuestoes))) {
			String line;
			while ((line = br.readLine()) != null) {
				processor.processNewQuestion(line.substring(0, line.trim().length()-1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		processor.checkTags();
	}
}
