package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("login")
@PageTitle("Login | Vaadin CRM")
public class LoginView extends Composite<LoginOverlay>{

    private final LoginForm login = new LoginForm();

    public LoginView(){
        LoginOverlay loginOverlay = getContent();
        loginOverlay.setTitle("Lable propject");
        loginOverlay.setDescription("Add/Delete/Rename you Labels");
        loginOverlay.setOpened(true);

        // Add listener to login component
        loginOverlay.addLoginListener(event -> {
            if("user".equals(event.getUsername())){
                UI.getCurrent().navigate(Mainview.class);
            }else if("admin".equals(event.getUsername())) {
                UI.getCurrent().navigate(AdminView.class);
            }else{
                Notification.show("wrong");
            }
        });
    }

}
