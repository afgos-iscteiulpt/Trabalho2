package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import FileReader.DataProcessor;
import FileReader.TextFileModifier;
import FileReader2.ReadFileQuestoes;

public class Main {

	public static void main(String[] args) {
		new File("unigrams").mkdirs();
		new File("bigrams").mkdirs();
		DataProcessor processor = new DataProcessor();
		ReadFileQuestoes subprocessor = new ReadFileQuestoes();
		
		
		//Substituir palavras nos ficheiros das questoes
		
		subprocessor.ReadQuestion(new File("corpora/QuestoesConhecidas.txt"),new File("corpora/QuestoesConhecidasTest.txt"));
		
		//subprocessor.ReadQuestion(new File("corpora/NovasQuestoes.txt"), new File("corpora/NovasQuestoesTest.txt"));
		
	
		//Unigrams
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
		TextFileModifier.writeUnigramFile("unigrams/unigrams_runtime.txt", processor.getRuntime_unigram());
		TextFileModifier.writeUnigramFile("unigrams/unigrams_vote_avg.txt", processor.getVote_avg_unigram());
		
		//bigrams
		TextFileModifier.writeBigramFile("bigrams/bigrams_actor_name.txt", processor.getActor_name_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_budget.txt", processor.getBudget_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_character_name.txt", processor.getCharacter_name_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_genre.txt", processor.getGenre_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_keyword.txt", processor.getKeyword_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_original_language.txt", processor.getOriginal_language_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_original_title.txt", processor.getOriginal_title_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_overview.txt", processor.getOverview_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_person_name.txt", processor.getPerson_name_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_production_company.txt", processor.getProduction_company_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_production_country.txt", processor.getProduction_country_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_release_date.txt", processor.getRelease_date_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_revenue_bigram.txt", processor.getRevenue_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_spoken_language.txt", processor.getSpoken_language_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_runtime.txt", processor.getRuntime_bigram());
		TextFileModifier.writeBigramFile("bigrams/bigrams_vote_avg.txt", processor.getVote_avg_bigram());
		
		//smooth unigrams
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_actor_name_smooth.txt", processor.getActor_name_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_budget_smooth.txt", processor.getBudget_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_character_name_smooth.txt", processor.getCharacter_name_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_genre_smooth.txt", processor.getGenre_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_keyword_smooth.txt", processor.getKeyword_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_original_language_smooth.txt", processor.getOriginal_language_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_original_title_smooth.txt", processor.getOriginal_title_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_overview_smooth.txt", processor.getOverview_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_person_name_smooth.txt", processor.getPerson_name_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_production_company_smooth.txt", processor.getProduction_company_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_production_country_smooth.txt", processor.getProduction_country_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_release_date_smooth.txt", processor.getRelease_date_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_revenue_smooth.txt", processor.getRevenue_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_spoken_language_smooth.txt", processor.getSpoken_language_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_runtime_smooth.txt", processor.getRuntime_unigram());
		TextFileModifier.writeUnigramSmoothFile("unigrams/unigrams_vote_avg_smooth.txt", processor.getVote_avg_unigram());
	
		//smooth bigrams
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_actor_name_smooth.txt", processor.getActor_name_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_budget_smooth.txt", processor.getBudget_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_character_name_smooth.txt", processor.getCharacter_name_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_genre_smooth.txt", processor.getGenre_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_keyword_smooth.txt", processor.getKeyword_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_original_language_smooth.txt", processor.getOriginal_language_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_original_title_smooth.txt", processor.getOriginal_title_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_overview_smooth.txt", processor.getOverview_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_person_name_smooth.txt", processor.getPerson_name_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_production_company_smooth.txt", processor.getProduction_company_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_production_country_smooth.txt", processor.getProduction_country_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_release_date_smooth.txt", processor.getRelease_date_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_revenue_smooth.txt", processor.getRevenue_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_spoken_language_smooth.txt", processor.getSpoken_language_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_runtime_smooth.txt", processor.getRuntime_bigram());
		TextFileModifier.writeBigramSmoothFile("bigrams/bigrams_vote_avg_smooth.txt", processor.getVote_avg_bigram());
	
	}

}
