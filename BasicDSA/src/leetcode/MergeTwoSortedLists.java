package leetcode;

public class MergeTwoSortedLists {
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if ( list1 == null  ) {
        	return list2;
        }
        if ( list2 == null  ) {
        	return list1;
        }
        ListNode tempList = new ListNode(0);
        ListNode sortedList = tempList;
        
        while ( list1 != null || list2 != null ) {
        	ListNode currL1N = (list1 != null) ? list1.currNode() : null;
        	ListNode currL2N = (list2 != null) ? list2.currNode() : null;
        	System.out.println("CMPR for current values : " + currL1N + ", " + currL2N);
        	if ( currL2N == null || (currL1N != null && currL1N.getVal() <= currL2N.getVal()) ) {
    			tempList.next = currL1N.currNode();
        		list1 = currL1N.nextNode();
        	} else {
        		tempList.next = currL2N.currNode();
        		list2 = currL2N.nextNode();
        	}
        	
        	ListNode tmp = tempList.nextNode();
            System.out.println("tmp : " + tmp);
            while ( tmp != null ) {
            	System.out.println("Before Assignment :" + tmp);
            	tmp = tmp.nextNode();
            }
            tmp = sortedList.nextNode();
            System.out.println("tmp : " + tmp);
            while ( tmp != null ) {
            	System.out.println("SortedList Before Assignment :" + tmp);
            	tmp = tmp.nextNode();
            }
            tempList = tempList.nextNode();
            tmp = tempList.nextNode();
            System.out.println("tmp : " + tmp);
            while ( tmp != null ) {
            	System.out.println("After Assignment :" + tmp);
            	tmp = tmp.nextNode();
            }
            tmp = sortedList.nextNode();
            System.out.println("tmp : " + tmp);
            while ( tmp != null ) {
            	System.out.println("SortedList After Assignment :" + tmp);
            	tmp = tmp.nextNode();
            }
            //System.out.println("Current values L1: " + list1);
        	//System.out.println("Current values L2: " + list2); 
        }
        ListNode tmp = sortedList.nextNode();
        System.out.println("tmp : " + tmp);
        while ( tmp != null ) {
        	System.out.println("Sorted :" + tmp);
        	tmp = tmp.nextNode();
        }
        return sortedList.nextNode();
    }
	
	public static void main(String[] args) {
		MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
		ListNode list1 = mergeTwoSortedLists.new ListNode(1);
		ListNode list2 = mergeTwoSortedLists.new ListNode(2);
		ListNode next1 = mergeTwoSortedLists.new ListNode(1);
		ListNode next2 = mergeTwoSortedLists.new ListNode(4);
		ListNode next3 = mergeTwoSortedLists.new ListNode(3);
		list1.next = next1;
		list2.next = next2;
		next1.next = next3;
		System.out.println(list1); // 1, 1, 3
		System.out.println(list2); // 2, 4
		System.out.println(mergeTwoSortedLists.mergeTwoLists(list1,list2));
	}
	
	class ListNode {
		int val;
		ListNode next;
		ListNode head;
		public ListNode() {}
		public ListNode(int val) { this.val = val; }
		public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		
		public ListNode nextNode() {
			return next;
		}

		public void setNextNode(ListNode next) {
			this.next= next;
		}
		
		public ListNode currNode() {
			return this;
		}

		public ListNode headNode() {
			return this;
		}
		
		public int getVal() {
			return val;
		}
		
		public String toString() {
			return Integer.toString(val);
		}
		
	}

}
