import java.io.*;
public class ConsecutivePrime {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						line = line.trim();
						String[] words = line.split(" +");
						int lower_limit = Integer.parseInt(words[0].trim());
						int upper_limit = Integer.parseInt(words[1].trim());
						int flag = 0, temp = 0, sum, index = 0, count = 0;
						int result[] = new int[100];
						for (int outer_index = lower_limit; outer_index < upper_limit; outer_index++) {
							for (int inner_index = 2; inner_index < outer_index; inner_index++) {
								if (outer_index % inner_index == 0) {
									flag = 0;
									break;
								} else
									flag = 1;
							}
							if (flag == 1) {
								result[index] = outer_index;
								index++;
							}
						}
						for (int outer_index = 0; outer_index < result.length; outer_index++) {
							if (result[outer_index] != 0) {
								sum = result[outer_index] + result[outer_index + 1] + 1;
								for (int inner_index : result) {
									if (sum == inner_index) {
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
