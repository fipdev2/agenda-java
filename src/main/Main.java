import agenda.Agenda;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        JTextArea input = new JTextArea();
        String text = input.getText();
        agenda.write(text);
    }
}