package com.example.demo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("main")
public class Mainview extends VerticalLayout{
    private TextField textField;
    private Label label;
    public Mainview() {
        textField = new TextField("Enter text:");
        Button addButton = new Button("Add", e -> addLabel());
        Button deleteButton = new Button("Delete", e -> deleteLabel());
        Button renameButton = new Button("Rename", e -> renameLabel());
        HorizontalLayout buttonsLayout = new HorizontalLayout(addButton, deleteButton, renameButton);
        add(textField, buttonsLayout);
    }
    private void addLabel() {
        String text = textField.getValue();
        label = new Label(text);
        add(label);
    }

    private void deleteLabel() {
        if (label != null) {
            remove(label);
            label = null;
        }
    }

    private void renameLabel() {
        if (label != null) {
            String text = textField.getValue();
            label.setText(text);
        }
    }
}
