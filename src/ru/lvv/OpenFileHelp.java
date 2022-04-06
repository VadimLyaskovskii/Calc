package ru.lvv;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class OpenFileHelp {
    public void openFileHelp() throws FileNotFoundException {
        URL url = getClass().getResource("Help");
        assert url != null;
        File file = new File(url.getPath());
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();
    }
}
