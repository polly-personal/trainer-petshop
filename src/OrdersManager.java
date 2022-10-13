import java.util.ArrayList;
import java.util.HashMap;


public class OrdersManager {
    HashMap<String, ArrayList<Double>> customersOrders;

    public OrdersManager() {
        customersOrders = new HashMap<>();
        ArrayList<Double> orders = new ArrayList<>();
        orders.add(154.43);
        orders.add(5453.98);
        orders.add(8776.65);
        customersOrders.put("Иван И.", orders);

        orders = new ArrayList<>();
        orders.add(25343.54);
        orders.add(420.50);
        customersOrders.put("Ольга С.", orders);

        orders = new ArrayList<>();
        orders.add(325.90);
        customersOrders.put("Александр Т.", orders);

        orders = new ArrayList<>();
        orders.add(253.54);
        orders.add(420.50);
        customersOrders.put("Александр Р.", orders);

        orders = new ArrayList<>();
        orders.add(780.54);
        orders.add(420.50);
        orders.add(36343.54);
        orders.add(2000.50);
        customersOrders.put("Екатерина О.", orders);
    }

    void printAllOrders() {
        for (String name : customersOrders.keySet()) { // Цикл должен пройтись по ключам
            System.out.println("Заказы " + name + ":");
            ArrayList<Double> value = customersOrders.get(name);
            System.out.println(value);
        }
    }

    double getOrdersSum() {
        double sum = 0;
        for (ArrayList<Double> orders : customersOrders.values()) { // Здесь должен быть обход по значениям HashMap(a)
            for (double orderPrice : orders) { // здесь обход по значениям ArrayList(a)
                sum += orderPrice;
            }
        }
        return sum;
    }

    void printCustomerOrders(String customerName) {
        if (customersOrders.containsKey(customerName)) { // Проверьте, есть ли указанный ключ в таблице
            System.out.println("Заказы " + customerName + ":");
            System.out.println(customersOrders.get(customerName));
        }
    }
    макс_сумма_заказов = 0;
    клиент_с_макс_суммой = "";
for (String имя_клиента : ключи таблицы) {
        список_заказов типа Double = таблица.get(имя_клиента);
//--------------------sum-------------------------------
        сумма_заказов = 0;

        for (double заказ : список_заказов) {
            сумма_заказов += заказ;
        }
        if (сумма_заказов больше чем макс_сумма_заказов) {
            макс_сумма_заказов = сумма_заказов;
            клиент_с_макс_суммой = имя_клиента;
        }
    }
    возвращаем клиент_с_макс_суммой;
    String getMaxOrderCustomerName() {
        double maxOrder = 0;
        String customerName = "";

        for (String nameCust : customersOrders.keySet()) {
            ArrayList<Double> ordersListOfCustomer = customersOrders.get(nameCust); //создали отдельную переменную
            // для присвоения конкретного клиента конкретной к нему относящейся суммы (Внешний цикл пройдёт по ключам хеш-таблицы, это имена клиентов магазина (типа String))
//--------------------sum-------------------------------
            double sum = 0;

            for (double order : ordersListOfCustomer) { // Внутренний цикл пройдёт по значениям из списка заказов
                // КОКРЕТНОГО клиента
                    sum += order;
                }
//--------------------max--------------------------------
            if (sum > maxOrder) {
                maxOrder = sum;
                customerName = nameCust;
            }
        }

        return customerName;
    }

    void removeUnprofitableOrders() {
        ArrayList<String> names = new ArrayList<>(); // Создайте список клиентов с заказами меньше 5000

        // Наполните список names
        for (String name : customersOrders.keySet()) {

            double ordersSum = 0;

            for (ArrayList or : customersOrders.values()) {
                ordersSum += customersOrders.get();
            }

            if (ordersSum < 5000) {
                //        ...
            }
        }
    }

        for (...) { // Удалите из хеш-таблицы тех, чьи расходы не превышают 5000

        System.out.println("Клиента " + name + " больше нет в таблице.");
    }
}
}
