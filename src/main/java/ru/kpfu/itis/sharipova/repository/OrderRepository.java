package ru.kpfu.itis.sharipova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.sharipova.model.Order;

/**
 * Created by lia on 30.05.16.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
}
