package ita.softserve.course_evaluation_analytics.service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface ExcelExporterService {
    ByteArrayOutputStream export(HttpServletResponse response) throws IOException;
}
