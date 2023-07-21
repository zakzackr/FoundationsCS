import java.util.function.*;
import java.util.stream.*;
import java.util.Arrays;

class Main{
    public static int myReduce(BiFunction<Integer, Integer, Integer> callback, int[] list, int initial){
        int lastResult = initial;
        for (int i = 0; i < list.length; i++){
            int result = callback.apply(list[i], lastResult);
            lastResult = result;
        }

        return lastResult;
    }

    public static void main(String[] args){
        BiFunction<Integer, Integer, Integer> callback = (x, total) -> x * total;
        int[] list = {1, 2, 3, 4, 5};
        System.out.println(myReduce(callback, list, 1));  // 5!
        System.out.println(myReduce((x, total) -> x * total, list, 1));  // 5!
        
        // StreamAPIには、この処理を行うreduce関数がある / 
        // reduce関数はストリームの終端操作でOptional型を返す
        String[] strList = {"I ", "am ", "very ", "happy."};
        System.out.println(Arrays.stream(list).reduce((x, total) -> x * total));  // 5!
        
        // Optional以外の型で受け取りたいときは、初期値を指定する
        System.out.println(Arrays.stream(list).reduce(1, (x, total) -> x * total));  // 5!
        System.out.println(Arrays.stream(list).reduce(0, (x, total) -> x + total));  // 1+2+3+4+5
        System.out.println(Arrays.stream(list).filter(x -> x % 2 != 0).reduce(1, (total, x) -> total * x));  // 15
        System.out.println(Arrays.stream(strList).reduce("", (total, x) -> total + x));  // I am very happy.
    }
}
