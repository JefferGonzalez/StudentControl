package com.student.control.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static HashMap<Integer, List<String>> ReadFile(String filename) {
        try {
            FileInputStream file = new FileInputStream(new File(filename));

            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);

            HashMap<Integer, List<String>> data = new HashMap<>();

            int i = 0;

            for (Row row : sheet) {
                data.put(i, new ArrayList<>());
                for (Cell cell : row) {
                    data.get(i).add(cell.getRichStringCellValue().getString());
                }
                i++;
            }

            workbook.close();

            return data;

        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                throw new RuntimeException("HUBO UN ERROR AL CARGAR EL ARCHIVO, INTENTE NUEVAMENTE");
            }
            throw new RuntimeException(e.getMessage());
        }

    }
}
