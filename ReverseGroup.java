import java.io.*;
class ReverseGroup {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						line = line.replaceAll(" ","");
						String[] words = line.split(";");
						String[] numbers = words[0].split(",");
						int limit = Integer.parseInt(words[1].trim());
						for (int outerIndex = 0; outerIndex < numbers.length / limit; ++outerIndex) {
							String[] temp = new String[limit];
							int start = (outerIndex * limit);
							for (int innerIndex = 0; innerIndex < limit; ++innerIndex)
								temp[limit - innerIndex - 1] = numbers[start + innerIndex];
							for (int innerIndex1 = 0; innerIndex1 < limit; ++innerIndex1)
								numbers[start + innerIndex1] = temp[innerIndex1];
						}
						StringBuilder temp = new StringBuilder();
						for (String element : numbers)
							temp.append(element + ",");
						if (temp.length() > 0)
							temp.deleteCharAt(temp.length() - 1);
						System.out.println(temp);
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
