package ru.kpfu.itis.sharipova.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by lia on 01.06.16.
 */
@Controller
public class OrderController {

    @Value()
    String path;

    @RequestMapping(value = "orders/{id}/download")
    public void getLogFile(HttpSession session, HttpServletResponse response,
                           @PathVariable("id") Long id) throws Exception {
        PatientHistory patientHistory = patientHistoryService.getHistoryById(id);
        try {
            String filePathToBeServed = path + patientHistory.getId() + '_' + patientHistory.getPatient().getFio() + ".pdf";//complete file name with path;
            File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=" + id + ".pdf");
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
