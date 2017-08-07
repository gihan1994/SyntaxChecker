import java.io.BufferedReader;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

public class SyntaxChecker {

	public static void main(String[] args) {


		try (FileReader file = new FileReader("src/Sample.txt");
		        BufferedReader buffer = new BufferedReader(file)) {
		  
		    String line;
		    int lineNo=1;
		    while ((line = buffer.readLine()) != null) {
		       lineChecker(line,lineNo);
		    lineNo++;
		    }
		    
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
				System.out.println(pattern.get(index));
				System.out.println(pattern.get(index+1));
				if(pattern.get(index+1).contains(symbles.get(pattern.get(index)))){
					System.out.println("line done");
					
				}else if (pattern.get(pattern.size() - (index + 1)).contains(symbles.get(pattern.get(index)))) {
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
