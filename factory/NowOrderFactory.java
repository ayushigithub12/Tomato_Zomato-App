package TOMATO.factory;

import java.util.List;

import TOMATO.models.Cart;
import TOMATO.models.DeliveryOrder;
import TOMATO.models.MenuItem;
import TOMATO.models.Order;
import TOMATO.models.PickupOrder;
import TOMATO.models.Resturant;
import TOMATO.models.User;
import TOMATO.strategy.PaymentStrategy;
import TOMATO.utils.TimeUtils;

public class NowOrderFactory implements OrderFactory {

    @Override
    public Order createOrder(Resturant resturant, User user, Cart cart, PaymentStrategy paymentStrategy,
            List<MenuItem> menuItems, double totalCost, String orderType) {
                    Order order = null;

                    if(orderType.equals("Delivery")){
                        DeliveryOrder deliveryOrder = new DeliveryOrder();
                        deliveryOrder.setUserAddress(user.getAddress());
                        order = deliveryOrder;
                    }else{
                        PickupOrder pickupOrder = new PickupOrder();
                        pickupOrder.setResturantAddress(resturant.getLocation());
                        order = pickupOrder;
                    }

                    order.setItems(menuItems);
                    order.setPaymentStrategy(paymentStrategy);
                    order.setResturant(resturant);
                    order.setSchedule(TimeUtils.getCurrentTime());
                    order.setTotal(totalCost);
                    order.setUser(user);
                return order;
    }
    
}
