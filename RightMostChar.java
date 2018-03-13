import java.io.*;
class RightMostChar {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					line = line.trim();
					int index = 0;
					if (line.length() != 0) {
						String[] words = line.split(",");
						if (words.length == 2)
							index = words[0].lastIndexOf(words[1].trim());
						if (index == -1 || !line.contains(",") || words.length != 2)
							System.out.println("wrong input or char not found");
						else
							System.out.println(index);
					} else
						System.out.println("blank line");
				}
			} else
				System.out.println("blank file");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("file name not  found");
		} catch (FileNotFoundException e) {
			System.out.println("file not found exception");
		} catch (Exception e) {
			System.out.println("invalid input");
		}
	}
}
