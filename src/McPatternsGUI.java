import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class McPatternsGUI extends JFrame {
    McPatternsPresenter presenter;
    Order order;

    public McPatternsGUI(McPatternsPresenter presenter) {

        this.presenter = presenter;
        presenter.attachView(this);
        order = presenter.getOrder();
        showGUI();


    }
    private void showGUI() {
        presenter.loadMenuItems();

        JFrame theFrame = new JFrame("Swing Example");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setLayout(new BorderLayout());

        JPanel title = new JPanel(new FlowLayout());
        title.add(new JLabel("Welcome to McPatterns"));

        JPanel orderPane = new JPanel();
        orderPane.setLayout(new BoxLayout(orderPane, BoxLayout.PAGE_AXIS));
        JLabel orderDetails = new JLabel("Your order");
        orderPane.setBorder(BorderFactory.createRaisedBevelBorder());
        orderPane.add(orderDetails);
        JTextField ccEntry = new JTextField("Enter CC #");

        JButton confirm = new JButton("Place Order");
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO: Add the function to handle confirmed order
                //Think about where you will store order and who should manipulate.
                //Handle the Payment validation before confirming order. Who should validate?
                orderDetails.setText("Order confrimed for " + ccEntry.getText());
            }

        });
        JButton cancel = new JButton("Cancel Order");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO: Add the function to handle cancel order
                //Think about where you will store order and who should manipulate.
                orderDetails.setText("Order cancelled");
            }

        });


        orderPane.add(ccEntry);
        orderPane.add(confirm);
        orderPane.add(cancel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        // TODO: Ask the presenter for the buttons to create. Iterate over the buttons and create them
//        buttonPanel.add(new JButton("Replace with actual Menu Items"));
//        buttonPanel.add(new JButton("test test"));
        for (Item i: order.getItems()){
            buttonPanel.add(new JButton(i.getName()));
        }

        theFrame.add(title,BorderLayout.NORTH);
        theFrame.add(buttonPanel, BorderLayout.CENTER);
        theFrame.add(orderPane, BorderLayout.EAST);
        theFrame.setSize(800,600);




        theFrame.pack();
        theFrame.setVisible(true);

    }
}