import java.io.*;
public class Halloween{
	public static String printPattern(String line){
		String strarr[] = line.split(",");
		int totalCandles = 0,numOfChild = 0;
		for(int index = 0;index < strarr.length;index++){
			String expression = strarr[index].replaceAll("[^0-9]","");
			totalCandles += (index == 0) ? (Integer.parseInt(expression)*3) : ((index == 1) ? Integer.parseInt(expression) * 4:((index==2)?Integer.parseInt(expression)*5:0));
			if(index == 3)totalCandles *= Integer.parseInt(expression);else numOfChild += Integer.parseInt(expression);
		}
		return "No Of Candles="+totalCandles+"\n"+"No Of Child="+numOfChild+"\n"+"ans="+(totalCandles/numOfChild)+"";
	}
	
	public static void main(String[] args) throws IOException{
		String line = null;
		File file = new File(args[0]);
			if(file.length() != 0){
				BufferedReader br=new BufferedReader(new FileReader(file));
				while((line = br.readLine())!=null){
					String result =(line.trim().length()>0)?((line.matches(" *?([a-zA-Z]+ *: *(\\d{1,2}(?!\\d)|100) *, *){3} *?([a-zA-Z]+ *: *(\\d{1,2}(?!\\d)|100) *)"))?printPattern(line.trim()):"Wrong Input/Data"):"Empty Line";
					System.out.println(result);
				}
			}else{
				System.out.println("File is Empty");
			}
	}
}