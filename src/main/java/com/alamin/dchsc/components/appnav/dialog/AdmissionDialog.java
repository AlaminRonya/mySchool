package com.alamin.dchsc.components.appnav.dialog;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.io.Serializable;

public class AdmissionDialog extends VerticalLayout implements Serializable {
    Dialog dialog = new Dialog();
    public AdmissionDialog() {
        dialog.setHeaderTitle("Hello");
        Button cancelButton = new Button("Cancel", (e) -> dialog.close());
        cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        dialog.getFooter().add(cancelButton);
//        dialog.removeAll();
//        dialog.add("Java");
//        dialog.open();
    }

    public void getDialog(String error){
//        dialog.removeAll();
        dialog.add(error);
        dialog.open();
    }
}
