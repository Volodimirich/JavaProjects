import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.util.ArrayList;
import java.util.Collection;

public class Parser {
    private Collection<String> data = new ArrayList<String>();

    private String FormatStr(String[] SepStr) {
        String surname = SepStr[0].substring(0, 1).toUpperCase() + SepStr[0].substring(1).toLowerCase();
        String name = SepStr[1].substring(0, 1).toUpperCase();
        String patronymic = SepStr[2].substring(0, 1).toUpperCase();
        return surname + " " + name + "." + patronymic;
    }

    private void StrConvert(String dataStr) {
        String[] dataSep = dataStr.split(" ");
        if (dataSep[0].equals("Филиал") || dataSep.length <= 2) {
            data.add(dataStr);
        } else {
            data.add(FormatStr(dataSep));
        }
    }

    public void DocumentParse(HSSFSheet list) {
        HSSFRow dataRow;
        HSSFCell dataCell;
        for (int i = 0; i < list.getLastRowNum(); i++) {
            if ((dataRow = list.getRow(i)) != null && (dataCell = dataRow.getCell(0)) != null) {
                String dataInCell = dataCell.toString();
                StrConvert(dataInCell);
            }
        }
    }

    public Collection<String> GetData() {
        return data;
    }

}




