import java.io.*;
class SwapCase {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						line = line.trim();
						StringBuffer result = new StringBuffer();
						for (int index = 0; index < line.length(); index++) {
							if (Character.isUpperCase(line.charAt(index)))
								result.append(Character.toLowerCase(line.charAt(index)));
							else if (Character.isLowerCase(line.charAt(index)))
								result.append(Character.toUpperCase(line.charAt(index)));
							else
								result.append(line.charAt(index));
						}
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
