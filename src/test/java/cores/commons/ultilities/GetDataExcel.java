package cores.commons.ultilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDataExcel {

    public static List<String> handleExcel(String pathExcel, String nameFileExcel, String nameSheet, int firstColum)throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        int count = 1;
        String value;
        FileInputStream fileInputStream = new FileInputStream(pathExcel+ nameFileExcel);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet(nameSheet);
        Row row;
        try {
            do {
                row = sheet.getRow(count);
                count++;
                value = String.valueOf(row.getCell(firstColum -1));
                arrayList.add(value);
            }while (!value.equals(" "));
        }catch (NullPointerException e){

        }
        return arrayList;
    }
}
