import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Writer {
    private FileWriter writer;
    Writer () {
        try {
            writer = new FileWriter("result.txt", false);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void SaveData(Collection<String> data) {
        try {
            for (String elem : data) {
                writer.write(elem + '\n');
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void CloseFile() {
        try {
            writer.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

