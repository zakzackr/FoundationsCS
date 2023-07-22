import java.util.function.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

class Customer {
    public int id;
    public String company;
    public String name;
    public String rank;

    public Customer(int id, String company, String name, String rank) {
        this.id = id;
       this.company = company;
       this.name = name;
       this.rank = rank;
    }

    // Object classのtoStringメソッドをoverrideする
    @Override
    public String toString(){
        return "Customer{" +
            "id=" + id +
            ", company='" + company +
            ", name='" + name +
            ", rank='" + rank +
            '}';
   }
}

class Main{
    public static void main(String[] args){
        List<Customer> customerList = Arrays.asList(
            new Customer(1, "MH Corp.", "Makenzie Hibbert", "A"),
            new Customer(2, "MH Corp.", "Abram Martinho Fleming", "B"),
            new Customer(3, "Best Inc.", "Trey Best", "A"),
            new Customer(4, "Best Inc.", "Joshua Charnley", "B"),
            new Customer(5, "Best Inc.", "Sue Rodger", "C")
        );

        List<Customer> rankBList = customerList.stream()
            .filter(customer -> customer.rank.equals("B"))
            .collect(Collectors.toList());
        
        System.out.println(rankBList);

        BiFunction<List<Customer>, String, Predicate<Customer>> extractionByCompany = (list, company) -> customer -> customer.company.equals(company);
        System.out.println(
            customerList.stream()
                .filter(extractionByCompany.apply(customerList, "Best Inc."))
                .collect(Collectors.toList())
        );

        Function<String, Predicate<Customer>> filterByRank = rank -> customer -> customer.rank.equals(rank);
        Function<String, Predicate<Customer>> filterByCompany = company -> customer -> customer.company.equals(company);

        BiFunction<List<Customer>, Function<String, Predicate<Customer>>, Function<String, List<Customer>>> versatileExtraction = (list, filterCriteria) -> value -> list.stream()
            .filter(filterCriteria.apply(value))
            .collect(Collectors.toList());

        System.out.println(versatileExtraction.apply(customerList, filterByRank).apply("A"));
        System.out.println(versatileExtraction.apply(customerList, filterByCompany).apply("Best Inc."));
    }
}
