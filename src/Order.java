

import java.util.*;
import java.util.concurrent.ExecutionException;

class Order {
    private static Order instance = new Order();
    private boolean isInstantiated = false;
    private HashMap<Item, Integer> currentOrder;

    private Order(){
    }

    public static Order getInstance(){
        return instance;
    }

    public void createOrder(MenuItems items){
        isInstantiated = true;
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
        return price;
    }

    public HashMap<Item, Integer> getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(HashMap<Item, Integer> currentOrder) {
        this.currentOrder = currentOrder;
    }

    public boolean isInstantiated() {
        return isInstantiated;
    }

    public void setInstantiated(boolean instantiated) {
        isInstantiated = instantiated;
    }

    public void clearOrder(){
        Iterator it = currentOrder.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (Map.Entry) it.next();
            currentOrder.put((Item) pair.getKey(), 0);
        }
        }

    public boolean checkoutOrder(){
        return false;
    }

    public Item[] getItems(){
        Item[] items = new Item[currentOrder.size()];
        Iterator it = currentOrder.entrySet().iterator();
        int itemIndex = 0;
        while (it.hasNext()) {
            HashMap.Entry pair = (Map.Entry) it.next();
            items[itemIndex] = (Item) pair.getKey();
            itemIndex++;
        }
        return items;
    }

}