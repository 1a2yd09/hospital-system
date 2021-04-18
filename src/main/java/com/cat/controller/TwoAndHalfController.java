package com.cat.controller;

import com.cat.dao.TwoAndHalfRepository;
import com.cat.pojo.Page;
import com.cat.pojo.TwoAndHalf;
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
public class TwoAndHalfController {
    private final TwoAndHalfRepository repository;

    public TwoAndHalfController(TwoAndHalfRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/TwoAndHalfAdd")
    public String add() {
        return "TwoAndHalf-Add";
    }

    @PostMapping("/TwoAndHalfAdd")
    public String doAdd(TwoAndHalf entity) {
        this.repository.save(entity);
        return "redirect:/TwoAndHalfList";
    }

    @GetMapping("/TwoAndHalfDel/{id}")
    public String del(@PathVariable("id") Long id) {
        this.repository.deleteById(id);
        return "redirect:/TwoAndHalfList";
    }

    @GetMapping("/TwoAndHalfList")
    public String list(Page page, Model model) {
        model.addAttribute("TwoAndHalfList", this.repository.findAll(PageRequest.of(page.getStart(), page.getCount())));
        page.calculateLast((int) this.repository.count());
        model.addAttribute("page", page);
        return "TwoAndHalf-List";
    }

    @GetMapping("/TwoAndHalfPDF/{id}.PDF")
    public void pdfView(@PathVariable("id") Long id, HttpServletResponse response) {
        String templatePath = "form/两对半.pdf";
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
            TwoAndHalf entity = this.repository.getOne(id);
            form.setField("t1", entity.getPatientName());
            form.setField("t2", entity.getReportingTime().toString());
            form.setField("t3", entity.getPatientGender());
            form.setField("t4", entity.getDepartment());
            form.setField("t5", String.valueOf(entity.getPatientAge()));
            form.setField("t6", entity.getCollectingTime().toString());
            form.setField("t7", entity.getSendingDoctor());
            form.setField("t8", entity.getPhoneNumber());
            form.setField("t9", "乙肝表面抗原");
            form.setField("t10", entity.getAntigen());
            form.setField("t11", "乙肝表面抗体");
            form.setField("t12", entity.getAntibody());
            form.setField("t13", "乙肝表面e抗原");
            form.setField("t14", entity.geteAntigen());
            form.setField("t15", "乙肝表面e抗体");
            form.setField("t16", entity.geteAntibody());
            form.setField("t17", "乙肝表面核心抗体");
            form.setField("t18", entity.getCoreAntibody());
            form.setField("t19", "阴性");
            form.setField("t20", "阴性或阳性");
            form.setField("t21", "阴性");
            form.setField("t22", "阴性");
            form.setField("t23", "阴性");
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