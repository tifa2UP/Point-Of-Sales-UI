import javax.swing.*;
import javax.swing.tree.ExpandVetoException;
import java.awt.*;
import java.awt.event.*;


class McPatternsGUI extends JFrame {
    public McPatternsPresenter getPresenter() {
        return presenter;
    }

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

//        JTextField ccEntry = new JTextField("Enter CC #");
        JTextArea ccEntry = new JTextArea(presenter.getDisplayFormat());


        JTextField orderDetail = new JTextField("no orders");

        JButton confirm = new JButton("Checkout");
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO: Add the function to handle confirmed order
                presenter.checkout();
                //Think about where you will store order and who should manipulate.
                //Handle the Payment validation before confirming order. Who should validate?
                orderDetails.setText("the total for your order is $" + order.computePrice() + " ");
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

        ActionListener menuItemPressed = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    presenter.addItem(e.getActionCommand());
                    ccEntry.setText(presenter.getDisplayFormat());

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        };
        for (Item i: order.getItems()){
            JButton menuItem = new JButton(i.getName());
            buttonPanel.add(menuItem);
            menuItem.addActionListener(menuItemPressed);
        }




        theFrame.add(title,BorderLayout.NORTH);
        theFrame.add(buttonPanel, BorderLayout.CENTER);
        theFrame.add(orderPane, BorderLayout.EAST);
        theFrame.setSize(800,600);




        theFrame.pack();
        theFrame.setVisible(true);

    }
}