import java.io.*;
class Pangram {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						String alphabets = "abcdefghijklmnopqrstuvwxyz";
						String comparsion = "";
						for (int index = 0; index < line.length(); index++) {
							if (Character.isAlphabetic(line.charAt(index))) {
								comparsion = ("" + line.charAt(index)).toLowerCase();
								if (alphabets.contains(comparsion)) {
									alphabets = alphabets.replace(comparsion, "");
									if (alphabets.isEmpty()) {
										System.out.println("panagram");
										break;
									}
								}
							} else
								comparsion = ("" + line.charAt(index));
						}
						if (!alphabets.isEmpty())
							System.out.println(alphabets);
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
