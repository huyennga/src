package unit1;

import java.io.*;

public class FileDirectory {
    public static void main(String[] args) throws IOException {
        // create new file
        File file = new File("text.txt");
        // write data in file
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        String data = new String("Nga Hoang");
        bw.write(data + "\n");
        bw.write(data + "\n");
        bw.close();
        fw.close();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read file
        FileReader fr = new FileReader("text.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        int i =0;
        while ((line = br.readLine()) != null) {
            System.out.println(++i +": " + line);
        }
        // create new folder
        File directory = new File("new");
        directory.mkdirs();
    }
}
