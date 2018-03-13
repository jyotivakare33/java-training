import java.io.*;
class ShortestRepeatation {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					line = line.trim();
					int length = line.length();
					if (length != 0) {
						int shortestlength = length;
						for (int partlength = 1; partlength <= length; partlength++) {
							if (length % partlength == 0) {
								String temp = line.substring(0, partlength);
								boolean isPeriod = true;
								for (int index = partlength; index <= length - partlength; index += partlength) {
									if (!line.substring(index, index + partlength).equals(temp)) {
										isPeriod = false;
										break;
									}
								}
								if (isPeriod == true) {
									System.out.println(partlength);
									break;
								}
							}
						}
					} else
						System.out.println("blank line ");
				}
			} else
				System.out.println("blank file");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Check the file name.");
		} catch (FileNotFoundException e) {
			System.out.println("Check the file.");
		} catch (Exception e) {
			System.out.println("Invalid input.");
		}
	}
}
