import java.util.Arrays;
import java.util.List;

public class MaxDigitBalloons {
	
	public String solve(int purse, List<Integer> balloonCosts) {
		String balloonDigit = "-1";
		if ( purse == 0 || balloonCosts == null || balloonCosts.size() == 0 ) {
			return balloonDigit;
		}
		int size = balloonCosts.size();
		int lowestBalloonCost = 0;
		int lowestCostBalloonNum = 0;
		StringBuilder balloonDigitSB = new StringBuilder();
		int tempPurse = purse;
		String tempMaxBalloonDigit = "";
		for (int balloonNum = (size - 1); balloonNum >= 0; balloonNum-- ) {
			int currBalloonCost = balloonCosts.get(balloonNum);
			if ( lowestBalloonCost == 0 ) {
				lowestBalloonCost = currBalloonCost;
			}
			if ( lowestBalloonCost > purse ) {
				continue;
			}
			if ( currBalloonCost <= lowestBalloonCost ) {
				lowestBalloonCost = currBalloonCost;
				lowestCostBalloonNum = balloonNum;
			}
			while ( tempPurse > 0 && tempPurse >= lowestBalloonCost ) {
				balloonDigitSB.append(lowestCostBalloonNum + 1);
				tempPurse -= lowestBalloonCost;
			}
			if ( tempPurse != 0 && balloonNum != 0 ) {
				continue;
			}
			int currMax = (tempMaxBalloonDigit == null || "".equals(tempMaxBalloonDigit) ) ? 0 : Integer.valueOf(tempMaxBalloonDigit);
			int newVal = (balloonDigitSB.length() > 0 ) ? Integer.parseInt(balloonDigitSB.toString()) : 0;
			if ( currMax < newVal ) {
				tempMaxBalloonDigit = balloonDigitSB.toString();
			}
			if ( tempPurse == 0 ) {
				tempPurse = purse;
				balloonDigitSB = new StringBuilder();
			}
		}
		balloonDigit = tempMaxBalloonDigit;
		return balloonDigit;
	}

	public static void main(String[] args) {
		MaxDigitBalloons balloons = new MaxDigitBalloons();
		int purse1 = 3;
		List<Integer> balloonsCost1 = Arrays.asList(new Integer[]{1,1,1,1,1,1,1,1,1});
		System.out.println(balloons.solve(purse1, balloonsCost1));
		

		int purse2 = 5;
		List<Integer> balloonsCost2 = Arrays.asList(new Integer[]{2,3,5,5,5,5,5,5,5});
		System.out.println(balloons.solve(purse2, balloonsCost2));
		
		int purse3 = 5;
		List<Integer> balloonsCost3 = Arrays.asList(new Integer[]{3,2,5,5,5,5,5,5,5});
		System.out.println(balloons.solve(purse3, balloonsCost3));
		
	}

}
