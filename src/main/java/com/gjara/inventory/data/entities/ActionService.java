package com.gjara.inventory.data.entities;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gjara.inventory.data.repository.IActionRepository;
import com.gjara.inventory.data.service.IActionService;

@Service
public class ActionService implements IActionService {
    private IActionRepository actionRepository;

    public ActionService(IActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }
    @Override
    public List<Action> getActionsByName(String name) {
        return actionRepository.findByName(name);
    }
    @Override
    public Action saveAction(Action action) {
        return actionRepository.save(action);
    }
    @Override
    public Action updateAction(Action action) {
        return actionRepository.save(action);
    }
    @Override
    public Action getActionById(Long id) {
        return actionRepository.findById(id).get();
    }
    @Override
    public void deleteAction(Long id) {
        actionRepository.deleteById(id);
    }
    
}
