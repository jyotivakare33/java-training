import java.io.*;
class JustifyTheText {

	public static void main(String[] args) throws Exception {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					line = line.trim();
					if (line.length() != 0) {
						String[] words = line.split(" ");
						StringBuilder result = new StringBuilder();
						for (String word : words) {
							if (result.length() + word.length() <= 80)
								result.append(word + " ");
							else {								
								int missing = 80 - result.length();
								int spaces = result.toString().split(" ").length - 1;
								int perSpace = missing / spaces;
								int surplus = missing % spaces;
								int start = 0;
								for (int outerIndex = 0; outerIndex < spaces; ++outerIndex) {
									int spacePosition = result.indexOf(" ", start);
									int currentSpaces = perSpace + (surplus > outerIndex ? 1 : 0);
									for (int innerIndex = 0; innerIndex < currentSpaces; ++innerIndex)
										result.insert(spacePosition, " ");
									start = spacePosition + currentSpaces + 1;
								}
								System.out.print(result);
								result = new StringBuilder(word + " ");
							}
						}
						if (result.length() > 0) {
							result.deleteCharAt(result.length() - 1);
							System.out.println(result);
						}
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
