import java.io.BufferedReader;

import java.io.FileReader;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

public class SyntaxChecker {

	public static void main(String[] args) {


		try {
			
			BufferedReader br = new BufferedReader(new FileReader("src/Sample.txt"));
			int lineNo = 1;
			while (br.readLine() != null) {
				
				String text=br.readLine();
				if(text!=null){lineChecker(text, lineNo);}
				
				lineNo++;
			
			}
			br.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static void lineChecker(String text, int lineNo) {
		HashMap<String, String> symbles = new HashMap<>();
		symbles.put("{", "}");
		symbles.put("[", "]");
		symbles.put("(", ")");

		ArrayList<String> pattern = new ArrayList<>();

		String checkChars[] = text.split("");
		for (String checkChar : checkChars) {

			for (Map.Entry<String, String> entry : symbles.entrySet()) {
				if (entry.getKey().contentEquals(checkChar) || entry.getValue().contentEquals(checkChar)) {

					pattern.add(checkChar);

				}

			}

		}

		for (int index = 0; index < pattern.size(); index++) {
			if (symbles.get(pattern.get(index)) != null) {

				if (pattern.get(pattern.size() - (index + 1)).contains(symbles.get(pattern.get(index)))) {
					System.out.println("line done");

				} else {
					System.out.println(
							"Syntax error in Line " + lineNo + ".This " + pattern.get(index) + " has not been closed.");
					System.out.println(symbles.get(pattern.get(index)) + " can not be found");

				}

			}

		}

	}

}
