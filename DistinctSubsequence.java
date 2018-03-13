import java.io.*;
class DistinctSubsequence {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						String[] words = line.split(",");
						int[][] table = new int[words[0].length() + 1][words[1].length() + 1];
						for (int index = 0; index < words[0].length(); index++)
							table[index][0] = 1;
						for (int outerIndex = 1; outerIndex <= words[0].length(); outerIndex++) {
							for (int innerIndex = 1; innerIndex <= words[1].length(); innerIndex++) {
								if (words[0].charAt(outerIndex - 1) == words[1].charAt(innerIndex - 1)) {
									table[outerIndex][innerIndex] = table[outerIndex - 1][innerIndex]
											+ table[outerIndex - 1][innerIndex - 1];
								} else {
									table[outerIndex][innerIndex] = table[outerIndex - 1][innerIndex];
								}
							}
						}
						int result = table[words[0].length()][words[1].length()];
						System.out.println(result);
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
