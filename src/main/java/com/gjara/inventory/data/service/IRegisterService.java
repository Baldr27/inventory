package com.gjara.inventory.data.service;

import java.util.List;

import com.gjara.inventory.data.entities.Action;
import com.gjara.inventory.data.entities.Product;
import com.gjara.inventory.data.entities.Register;
import com.gjara.inventory.data.entities.User;

public interface IRegisterService {
    
    List<Register> getAllRegisters();
    List<Register> getRegistersByUser(User user);
    List<Register> getRegisterByProduct(Product product);
    List<Register> getRegisterByAction(Action action);
    Register saveRegister(Register register);
    Register updateRegister(Register register);
    void deleteRegister(Long id);
    
}
