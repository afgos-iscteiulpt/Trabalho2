package Main;

import java.io.File;

import FileReader.DataProcessor;
import FileReader.TextFileModifier;

public class Main {

	public static void main(String[] args) {
		new File("unigrams").mkdirs();
		new File("bigrams").mkdirs();
		DataProcessor processor = new DataProcessor();
		TextFileModifier.readFile(new File("corpora/QuestoesConhecidas.txt"), processor);
		TextFileModifier.writeUnigramFile("unigrams/unigrams_actor_name.txt", processor.getActor_name_unigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_actor_name.txt", processor.getActor_name_bigram());
	}

}
