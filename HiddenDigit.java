import java.io.*;
class HiddenDigit {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						line = line.trim();
						StringBuffer result = new StringBuffer();
						for (char character : line.toCharArray()) {
							switch (character) {
								case 'a':
									result.append('0');
									break;
								case 'b':
									result.append('1');
									break;
								case 'c':
									result.append('2');
									break;
								case 'd':
									result.append('3');
									break;
								case 'e':
									result.append('4');
									break;
								case 'f':
									result.append('5');
									break;
								case 'g':
									result.append('6');
									break;
								case 'h':
									result.append('7');
									break;
								case 'i':
									result.append('8');
									break;
								case 'j':
									result.append('9');
								default:
									if (Character.isDigit(character))
										result.append(character);
							}
						}
						if (result.length() == 0)
							result.append("NONE");
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
