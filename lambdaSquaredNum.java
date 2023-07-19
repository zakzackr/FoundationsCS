import java.util.ArrayList;
import java.util.function.*;

class Main{
    // 固定配列の要素をそれぞれ2乗して動的配列で返す
    public static void main(String[] args){
        BiFunction<Function<Integer, Integer>, int[], ArrayList<Integer>> squaredList = (f, list) -> {
            ArrayList<Integer> output = new ArrayList<>();
            for (int num: list) output.add(f.apply(num));
            return output;
        };

        System.out.println(squaredList.apply(x -> x * x, new int[]{10, 20, 30, 40, 50}));
    }
}
