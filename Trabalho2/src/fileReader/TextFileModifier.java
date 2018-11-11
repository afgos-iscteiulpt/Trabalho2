package fileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import com.google.common.collect.Multiset;
import com.google.common.collect.Table;

import languageModel.TextFileProcessor;

public class TextFileModifier {

	public static void readFile(File file, DataProcessor processor) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				processor.processQuestion(TextFileProcessor.treatString(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeUnigramFile(String fileName, Multiset<String> unigram) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			Set<String> uniqueSet = unigram.elementSet();
			for (String s : uniqueSet) {
				writer.write(s + " " + unigram.count(s) + "\n");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeBigramFile(String fileName, Table<String, String, Integer> bigram) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for (String row : bigram.rowKeySet())
				for (String column : bigram.columnKeySet())
					if (bigram.get(row, column) != null)
						writer.write(row + " " + column + " " + bigram.get(row, column) + "\n");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeUnigramSmoothFile(String fileName, Multiset<String> unigram) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			Set<String> uniqueSet = unigram.elementSet();
			for (String s : uniqueSet) {
				Integer value = unigram.count(s)+unigram.elementSet().size();
				writer.write(s + " " + value + "\n");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeBigramSmoothFile(String fileName, Table<String, String, Integer> bigram) {
		Integer value;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for (String row : bigram.rowKeySet()) {
				for (String column : bigram.columnKeySet()) {
					if (bigram.get(row, column) != null) {
						value = bigram.get(row, column)+1;
					} else {
						value = 1;
					}
						writer.write(row + " " + column + " " + value + "\n");
				}
			}			
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
