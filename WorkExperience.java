import java.io.*;
class WorkExperience {

	static final int YEARS = 31;
	static final int MONTHS = 12;

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
				String line;
				while ((line = buffer.readLine()) != null) {
					line = line.trim();
					if (line.length() != 0) {
						String[] dates = line.split(";");
						boolean[][] months = new boolean[YEARS][MONTHS];
						for (String date : dates) {
							String[] dateRanges = date.trim().split("-");
							String[] start = dateRanges[0].trim().split(" ");
							String[] end = dateRanges[1].trim().split(" ");
							int startMonth = month(start[0]);
							int startYear = Integer.valueOf(start[1]);
							startYear = startYear - 1990;
							int endMonth = month(end[0]);
							int endYear = Integer.valueOf(end[1]);
							endYear = endYear - 1990;
							while (true) {
								months[startYear][startMonth] = true;
								startMonth++;
								if (startMonth >= MONTHS) {
									startYear++;
									startMonth = 0;
								}
								if (startYear > endYear) {
									break;
								}
								if (startYear == endYear)
									if (startMonth > endMonth) {
										break;
								}
							}
						}
						int monthSum = 0;
						for (int year = 0; year < YEARS; ++year) {
							for (int month = 0; month < MONTHS; ++month) {
								if (months[year][month] == true)
									monthSum++;
							}
						}
						System.out.println(monthSum / 12);
					} else
						System.out.println("Blank line.Please enter inputs.");
				}
			} else
				System.out.println("Blank file.Please enter inputs.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please check the filename.");
		} catch (FileNotFoundException e) {
			System.out.println("Please check the file existence.");
		} catch (Exception e) {
			System.out.println("Invalid input.");
		}
	}

	static int month(String month) {
		if ("Jan".equals(month))
			return 0;
		else if ("Feb".equals(month))
			return 1;
		else if ("Mar".equals(month))
			return 2;
		else if ("Apr".equals(month))
			return 3;
		else if ("May".equals(month))
			return 4;
		else if ("Jun".equals(month))
			return 5;
		else if ("Jul".equals(month))
			return 6;
		else if ("Aug".equals(month))
			return 7;
		else if ("Sep".equals(month))
			return 8;
		else if ("Oct".equals(month))
			return 9;
		else if ("Nov".equals(month))
			return 10;
		else
			return 11;
	}
}
