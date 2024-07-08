package leetcode;

public class AddTwoNumsLL {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			ListNode curr = this;
			while ( curr != null ) {
				sb.append(curr.val);
				curr = curr.next;
			}
			return sb.toString();
		}
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
        if ( l2 == null ) {
        	sum.val = l1.val;
        	return sum;
        }
        ListNode num1 = l1;
        ListNode num2 = l2;
        ListNode sum1 = sum;
        int currSum = 0;
        int remainder = 0;
        int carryForward = 0;
        while ( num1 != null || num2 != null ) {
        	currSum = (num1 == null ? 0 : num1.val) + (num2 == null ? 0 : num2.val) + carryForward;
        	if ( currSum >= 10 ) {
	        	remainder = currSum % 10;
	        	sum1.val = remainder;
	        	carryForward = currSum / 10;
        	} else {
        		sum1.val = currSum;
				carryForward = 0;
        	}
			if ( num1 != null ) {
				num1 = num1.next;
			}
			if ( num2 != null ) {
				num2 = num2.next;
			}
        	if ( num1 != null || num2 != null ) {
				sum1.next = new ListNode();
				sum1 = sum1.next;
			}
		}
		if ( carryForward > 0 ) {
			sum1.next = new ListNode();
			sum1 = sum1.next;
			sum1.val = carryForward;
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
		//ListNode sum = addTwoNumsLL.addTwoNumbers(num11, num21);
		//System.out.println(sum);
		
		AddTwoNumsLL.ListNode num31 = addTwoNumsLL.new ListNode(9);
		AddTwoNumsLL.ListNode num32 = addTwoNumsLL.new ListNode(9);
		AddTwoNumsLL.ListNode num33 = addTwoNumsLL.new ListNode(9);
		AddTwoNumsLL.ListNode num34 = addTwoNumsLL.new ListNode(9);
		AddTwoNumsLL.ListNode num35 = addTwoNumsLL.new ListNode(9);
		AddTwoNumsLL.ListNode num36 = addTwoNumsLL.new ListNode(9);
		AddTwoNumsLL.ListNode num37 = addTwoNumsLL.new ListNode(9);
		num31.next = num32;
		num32.next = num33;
		num33.next = num34;
		num34.next = num35;
		num35.next = num36;
		num36.next = num37;
		System.out.println(num31);
		AddTwoNumsLL.ListNode num41 = addTwoNumsLL.new ListNode(9);
		AddTwoNumsLL.ListNode num42 = addTwoNumsLL.new ListNode(9);
		AddTwoNumsLL.ListNode num43 = addTwoNumsLL.new ListNode(9);
		AddTwoNumsLL.ListNode num44 = addTwoNumsLL.new ListNode(9);
		num41.next = num42;
		num42.next = num43;
		num43.next = num44;
		System.out.println(num41);
		//ListNode sum2 = addTwoNumsLL.addTwoNumbers(num31, num41);
		//System.out.println(sum2);
		AddTwoNumsLL.ListNode num5 = addTwoNumsLL.new ListNode(0);
		AddTwoNumsLL.ListNode num6 = addTwoNumsLL.new ListNode(1);
		ListNode sum3 = addTwoNumsLL.addTwoNumbers(num5, num6);
		System.out.println(sum3);
	}

}
