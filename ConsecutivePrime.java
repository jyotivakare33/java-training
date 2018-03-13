import java.io.*;
class ConsecutivePrime {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						line = line.trim();
						String[] words = line.split(" +");
						int lowerLimit = Integer.parseInt(words[0].trim());
						int upperLimit = Integer.parseInt(words[1].trim());
						int flag = 0, temp = 0, sum, index = 0, count = 0;
						int result[] = new int[100];
						for (int outerIndex = lowerLimit; outerIndex < upperLimit; outerIndex++) {
							for (int innerIndex = 2; innerIndex < outerIndex; innerIndex++) {
								if (outerIndex % innerIndex == 0) {
									flag = 0;
									break;
								} else
									flag = 1;
							}
							if (flag == 1) {
								result[index] = outerIndex;
								index++;
							}
						}
						for (int outerIndex = 0; outerIndex < result.length; outerIndex++) {
							if (result[outerIndex] != 0) {
								sum = result[outerIndex] + result[outerIndex + 1] + 1;
								for (int innerIndex : result) {
									if (sum == innerIndex) {
										System.out.println(sum);
										count = 1;
									}
								}
							}
						}
						if (count == 0)
							System.out.println("not present");
					} else
						System.out.println("blank line");
				}
			} else
				System.out.println("blank file");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("file name not  found");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (NumberFormatException e) {
			System.out.println("invalid inputs");
		}
	}
}
