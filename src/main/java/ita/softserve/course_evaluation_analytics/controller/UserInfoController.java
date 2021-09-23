package ita.softserve.course_evaluation_analytics.controller;

import ita.softserve.course_evaluation_analytics.entity.FeedbackInfo;
import ita.softserve.course_evaluation_analytics.entity.UserInfo;
import ita.softserve.course_evaluation_analytics.repository.FeedbackInfoRepository;
import ita.softserve.course_evaluation_analytics.repository.UserInfoRepository;
import ita.softserve.course_evaluation_analytics.service.impl.FeedbackExcelExporterServiceImpl;
import ita.softserve.course_evaluation_analytics.service.impl.UserExcelExporterServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin/analytics/user-info")
@RequiredArgsConstructor
@Slf4j
public class UserInfoController {

    private final UserInfoRepository userInfoRepository;

    @GetMapping("/export/excel")
    public ResponseEntity<?> exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=feedbackInfo_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<UserInfo> userInfoList = userInfoRepository.findUserInfoByRoleId();

        UserExcelExporterServiceImpl excelExporter = new UserExcelExporterServiceImpl(userInfoList);

        byte[] returnResponse = excelExporter.export(response).toByteArray();
        log.info("Export user info to excel");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        return new ResponseEntity<byte[]>(returnResponse,headers, HttpStatus.OK);
    }

}
