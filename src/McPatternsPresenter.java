import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class McPatternsPresenter {
        //This is the class that will handle the model <-> UI communication.
        Order order;
        McPatternsGUI view;

    public Order getOrder() {
        return order;
    }

    void loadMenuItems() {
            MenuItems itemsList = new MenuItems();
            FileInputStream in = null;

            try {
                in = new FileInputStream("input.txt");
                Scanner input = new Scanner(in);
                while (input.hasNextLine()){
                    String s = input.nextLine();
                    String itemName = s.substring(0, s.indexOf('|'));
                    double itemPrice = Double.parseDouble(s.substring(s.indexOf('|') + 1));
                    itemsList.addItem(new Item(itemName, itemPrice));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            //create the order
            order = Order.getInstance();
            order.createOrder(itemsList);
        }

        void attachView(McPatternsGUI view) {
        this.view = view;
        }
        // Add functions to return the menu items.

        public McPatternsPresenter(){
        loadMenuItems();
        }

        public String getDisplayFormat(){
            String output = "";
            HashMap orderMap = order.getCurrentOrder();
            Iterator it = orderMap.entrySet().iterator();
            while (it.hasNext()) {
                HashMap.Entry pair = (Map.Entry) it.next();
//                items[itemIndex] = (Item) pair.getKey();
//                itemIndex++;
                output += ((Item) pair.getKey()).getName();
                output += " x ";
                output += (pair.getValue() + "\n");
            }
            output += "===\n";
            output += "Enter CC number: \n";
            System.out.println(output);
            return output;
        }
        }

