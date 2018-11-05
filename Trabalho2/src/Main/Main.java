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
		TextFileModifier.writeUnigramFile("unigrams/unigrams_budget.txt", processor.getBudget_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_character_name.txt", processor.getCharacter_name_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_genre.txt", processor.getGenre_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_keyword.txt", processor.getKeyword_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_original_language.txt", processor.getOriginal_language_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_original_title.txt", processor.getOriginal_title_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_overview.txt", processor.getOverview_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_person_name.txt", processor.getPerson_name_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_production_company.txt", processor.getProduction_company_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_production_country.txt", processor.getProduction_country_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_release_date.txt", processor.getRelease_date_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_revenue_unigram.txt", processor.getRevenue_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_spoken_language.txt", processor.getSpoken_language_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_vote_avg.txt", processor.getVote_avg_unigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_.txt", processor.getActor_name_bigram());
	}

}
