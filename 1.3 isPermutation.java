1.3 Given two strings, write a method to decide if one is a permutation of the other.

// sort
boolean isPermutaion(String s1, String s2) {
	if (s1.length() != s2.length()) return false;
	char[] char1 = s1.toCharArray();
	java.util.Arrays.sort(char1);
	char[] char2 = s2.toCharArray();
	java.util.Arrays.sort(char2);	// 此处重复sort了两次，应该另外写一个sort的函数
	for (int i = 0; i < s1.length(); i++) {
		if (char1[i] != char2[i])
			return false;
	}
	return true;
}

// hashmap
// TC: O(n), SC: O(n)
boolean isPermutaion2(String s1, String s2) {
	if (s1.length() != s2.length()) return false;
	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
	for (int i = 0; i < s1.length(); i++) {
		if (hm.containsKey(s1.charAt(i))) {
			int k = hm.get(s1.charAt(i));
			hm.put(s1.charAt(i), k + 1);
		} else {
			hm.put(s1.charAt(i), 1);
		}
	}
	for (int i = 0; i < s2.length(); i++) {
		if (!hm.containsKey(s2.charAt(i)))
			return false;
		int k = hm.get(s2.charAt(i));
		if (k - 1 < 0)
			return false;
		hm.put(s2.charAt(i), k - 1);
	}
	return true;
}

// Array
// ...

// 1.是否分大小写，空格是否忽略； 2.长度不等直接返回false