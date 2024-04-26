package com.es.proyectoFormulario.ui;

import com.es.proyectoFormulario.services.impl.ServiceUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelLogin extends JPanel{

    /*
   1º Label con el mensaje
   2º Si hay alcún campo vacío se le colorea en rojo ese campo
    */
    JButton bEnviar;
    JLabel labelUsuario;
    JLabel labelPassword;
    JTextField textFieldUsuario;
    JPasswordField textFieldPassword;
    ServiceUser serviceUser = new ServiceUser();
    JLabel estaRegistrado;

    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

            JButton b =(JButton) e.getSource();
            /*
            String user = textFieldUsuario.getText();
            String password = textFieldPassword.getText();
            System.out.println("User: "+user+"\n"+
                    "Password: "+password);
             */
            if (serviceUser.checkUser(textFieldUsuario.getText(), textFieldPassword.getText())) {
                System.out.println("Esta registrado");
                estaRegistrado.setText("Esta registrado");
            } else {
                System.out.println("Pa tu casa");
                estaRegistrado.setText("Pa tu casa");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    public PanelLogin() {
        this.setBackground(new Color(200,200,200));
        this.setLayout(null);

        bEnviar = new JButton("Enviar");
        bEnviar.setLocation(220,320);
        bEnviar.setSize(new Dimension(150,32));
        bEnviar.addMouseListener(mouseListener);

        labelUsuario = new JLabel("Usuario");
        labelUsuario.setSize(new Dimension(100, 32));
        labelUsuario.setLocation(200,200);
        labelPassword = new JLabel("Password");
        labelPassword.setSize(new Dimension(100,32));
        labelPassword.setLocation(200, 250);
        estaRegistrado = new JLabel();
        estaRegistrado.setSize(new Dimension(200,100));
        estaRegistrado.setLocation(400,225);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setSize(new Dimension(100,32));
        textFieldUsuario.setLocation(265,200);
        textFieldPassword = new JPasswordField();
        textFieldPassword.setSize(new Dimension(100,32));
        textFieldPassword.setLocation(265,250);

        this.add(estaRegistrado);
        this.add(textFieldPassword);
        this.add(textFieldUsuario);
        this.add(labelUsuario);
        this.add(labelPassword);
        this.add(bEnviar);
    }

}
