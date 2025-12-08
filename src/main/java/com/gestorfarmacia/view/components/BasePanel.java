package com.gestorfarmacia.view.components;

import javax.swing.*;

public abstract class BasePanel extends JPanel {

    public BasePanel() {
        inicializarComponentes();
    }

    protected abstract void inicializarComponentes();

    public abstract void limpiar();

    protected void configurarBorde(String titulo) {
        setBorder(BorderFactory.createTitledBorder(titulo));
    }
}
