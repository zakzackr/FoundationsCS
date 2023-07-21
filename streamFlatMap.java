import java.util.Arrays;

class Main{
    public static void main(String[] args){
        int[][] array2d = {{1, 2, 3, 4}, {10, 20, 30}, {100}};
        // 2d -> 1d Array
        int[] flatten = Arrays.stream(array2d).flatMapToInt(Arrays::stream).toArray();
        int sum = Arrays.stream(array2d).flatMapToInt(Arrays::stream).filter(x -> x > 10).reduce(0, (x, total) -> x + total);

        System.out.println(Arrays.toString(flatten));
        System.out.println(flatten[2]);
        System.out.println(sum);
    }
}
