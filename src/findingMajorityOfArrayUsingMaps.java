import java.util.*;
public class findingMajorityOfArrayUsingMaps {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> a=new HashMap<>();
        int u=nums.length;
        if(u==1){
            return nums[0];
        }
        for(int i=0;i<u;i++){
            if(!a.containsKey(nums[i])){
                a.put(nums[i],0);
            }
            else{
                a.put(nums[i],(Integer)(a.get(nums[i])+1));
            }
        }
        int k=0;
        int y=0;
        for(int j=0;j<u;j++){
            if(a.get(nums[j])>k){
                k=a.get(nums[j]);
                y=nums[j];
            }
        }
        return y;
    }
}
