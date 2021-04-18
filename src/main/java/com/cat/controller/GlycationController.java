package com.cat.controller;

import com.cat.pojo.Glycation;
import com.cat.pojo.Page;
import com.cat.dao.GlycationRepository;
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
public class GlycationController {
    private final GlycationRepository repository;

    public GlycationController(GlycationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/GlycationAdd")
    public String add() {
        return "Glycation-Add";
    }

    @PostMapping("/GlycationAdd")
    public String doAdd(Glycation entity) {
        this.repository.save(entity);
        return "redirect:/GlycationList";
    }

    @GetMapping("/GlycationDel/{id}")
    public String del(@PathVariable("id") Long id) {
        this.repository.deleteById(id);
        return "redirect:/GlycationList";
    }

    @GetMapping("/GlycationList")
    public String list(Page page, Model model) {
        model.addAttribute("GlycationList", this.repository.findAll(PageRequest.of(page.getStart(), page.getCount())));
        page.calculateLast((int) this.repository.count());
        model.addAttribute("page", page);
        return "Glycation-List";
    }

    @GetMapping("/GlycationPDF/{id}.PDF")
    public void pdfView(@PathVariable("id") Long id, HttpServletResponse response) {
        String templatePath = "form/糖化报告.pdf";
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
            Glycation entity = this.repository.getOne(id);
            form.setField("t1", entity.getPatientName());
            form.setField("t2", entity.getReportingTime().toString());
            form.setField("t3", entity.getPatientGender());
            form.setField("t4", entity.getDepartment());
            form.setField("t5", String.valueOf(entity.getPatientAge()));
            form.setField("t6", entity.getCollectingTime().toString());
            form.setField("t7", entity.getSendingDoctor());
            form.setField("t8", entity.getPhoneNumber());
            form.setField("t9", "糖化血红蛋白");
            form.setField("t10", entity.getHemoglobin());
            form.setField("t11", "4.0-6.0");
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