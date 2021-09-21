package ita.softserve.course_evaluation_analytics.service.impl;

import ita.softserve.course_evaluation_analytics.entity.FeedbackInfo;
import lombok.extern.slf4j.Slf4j;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class FeedbackExcelExporter {

    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private final List<FeedbackInfo> feedbackInfos;

    public FeedbackExcelExporter(List<FeedbackInfo> feedbackInfoList) {
        this.feedbackInfos = feedbackInfoList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("CourseFeedbackInfo");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(12);
        style.setFont(font);

        createCell(row, 0, "Feedback Description", style);
        createCell(row, 1, "Start Date", style);
        createCell(row, 2, "End Date", style);
        createCell(row, 3, "Status", style);
        createCell(row, 4, "Course Name", style);
        createCell(row, 5, "Question Text", style);
        createCell(row, 6, "Rate", style);
        createCell(row, 7, "Student ID", style);
        createCell(row, 8, "Student Email", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof LocalDateTime){
            cell.setCellValue(String.valueOf(value));
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

        for (FeedbackInfo feedbackInfo : feedbackInfos) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, feedbackInfo.getFeedbackDescription(), style);
            createCell(row, columnCount++, feedbackInfo.getStartDate(), style);
            createCell(row, columnCount++, feedbackInfo.getEndDate(), style);
            createCell(row, columnCount++, feedbackInfo.getStatus(), style);
            createCell(row, columnCount++, feedbackInfo.getCourseName(), style);
            createCell(row, columnCount++, feedbackInfo.getQuestionText(), style);
            createCell(row, columnCount++, feedbackInfo.getRate(), style);
            createCell(row, columnCount++, feedbackInfo.getStudentId(), style);
            createCell(row, columnCount++, feedbackInfo.getEmail(), style);

        }
    }

    public ByteArrayOutputStream export(HttpServletResponse response, String filePath) throws IOException {
        writeHeaderLine();
        writeDataLines();

        File currDir = new File(filePath);
        String path = currDir.getAbsolutePath();
        String fileLocation = path + "\\feedbackInfo-"+feedbackInfos.get(0).getCourseName()+".xlsx";

        FileOutputStream outputStream2 = new FileOutputStream(fileLocation);
        workbook.write(outputStream2);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        return baos;
    }

}
