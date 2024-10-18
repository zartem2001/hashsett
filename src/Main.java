import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Adress, Integer> costPerAdress = new HashMap<>();
        costPerAdress.put(new Adress("Россия", "Москва"), 234);
        costPerAdress.put(new Adress("Россия", "СПБ"), 239);
        costPerAdress.put(new Adress("Россия", "Новособирск"), 240);
        costPerAdress.put(new Adress("Россия", "Москва"), 223);
        Scanner scanner = new Scanner(System.in);
        Set<String> countries = new HashSet<>();
        int totalPrice = 0;
        while (true) {
            System.out.println("Заполнение нового заказа");
            System.out.print("Введите страну: ");
            String country = scanner.nextLine();
            if ("end".equals(country)) {
                break;
            }
            System.out.print("Введите город ");
            String city = scanner.nextLine();
            System.out.print("Введите вес ");
            int weight = Integer.parseInt(scanner.nextLine());
            Adress adress = new Adress(country, city);
            if (costPerAdress.containsKey(adress)) {
                int currentPrice = weight * costPerAdress.get(adress);
                totalPrice += currentPrice;
                countries.add(country);
                System.out.printf("Стоимость доставки составит: %s \n",currentPrice);
                System.out.printf("Общая стоимость всех доставок:%s, \n",totalPrice);
                System.out.printf("Количество городов: %s \n" ,countries.size());
            }else{
                System.out.println("Такой адрес не обслуживается");
            }
            System.out.println();
        }
    }
}