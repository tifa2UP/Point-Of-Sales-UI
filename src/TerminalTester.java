/**
 * Created by Abdellatif on 4/15/2016.
 */
public class TerminalTester {
    public static void main(String[] args) throws Exception {
        MenuItems itemsList= new MenuItems();
        Item tea = new Item("tea", 2.00);
        Item coffee = new Item("coffee", 3.00);
        itemsList.addItem(tea);
        itemsList.addItem(coffee);

        Order order = new Order(itemsList);
        order.addItemToOrder(tea);
        order.addItemToOrder(coffee);
        order.addItemToOrder(coffee);
        order.addItemToOrder(coffee);
        order.addItemToOrder(coffee);
//        System.out.println(order.computePrice());
    }



}
