package agenda;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agenda {
    private final String dir;
    private File file;

    public Agenda(String dir) {
        System.out.println(getTodayDate());
        this.dir = dir;
        createDirectory();
    }

    public Agenda() {
        this.dir = System.getProperty("user.home") + "/agenda";
        createDirectory();
    }

    private void createDirectory() {
        File dir = new File(this.dir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    private boolean createFile() {

        this.file = new File(this.dir + "/" + getTodayDate() + ".txt");

        try {
            return this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        return sdf.format(today);
    }

    public boolean write(String content) {
        if (!createFile()) {
            return false;
        }

        try {
            FileWriter fw = new FileWriter(this.file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void openFile() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("Abertura automática não suportada neste sistema.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
