import java.util.ArrayList;

public class AfterFour {
    public static ArrayList<Integer> checkArr(int[] arr) {
        int lastFourIndex = -1;
        ArrayList<Integer> res =new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                lastFourIndex = i;
            }
        }
        if (lastFourIndex == -1)
            throw new RuntimeException();
        else if (lastFourIndex < arr.length - 1) {

            for (int i = lastFourIndex+1; i < arr.length; i++) {
                res.add(arr[i]);


            }
            for (Integer i:res
                 ) {
                System.out.println(i);

            }

            }
        return res;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 2, 4, 2, 2, 3, 2,1,9,4};
        AfterFour.checkArr(arr1);
    }
}



