import java.io.*;
import java.lang.String;
public class Longestwords {

	public static void main(String[] args) throws FileNotFoundException , IOException{
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		File file = new File("C:\\Users\\Varsha\\eclipse-workspace\\Trick\\src\\longestnumber.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line=null;
		while((line=br.readLine())!=null)
			{		 
			line = line.trim();
			String[] words = line.split(" ");
			int[] lengths = new int[words.length];
			for (int i = 0; i < words.length; i++) {
				lengths[i] = words[i].length();
			}
			int maxIdx = 0;
			for (int i = 1; i < lengths.length; i++) {
				if (lengths[maxIdx] < lengths[i])
					maxIdx = i;
			}
			System.out.println(words[maxIdx]);
			}
	}
}
