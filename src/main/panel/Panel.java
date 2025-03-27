package panel;

import agenda.Agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JFrame {
    public Panel(Agenda agenda) {
        setTitle("Bem vindo ao sua agenda");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Digite o texto:");
        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton button = new JButton("Enviar");

        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        add(panel);
        button.addActionListener(e -> {
            String text = textArea.getText();
            System.out.println(text);
            agenda.write(text);
        });
        setVisible(true);
    }
}
