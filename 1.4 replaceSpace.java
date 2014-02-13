1.4 Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
EXAMPLE
Input:  "Mr John Smith    "
Output: "Mr%20John%20Smith"

// TC: O(n), SC: O(n)
String replaceSpaces(char[] c_array, int length) {
	// count whitspace
	int count = 0;
	for (int i = 0; i < length; i++) {
		if (c_array[i] == ' ')
			count++;
	}

	int end = count * 2 + length;

	// replace from the end
	end--;						// 注意数组末尾和长度的差别
	for (int i = length - 1; i >= 0; i--) {
		if (c_array[i] != ' ') {
			c_array[end] = c_array[i];
		} else {
			c_array[end--] = '0';
			c_array[end--] = '2';
			c_array[end] = '%';
		}
		end--;
	}
	return new String(c_array);
}