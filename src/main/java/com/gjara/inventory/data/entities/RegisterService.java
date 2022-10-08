package com.gjara.inventory.data.entities;

import java.util.List;

import com.gjara.inventory.data.repository.IRegisterRepository;
import com.gjara.inventory.data.service.IRegisterService;

public class RegisterService implements IRegisterService{
    private IRegisterRepository registerRepository;

    public RegisterService(IRegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public List<Register> getAllRegisters() {
        return registerRepository.findAll();
    }

    @Override
    public List<Register> getRegistersByUser(User user) {
        return registerRepository.findByUser(user);
    }

    @Override
    public List<Register> getRegisterByProduct(Product product) {
        return registerRepository.findByProduct(product);
    }

    @Override
    public List<Register> getRegisterByAction(Action action) {
        return registerRepository.findByAction(action);
    }

    @Override
    public Register saveRegister(Register register) {
        return registerRepository.save(register);
    }

    @Override
    public Register updateRegister(Register register) {
        return registerRepository.save(register);
    }

    @Override
    public void deleteRegister(Long id) {
        registerRepository.deleteById(id);
    }
}
