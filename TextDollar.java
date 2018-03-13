import java.io.*;
class TextDollar {
	
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			if (file.length() != 0) {
				while ((line = buffer.readLine()) != null) {
					try {
						if (line.length() != 0) {
							int number = Integer.parseInt(line);
							TextDollar dollar = new TextDollar();
							dollar.numberToWord((number / 1000000000), "Hundred");
							dollar.numberToWord((number / 10000000) % 100, "crore");
							dollar.numberToWord(((number / 100000) % 100), "lakh");
							dollar.numberToWord(((number / 1000) % 100), "thousand");
							dollar.numberToWord(((number / 100) % 10), "hundred");
							dollar.numberToWord((number % 100), "");
						} else
							System.out.println("blank line");
					} catch (NumberFormatException nfe) {
						System.out.println("Invalid input or range is greater than 1 billion");
					}
					System.out.println();
				}
			} else
				System.out.println("Empty file");
		} catch (ArrayIndexOutOfBoundsException aie) {
			System.out.println("Please provide file name");
		} catch (FileNotFoundException fe) {
			System.out.println("File not found..");
		} catch (Exception ie) {
			System.out.println("invalid input ");
		}
	}

	static void numberToWord(int number, String text) 
	{
		String ones[] = {" ", "one", "two", "three", "four", "five", "six", "seven",
						"eight", "Nine", "ten", "eleven", "twelve", "thirteen",
						"fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
						"nineteen" };
		String tens[] = { " ", " ", "twenty", "thirty", "forty", "fifty",
						"sixty", "seventy", "eighty", "ninety" };
		if (number > 19)
           System.out.print(tens[number / 10] + ones[number % 10]);
		else
           System.out.print(ones[number]);
		if (number > 0)
           System.out.print(text);
	}
}
