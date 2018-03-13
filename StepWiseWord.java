import java.io.*;
public class StepwiseWord
{
	public static void main(String[] args)
	{
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("stepwise_word.txt")));
			String line = br.readLine().trim();
			String longestString = "";
			while(line!=null)
			{
				if(line.trim().length() > 0)
				{
					if(line.trim().length() > 0)
					{
						String[] totalWords = line.trim().split(" ");
						if(totalWords.length <= 15)
						{	
							for(int index = 0;index < totalWords.length;index++)
							{
								if(totalWords[index].length() <= 10&&longestString.length() >= 0)
								{	
									if(totalWords[index].trim().length() > longestString.trim().length())
									{
										longestString = totalWords[index].trim();
									}
								}
							}
							int count = 0;
							for(int index1=0;index1 < longestString.length();index1++)
							{
								char ch = longestString.charAt(index1);
								System.out.print(ch+" ");
								for(int index2 = 0;index2 <= count;index2++)
								{
									if(index1 != longestString.length()-1)
									System.out.print("*");						
								}
								count++;
							}
							System.out.println("");
							longestString = " ";
						}
						else
							System.out.println("Word length should not greater than 15");
					}
				}
				else
					System.out.println("Line is Empty write something......");
				line = br.readLine();
			}
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("File is not available, Give valid File name");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}