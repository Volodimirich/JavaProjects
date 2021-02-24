import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static HSSFSheet ReadFile(String file)  {
        try (HSSFWorkbook ExcelFile = new HSSFWorkbook(new FileInputStream(file))) {
            return ExcelFile.getSheetAt(0);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }

    public static ArrayList<String> DataParse(HSSFSheet list) {
        ArrayList<String> data = new ArrayList<String>();
        for (int i=0; i<list.getPhysicalNumberOfRows(); i++) {
            HSSFRow dataRow = list.getRow(i);
            if (dataRow != null) {


                HSSFCell dataCell = dataRow.getCell(0);
                if (dataCell != null) {
                    String dataInCell = dataCell.toString();
                    String[] dataSep = dataInCell.split(" ");
                    if (dataSep[0].equals(new String("Филиал")) || dataSep.length <=2) {
                        data.add(dataInCell);
                    } else {
                        System.out.println(dataInCell);
                        data.add(dataSep[0] + ' ' + dataSep[1].toUpperCase().charAt(0) + '.' +
                                dataSep[2].toUpperCase().charAt(0));
                    }
                }
            }
        }

        return data;
    }

    public static void SaveData(ArrayList<String> data) {
        try (FileWriter writer = new FileWriter("result.txt", false))
        {
            for (String elem: data) {
                writer.write(elem);
                writer.write('\n');
            }

        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SaveData(DataParse(ReadFile(args[0])));
    }
}
