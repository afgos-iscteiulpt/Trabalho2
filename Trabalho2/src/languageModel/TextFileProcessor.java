package languageModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileProcessor {

	public static void readNewQuestionsFile(File filesPair, File novasQuestoes, boolean smoothing) {
		LanguageModelProcessor processor = new LanguageModelProcessor(filesPair);
		try (BufferedReader br = new BufferedReader(new FileReader(novasQuestoes))) {
			String line;
			while ((line = br.readLine()) != null) {
				processor.processNewQuestion(treatString(line), smoothing);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		processor.checkTags();
	}
	
	public static String treatString(String s) {
		return s.trim().replaceAll("[.?!]", "");
	}
}
