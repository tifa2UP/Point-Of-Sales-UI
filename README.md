<h1 style="text-align: center">Point of Sales</h1>

<img src="http://www.stirling-payments.com/images/Harbortouch.jpg" alt="Point of sales image" style="width: 350px; height: 250px; alignment: center">

<h3><i>Point of Sales</i> is a Java Swing application that imitates a checkout counter at most shops</h3>

<h2>Features: </h2>

<h2>Design Decisions: </h2>
<ul>
    <li>Made the <i>Order</i> Class a singleton since only one order can be active at any instance</li>
    <li>The Program Creates CreditCards using the <i>Factory Method</i> pattern by getting the cardnumber ->
        determining the type of the card -> Creating a CreditCard object (and returns null if the number is incorrect)</li>
    <li>Used a <i>HashMap</i> to store the order status and choosing the key to be the item and the value to be the number
        of items to checkout. (in addition to the fact that duplicates aren't allowed)</li>
    <li>Followed the MVC pattern and used <i>Action Listeners</i> to alert the controller of any changes</li>
    <li>I chose not to make the model type-safe since the user can only input data through the UI which I'm sure of its type
    (and this saved me a lot of implementation time!)</li>
    <li>I chose to input the credit card information as a <i>String</i> and then parse it into a <i>Big Integer</i>
    since credit card number can have up to 18 digits (which even a <i>float</i> can't handle)</li>
</ul>
<br>
<h2>Screenshots: </h2>
<p>//TODO: add screenshots</p>
<br>
<h2>Design drawbacks: </h2>
<ul>
    <li>The biggest drawback of my design is that it's tightly coupled due to the extensive use of design patterns</li>
    <li>The user has to relaunch the application if he/she wants to add a new item to the menu</li>
</ul>
<h2>Other info:</h2>
<ul>
    <li>The application parses the menu from input.txt</li>
    <li>The input file should be formatted in the following way:
    Item name | Price (without the dollar sign) followed by a new line <br>
    For example:<br>
        Royale with cheese|3.99 <br>
        Le Big Mac|4.99 <br>
        Milkshake|5.00</li>
    <li>The type of the credit card swiped and it's info is available at the terminal, in addition to the order status</li>
    <li>Only 3 Credit Card types are currently supported: Visa, American Express and MasterCard</li>
</ul>


