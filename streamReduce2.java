import java.util.Arrays;

class Order{
    public int price;
    public int quantity;
    public String name;
    public String genre;

    public Order(int price, int quantity, String name, String genre){
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.genre = genre;
    }
}

class Main{
    public static void main(String[] args){
        Order ramen = new Order(10, 2, "ramem", "food");
        Order orangeJuice = new Order(7, 2, "orange juice", "beverage"); 
        Order pen = new Order(5, 10, "pen", "stationery"); 
        Order[] shoppingList = {ramen, orangeJuice, pen};

        int totalPayment = Arrays.stream(shoppingList)
            .mapToInt(order -> order.price * order.quantity)  // intStream
            .reduce(0, (total, x) -> total + x);

        System.out.println(totalPayment);

        int totalPayment2 = Arrays.stream(shoppingList)
            .map(order -> order.price * order.quantity)  // Stream<Integer>
            .reduce(0, (total, x) -> total + x);
        
        System.out.println(totalPayment2);
    }
}
