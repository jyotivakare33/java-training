import java.io.*;
import java.util.*;
class StringRotation {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						String[] words = line.split(",");
						char[] wordToCompare = words[0].toCharArray();
						char[] rotatedWord = words[1].toCharArray();
						Arrays.sort(wordToCompare);
						Arrays.sort(rotatedWord);
						if (Arrays.equals(wordToCompare, rotatedWord))
							System.out.println("Strings are equal");
						else
							System.out.println("Strings are unequal");
					} else
						System.out.println("blank line");
				}
			} else
				System.out.println("blank file");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("file name not  found");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (Exception e) {
			System.out.println("invalid input");
		}
	}
}
