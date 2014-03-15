5.1 You are given two 32-bit numbers, N amd M, and two bit positions, i and j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You can assume that the bits j through i have enough space to fit all of M. That is, if M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for example, have j = 3 an i = 2, because M could not fully fit between bit 3 and bit 2.
EXAMPLE
Input:  N = 10000000000, M = 10011, i = 2, j = 6
Output: N = 10001001100

// use loop
public int insert(int N, int M, int i, int j) {
	// (j - i + 1) 1s
	int mask = 0;
	for (int k = 0; k < j - i + 1; k++) {
		mask |= (1 << k);
	}
	// reverse mask
	mask = (~mask);
	// clear N
	N &= mask;
	// combine M
	M <<= i;
	N |= M;
	return N;
}

// optimized, no loop
public int insert2(int N, int M, int i, int j) {
	int allOnes = ~0;
	int left = allOnes << (j + 1);
	int right = allOnes - allOnes << i;
	int mask = left | right;
	int clean = N & mask;
	int combine = clean | (M << i);
	return combine;
}