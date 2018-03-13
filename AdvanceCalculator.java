import java.io.*;
class AdvanceCalculator {

	public static void main(String[] args) throws Exception {
		String line;
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						line = line.trim();
						int result = 0, firstNumber = 0, secondNumber = 0;
						if (line.contains("+")) {
							String[] numbers = line.split("\\+");
							firstNumber = Integer.parseInt(numbers[0].trim());
							secondNumber = Integer.parseInt(numbers[1].trim());
							result = firstNumber + secondNumber;
						}
						if (line.contains("-")) {
							String[] numbers = line.split("\\-");
							firstNumber = Integer.parseInt(numbers[0].trim());
							secondNumber = Integer.parseInt(numbers[1].trim());
							result = firstNumber - secondNumber;
						}
						if (line.contains("*")) {
							String[] numbers = line.split("\\*");
							firstNumber = Integer.parseInt(numbers[0].trim());
							secondNumber = Integer.parseInt(numbers[1].trim());
							result = firstNumber * secondNumber;
						}
						if (line.contains("/")) {
							String[] numbers = line.split("\\/");
							firstNumber = Integer.parseInt(numbers[0].trim());
							secondNumber = Integer.parseInt(numbers[1].trim());
							result = firstNumber / secondNumber;
						}
						if (line.contains("%")) {
							String[] numbers = line.split("\\%");
							firstNumber = Integer.parseInt(numbers[0].trim());
							secondNumber = Integer.parseInt(numbers[1].trim());
							result = firstNumber % secondNumber;
						}
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
