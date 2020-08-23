// StringQuickSort.java
// just quick sort with pivot is the last element

package phonebook;

public class StringQuickSort {

    static void sort(String[] stringArray) {
        sort(stringArray, 0, stringArray.length - 1);
    };

    static private void sort(String[] stringArray, int low, int high) {
        if (low < high) {
            int pivot = getPivot(stringArray, low, high);
            sort(stringArray, low, pivot - 1); // sort before pivot
            sort(stringArray, pivot + 1, high); // sort after pivot
        }
    }

    private static int getPivot(String[] stringArray, int low, int high) {
        String pivot = stringArray[high];
        int i = low;
        for (int j = low; j <= high - 1; j++) {
            if (stringArray[j].compareToIgnoreCase(pivot) < 0) {
                swap(stringArray, i, j);
                i++;
            }
        }
        swap(stringArray, i, high);
        return i;

    }

    private static void swap(String[] stringArray, int i, int j) {
        String temp = stringArray[i];
        stringArray[i] = stringArray[j];
        stringArray[j] = temp;
    }

    // public static void main(String[] args) {
    // String[] stringArray = new String[] { "Z", "B", "Y", "F", "S", "I", "E", "O",
    // "R", "L", "G", "J", "V", "T", "X",
    // "U", "K", "P", "A", "W", "Q", "D", "C", "H", "N", "M" };
    // StringQuickSort.sort(stringArray);
    // for (String string : stringArray) {
    // System.out.println(string);
    // }
    // }

}