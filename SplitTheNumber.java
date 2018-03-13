import java.io.*;
<<<<<<< HEAD
public class SplitTheNumber
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		File file=new File(args[0]);
		BufferedReader br=new BufferedReader(new FileReader(file));
		if(file.length()>0)
		{
			String line=br.readLine().trim();
			while(line!=null)
			{
				if(line.trim().length()>0)
				{
					try{
						System.out.print(line.trim()+"=>");
						String[] stringArray=line.trim().split(" ");
						String firstWord=stringArray[0].trim();//before space number
						String secondWord=stringArray[1];//after space (alphabets & operator sign)
						char operator=' ';
						String number="",str="";
						char charArray[]=new char[firstWord.length()];
						for(int index=0;index<secondWord.length();index++)
						{
							if(index<secondWord.length()-1)
							{
								charArray[index]=firstWord.charAt(index);//All the Number
							}
							if(secondWord.charAt(index)=='+'||secondWord.charAt(index)=='-')
							{
								operator=secondWord.charAt(index);//Operator 
								continue;
							}
							str+=secondWord.charAt(index);//All the alphabets
						}
						for(int index=0;index<charArray.length;index++)
						{
							System.out.print(str.charAt(index)+":"+charArray[index]+", ");//pattern
						}
						System.out.print("\b\b ");
						if((charArray.length)%2==0&&operator=='+')
						{
							int i=0;
							for(int index=0;index<(charArray.length)/2;index++)
							{
								System.out.print(Character.getNumericValue(charArray[i])+Character.getNumericValue(charArray[i+2]));
								i++;
							}
						}
						else if((charArray.length)%2!=0&&operator=='+')
						{
							int firstIndex=Character.getNumericValue(charArray[0]);
							for(int index=0;index<charArray.length;index++)
							{
								if(index!=0)
									number+=charArray[index];
							}
							System.out.print(""+(firstIndex+(Integer.parseInt(number))));
						}
						else if(operator=='-')
						{
							int firstIndex=Character.getNumericValue(charArray[0]);
							for(int index=0;index<charArray.length;index++)
							{
								if(index!=0)
									number+=charArray[index];
							}
							System.out.print("-"+((Integer.parseInt(number))-firstIndex));
						}
						System.out.println();
					}catch(Exception e){System.out.println("Wrong Input");}
				}//end of if(space)
				else
					System.out.println("This Line are Empty");
				line=br.readLine();
			}//end of while
		}//end of if(file length)
		else
			System.out.println("Your File is Empty");
	}//end of main
}//end of class 
=======
class SplitTheNumber {

	public static void main(String[] args) throws IOException {	
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
			String line;
			while ((line = buffer.readLine()) != null) {
				if (line.length() != 0) {
					line = line.trim();
					String[] words = line.split(" ");
					long result = 0;
					if (words.length != 1) {
						if (words[1].contains("+") && words[1].matches(".*[a-z]")) {
							String[] numbers = words[1].split("\\+");
							if (words[0].length() == words[1].length() - 1) {
								result = Long.parseLong(words[0].substring(0, numbers[0].length()))
										+ Long.parseLong(words[0].substring(numbers[0].length()));
								System.out.println(result);
							} else
								System.out.println("wrong input ");
						} else if (words[1].contains("-")) {
							String[] numbers = words[1].split("-");
							if (words[0].length() == words[1].length() - 1) {
								result = Long.parseLong(words[0].substring(0, numbers[0].length()))
										- Long.parseLong(words[0].substring(numbers[0].length()));
								System.out.println(result);
							} else
								System.out.println("wrong input the characters are not correct  ");
						} else
							System.out.println("wrong input out of range ");
					} else
						System.out.println("wrong input");
				} else
					System.out.println("blank line");
			}
		} catch (Exception e) {
			System.out.println("Invalid input exception occurred");
		} 
	}
}

>>>>>>> 789763c098c1720611b2311b19e03b4c4aabb560
