package com.example.mobilprogramlamafinal.Modals;

import android.widget.Button;

public class AddLabelModals {

    String label ;
    String description;
    Button btnAddLabel;

    public AddLabelModals() {
    }

    public AddLabelModals(String label, String description, Button btnAddLabel) {
        this.label = label;
        this.description = description;
        this.btnAddLabel = btnAddLabel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Button getBtnAddLabel() {
        return btnAddLabel;
    }

    public void setBtnAddLabel(Button btnAddLabel) {
        this.btnAddLabel = btnAddLabel;
    }
}
