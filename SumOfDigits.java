import java.io.*;
public class SumOfDigits
{
	public static void main(String[] args) throws IOException{
		boolean flag = false;
		File file = new File(args[0]);
		int sum = 0;
		if(file.exists() && file.length() > 0){
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = br.readLine().trim();
				while(line != null){
					if(line.trim().length() != 0){
						if(line.trim().matches("[1-9]*") == true){
							String str = line.trim();
							flag = true;
							for(int index1 = 0;index1 < str.length();index1++){
								char ch = 49;
								for(int index2 = 1;index2 <= 9;index2++){
									if(str.charAt(index1) == ch)	{
										sum += index2;
									}	
									ch++;
								}
							}
							if(flag == true){
								System.out.println("constituent digits="+line+"\tsum="+sum);
							}
						}
						else{
							System.out.println("Incorrect Input");
						}
					}
					else{
						System.out.println("Your Line is Empty");
					}
					sum = 0;
					line = br.readLine();
				}
		}
		else{
			System.out.println("File are not exists OR File is Empty");
		}
	}
}