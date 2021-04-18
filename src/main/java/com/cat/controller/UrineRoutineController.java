package com.cat.controller;

import com.cat.dao.UrineRoutineRepository;
import com.cat.pojo.Page;
import com.cat.pojo.UrineRoutine;
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
public class UrineRoutineController {
    private final UrineRoutineRepository repository;

    public UrineRoutineController(UrineRoutineRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/UrineRoutineAdd")
    public String add() {
        return "UrineRoutine-Add";
    }

    @PostMapping("/UrineRoutineAdd")
    public String doAdd(UrineRoutine entity) {
        this.repository.save(entity);
        return "redirect:/UrineRoutineList";
    }

    @GetMapping("/UrineRoutineDel/{id}")
    public String del(@PathVariable("id") Long id) {
        this.repository.deleteById(id);
        return "redirect:/UrineRoutineList";
    }

    @GetMapping("/UrineRoutineList")
    public String list(Page page, Model model) {
        model.addAttribute("UrineRoutineList", this.repository.findAll(PageRequest.of(page.getStart(), page.getCount())));
        page.calculateLast((int) this.repository.count());
        model.addAttribute("page", page);
        return "UrineRoutine-List";
    }

    @GetMapping("/UrineRoutinePDF/{id}.PDF")
    public void pdfView(@PathVariable("id") Long id, HttpServletResponse response) {
        String templatePath = "form/尿液常规.pdf";
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
            UrineRoutine entity = this.repository.getOne(id);
            form.setField("t1", entity.getPatientName());
            form.setField("t2", entity.getReportingTime().toString());
            form.setField("t3", entity.getPatientGender());
            form.setField("t4", entity.getDepartment());
            form.setField("t5", String.valueOf(entity.getPatientAge()));
            form.setField("t6", entity.getCollectingTime().toString());
            form.setField("t7", entity.getSendingDoctor());
            form.setField("t8", entity.getPhoneNumber());
            form.setField("t9", "维C");
            form.setField("t10", entity.getVitamin());
            form.setField("t11", "酸碱度");
            form.setField("t12", entity.getAcidityAndAlkalinity());
            form.setField("t13", "白细胞");
            form.setField("t14", entity.getLeukocytes());
            form.setField("t15", "尿比重");
            form.setField("t16", entity.getUrineSpecificGravity());
            form.setField("t17", "葡萄糖");
            form.setField("t18", entity.getGlucose());
            form.setField("t19", "亚硝酸");
            form.setField("t20", entity.getNitrite());
            form.setField("t21", "蛋白质");
            form.setField("t22", entity.getProtein());
            form.setField("t23", "隐血");
            form.setField("t24", entity.getOccultBlood());
            form.setField("t25", "酮体");
            form.setField("t26", entity.getKetoneBody());
            form.setField("t27", "尿胆原");
            form.setField("t28", entity.getUrobilinogen());
            form.setField("t29", "胆红素");
            form.setField("t30", entity.getBilirubin());
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