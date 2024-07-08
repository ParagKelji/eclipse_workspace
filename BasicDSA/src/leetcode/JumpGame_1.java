package leetcode;

public class JumpGame_1 {
	
	public boolean canJump(int[] nums) {
        boolean isJumpable = false;
        if ( nums == null || nums.length <= 0 ) {
			return isJumpable;
		}
        if ( nums.length == 1 ) {
			return true;
		}
        int end = nums.length - 1;
        int firstJumpMax = nums[0];
        if ( firstJumpMax <= 0 ) {
			return isJumpable;
		}
        if ( firstJumpMax >= end ) {
        	return true;
        }
        int jumpDistance = 0;
        for ( int i = 1; i <= firstJumpMax; i++ ) {
        	jumpDistance = i;
        	while ( jumpDistance < end ) {
				int currJump = nums[jumpDistance];
				if ( currJump == 0 ) {
					break;
				}
        		jumpDistance += currJump;
				if ( jumpDistance >= end ) {
					isJumpable = true;
					break;
				}
			}
        	if ( isJumpable ) {
				break;
			}
        }
        return isJumpable;
    }
	
	public static void main(String[] args) {
		JumpGame_1 jmpGame = new JumpGame_1();
		int[] nums = {3,2,1,0,4};
		//System.out.println(jmpGame.canJump(nums));
		int[] nums2 = {2,3,1,1,4};
		//System.out.println(jmpGame.canJump(nums2));
		int[] nums3 = {1,2,3};
		System.out.println(jmpGame.canJump(nums3));
	}

}
