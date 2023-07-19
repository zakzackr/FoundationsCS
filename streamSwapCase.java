import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

class Main{
    public static void swapCase(char[] charList){
        List<Character> list = new ArrayList<Character>();
        for (Character c: charList) list.add(c);

        Function<Character, Character> swap = c -> {
            if (Character.isUpperCase(c)) return Character.toLowerCase(c);
            return Character.toUpperCase(c);
        };

        list.stream()
            .map(swap)
            .forEach(System.out::println);

        // Character[] output = list.stream().map(swap).toArray(size -> new Character[size]);
        // Arrays.stream(output).forEach(System.out::println);
    }

    public static void main(String[] args){
        swapCase(new char[]{'a', 'B', 'c', 'D'});
    }
}
