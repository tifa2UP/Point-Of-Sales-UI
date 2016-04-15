import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

class Order {
    private HashMap<String, Integer> currentOrder;

    public Order(MenuItems items){

        for (Item item: items.getMenuItems()){
            currentOrder.put(item.getName(), 0);
        }
    }

    public void addItemToOrder(String name){
        currentOrder.put(name, currentOrder.get(name)+ 1);
    }


}