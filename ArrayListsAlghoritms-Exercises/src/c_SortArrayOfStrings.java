import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;

public class c_SortArrayOfStrings {
    public static void main(String[] args) throws IOException {
        boolean swapped;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = reader.readLine().split(" ");
        Collator frCollator = Collator.getInstance();
        //do {
        //    swapped = false;
        //    for (int i = 0; i < arr.length - 1; i++) {
        //        if (frCollator.compare(arr[i], arr[i + 1]) > 0) {
        //            String temp = arr[i];
        //            arr[i] = arr[i + 1];
        //            arr[i+1] = temp;
        //            swapped=true;
        //        }
        //    }
        //} while (swapped);

        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j > 0) {
                if (frCollator.compare(arr[j - 1], arr[j]) > 0) {
                //if (arr[j-1].compareToIgnoreCase(arr[j]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
                }
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append(" ");
        }

        System.out.println(sb);
    }
}
