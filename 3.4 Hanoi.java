3.4 In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
(1) Only one idsk can be moved at a time.
(2) A disk is slid off the top of one tower onto the next tower.
(3) A disk can only be placed on top of a larger disk.
Write a program to move the disks from the first tower to the last using stacks.

// We should put all the disks on the first tower except the last one to the second tower.
// Put the last disk to the third tower.
// Put all the disks on the second tower to the last tower. Done.

void Hanoi(Stack<Integer> st[0], Stack<Integer> st[1], Stack<Integer> st[2], int size) {
	if (size == 0) return;
	Hanoi(st[0], st[2], st[1], size - 1);
	st[2].push(st[0].pop());
	Hanoi(st[1], st[0], st[2], size - 1);
	return;
}

public static void main(String[] args) {
	Stack<Integer> stacks[3];
	int disks[N];
	Hanoi(st[0], st[1], st[2], N);
}

// Would be better if we create a Tower Class and use OO Design.