package Main;

import java.io.File;

import FileReader.TextFileModifier;

public class main {

	public static void main(String[] args) {
		TextFileModifier.readFile(new File("corpora/QuestoesConhecidas.txt"));
	}

}
