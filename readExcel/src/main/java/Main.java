import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@SuppressWarnings("deprecation")
public class Main {
    public static void main(String[] args) throws IOException {
        String excelFilePath = "E:\\Programming\\JavaTasksProgrammingFundamentals\\readExcel\\src\\main\\java\\test.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);

        for (Row nextRow : firstSheet) {
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "|");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print((int)(cell.getNumericCellValue()) + "|");
                        break;
                }
            }
            System.out.println();
        }

        workbook.close();
        inputStream.close();
    }
}
