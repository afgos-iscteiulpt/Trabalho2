package languageModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import FileReader.DataProcessor;
import resources.Tags;

public class LanguageModelProcessor {

	Map<String, String> filesDirectories = new HashMap<>();

	public LanguageModelProcessor(File filesPair) {

		try (BufferedReader br = new BufferedReader(new FileReader(filesPair))) {
			String line;
			while ((line = br.readLine()) != null) {
				processConfigLine(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processConfigLine(String line) {
		filesDirectories.put(line.substring(0, line.indexOf(' ')), line.substring(line.indexOf(' ')).trim());
	}

	public void processNewQuestion(String s) {
		double probability;
		double higherProbability = 0;
		String tag = Tags.actor_name.toString();
		String[] stringArray = s.split("\\s");
		for (Tags t : Tags.values()) {
			probability=1;
			String lastWord = "<s>";
			for (String word : stringArray) {
				probability = probability * conditionalProbabilities(t.toString(), word, lastWord);
				lastWord = word;
			}
			if (probability> higherProbability) {
				higherProbability = probability;
				tag = t.toString();
			}
		}
		System.out.println(tag);
	}

	private double conditionalProbabilities(String tag, String word, String lastWord) {
		double lastWordFreq = 0;
		double wordAfterLastWordFreq = 0;
		try {
			BufferedReader br = new BufferedReader(
					new FileReader("unigrams/" + filesDirectories.get(tag).split("\\s")[0]));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get(tag).split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (lastWordFreq != 0 && wordAfterLastWordFreq!=0)
			return wordAfterLastWordFreq / lastWordFreq;
		else
			return conditionalProbabilitiesException(tag);
	}

	private double conditionalProbabilitiesException(String tag) {
		double counter = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get(tag).split("\\s")[0]));
			while (reader.readLine() != null) {
				counter++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 1.0/counter;
	}
}
