class RobotMovement {
	
	public static void main(String[] args) {
		int row = 4, column = 4;		
		int matrix[][] = new int[row + 1][column + 1];
		for (int index = 0; index < row; index++) {
			matrix[0][index] = 1;
			matrix[index][0] = 1;
		}
		for (int outerIndex = 1; outerIndex < 4; outerIndex++) {
			for (int innerIndex = 1; innerIndex < 4; innerIndex++) {
				matrix[outerIndex][innerIndex] = matrix[outerIndex - 1][innerIndex] + matrix[outerIndex][innerIndex - 1];
			}
		} 
		System.out.println(matrix[row-1][column-1]);
	}
}
