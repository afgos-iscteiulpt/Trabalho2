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
			break;
		case "character_name":
			character_name_unigram.add(word);
			break;
		case "genre":
			genre_unigram.add(word);
			break;
		case "keyword":
			keyword_unigram.add(word);
			break;
		case "original_language":
			original_language_unigram.add(word);
			break;
		case "original_title":
			original_title_unigram.add(word);
			break;
		case "overview":
			overview_unigram.add(word);
			break;
		case "person_name":
			person_name_unigram.add(word);
			break;
		case "production_company":
			production_company_unigram.add(word);
			break;
		case "production_country":
			production_country_unigram.add(word);
			break;
		case "release_date":
			release_date_unigram.add(word);
			break;
		case "revenue":
			revenue_unigram.add(word);
			break;
		case "runtime":
			runtime_unigram.add(word);
			break;
		case "spoken_language":
			spoken_language_unigram.add(word);
			break;
		case "vote_avg":
			vote_avg_unigram.add(word);
			break;
		}
		lastRead = word;
	}
	

	public void countAllObjects(Multiset<String> set) {
		Set<String> uniqueSet = set.elementSet();
		for (String s : uniqueSet) {
			System.out.println(s + " -> " + set.count(s));
		}
	}

}
