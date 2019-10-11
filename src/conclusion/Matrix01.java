package conclusion;

public class Matrix01 {

	public int[][] updateMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return matrix;
		}
		int range = matrix.length * matrix[0].length;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					int upCell = (i > 0) ? matrix[i - 1][j] : range;
					int leftCell = (j > 0) ? matrix[i][j - 1] : range;
					matrix[i][j] = Math.min(upCell, leftCell) + 1;
				}
			}
		}

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (matrix[i][j] != 0) {
					int downCell = (i < matrix.length - 1) ? matrix[i + 1][j] : range;
					int rightCell = (j < matrix[0].length - 1) ? matrix[i][j + 1] : range;
					matrix[i][j] = Math.min(Math.min(downCell, rightCell) + 1, matrix[i][j]);
				}
			}
		}

		return matrix;
	}

}
