import java.io.*;

class LongestWord {

	public static void main(String[] args) throws IOException {
		try {			
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file))
				String line = null;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						line = line.trim();
						String[] words = line.split("\\s+");
						int[] wordLength = new int[words.length];
						for (int index = 0; index < words.length; index++)
							wordLength[index] = words[index].length();
						int maximum = 0;
						for (int index = 1; index < wordLength.length; index++) {
							if (wordLength[maximum] < wordLength[index])
								maximum = index;
						}
						System.out.println(words[maximum]);
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
