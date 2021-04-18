package com.cat.controller;

import com.cat.dao.PregnantWomenRepository;
import com.cat.pojo.Page;
import com.cat.pojo.PregnantWomen;
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
public class PregnantWomenController {
    private final PregnantWomenRepository repository;

    public PregnantWomenController(PregnantWomenRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/PregnantWomenAdd")
    public String add() {
        return "PregnantWomen-Add";
    }

    @PostMapping("/PregnantWomenAdd")
    public String doAdd(PregnantWomen entity) {
        this.repository.save(entity);
        return "redirect:/PregnantWomenList";
    }

    @GetMapping("/PregnantWomenDel/{id}")
    public String del(@PathVariable("id") Long id) {
        this.repository.deleteById(id);
        return "redirect:/PregnantWomenList";
    }

    @GetMapping("/PregnantWomenList")
    public String list(Page page, Model model) {
        model.addAttribute("PregnantWomenList", this.repository.findAll(PageRequest.of(page.getStart(), page.getCount())));
        page.calculateLast((int) this.repository.count());
        model.addAttribute("page", page);
        return "PregnantWomen-List";
    }

    @GetMapping("/PregnantWomenPDF/{id}.PDF")
    public void pdfView(@PathVariable("id") Long id, HttpServletResponse response) {
        String templatePath = "form/孕妇体检.pdf";
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
            PregnantWomen entity = this.repository.getOne(id);
            form.setField("t1", entity.getPatientName());
            form.setField("t2", entity.getReportingTime().toString());
            form.setField("t3", entity.getPatientGender());
            form.setField("t4", entity.getDepartment());
            form.setField("t5", String.valueOf(entity.getPatientAge()));
            form.setField("t6", entity.getCollectingTime().toString());
            form.setField("t7", entity.getSendingDoctor());
            form.setField("t8", entity.getPhoneNumber());
            form.setField("t9", "血型");
            form.setField("t10", entity.getBloodType());
            form.setField("t11", "Rh");
            form.setField("t12", entity.getRh());
            form.setField("t13", "HBSAg");
            form.setField("t14", entity.getHbsag());
            form.setField("t15", "HBSAb");
            form.setField("t16", entity.getHbsab());
            form.setField("t17", "RPR");
            form.setField("t18", entity.getRpr());
            form.setField("t19", "丙肝");
            form.setField("t20", entity.getHepatitis());
            form.setField("t21", "HIV");
            form.setField("t22", entity.getHiv());
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