import java.io.*;
public class ReverseWords 
{
	public static void main(String[] args) throws IOException{
		String line = "";
		File file = new File(args[0]);
		if(file.length() > 0)
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null)
			{
				if(line.trim().length() > 0)
				{
					String stringArray[] = line.split(" ");
					for(int index=stringArray.length-1;index >= 0;index--)
					{
						System.out.print(stringArray[index]+" ");
					}
					System.out.println();
				}
				else
					System.out.println("Your line is empty");
			}
		}
		else
			System.out.println("Your File Is Empty");
	}
}