package com.example.demo;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
@Route("user")
public class Userview extends VerticalLayout {
    public Userview() {
        add(new H1("welcome"));
    }
}
