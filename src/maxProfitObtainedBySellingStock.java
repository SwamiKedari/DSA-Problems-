public class maxProfitObtainedBySellingStock {
    // doubt
    public int maxProfit(int[] p) {
        int m=p[0];
        int k=0;
        int g=p.length;
        for(int i=1;i<g;i++){
            m=Math.min(p[i],m);
            k=Math.max(p[i]-m,k);
        }
        return k;
    }
}
