import java.io.FileInputStream;
import java.util.Scanner;

public class McPatterns {

    public static void main(String[] args)
    {
        MenuItems itemsList = new MenuItems();
        FileInputStream in = null;

        try {
            in = new FileInputStream("input.txt");
            Scanner input = new Scanner(in);
            while (input.hasNextLine()){
                String s = input.nextLine();
                String itemName = s.substring(0, s.indexOf('|'));
                double itemPrice = Double.parseDouble(s.substring('|'));
                itemsList.addItem(new Item(itemName, itemPrice));
            }
        }
        catch (Exception e){

        }
        McPatternsGUI gui = new McPatternsGUI(new McPatternsPresenter());
    }
}