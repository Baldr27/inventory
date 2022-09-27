package com.gjara.inventory.views.list;

import java.util.List;

import com.gjara.inventory.data.entities.Category;
import com.gjara.inventory.data.entities.Product;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;;

public class ProductForm extends FormLayout{

    private TextField name = new TextField("Name");
    private TextArea description = new TextArea("Description");
    private NumberField quantity = new NumberField("Quantity");
    private ComboBox<Category> category = new ComboBox<>("Category");

    private Product product;

    Binder<Product> binder = new BeanValidationBinder<>(Product.class);

    public ProductForm(List<Category> categories){
        addClassName("product-form");
        binder.bindInstanceFields(this);

        quantity.setSuffixComponent(new Span("pcs"));
        quantity.setStep(1);

        category.setItems(categories);
        category.setItemLabelGenerator(Category::getName);


        Button save = new Button("Save");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        save.addClickShortcut(Key.ENTER);
        save.addClickListener(e -> validateAndSave());

        Button delete = new Button("Delete");
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        delete.addClickListener(e -> fireEvent(new DeleteEvent(this, product)));

        Button cancel = new Button("Cancel");
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        cancel.addClickShortcut(Key.ESCAPE);
        cancel.addClickListener(e -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        HorizontalLayout buttons = new HorizontalLayout(save, delete, cancel);
        add(name, description, quantity, category, buttons);
    }

    private void validateAndSave(){
        try{
            binder.writeBean(product);
            fireEvent(new SaveEvent(this, product));
        }catch (ValidationException e){
            e.printStackTrace();
        }
    }

    public void setProduct(Product product){
        this.product = product;
        binder.readBean(product);
    }

    public static abstract class ProductFormEvent extends ComponentEvent<ProductForm>{
        private Product product;
    
        protected ProductFormEvent(ProductForm source, Product product){
            super(source, false);
            this.product = product;
        }
    
        public Product getProduct(){
            return product;
        }
    }
    
    public static class SaveEvent extends ProductFormEvent{
        SaveEvent(ProductForm source, Product product){
            super(source, product);
        }
    }
    
    public static class DeleteEvent extends ProductFormEvent{
        DeleteEvent(ProductForm source, Product product){
            super(source, product);
        }
    }
    
    public static class CloseEvent extends ProductFormEvent{
        CloseEvent(ProductForm source){
            super(source, null);
        }
    }
    
    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener){
        return getEventBus().addListener(eventType, listener);
    }
}
