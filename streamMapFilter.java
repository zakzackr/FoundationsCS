import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.function.*;
import java.util.stream.*;


class Main{
    // forEach method: iterable interface(Collection interfaceのsuper interface)やMap interfaceが持つメソッド
    // それらを継承しているList, Collection, HashMap, TreeMapクラスなどで利用できる
    // forEachの引数はConsumer型で、戻り値を取らないラムダ式となる: forEach(Consumer<?> action)

    public static void main(String[] args){
        List<Integer> numList = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        numList.forEach(x -> System.out.println(x));
        // メソッド参照を使う
        numList.forEach(System.out::println);

        
        // MapクラスはMap interfaceを継承しているからforEach()を使うことができる
        Map<String, Integer> map = new HashMap<>(){
            {
                {
                    put("apple", 10);
                    put("lemon", 13);
                    put("cherry", 5);
                    put("melon", 3);
                }
            }
        };
        map.forEach((key, value) -> System.out.println(key + ":" + value));

        // stream API
        // StreamAPI: コレクションや配列などのデータソースを流れ（stream)として処理し、目的の結果を得るためのAPI。
        // データソース => 中間操作 => 終端操作 という流れで処理する。

        // Arrays class: stream(Array[] arr)
        int[] intArr = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(intArr);
        // streamは一度処理すると再利用できない
        // streamのforEach()は引数で指定された処理を各要素に対して実行する終端操作
        stream.forEach(System.out::println);  

        Arrays.stream(intArr)
            .forEach(System.out::println);


        // Collection interface: stream()
        List<String> strList = Arrays.asList("a","b","c","d");
        strList.stream()
            .forEach(System.out::println);


        // Stream interface: of(新しいstreamの要素となる値)
        Stream.of(2, 3, 4, 5, 6)
            .forEach(System.out::println);
        
        Stream.of("a","b","c","d")
            .forEach(System.out::println);


        // StreamAPIのmapメソッド
        // ストリームは、データソース(stream) => 中間操作 => 終端操作　という一連の流れで処理をする
        // mapメソッドは中間操作の1つで、Function interfaceを引数に持ち、指定された処理を適用した結果から構成されるストリームを返す
        // 中間操作は取得したストリームに何らかの処理をしてストリームを返すので、メソッドチェーンにより別の処理を続けることも可能
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        nums.stream()  // データソース
            .map(x -> x * x)  // 中間操作
            .forEach(System.out::println);  // 終焉操作
        
        Function<Integer, Integer> cube = x -> (int)Math.pow(x, 3);
        nums.stream()
            .map(cube)  // Function interfaceを引数に持つ
            .forEach(System.out::println);


        // StreamAPIのfilterメソッド
        // filterメソッドはPredicate interfaceを引数に持ち、指定した条件に合った要素で構成されるストリームを返す中間操作
        nums.stream()
            .filter(x -> x % 2 == 0)
            .forEach(x -> System.out.println("Even: " + x));

        Predicate<Integer> myFilter = x -> x % 2 != 0;
        nums.stream()
            .filter(myFilter)
            .forEach(x -> System.out.println("Odd: " + x));
    }
}
