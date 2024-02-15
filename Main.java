import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private ArrayList<Object> mixedList = new ArrayList<>();
    private List<String> sortedStrings; // This will be initialized during sorting

    public static void main(String[] args) {
        Main main = new Main();
        main.addItem(1);
        main.addItem("Amazing");
        main.addItem(3.14);
        main.addItem("Love");
        main.addItem(2);

        // Sort the strings in the mixedList by their length
        main.sortStringsByLength();

        // Print the sorted list
        System.out.println(main.mixedList);
    }

    public void addItem(Object item) {
        mixedList.add(item);
    }

    public Object getItem(int index) {
        return mixedList.get(index);
    }

    private void sortStringsByLength() {
        // Extract strings, sort them by length, and store in the private sortedStrings list
        sortedStrings = mixedList.stream()
                .filter(item -> item instanceof String)
                .map(item -> (String) item)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        // Replace strings in mixedList with sorted strings from sortedStrings
        for (int i = 0, strIndex = 0; i < mixedList.size(); i++) {
            if (mixedList.get(i) instanceof String) {
                mixedList.set(i, sortedStrings.get(strIndex++));
            }
        }
    }
}
