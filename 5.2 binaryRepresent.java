5.2 Given a real number between 0 and 1 (eg, 0.72) that is passed in as a double, print the binary representation. If the number cannot be rpresented accuratedly in binary with at most 32 characters, print "ERROR".

public String binaryRepresent(double d) {
	if (d <= 0 || d >= 1) return "ERROR";
	StringBuffer sb = new StringBuffer("0.");
	int count = 3;	// "0." occupy two bits
	while (d != 0) {
		d = d * 2;
		if (d >= 1) {
			sb.append("1");
			d -= 1;
		} else {
			sb.append("0");
		}
		count++;
		if (count > 32) {
			return "ERROR";
		}
	}
	return sb.toString();
}