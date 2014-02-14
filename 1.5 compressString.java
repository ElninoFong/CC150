1.5 Implement a method to perform basic string compression using the count of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string.

// use StringBuffer
// TC: O(n), SC:O(1)
String compression(String str) {
	// count compressed new length
	int newLength = countLength(str);
	if (newLength >= str.length())
		return str;

	// compress
	StringBuffer sb = new StringBuffer();
	int count = 1;
	char cur = str.charAt(0);
	for (int i = 1; i < str.length(); i++) {
		if (cur == str.charAt(i)) {
			count++;
		} else {
			sb.append(cur);
			char[] c_arr = String.valueOf(count).toCharArray();
			for (char c : c_arr) {
				sb.append(c);
			}						// equals sb.append(count)
			cur = str.charAt(i);
			count = 1;
		}
	}
	sb.append(cur);
	char[] c_arr = String.valueOf(count).toCharArray();
	for (char c : c_arr) {
		sb.append(c);
	}
	return sb.toString();
}

int countLength(String str) {
	if (str == null || str.isEmpty())
		return 0;
	int len = 0;
	int count = 1;
	char cur = str.charAt(0);
	for (int i = 1; i < str.length(); i++) {
		if (cur == str.charAt(i)) {
			count++;
		} else {
			cur = str.charAt(i);
			len += 1 + String.valueOf(count).length();
			count = 1;
		}
	}
	len += 1 + String.valueOf(count).length();
	return len;
}

// use Array
// ...

// 1. 先算长度再压缩。 2. 如果重复长度是两位数？