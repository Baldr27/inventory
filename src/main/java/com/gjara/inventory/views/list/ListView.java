package com.gjara.inventory.views.list;

import java.util.Collections;
import com.gjara.inventory.data.entities.Product;
import com.gjara.inventory.data.service.CrmService;
import com.gjara.inventory.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="", layout = MainLayout.class)
@PageTitle("Product List")
public class ListView extends VerticalLayout{
    Grid<Product> grid = new Grid<>(Product.class);
    TextField filterText = new TextField();
    ProductForm form;
    CrmService service;

    public ListView(CrmService service){
        this.service = service;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureForm();

        add(getToolbar(), getContent());
        updateList();
        closeEditor();
    }

    private Component getContent(){
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureForm(){
        form = new ProductForm(Collections.emptyList());
        form.setWidth("25em");
        form.addListener(ProductForm.SaveEvent.class, this::saveProduct);
        form.addListener(ProductForm.DeleteEvent.class, this::deleteProduct);
        form.addListener(ProductForm.CloseEvent.class, e -> closeEditor());
    }

    private void saveProduct(ProductForm.SaveEvent event){
        service.saveProduct(event.getProduct());
        updateList();
        closeEditor();
    }

    private void deleteProduct(ProductForm.DeleteEvent event){
        service.deleteProduct(event.getProduct());
        updateList();
        closeEditor();
    }

    private void configureGrid(){
        grid.addClassNames("product-grid");
        grid.setSizeFull();
        grid.setColumns("id", "name", "description", "quantity", "category");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(e -> editProduct(e.getValue()));
    }

    private HorizontalLayout getToolbar(){
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addProductButton = new Button("Add product");
        addProductButton.addClickListener(e -> addProduct());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addProductButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    public void editProduct(Product product){
        if(product == null){
            closeEditor();
        }else{
            form.setProduct(product);
            form.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor(){
        form.setProduct(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void addProduct(){
        grid.asSingleSelect().clear();
        editProduct(new Product());
    }

    private void updateList(){
        grid.setItems(service.findAllProducts(filterText.getValue()));
    }
}
