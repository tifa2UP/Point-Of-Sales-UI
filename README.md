<h1 style="text-align: center">Point of Sales</h1>

<img src="http://www.stirling-payments.com/images/Harbortouch.jpg" alt="Point of sales image" style="width: 350px; height: 250px; alignment: center">

<h3><i>Point of Sales</i> is a Java Swing application that immitates a checkout counter at most shops</h3>

<h2>Features: </h2>
<ul>
    <li></li>
    <li></li>
</ul>

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
</ul>

