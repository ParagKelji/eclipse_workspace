package leetcode;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class JumpGame_1 {
	
	public boolean canJump(int[] nums) {
		boolean isJumpable = false;
		if ( nums == null || nums.length <= 0 ) {
			return isJumpable;
		}
        if ( nums.length == 1 ) {
			return true;
		}
        int len = nums.length;
        boolean jumpedAtZero = false;
        int jumpValToAvoidZero = 0;
        nums[len - 1] += 1;
        boolean containsZero = Arrays.stream(nums).anyMatch((num) -> num == 0 );
        isJumpable = !containsZero;
        if ( !isJumpable ) {
        	for ( int i = len - 1; i >= 0; i-- ) {
        		if ( !jumpedAtZero && nums[i] == 0 ) {
        			jumpValToAvoidZero = 2;
        			jumpedAtZero = true;
        			continue;
        		}
        		if ( jumpedAtZero && nums[i] >= jumpValToAvoidZero ) {
        			jumpedAtZero = false;
        		} else {
        			jumpValToAvoidZero++;
        		}
        	}
        }
        nums[len - 1] += 1;
        if ( jumpedAtZero ) {
        	isJumpable = false;
        } else {
        	isJumpable = true;
        }
		return isJumpable;
	}
	
	public boolean canJump1(int[] nums) {
		int reachable = 0;
	       for(int i = 0; i < nums.length; i ++) {
	           if(i > reachable) return false;
	           reachable = Math.max(reachable, i + nums[i]);
	       } 
	       return true;
    }
	
	public static void main(String[] args) {
		JumpGame_1 jmpGame = new JumpGame_1();
		int[] nums = {3,2,1,0,4};
		System.out.println(jmpGame.canJump1(nums));
		int[] nums2 = {2,3,1,1,4};
		System.out.println(jmpGame.canJump1(nums2));
		int[] nums3 = {1,2,3};
		System.out.println(jmpGame.canJump1(nums3));
		int[] nums4 = {2,0};
		System.out.println(jmpGame.canJump1(nums4));
		int[] nums5 = {2,3,1,1,4};
		System.out.println(jmpGame.canJump1(nums5));
		int[] nums6 = {2,0,0};
		System.out.println(jmpGame.canJump1(nums6));
	}

}
