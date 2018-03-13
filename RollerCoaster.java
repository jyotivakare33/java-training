import java.io.*;
<<<<<<< HEAD
public class RollerCoaster
{
	public static void main(String[] args) throws IOException
	{
		boolean flag = false;
		File file = new File("roller_coaster.txt");
		if(file.length() > 0)
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while(line != null)
			{
				if(line.trim().length()>0)
				{
					String stringArray[] = line.trim().split(" ");
					for(int i = 0;i < stringArray.length;i++)
					{
						if(stringArray[i].length() > 1000)break;
						for(int j = 0;j < stringArray[i].trim().length();j++)
						{
							for(char ch = 'a',ch1 = 'A';ch <= 'z';ch++,ch1++)
							{
								if((stringArray[i].trim().charAt(j) == ch || stringArray[i].trim().charAt(j) == ch1) && flag == false)
								{
									System.out.print(ch1);
									flag = true;
								}
								else if((stringArray[i].trim().charAt(j) == ch || stringArray[i].trim().charAt(j) == ch1) && flag == true)
								{
									System.out.print(ch);
									flag = false;
								}
								else if(stringArray[i].trim().charAt(j) == '\'' || stringArray[i].trim().charAt(j) == ':' || stringArray[i].trim().charAt(j) == ',' || stringArray[i].trim().charAt(j) == '.' )
								{
									System.out.print(stringArray[i].trim().charAt(j));
									break;
								}
							}
						}
						System.out.print(" ");
					}
					flag = false;
					System.out.println();
				}
				else
					System.out.print("Line is Empty Write Something");
				line = br.readLine();
			}
		}
		else
			System.out.print("Your File is Empty write something");
	}
}
=======
class RollerCoaster {
	
	public static void main(String[] args) throws IOException {		
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				if (line.length() != 0 && line.length() < 1000) {
					boolean flag = true;
					int counter = 0;
					StringBuilder result = new StringBuilder();
					for (int index = 0; index < line.length(); ++index)
					{
						String letter = line.substring(index, index+1);
						if (letter.matches("[a-zA-Z]"))
						{
							if (counter % 2 == 0)
								result.append(letter.toUpperCase());
							else
								result.append(letter.toLowerCase());						
							++counter;
						}
						else
							result.append(letter);
					}
					System.out.println(result);
				} else
					System.out.println("blank line or more than 1000 charcters");
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
>>>>>>> 789763c098c1720611b2311b19e03b4c4aabb560
