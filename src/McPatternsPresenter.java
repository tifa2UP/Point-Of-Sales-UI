import java.io.FileInputStream;
import java.util.Scanner;

class McPatternsPresenter {
        //This is the class that will handle the model <-> UI communication.
        Order order;
        McPatternsGUI view;

    public Order getOrder() {
        return order;
    }

    void loadMenuItems() {
        // TODO: Add code to read a file and load the menu items.
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
        }

