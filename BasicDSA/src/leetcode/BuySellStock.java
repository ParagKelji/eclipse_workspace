package leetcode;

public class BuySellStock {
	
	public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        if ( prices == null || prices.length == 0 ) {
        	return maxProfit;
        }
        int days = prices.length;
        int lowestPrice = prices[0];
        int maxPrice = 0;
        int lowestPriceDay = 0;
        int maxPriceDay = -1;
        for ( int currDay = 0; currDay < days; currDay++ ) {
        	int currPrice = prices[currDay];
        	if (lowestPrice > currPrice ) {
        		lowestPrice = currPrice;
        		lowestPriceDay = currDay;
        	}
			if (currDay != lowestPriceDay && maxPrice < currPrice ) {
        		maxPrice = currPrice;
        		maxPriceDay = currDay;
        	}
			if ( lowestPriceDay > maxPriceDay ) {
        		maxPrice = 0;
        		maxPriceDay = -1;
        	}
			if ( (maxPrice - lowestPrice) > maxProfit ) {
				maxProfit = maxPrice - lowestPrice;
			}
        }
        
        return maxProfit;
    }
	
	public static void main(String[] args) {
		BuySellStock advice = new BuySellStock();
		
		int [] prices1 = {7,1,5,3,6,4};
		System.out.println(advice.maxProfit(prices1));
		int [] prices2 = {7,6,4,3,1};
		System.out.println(advice.maxProfit(prices2));
		int [] prices3 = {100};
		System.out.println(advice.maxProfit(prices3));
		int [] prices4 = {7,1,6,4,3,1};
		System.out.println(advice.maxProfit(prices4));
		int [] prices5 = {7,1,6,4,3,2,1,8};		System.out.println(advice.maxProfit(prices5));
		int [] prices6 = {1,2}; System.out.println(advice.maxProfit(prices6));		 
		int [] prices7 = {2,4,1};
		System.out.println(advice.maxProfit(prices7));
		int [] prices8 = {2,5,1,3};
		System.out.println(advice.maxProfit(prices8));
	}

}
