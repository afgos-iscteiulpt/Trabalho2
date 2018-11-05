package Main;

import java.io.File;

import FileReader.TextFileReader;

public class main {

	public static void main(String[] args) {
		TextFileReader.readFile(new File("corpora/QuestoesConhecidas.txt"));
	}

}
