import java.io.*;
class ReadMore {

	public static void main(String[] args) throws Exception {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.length() != 0) {
						if (line.length() <= 55)
							System.out.println(line);
						if (line.length() > 55) {
							System.out.println(line.substring(0, 39).trim() + "... <Read More>");
						}
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
