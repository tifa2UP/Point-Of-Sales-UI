import java.math.BigInteger;

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

        Order order = Order.getInstance();
        order.createOrder(itemsList);
        order.addItemToOrder(tea);
        order.addItemToOrder(coffee);
        order.addItemToOrder(coffee);
        order.addItemToOrder(coffee);
        order.addItemToOrder(coffee);
        System.out.println(order.computePrice());

        BigInteger creditCardNumber = new BigInteger("4012888888881881");
       CreditCard test = CreditCardFactory.getCreditCard(creditCardNumber);
        test.swipe();
    }



}
