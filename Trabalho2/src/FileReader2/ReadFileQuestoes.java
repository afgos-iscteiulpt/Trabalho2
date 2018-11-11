package FileReader2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import fileReader.DataProcessor;

public class ReadFileQuestoes {

	private Map<File, String> map = new HashMap<File, String>();
	private File questionfile;
	private File targetfile;

	public ReadFileQuestoes() {
		map.put(new File("recursos/list_characters.txt"), "_CHARACTER_");
		map.put(new File("recursos/list_companies.txt"), "_COMPANY_");
		map.put(new File("recursos/list_genres.txt"), "_GENRE_");
		map.put(new File("recursos/list_jobs.txt"), "_JOB_");
		map.put(new File("recursos/list_keywords.txt"), "_KEYWORD_");
		map.put(new File("recursos/list_movies.txt"), "_MOVIE_");
		map.put(new File("recursos/list_people.txt"), "_PEOPLE_");
	}

	public void ReadQuestion(File qfile, File tfile) {
		questionfile = qfile;
		targetfile = tfile;
		targetfile.delete();
		try (BufferedReader br = new BufferedReader(new FileReader(qfile))) {
			String question;
			while ((question = br.readLine()) != null) {
				ReadTargetFile(question);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ReadTargetFile(String question) {
		String[] splitquestion = question.split("\t");

		String q1;

		if (splitquestion.length == 1) {
			q1 = splitquestion[0];
		} else {
			q1 = splitquestion[1];
		}
		System.out.println(q1);

		Map<String, String> possibleMatches = new HashMap<String, String>();
		for (File f : map.keySet()) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"))) {
				String line;
				while ((line = br.readLine()) != null && line.trim().length() != 0) {
					String regexWord = GetRegexWordPattern(line);
					String pattern ="(.*)(^"+ regexWord + "[\\s|\\W|\\n]|[\\s|\\t]" + regexWord + "[\\s|\\W]|[\\s|\\t]" + regexWord +"$)(.*)";
					if (q1.matches(pattern)) {
						possibleMatches.put(line, map.get(f));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		CheckForSubstrings(possibleMatches);
		String replaced = q1;
		for (String g : possibleMatches.keySet()) {
			replaced = replaced.replaceAll(g, possibleMatches.get(g));
		}
		if (splitquestion.length > 1) {
			replaced = splitquestion[0] + "\t" + replaced;
		}

		if (!possibleMatches.isEmpty()) {
			WriteToTargetFile(replaced);
		}

	}

	public void CheckForSubstrings(Map<String, String> matches) {
		Map<String, String> map2 = matches;
		try {
			Iterator it = matches.keySet().iterator();
			while (it.hasNext()) {
				String g1 = (String) it.next();
				for (String g2 : matches.keySet()) {
					if (g2.contains(g1) && !g2.equals(g1)) {
						it.remove();
						break;
					}
				}
			}
		} catch (ConcurrentModificationException e) {
			e.printStackTrace();
		}

		return;
	}

	public String GetRegexWordPattern(String word) {
		String regexRestrictions = "[^A-z0-9|\\s|\\W]|\\.";
		String regexword = "";
		String[] characters = word.split("");
		for (String g : characters) {
			String g1 = g;
			if (g.matches(regexRestrictions)) {

				g1 = "\\" + g;
			}
			regexword += g1;
		}

		return regexword;
	}

	public void WriteToTargetFile(String line) {
		try {
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(targetfile.getAbsolutePath(), true), "UTF-8"));
			writer.append(line + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
