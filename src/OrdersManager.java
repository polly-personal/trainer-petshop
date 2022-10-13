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
    String getMaxOrderCustomerName() {
        double maxOrder = 0;
        String customerName = "";

        for (String nameCust : customersOrders.keySet()) {
            ArrayList<Double> ordersListOfCustomer = customersOrders.get(nameCust); //создали отдельную переменную
            //(переменная ordersListOfCustomer - список
            // заказов. нужна для присвоения конкретному клиенту суммы относящейся конкретно к нему
            //  (Внешний цикл пройдёт по ключам
            // хеш-таблицы, - это имена клиентов магазина (типа String))
//--------------------sum-------------------------------
            double sum = 0;

            for (double order : ordersListOfCustomer) { // Внутренний цикл пройдёт по значениям из списка заказов
                // КОНКРЕТНОГО клиента
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
        ArrayList<String> namesCustommerOrderLess5000 = new ArrayList<>(); // Создайте список клиентов с заказами
        // меньше 5000
        // создадим новый пустой список, куда соберём «неприбыльных» клиентов.

        // Затем с помощью двух вложенных циклов for определим суммы заказов по каждому клиенту — так же, как мы сделали в предыдущем методе getMaxOrderCustomerName(),
        // Наполните список namesCustommerOrderLess5000
        for (String name : customersOrders.keySet()) {
            ArrayList<Double> ordersListOfCustomer2 = customersOrders.get(name);
//--------------------sum-------------------------------
            double ordersSum = 0;

            for (double order : ordersListOfCustomer2) {
                ordersSum += order;
            }
            // если у какого-то из клиентов сумма заказов окажется меньше 5000, то мы добавим его в созданный список.
            if (ordersSum < 5000) {
                namesCustommerOrderLess5000.add(name);
            }
        }

        // отдельно напишем третий цикл for, которым пройдём по НОВОМУ списку клиентов
        for (String name : namesCustommerOrderLess5000) { // Удалите из хеш-таблицы тех, чьи расходы не превышают 5000
            // и уберём из исходной хеш-таблицы тех клиентов, чьи имена совпадают с именами из «неприбыльного» списка:
                customersOrders.remove(name);
            System.out.println("Клиента " + name + " больше нет в таблице.");
        }
    }
}

