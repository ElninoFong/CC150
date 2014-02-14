1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, wirte a method to rotate the image by 90 degrees. Can you do this in place?

// rotate pixel by pixel, 4 bytes means it can be store in an Integer.
// TC: O(n), SC: O(1)
void rotateMatrix(int[][] matrix) {
	int tmp;
	int N = matrix.length;
	for (int i = 0; i < N / 2; i++) {
		for (int j = i; j < N - i - 1; j++) {	// 最后一位已换，所以要减1
			tmp = matrix[i][j];
			matrix[i][j] = matrix[N-j-1][i];
			matrix[N-j-1][i] = matrix[N-i-1][N-j-1];
			matrix[N-i-1][N-j-1] = matrix[j][N-i-1];
			matrix[j][N-i-1] = tmp;
		}
	}
}
