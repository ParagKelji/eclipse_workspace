package leetcode;

public class AddTwoNumsLL {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        if ( l1 == null && l2 == null ) {
        	return sum;
        }
        if ( l1 == null ) {
        	sum.val = l2.val;
        	return sum;
        }
        if ( l2.next == null ) {
        	sum.val = l1.val;
        	return sum;
        }
        ListNode num1 = l1;
        ListNode num2 = l2;
        ListNode sum1 = sum;
        int currSum = 0;
        int remainder = 0;
        int carryForward = 0;
        while ( num1 != null && num2 != null ) {
        	currSum = num1.val + num2.val  + remainder;
        	if ( currSum >= 10 ) {
	        	remainder = currSum % 10;
	        	sum1.val = remainder;
	        	carryForward = currSum / 10;
        	} else {
        		sum1.val = currSum;
        	}
        	num1 = num1.next;
        	num2 = num2.next;
        	sum1 = sum1.next;
        	
        }
        return sum;
    }
	
	public static void main(String[] args) {
		AddTwoNumsLL addTwoNumsLL = new AddTwoNumsLL();
		AddTwoNumsLL.ListNode num11 = addTwoNumsLL.new ListNode(2);
		AddTwoNumsLL.ListNode num12 = addTwoNumsLL.new ListNode(4);
		AddTwoNumsLL.ListNode num13 = addTwoNumsLL.new ListNode(3);
		num11.next = num12;
		num12.next = num13;
		AddTwoNumsLL.ListNode num21 = addTwoNumsLL.new ListNode(5);
		AddTwoNumsLL.ListNode num22 = addTwoNumsLL.new ListNode(6);
		AddTwoNumsLL.ListNode num23 = addTwoNumsLL.new ListNode(4);
		num21.next = num22;
		num22.next = num23;
		ListNode sum = addTwoNumsLL.addTwoNumbers(num11, num21);
		
	}

}
