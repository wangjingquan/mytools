import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelSameChars {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        List<String> result = new ArrayList<>();
        boolean isContain;
        for (int i = 0; i < array.length; i++) {
            isContain = false;
            for (int j = 0; j < result.size(); j++) {
                if (array[i].equals(result.get(j))) {
                    isContain = true;
                    break;
                }
            }
            if (!isContain) {
                result.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) result.toArray(new String[result.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }
}
