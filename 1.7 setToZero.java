1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.

// use two arrays
// TC: O(max(M,N)^2), SC:O(max(M,N))
void setToZero(int[][] matrix) {
	int M = matrix.length;
	int N = matrix[0].length;
	boolean[] row = new boolean[M];
	boolean[] col = new boolean[N];
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			// if 0, set to row and col to 1;
			if (matrix[i][j] == 0) {
				row[i] = true;
				col[j] = true;
			}
		}
	}
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (row[i] || col[j])
				matrix[i][j] = 0;
		}
	}
}

// use bit vectors, assume M, N < 2^31-1
// TC: O(max(M,N)^2), SC:O(1)
void setToZero2(int[][] matrix) {
	int row = 0;
	int col = 0;
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[i][j] == 0) {
				row |= 1 << i;
				col |= 1 << j;
			}
		}
	}
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			if ((row & (1 << i)) > 0 || (col & (1 << j)) > 0) {
				matrix[i][j] = 0;
			}
		}
	}
}