1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

/* use HashSet */
// TC: O(n), SC: O(n)
public boolean isUnique(String str) {
	if (str == null || str.isEmpty())
		return ture;
	HashSet<Character> hs = new HashSet<Character>();
	for (char c : str.toCharArray()) {
		if (hs.contains(c))
			return false;
		hs.add(c);
	}
	return true;
}

/* use Array */
// TC: O(n), SC: O(1)
public boolean isUnique2(String str) {
	if (str == null || str.isEmpty())
		return true;
	if (str.length() > 256)
		return false;
	boolean[] checker = new boolean[256];	// ASCII String
	for (char c : str.toCharArray()) {
		if (checker[c])
			return false;
		checker[c] = true;
	}
	return true;
}

/* not use additional ds */
// TC: O(n^2), SC: O(1)
public boolean isUnique3(String str) {
	if (str == null || str.isEmpty())
		return true;
	char[] myArray = str.toCharArray();
	int len = myArray.length;
	for (int i = 0; i < length - 1; i++) {
		for (int j = i + 1; j < length; j++) {
			if (myArray[i] == myArray[j])
				return false;
		}
	}
	return true;
}