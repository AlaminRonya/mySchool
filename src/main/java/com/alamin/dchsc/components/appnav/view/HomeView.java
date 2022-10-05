package com.alamin.dchsc.components.appnav.view;

import com.alamin.dchsc.components.appnav.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Home | D.C. High School & Collage")
public class HomeView extends VerticalLayout {
    public HomeView() {
        add(new Button("Hello"));
    }
}
