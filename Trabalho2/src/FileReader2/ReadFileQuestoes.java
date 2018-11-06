package FileReader2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import FileReader.DataProcessor;

public class ReadFileQuestoes {

	private static Map<File, String> map = new HashMap<File, String>();
	private static File questionfile;
	private static File targetfile;

	public ReadFileQuestoes() {
		map.put(new File("recursos/list_characters.txt"), "_CHARACTER_");
		map.put(new File("recursos/list_companies.txt"), "_COMPANY_");
		map.put(new File("recursos/list_genres.txt"), "_GENRE_");
		map.put(new File("recursos/list_jobs.txt"), "_JOB_");
		map.put(new File("recursos/list_keywords.txt"), "_KEYWORD_");
		map.put(new File("recursos/list_movies.txt"), "_MOVIE_");
		map.put(new File("recursos/list_people.txt"), "_PEOPLE_");
	}

	public static void ReadQuestion(File qfile, File tfile) {
		questionfile = qfile;
		targetfile = tfile;
		try (BufferedReader br = new BufferedReader(new FileReader(questionfile))) {
			String question;
			while ((question = br.readLine()) != null) {
				ReadTargetFile(question);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ReadTargetFile(String question) {
		for (File f : map.keySet()) {
			try (BufferedReader br = new BufferedReader(new FileReader(f))) {
				String line;
				while ((line = br.readLine()) != null) {
					line = " " + line + " ";
					// System.out.println(question.matches(""+line+"\\W$"));
					if (question.contains(line)) {
						//System.out.println(question + " -" + line);

						String q2 = question;
						q2 = q2.replaceAll(line, " " + map.get(f) + " ");
						
						WriteToTargetFile(q2);

					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void WriteToTargetFile(String line) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(targetfile,true));
			writer.append(line + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
