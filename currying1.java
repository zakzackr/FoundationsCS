import java.util.function.*;

class Main{
   public static void main(String[] args){
      BiFunction<Integer, Integer, Integer> f1 = (x, y) -> x * y;
      System.out.println(f1.apply(10, 20));

      // カリー化: 複数の引数を取る関数を、それぞれ単一の引数を取る一連の関数に変換する方法
      Function<Integer, Function<Integer, Integer>> curryF = x -> y -> x * y;
      System.out.println(curryF.apply(10).apply(20));
   }
}
