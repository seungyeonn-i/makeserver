package com.ssumc.crud.web.order;

import com.ssumc.crud.domain.order.Order;
import com.ssumc.crud.domain.order.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping(value = "/orders/new")
    public String addOrder(@ModelAttribute("order") Order order, RedirectAttributes redirectAttributes) {
        Order order1 = new Order();
        order1.setOrderId(order1.getOrderId());
        order1.setStoreId(order.getStoreId());
        order1.setBucketId(order.getBucketId());
        order1.setUserId(order.getUserId());
        order1.setToAddress(order.getToAddress());
        order1.setTotalPrice(order.getTotalPrice());
        order1.setStoreMessage(order.getStoreMessage());
        order1.setRiderMessage(order.getRiderMessage());


        orderService.save(order);

        return "redirect:/";
    }

    @PostMapping(value = "/orders/findOrder")
    public String findByOrder(@ModelAttribute("order") OrderId orderId, RedirectAttributes redirectAttributes) {
//        log.info(String.valueOf(orderId.getOrderId()));

        Optional<Order> result = orderService.findByOrder(orderId.getOrderId());

        log.info("find Order : " +  result.get().getOrderId());
        return "redirect:/";
    }
    @Getter @Setter
    class OrderId{
        int orderId;
    }


}
