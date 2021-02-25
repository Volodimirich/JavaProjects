import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Reader {
    private HSSFSheet workbook = null;
    Reader (String file) {
        try (HSSFWorkbook ExcelFile = new HSSFWorkbook(new FileInputStream(file))) {
            workbook  = ExcelFile.getSheetAt(0);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public HSSFSheet GetWorkbook () {
        return workbook;
    }
}
