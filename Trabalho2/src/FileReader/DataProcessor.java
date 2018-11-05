package FileReader;

import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;

public class DataProcessor {

	private String lastRead = "<s>";

	private Multiset<String> actor_name_unigram = HashMultiset.create();
	private Multiset<String> budget_unigram = HashMultiset.create();
	private Multiset<String> character_name_unigram = HashMultiset.create();
	private Multiset<String> genre_unigram = HashMultiset.create();
	private Multiset<String> keyword_unigram = HashMultiset.create();
	private Multiset<String> original_language_unigram = HashMultiset.create();
	private Multiset<String> original_title_unigram = HashMultiset.create();
	private Multiset<String> overview_unigram = HashMultiset.create();
	private Multiset<String> person_name_unigram = HashMultiset.create();
	private Multiset<String> production_company_unigram = HashMultiset.create();
	private Multiset<String> production_country_unigram = HashMultiset.create();
	private Multiset<String> release_date_unigram = HashMultiset.create();
	private Multiset<String> revenue_unigram = HashMultiset.create();
	private Multiset<String> runtime_unigram = HashMultiset.create();
	private Multiset<String> spoken_language_unigram = HashMultiset.create();
	private Multiset<String> vote_avg_unigram = HashMultiset.create();

	private Table<String, String, Integer> actor_name_bigram = HashBasedTable.create();
	private Table<String, String, Integer> budget_bigram = HashBasedTable.create();
	private Table<String, String, Integer> character_name_bigram = HashBasedTable.create();
	private Table<String, String, Integer> genre_bigram = HashBasedTable.create();
	private Table<String, String, Integer> keyword_bigram = HashBasedTable.create();
	private Table<String, String, Integer> original_language_bigram = HashBasedTable.create();
	private Table<String, String, Integer> original_title_bigram = HashBasedTable.create();
	private Table<String, String, Integer> overview_bigram = HashBasedTable.create();
	private Table<String, String, Integer> person_name_bigram = HashBasedTable.create();
	private Table<String, String, Integer> production_company_bigram = HashBasedTable.create();
	private Table<String, String, Integer> production_country_bigram = HashBasedTable.create();
	private Table<String, String, Integer> release_date_bigram = HashBasedTable.create();
	private Table<String, String, Integer> revenue_bigram = HashBasedTable.create();
	private Table<String, String, Integer> runtime_bigram = HashBasedTable.create();
	private Table<String, String, Integer> spoken_language_bigram = HashBasedTable.create();
	private Table<String, String, Integer> vote_avg_bigram = HashBasedTable.create();

	public void processQuestion(String s) {
		String[] tabSplit = s.trim().split("\\t");
		String[] stringArray = tabSplit[1].split("\\s");
		for (String word : stringArray) {
			processWord(tabSplit[0].trim(), word);
		}
		lastRead = "<s>";
	}
	
	public void processWord(String tag, String word) {
		Integer tableValue;
		word = checkLastCharacter(word);
		switch (tag) {
		case "actor_name":
			actor_name_unigram.add(word);
			tableValue = actor_name_bigram.get(lastRead, word);
			if (tableValue == null)
				actor_name_bigram.put(lastRead, word, 1);
			else
				actor_name_bigram.put(lastRead, word, tableValue+1);
			break;
		case "budget":
			budget_unigram.add(word);
			tableValue = budget_bigram.get(lastRead, word);
			if (tableValue == null)
				budget_bigram.put(lastRead, word, 1);
			else
				budget_bigram.put(lastRead, word, tableValue+1);
			break;
		case "character_name":
			character_name_unigram.add(word);
			tableValue = character_name_bigram.get(lastRead, word);
			if (tableValue == null)
				character_name_bigram.put(lastRead, word, 1);
			else
				character_name_bigram.put(lastRead, word, tableValue+1);
			break;
		case "genre":
			genre_unigram.add(word);
			tableValue = genre_bigram.get(lastRead, word);
			if (tableValue == null)
				genre_bigram.put(lastRead, word, 1);
			else
				genre_bigram.put(lastRead, word, tableValue+1);
			break;
		case "keyword":
			keyword_unigram.add(word);
			tableValue = keyword_bigram.get(lastRead, word);
			if (tableValue == null)
				keyword_bigram.put(lastRead, word, 1);
			else
				keyword_bigram.put(lastRead, word, tableValue+1);
			break;
		case "original_language":
			original_language_unigram.add(word);
			tableValue = original_language_bigram.get(lastRead, word);
			if (tableValue == null)
				original_language_bigram.put(lastRead, word, 1);
			else
				original_language_bigram.put(lastRead, word, tableValue+1);
			break;
		case "original_title":
			original_title_unigram.add(word);
			tableValue = original_title_bigram.get(lastRead, word);
			if (tableValue == null)
				original_title_bigram.put(lastRead, word, 1);
			else
				original_title_bigram.put(lastRead, word, tableValue+1);
			break;
		case "overview":
			overview_unigram.add(word);
			tableValue = overview_bigram.get(lastRead, word);
			if (tableValue == null)
				overview_bigram.put(lastRead, word, 1);
			else
				overview_bigram.put(lastRead, word, tableValue+1);
			break;
		case "person_name":
			person_name_unigram.add(word);
			tableValue = person_name_bigram.get(lastRead, word);
			if (tableValue == null)
				person_name_bigram.put(lastRead, word, 1);
			else
				person_name_bigram.put(lastRead, word, tableValue+1);
			break;
		case "production_company":
			production_company_unigram.add(word);
			tableValue = production_company_bigram.get(lastRead, word);
			if (tableValue == null)
				production_company_bigram.put(lastRead, word, 1);
			else
				production_company_bigram.put(lastRead, word, tableValue+1);
			break;
		case "production_country":
			production_country_unigram.add(word);
			tableValue = production_country_bigram.get(lastRead, word);
			if (tableValue == null)
				production_country_bigram.put(lastRead, word, 1);
			else
				production_country_bigram.put(lastRead, word, tableValue+1);
			break;
		case "release_date":
			release_date_unigram.add(word);
			tableValue = release_date_bigram.get(lastRead, word);
			if (tableValue == null)
				release_date_bigram.put(lastRead, word, 1);
			else
				release_date_bigram.put(lastRead, word, tableValue+1);
			break;
		case "revenue":
			revenue_unigram.add(word);
			tableValue = revenue_bigram.get(lastRead, word);
			if (tableValue == null)
				revenue_bigram.put(lastRead, word, 1);
			else
				revenue_bigram.put(lastRead, word, tableValue+1);
			break;
		case "runtime":
			runtime_unigram.add(word);
			tableValue = runtime_bigram.get(lastRead, word);
			if (tableValue == null)
				runtime_bigram.put(lastRead, word, 1);
			else
				runtime_bigram.put(lastRead, word, tableValue+1);
			break;
		case "spoken_language":
			spoken_language_unigram.add(word);
			tableValue = spoken_language_bigram.get(lastRead, word);
			if (tableValue == null)
				spoken_language_bigram.put(lastRead, word, 1);
			else
				spoken_language_bigram.put(lastRead, word, tableValue+1);
			break;
		case "vote_avg":
			vote_avg_unigram.add(word);
			tableValue = vote_avg_bigram.get(lastRead, word);
			if (tableValue == null)
				vote_avg_bigram.put(lastRead, word, 1);
			else
				vote_avg_bigram.put(lastRead, word, tableValue+1);
			break;
		}
		lastRead = word;
	}
	
	/**
	 * Receives a String
	 * Checks if the last charater is an interrogation point and deletes it if it is
	 */
	public String checkLastCharacter(String word) {
		if(word.charAt(word.length()-1) == '?') {
			return word.substring(0, word.length()-1);
		}
		return word;
	}
	

	public void countAllObjects(Multiset<String> set) {
		Set<String> uniqueSet = set.elementSet();
		for (String s : uniqueSet) {
			System.out.println(s + " -> " + set.count(s));
		}
	}

	public String getLastRead() {
		return lastRead;
	}

	public Multiset<String> getActor_name_unigram() {
		return actor_name_unigram;
	}

	public Multiset<String> getBudget_unigram() {
		return budget_unigram;
	}

	public Multiset<String> getCharacter_name_unigram() {
		return character_name_unigram;
	}

	public Multiset<String> getGenre_unigram() {
		return genre_unigram;
	}

	public Multiset<String> getKeyword_unigram() {
		return keyword_unigram;
	}

	public Multiset<String> getOriginal_language_unigram() {
		return original_language_unigram;
	}

	public Multiset<String> getOriginal_title_unigram() {
		return original_title_unigram;
	}

	public Multiset<String> getOverview_unigram() {
		return overview_unigram;
	}

	public Multiset<String> getPerson_name_unigram() {
		return person_name_unigram;
	}

	public Multiset<String> getProduction_company_unigram() {
		return production_company_unigram;
	}

	public Multiset<String> getProduction_country_unigram() {
		return production_country_unigram;
	}

	public Multiset<String> getRelease_date_unigram() {
		return release_date_unigram;
	}

	public Multiset<String> getRevenue_unigram() {
		return revenue_unigram;
	}

	public Multiset<String> getRuntime_unigram() {
		return runtime_unigram;
	}

	public Multiset<String> getSpoken_language_unigram() {
		return spoken_language_unigram;
	}

	public Multiset<String> getVote_avg_unigram() {
		return vote_avg_unigram;
	}

	public Table<String, String, Integer> getActor_name_bigram() {
		return actor_name_bigram;
	}

	public Table<String, String, Integer> getBudget_bigram() {
		return budget_bigram;
	}

	public Table<String, String, Integer> getCharacter_name_bigram() {
		return character_name_bigram;
	}

	public Table<String, String, Integer> getGenre_bigram() {
		return genre_bigram;
	}

	public Table<String, String, Integer> getKeyword_bigram() {
		return keyword_bigram;
	}

	public Table<String, String, Integer> getOriginal_language_bigram() {
		return original_language_bigram;
	}

	public Table<String, String, Integer> getOriginal_title_bigram() {
		return original_title_bigram;
	}

	public Table<String, String, Integer> getOverview_bigram() {
		return overview_bigram;
	}

	public Table<String, String, Integer> getPerson_name_bigram() {
		return person_name_bigram;
	}

	public Table<String, String, Integer> getProduction_company_bigram() {
		return production_company_bigram;
	}

	public Table<String, String, Integer> getProduction_country_bigram() {
		return production_country_bigram;
	}

	public Table<String, String, Integer> getRelease_date_bigram() {
		return release_date_bigram;
	}

	public Table<String, String, Integer> getRevenue_bigram() {
		return revenue_bigram;
	}

	public Table<String, String, Integer> getRuntime_bigram() {
		return runtime_bigram;
	}

	public Table<String, String, Integer> getSpoken_language_bigram() {
		return spoken_language_bigram;
	}

	public Table<String, String, Integer> getVote_avg_bigram() {
		return vote_avg_bigram;
	}

}
