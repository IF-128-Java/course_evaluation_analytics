package ita.softserve.course_evaluation_analytics.controller;

import ita.softserve.course_evaluation_analytics.entity.FeedbackInfo;
import ita.softserve.course_evaluation_analytics.repository.FeedbackInfoRepository;
import ita.softserve.course_evaluation_analytics.service.impl.FeedbackExcelExporter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin/analytics/feedback-info")
@RequiredArgsConstructor
@Slf4j
public class FeedbackInfoController {

    private final FeedbackInfoRepository feedbackInfoRepository;

    @GetMapping("/{course_id}/export/excel")
    public void exportToExcel(HttpServletResponse response, @PathVariable("course_id") long courseId, @RequestParam String filePath) throws IOException {


        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=feedbackInfo_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<FeedbackInfo> feedbackInfoList = feedbackInfoRepository.findFeedbackInfoByCourseId(courseId);
        log.info(feedbackInfoList + "");

        FeedbackExcelExporter excelExporter = new FeedbackExcelExporter(feedbackInfoList);

        excelExporter.export(response, filePath);
        log.info("export excel");
    }

}
