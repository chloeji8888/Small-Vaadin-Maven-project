package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        // Initialize your application's UI
        Button logoutButton = new Button("Logout");
        logoutButton.addClickListener(e -> {
            // Save any unsaved data to the database
            saveDataToDatabase();
            // Refresh the UI by navigating to the login view
            UI.getCurrent().navigate(LoginView.class);
        });
        Label myLabel = new Label("Welcome to my application!");
        VerticalLayout layout = new VerticalLayout(myLabel, logoutButton);
        add(layout);
    }
    private void saveDataToDatabase() {
        TextField nameField = new TextField("Name");

        // Get the current user's data from the UI components
        String name = nameField.getValue();

        // Update the database with the user's data
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password")) {
            String sql = "UPDATE users SET name=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                Notification.show("Data saved successfully");
            } else {
                Notification.show("Data not saved");
            }
        } catch (SQLException ex) {
            Notification.show("Error: " + ex.getMessage());
        }
    }


}
