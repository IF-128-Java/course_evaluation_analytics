package ita.softserve.course_evaluation_analytics.service.impl;

import ita.softserve.course_evaluation_analytics.entity.UserInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service

public class UserExcelExporterServiceImpl {
    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private final List<UserInfo> userInfoList;

    public UserExcelExporterServiceImpl(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("CourseUserInfo");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(12);
        style.setFont(font);

        createCell(row, 0, "First Name", style);
        createCell(row, 1, "Last Name", style);
        createCell(row, 2, "Email", style);
        createCell(row, 3, "Group Name", style);
        createCell(row, 4, "Role Name", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(12);
        style.setFont(font);

        for (UserInfo userInfo : userInfoList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, userInfo.getFirstName(), style);
            createCell(row, columnCount++, userInfo.getLastName(), style);
            createCell(row, columnCount++, userInfo.getEmail(), style);
            createCell(row, columnCount++, userInfo.getGroupName(), style);
            createCell(row, columnCount++, userInfo.getRoleName(), style);

        }
    }

    public ByteArrayOutputStream export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        return baos;
    }
}
