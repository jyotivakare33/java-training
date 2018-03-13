import java.io.*;
class TrickOrTreat {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					try {
						int test_cases = 0;
						test_cases++;
						if (line.length() != 0 && test_cases != 40) {
							int vampires = 0, witches = 0, zombies = 0, houses = 0, sum = 0, result = 0, total = 0, index = 0;
							String[] temp = line.split(",");
							if (temp.length == 4) {
								for(index = 0; index < temp.length; index++) {
									if(temp[index].matches("[a-zA-Z]+:[0-9]+")) {	
										vampires = Integer.valueOf(temp[0].split(":")[1]);
										zombies = Integer.valueOf(temp[1].split(":")[1]);
										witches = Integer.valueOf(temp[2].split(":")[1]);
										houses = Integer.valueOf(temp[3].split(":")[1]);
										if (vampires > 0 && zombies > 0 && witches > 0 && houses > 0 && vampires <= 100
												&& zombies <= 100 && witches <= 100 && houses <= 100) {
											sum = (vampires * 3 + zombies * 4 + witches * 5) * houses;
											total = vampires + witches + zombies;
											result = sum / total;
											System.out.println(result);
											break;											
										} else
											System.out.println("out of range input");
									} else {
										System.out.println("invalid input");
										break;
									}
								}								
							} else
								System.out.println("more than 4 words");
						} else
							System.out.println("blank line or test cases is more than 40");
					} catch (NumberFormatException e) {
						System.out.println("invalid input not integer");
					}
				}
			} else
				System.out.println("blank file");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("file name not  found");
		} catch (FileNotFoundException e) {
			System.out.println("invalid file");
		}
	}
}
