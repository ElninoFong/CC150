3.1 Describe how you could use a single array to implement three stacks.

// divide the array into three parts equally.
int stackSize = 100;
int[] arr = new int[stackSize * 3];
int[] ptr = {-1, -1, -1};

void push(int stackNum, int n) throws Exception {
	if (ptr[stackNum] == stackSize - 1) 
		throw new Exception("Out of bounds");
	arr[stackNum * stackSize + (++ptr[stackNum])] = n;
}

int pop(int stackNum) throws Exception {
	if (ptr[stackNum] == -1)
		throw new Exception("Empty stack");
	return arr[stackNum * stackSize + (ptr[stackNum]--)];
}

int peek(int stackNum) throws Exception {
	if (ptr[stackNum] == -1)
		throw new Exception("Empty stack");
	return arr[stackNum * stackSize + ptr[stackNum]];
}

boolean isEmpty(int stackNum) {
	return ptr[stackNum] == -1;
}


// dynamic allocate three parts