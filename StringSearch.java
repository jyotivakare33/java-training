import java.io.*;
class StringSearch {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						String[] words = line.split(",");
						int positionOfOperator = 0;	
						if (words[0].contains(words[1]))
							System.out.println("true");						
						else if(words[1].contains("*")) {							
							positionOfOperator = words[1].indexOf("*");
							words[1] = words[1].replace("\\*","*");
							String[] wordsStar = words[1].split("\\*");							
							if (words[0].contains(wordsStar[0]) && words[0].contains(wordsStar[1]))
								System.out.println("true");
						} else
							System.out.println("false");
					} else
						System.out.println("blank line");
				}
			} else
				System.out.println("blank file");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("file name not  found or invalid input");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
