import java.util.function.*;

class Main{
   public static double usdTojpy (double USDJPY, double paymentUSD, double handlingCharge) {
      return USDJPY * paymentUSD + handlingCharge;
   }

   public static void main(String[] args){
      System.out.println(usdTojpy(139.85, 200, 3000));
      System.out.println(usdTojpy(139.85, 32, 3000));

      Function<Double, Double> usdTojpyVisaNov17th = paymentUSD -> usdTojpy(139.85, paymentUSD, 3000);
      System.out.println(usdTojpyVisaNov17th.apply(200d));
      System.out.println(usdTojpyVisaNov17th.apply(32d));

      // 別の例
      // 2つの引数をとる元の関数
      BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
      Function<Integer, Function<Integer, Integer>> addPartial = x -> y -> add.apply(x, y);

      // 1つの引数をとる新しい関数
      Function<Integer, Integer> add10 = addPartial.apply(10);
      System.out.println(add10.apply(20));
      System.out.println(add10.apply(30));
   }
}
