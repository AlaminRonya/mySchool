package com.alamin.dchsc.components.appnav;

import com.alamin.dchsc.components.appnav.view.HomeView;
import com.alamin.dchsc.components.appnav.view.RegistrationForm;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {
    public MainLayout() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("D.C High School & Collage");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");


        VerticalLayout tabs = getTabs();
//        Tabs tabs = new Tabs();


        addToDrawer(tabs);
        addToNavbar(toggle, title);
    }

    private VerticalLayout getTabs() {
        final RouterLink listLink = new RouterLink("Home", HomeView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());
        return new VerticalLayout(
                listLink,
                new RouterLink("Admission", RegistrationForm.class)
        );
    }
}
