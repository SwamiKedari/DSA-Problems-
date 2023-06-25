package tricky;

public class matchSticksGame {
    static int matchGame(Long n) {
        // code here
        // we have to find the number of matchsticks we should remove such that he wins always
        int val=(int)(n%5);
        if(val==0){
            return -1;
        }
        return val;
    }
    // in this question, if the n is the multiple of 5, then the person playing second will always win because he will convert the no to the multiple of n again
    // so during the first move , if the n is the multiple of 5, then the first person to play can not win
    // if the first person is not equal to multiple of 5, then the first person can convert it to the multiple of 5 and thus win
}
