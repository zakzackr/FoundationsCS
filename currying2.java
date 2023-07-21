import java.util.function.*;

class FootballClub{
   public String name;
   public String city;

   public FootballClub(String name, String city){
      this.name = name;
      this.city = city;
   }
}

class Main{
   public static void main(String[] args){
      BiFunction<String, String, FootballClub> footballFunc = (name, city) -> new FootballClub(name, city);
      FootballClub manCity = footballFunc.apply("ManCity", "Manchester");

      // カリー化
      Function<String, Function<String, FootballClub>> curryFootballFunc = name -> city -> new FootballClub(name, city);
      FootballClub liverpool = footballFunc.apply("Liverpool", "Liverpool");

      System.out.println(manCity.name);
      System.out.println(liverpool.name);
   }
}
