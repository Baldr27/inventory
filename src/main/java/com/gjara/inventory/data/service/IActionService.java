package com.gjara.inventory.data.service;

import java.util.List;

import com.gjara.inventory.data.entities.Action;

public interface IActionService {
        
        List<Action> getAllActions();
        List<Action> getActionsByName(String name);
        Action saveAction(Action action);
        Action updateAction(Action action);
        Action getActionById(Long id);
        void deleteAction(Long id);
    
}
