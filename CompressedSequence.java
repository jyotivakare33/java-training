import java.io.*;
class CompressedSequence
{
    public static void main (String[] args) throws IOException
    {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						String[] number = line.split(" +");
						int[] input = new int[number.length];
						try {
							for (int index = 0; index < number.length; index++) 
								input[index] = Integer.parseInt(number[index]); 
						} catch (NumberFormatException e) {
							System.out.println("invalid input");
						}      
						int currentNumber = input[0];
						int currentCount = 1;
						for (int index = 1; index < input.length; index++) {
							int number = input[index];
							if (number != currentNumber) {
								System.out.print(currentCount + " " + currentNumber + " ");
								currentNumber = number;
								currentCount = 1;
							}
							else 
								currentCount++;
						}
						System.out.println(currentCount + " " + currentNumber);
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
