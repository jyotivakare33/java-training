import java.io.*;
class EggCrack {
	
	static int maximum(int temp, int temp1) {
		return (temp > temp1) ? temp : temp1;
	}

	static int eggDrop(int noOfEggs, int noOfFloors) {
		int eggFloor[][] = new int[noOfEggs + 1][noOfFloors + 1];
		int result;
		int eggs, floors, index;
		for (eggs = 1; eggs <= noOfEggs; eggs++) {
			eggFloor[eggs][1] = 1;
			eggFloor[eggs][0] = 0;
		}
		for (floors = 1; floors <= noOfFloors; floors++)
			eggFloor[1][floors] = floors;
		for (eggs = 2; eggs <= noOfEggs; eggs++) {
			for (floors = 2; floors <= noOfFloors; floors++) {
				eggFloor[eggs][floors] = Integer.MAX_VALUE;
				for (index = 1; index <= floors; index++) {
					result = 1 + maximum(eggFloor[eggs - 1][index - 1], eggFloor[eggs][floors - index]);
					if (result < eggFloor[eggs][floors])
						eggFloor[eggs][floors] = result;
				}
			}
		}
		return eggFloor[noOfEggs][noOfFloors];
	}

	public static void main(String args[]) throws IOException {

		try {
			File file = new File(args[0]);
			if (file.length() != 0) {
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String line;
				while ((line = buffer.readLine()) != null) {
					line = line.trim();
					if (line.length() != 0) {
						int noOfEggs = Integer.parseInt(line.split("\\s+")[0]);
						int noOfFloors = Integer.parseInt(line.split("\\s+")[1]);
						System.out.println(eggDrop(noOfEggs, noOfFloors));
					} else
						System.out.println("blank line");
				}
			} else
				System.out.println("blank file");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("file name not  found");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
	}
}
