package com.gjara.inventory.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gjara.inventory.data.entities.Action;

public interface IActionRepository extends JpaRepository<Action, Long> {

    List<Action> findByName(String name);

}
