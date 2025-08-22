package TOMATO.factory;
// OrderFactory work is to create aa order

import java.util.List;

import TOMATO.models.Cart;
import TOMATO.models.MenuItem;
import TOMATO.models.Order;
import TOMATO.models.Resturant;
import TOMATO.models.User;
import TOMATO.strategy.PaymentStrategy;

public interface OrderFactory {

    Order createOrder(Resturant resturant, User user, Cart cart, PaymentStrategy paymentStrategy, List<MenuItem> menuItems, double totalCost, String orderType);
}
