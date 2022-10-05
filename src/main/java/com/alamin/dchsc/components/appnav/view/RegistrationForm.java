package com.alamin.dchsc.components.appnav.view;

import com.alamin.dchsc.backend.ClassName;
import com.alamin.dchsc.backend.dto.RequestStudentDto;
import com.alamin.dchsc.components.appnav.MainLayout;
import com.alamin.dchsc.components.appnav.dialog.AdmissionDialog;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;

@Route(value = "/registration", layout = MainLayout.class)
@PageTitle("Admission | D.C. High School & Collage")
public class RegistrationForm extends VerticalLayout implements Serializable {

    FormLayout formLayout = new FormLayout();

    TextField fullName = new TextField("Full name *");
    TextField phoneNumber = new TextField("Phone number *");
    TextField fatherName = new TextField("Father's name *");
    TextField motherName = new TextField("Mother's name *");
    TextField presentAddress = new TextField("Present Address *");
    TextField permanentAddress = new TextField("Permanent Address *");
    TextField district = new TextField("District *");
    TextField religion = new TextField("Religion *");
    EmailField email = new EmailField("Email *");
    RadioButtonGroup<String> gender = new RadioButtonGroup<>();
    MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
    Upload upload = new Upload(buffer);
    DatePicker dateOfBirth = new DatePicker("Date of Birth *");
    ComboBox<ClassName> classNames = new ComboBox<>("Class *");
    Binder<RequestStudentDto> binder = new BeanValidationBinder<>(RequestStudentDto.class);
    Button submitted = new Button("Save");
//    Button clearBtn = new Button("Clear", event -> UI.getCurrent().navigate(""));
    Button clearBtn = new Button("Clear");
    String fileName = null;
    String classNameAdmission = null;


//    Dialog dialog = new Dialog();



    public RegistrationForm() {
        binder.bindInstanceFields(this);

        gender.setItems("MALE", "FEMALE");
        classNames.setItems(ClassName.values());

//        dialog.setHeaderTitle("Hello");
//        Button cancelButton = new Button("Cancel", (e) -> dialog.close());
//        cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
//        dialog.getFooter().add(cancelButton);

        add(
                createdFrom()
        );
    }

    private FormLayout createdFrom(){
        gender.addThemeVariants(RadioGroupVariant.LUMO_HELPER_ABOVE_FIELD);
        gender.setLabel("Gender *");


        upload.setDropAllowed(false);

        upload.addSucceededListener(event -> {
            fileName = event.getFileName();
            InputStream inputStream = buffer.getInputStream(fileName);

            System.out.println("File name==>: "+fileName);
            // Do something with the file data
            // processFile(inputStream, fileName);
        });
        classNames.addValueChangeListener(e->{
            classNameAdmission = String.valueOf(e.getValue());
        });

        formLayout.add(classNames,
                fullName, email,
                phoneNumber, dateOfBirth,
                gender, upload,
                fatherName, motherName,
                presentAddress, permanentAddress,
                district, religion,
                createButtonsLayout());

        formLayout.setResponsiveSteps(
                // Use one column by default
                new FormLayout.ResponsiveStep("0", 1),
                // Use two columns, if layout's width exceeds 500px
                new FormLayout.ResponsiveStep("500px", 2));
// Stretch the username field over 2 columns
        formLayout.setColspan(classNames, 2);
//        formLayout.setColspan(submitted, 2);
        return formLayout;
    }

    private Component createButtonsLayout() {

        submitted.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        clearBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);

        submitted.addClickListener(event -> validateAndSave());
        clearBtn.addClickListener(event-> refreshPage());

        return new HorizontalLayout(
                submitted,
                clearBtn
                );
    }

    private void validateAndSave() {
        collectData();
//        errorShow();
//        dialog.removeAll();
//        dialog.add("Java");
//        dialog.open();
    }

    private void collectData(){
        System.out.println("===============>"+ classNameAdmission);

        if (fileName == null){
            System.out.println("File is null");
        }
        if (fullName.isEmpty()){
            fullName.focus();
        }
        if (email.isEmpty() ){
            email.focus();
        }
        if (phoneNumber.isEmpty()){
            phoneNumber.focus();
        }
        if (dateOfBirth.getValue() == null){
            dateOfBirth.focus();
        }
        if (gender.getValue() == null){
            System.out.println("Gender is null");
        }
        if (fatherName.isEmpty()){
            fatherName.focus();
        }
        if (motherName.isEmpty()){
            motherName.focus();
        }
        if (presentAddress.isEmpty()){
            presentAddress.focus();
        }
        if (permanentAddress.isEmpty()){
            permanentAddress.focus();
        }
        if (district.isEmpty()){
            district.focus();
        }
        if (religion.isEmpty()){
            religion.focus();
        }


        final String fullNameValue = fullName.getValue();
        final String emailValue = email.getValue();
        final String phoneNumberValue = phoneNumber.getValue();
        final LocalDate dateOfBirthValue = dateOfBirth.getValue();
        final String genderValue = gender.getValue();
        final String fatherNameValue = fatherName.getValue();
        final String motherNameValue = motherName.getValue();
        final String presentAddressValue = presentAddress.getValue();
        final String permanentAddressValue = permanentAddress.getValue();
        final String districtValue = district.getValue();
        final String religionValue = religion.getValue();





//        System.out.println("fullNameValue:"+fullNameValue);
//        System.out.println("emailValue:"+emailValue);
//        System.out.println("phoneNumberValue:"+phoneNumberValue);
//        System.out.println("dateOfBirthValue:"+dateOfBirthValue);
//        System.out.println("genderValue:"+genderValue);
//        System.out.println("fatherNameValue:"+fatherNameValue);
//        System.out.println("motherNameValue:"+motherNameValue);
//        System.out.println("presentAddressValue:"+presentAddressValue);
//        System.out.println("permanentAddressValue:"+permanentAddressValue);
//        System.out.println("districtValue:"+districtValue);
//        System.out.println("religionValue:"+religionValue);

    }




    private void errorShow(){
        var dialog = new AdmissionDialog();
        dialog.getDialog("Java Programming");

    }

    private void refreshPage(){
        UI.getCurrent().getPage().reload();
    }

}
