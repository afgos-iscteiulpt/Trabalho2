package Main;

import java.io.File;

import languageModel.TextFileProcessor;

public class MainTarefa2 {

	public static void main(String[] args) {
			File filesPair = new File(args[0]);
			File novasQuestoes = new File(args[1]);
			TextFileProcessor.readNewQuestionsFile(filesPair, novasQuestoes);
			
	}

}
