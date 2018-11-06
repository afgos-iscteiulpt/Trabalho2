package languageModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import FileReader.DataProcessor;

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
		double probability = 1;
		String lastWord = "<s>";
		String[] stringArray = s.split("\\s");
		for (String word : stringArray) {
			probability = probability * conditionalProbabilities(word, lastWord);
			System.out.println(probability);
			lastWord = word;
		}
	}

	private double conditionalProbabilities(String word, String lastWord) {
		double lastWordFreq = 0;
		double wordAfterLastWordFreq = 0;
		double result= 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("actor_name").split("\\s")[0]));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("actor_name").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			result = wordAfterLastWordFreq / lastWordFreq;
			//======================budget=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("budget").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("budget").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================character name=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("character_name").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("character_name").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================genre=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("budget").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("budget").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================keyword=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("keyword").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("keyword").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================original language=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("original_language").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("original_language").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================original_title=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("original_title").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("original_title").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================overview=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("overview").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("overview").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//=====================person_name=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("person_name").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("person_name").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================production_company=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("production_company").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("production_company").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================production country=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("production_country").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("production_country").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================release_date=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("release_date").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("release_date").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================revenue=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("revenue").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("revenue").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================runtime=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("runtime").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("runtime").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			
			//======================spoken_language=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("spoken_language").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("spoken_language").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
			//======================vote_avg=============/
			br = new BufferedReader(new FileReader("unigrams/" + filesDirectories.get("vote_avg").split("\\s")[0]));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(lastWord)) {
					lastWordFreq = Integer.valueOf(line.split("\\s")[1]);
					break;
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("bigrams/" + filesDirectories.get("vote_avg").split("\\s")[1]));
			while ((line = br.readLine()) != null) {
				String[] stringArray = line.split("\\s");
				if (stringArray[0].equals(lastWord) && stringArray[1].equals(word)) {
					wordAfterLastWordFreq = Integer.valueOf(line.split("\\s")[2]);
					break;
				}
			}
			br.close();
			if(result < (wordAfterLastWordFreq / lastWordFreq))
				result = wordAfterLastWordFreq / lastWordFreq;
			
//			System.out.println(wordAfterLastWordFreq + "/" + lastWordFreq);
//			System.out.println("======");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
