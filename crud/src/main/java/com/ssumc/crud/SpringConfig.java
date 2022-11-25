package com.ssumc.crud;

import com.ssumc.crud.domain.item.ItemRepository;
import com.ssumc.crud.domain.item.ItemService;
import com.ssumc.crud.domain.item.ItemServiceImpl;
import com.ssumc.crud.domain.item.JdbcItemRepository;
import com.ssumc.crud.domain.order.JdbcOrderRepository;
import com.ssumc.crud.domain.order.OrderRepository;
import com.ssumc.crud.domain.user.JdbcUserRepository;
import com.ssumc.crud.domain.user.UserRepository;
import com.ssumc.crud.domain.user.UserService;
import com.ssumc.crud.domain.user.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new JdbcUserRepository(dataSource);
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceImpl(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JdbcItemRepository(dataSource);
    }

    @Bean
    public OrderRepository billRepository() {
        return new JdbcOrderRepository(dataSource);
    }

}
