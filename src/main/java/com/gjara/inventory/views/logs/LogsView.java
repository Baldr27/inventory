package com.gjara.inventory.views.logs;

import javax.annotation.security.PermitAll;

import com.gjara.inventory.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PermitAll
@Route(value = "logs", layout = MainLayout.class)
@PageTitle("Logs")
public class LogsView extends VerticalLayout{
    
}
