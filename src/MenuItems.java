import java.util.ArrayList;

/**
 * Created by Abdellatif on 4/15/2016.
 */
public class MenuItems {
    private ArrayList<Item> menuItems;

    public MenuItems(int numberOfItems){
        menuItems = new ArrayList<>();
    }

    public void addItem (Item item){
        menuItems.add(item);
    }

    public int getNumberOfItems(){
        return menuItems.size();
    }

    public ArrayList<Item> getMenuItems(){
        return menuItems;
    }
}
