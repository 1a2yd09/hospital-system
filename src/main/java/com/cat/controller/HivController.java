package com.cat.controller;

import com.cat.dao.HivRepository;
import com.cat.pojo.Hiv;
import com.cat.pojo.Page;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HivController {
    private final HivRepository hivRepository;

    public HivController(HivRepository hivRepository) {
        this.hivRepository = hivRepository;
    }

    @GetMapping("/hivAdd")
    public String hivAdd() {
        return "hiv-add";
    }

    @PostMapping("/hivAdd")
    public String doHivAdd(Hiv hiv) {
        this.hivRepository.save(hiv);
        return "redirect:/hivList";
    }

    @GetMapping("/hivDel/{id}")
    public String hivDel(@PathVariable("id") Long id) {
        this.hivRepository.deleteById(id);
        return "redirect:/hivList";
    }

    @GetMapping("/hivList")
    public String hivList(Page page, Model model) {
        model.addAttribute("hivList", this.hivRepository.findAll(PageRequest.of(page.getStart(), page.getCount())));
        page.calculateLast((int) this.hivRepository.count());
        model.addAttribute("page", page);
        return "hiv-list";
    }

    @GetMapping("/hivPDF/{id}.PDF")
    public void pdfView(@PathVariable("id") Long id, HttpServletResponse response) {
        String templatePath = "form/HIV.pdf";
        PdfReader reader;
        ByteArrayOutputStream baos;
        PdfStamper stamper;
        List<PdfReader> list = new ArrayList<>();
        try {
            reader = new PdfReader(templatePath);
            PdfReader pdfReader;
            baos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, baos);
            AcroFields form = stamper.getAcroFields();
            Hiv entity = this.hivRepository.getOne(id);
            form.setField("t1", entity.getPatientName());
            form.setField("t2", entity.getReportingTime().toString());
            form.setField("t3", entity.getPatientGender());
            form.setField("t4", entity.getDepartment());
            form.setField("t5", String.valueOf(entity.getPatientAge()));
            form.setField("t6", entity.getCollectingTime().toString());
            form.setField("t7", entity.getSendingDoctor());
            form.setField("t8", entity.getPhoneNumber());
            form.setField("t9", "HIV");
            form.setField("t10", entity.getHivResult());
            form.setField("t11", "RPR");
            form.setField("t12", entity.getRprResult());
            stamper.setFormFlattening(false);
            stamper.close();
            pdfReader = new PdfReader(baos.toByteArray());
            list.add(pdfReader);
            ServletOutputStream outputStream = response.getOutputStream();
            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, outputStream);
            doc.open();
            for (PdfReader pdfReader1 : list) {
                doc.newPage();
                copy.addDocument(pdfReader1);
            }
            copy.close();
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
