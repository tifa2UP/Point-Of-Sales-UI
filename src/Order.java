

import java.util.*;
import java.util.concurrent.ExecutionException;

class Order {
    private HashMap<Item, Integer> currentOrder;

    public Order(MenuItems items){
        currentOrder = new HashMap<>();


        for (Item item: items.getMenuItems()){
            currentOrder.put(item, 0);
        }
    }

    public void addItemToOrder(Item item) throws Exception{
        if (!currentOrder.containsKey(item)) {
            Exception e = new Exception("item not found!");
            throw e;
        }
            currentOrder.put(item, currentOrder.get(item)+ 1);
    }

    public double computePrice(){
        double price = 0;
        Iterator it = currentOrder.entrySet().iterator();
        while (it.hasNext()){
            HashMap.Entry pair = (Map.Entry) it.next();
            Item item = (Item) pair.getKey();
            int itemPrice = (int) pair.getValue();
            price += (item.getPrice())*(itemPrice);
        }
//        System.out.println(price);
        return price;
    }
}