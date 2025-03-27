import agenda.Agenda;

import javax.swing.*;

import panel.Panel;

public class Main {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        SwingUtilities.invokeLater(() -> new Panel(agenda));
    }
}