import java.util.Arrays;

class Main{
    public static void main(String[] args){
        int[][] array2d = {{1, 2, 3, 4}, {10, 20, 30}, {100}};
        
        // Arrays.stream(array2d): 2dArrayをStream<int[]>に変換
        // flatMapToInt(Arrays::stream): subArrayをIntStreamに変換
        // toArray(): 2dArrayのそれぞれの要素からなるIntStreamをint[]に変換
        int[] flatten = Arrays.stream(array2d).flatMapToInt(Arrays::stream).toArray();  // 2d -> 1d Array
        int sum = Arrays.stream(array2d).flatMapToInt(Arrays::stream).filter(x -> x > 10).reduce(0, (x, total) -> x + total);

        System.out.println(Arrays.toString(flatten));
        System.out.println(flatten[2]);
        System.out.println(sum);
    }
}

