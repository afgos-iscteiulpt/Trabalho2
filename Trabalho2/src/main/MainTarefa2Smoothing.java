package main;

import java.io.File;

import languageModel.TextFileProcessor;

public class MainTarefa2Smoothing {


	public static void main(String[] args) {
			File filesPair = new File(args[0]);
			File novasQuestoes = new File(args[1]);
			TextFileProcessor.readNewQuestionsFile(filesPair, novasQuestoes, true);
	}

}
