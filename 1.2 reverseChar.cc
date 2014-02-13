1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.

// in place
// TC: O(n), SC:O(1)
void reverse(char* str) {
	if (str) {			// is empty
		char* p = str;
		while(*p) {
			p++;
		}
		p--;
		char tmp;
		while(p > str) {
			tmp = *str;
			*str++ = *p;
			*p-- = tmp;
		}
	}
}