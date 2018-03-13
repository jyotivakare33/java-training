import java.io.*;
class ReverseAndAdd {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						line = line.trim();
						int count = 0;
						while (isPalindrome(line) != true) {
							if (count <= 100) {
								count++;
								StringBuilder reverseLine = new StringBuilder(line).reverse();
								int sum = Integer.parseInt(line) + Integer.parseInt(reverseLine.toString());
								line = Integer.toString(sum);
							} else {
								System.out.println("iterations are more than 100 ");
								break;
							}
						}
						System.out.println(line + " " + count);
					} else {
						System.out.println("blank line ");
					}
				}
			} else
				System.out.println("blank file");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("file name not  found");
		} catch (FileNotFoundException e) {
			System.out.println("file not found ");
		} catch (Exception e) {
			System.out.println("invalid input");
		}
	}

	static boolean isPalindrome(String line) {
		boolean flag = false;
		char[] result = line.toCharArray();
		for (int index = 0; index < result.length / 2; index++) {
			if (result[index] == result[result.length - index - 1]) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
