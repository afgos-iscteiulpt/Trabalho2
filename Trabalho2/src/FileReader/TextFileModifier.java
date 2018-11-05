package FileReader;

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

public class TextFileModifier {
	
	public static void readFile(File file, DataProcessor processor) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       processor.processQuestion(line);
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeBigramFile(String fileName, Table<String, String, Integer> bigram) {
		
	}
}
