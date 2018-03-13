import java.io.*;
import java.util.*;
class TextToNumber {
	
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("zero", 0);
				map.put("one", 1);
				map.put("two", 2);
				map.put("three", 3);
				map.put("four", 4);
				map.put("five", 5);
				map.put("six", 6);
				map.put("seven", 7);
				map.put("eight", 8);
				map.put("nine", 9);
				map.put("ten", 10);
				map.put("leven", 11);
				map.put("twelve", 12);
				map.put("thirteen", 13);
				map.put("fourteen", 14);
				map.put("fifteen", 15);
				map.put("sixteen", 16);
				map.put("seventeen", 17);
				map.put("eighteen", 18);
				map.put("nineteen", 19);
				map.put("twenty", 20);
				map.put("thirty", 30);
				map.put("fourty", 40);
				map.put("fifty", 50);
				map.put("sixty", 60);
				map.put("seventy", 70);
				map.put("eighty", 80);
				map.put("ninety", 90);
				map.put("hundred", 100);
				map.put("thousand", 1000);
				map.put("million", 1000000);
				int hundred = 0, thousand = 0, million = 0;
				while ((line = buffer.readLine()) != null) {
					line = line.trim();
					if (line.length() != 0) {
						line = line.trim();
						int count = 0, number = 0;
						String[] words = line.split("\\s+");					
						while (true) {
							int input = map.get(words[count]);
							if (input == 100 || input == 1000 || input == 1000000)
								number = number * input;
							else
								number = number + input;							
							if(input == 100) {
								hundred = number;
								number = 0;
							}								
							if(input == 1000) {
								thousand = number;
								number = 0;
							}							
							if(input == 1000000) {
								million = number;
								number = 0;
							}								
							count++;
							if (count >= words.length)
								break;										
						}
						int total =  million + thousand + hundred + number;						
						if (number < 1000000000)
							System.out.println(total);
						else
							System.out.println("number is greater than 1 billion.....");
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
