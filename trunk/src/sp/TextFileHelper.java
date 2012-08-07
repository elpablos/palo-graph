package sp;

import java.io.*;

/**
 * Pomocna staticka trida usnadnujici praci s text. soubory.
 * Ukladani a nacitani textu.
 * @author Pavel Lorenz
 */
public class TextFileHelper {

	/**
	 * Nacitani textu z textoveho souboru.
	 * @param path cesta k souboru
	 * @return textovy retezec
	 * @throws IOException souborova vyjimka
	 */
	public static String readString(String path) throws IOException {
		// inicializujeme string Builder
		StringBuilder builder = new StringBuilder();
		// vytvorime text reader
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		String strLine;
		// nacteme cely soubor do textoveho retezce
		while ((strLine = reader.readLine()) != null) {
			builder.append(strLine);
		}
		// uzavreme proudy
		reader.close();
		// vratime textovy retezec
		return builder.toString();
	}
	
	/**
	 * Ukladani textu do textoveho souboru.
	 * @param path cesta k souboru
	 * @param outputText textovy retezec
	 * @throws IOException souborova vyjimka
	 */
	public static void writeString(String path, String outputText) throws IOException {
		// vytvorime text writer
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
		// zapiseme
		writer.write(outputText);
		// uzavreme proudy
		writer.close();
	}
}
