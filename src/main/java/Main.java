import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static int findPositionOfLargestElement(int [] array){
        int maxPosition = 0;
        for(int i=0; i<array.length; i++) {
            if(array[i]>=array[maxPosition]) {
                maxPosition = i;
            }
        }
        return maxPosition;
    }

    private static int findMaxSumForHair(int[] prices) {
        int maxPosition = 0;
        int earnedSum = 0;
        while (prices.length>0) {
            maxPosition = findPositionOfLargestElement(prices);
            earnedSum += (maxPosition+1)*prices[maxPosition];
            prices = Arrays.copyOfRange(prices, maxPosition+1, prices.length);
        }
        return earnedSum;
    }


    public static void main (String [] args) {

        try {
            String input = FileDao.readOneLineFromFile();
            String [] inputArray=input.split(" ");
            int [] inputArrayInt=new int[inputArray.length];
            for(int i=0;i<inputArray.length;i++){
                inputArrayInt[i]=Integer.parseInt(inputArray[i]);
            }

            int result = findMaxSumForHair(inputArrayInt);
            FileDao.writeStringToFile(""+result);
        } catch (IOException | NullPointerException e) {
            System.err.println(e.toString());
        }
    }
}
