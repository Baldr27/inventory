package com.gjara.inventory.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gjara.inventory.data.entities.Action;
import com.gjara.inventory.data.entities.Product;
import com.gjara.inventory.data.entities.Register;
import com.gjara.inventory.data.entities.User;

public interface IRegisterRepository extends JpaRepository<Register, Long> {

    List<Register> findByUser(User user);

    List<Register> findByProduct(Product product);

    List<Register> findByAction(Action action);

    
}
