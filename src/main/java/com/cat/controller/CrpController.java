package com.cat.controller;

import com.cat.dao.CrpRepository;
import com.cat.pojo.Crp;
import com.cat.pojo.Page;
import com.cat.utils.MainUtil;
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
public class CrpController {
    private final CrpRepository crpRepository;

    public CrpController(CrpRepository crpRepository) {
        this.crpRepository = crpRepository;
    }

    @GetMapping("/crpAdd")
    public String crpAdd() {
        return "crp-add";
    }

    @PostMapping("/crpAdd")
    public String doCrpAdd(Crp crp) {
        this.crpRepository.save(crp);
        return "redirect:/crpList";
    }

    @GetMapping("/crpDel/{id}")
    public String crpDel(@PathVariable("id") Long id) {
        this.crpRepository.deleteById(id);
        return "redirect:/crpList";
    }

    @GetMapping("/crpList")
    public String crpList(Page page, Model model) {
        model.addAttribute("crpList", this.crpRepository.findAll(PageRequest.of(page.getStart(), page.getCount())));
        page.calculateLast((int) this.crpRepository.count());
        model.addAttribute("page", page);
        return "crp-list";
    }

    @GetMapping("/crpPDF/{id}.PDF")
    public void pdfView(@PathVariable("id") Long id, HttpServletResponse response) {
        String templatePath = "form/CRP.pdf";
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
            Crp entity = this.crpRepository.getOne(id);
            form.setField("t1", entity.getPatientName());
            form.setField("t2", entity.getReportingTime().toString());
            form.setField("t3", entity.getPatientGender());
            form.setField("t4", entity.getDepartment());
            form.setField("t5", String.valueOf(entity.getPatientAge()));
            form.setField("t6", entity.getCollectingTime().toString());
            form.setField("t7", entity.getSendingDoctor());
            form.setField("t8", entity.getPhoneNumber());
            form.setField("t9", "常规CRP");
            form.setField("t10", MainUtil.unitConversion(entity.getGeneralCrpResult(), "mg/l"));
            form.setField("t11", MainUtil.unitConversion(entity.getGeneralCrpReference(), "mg/l"));
            form.setField("t12", "HsCRP");
            form.setField("t13", MainUtil.unitConversion(entity.getHsCrpResult(), "mg/l"));
            form.setField("t14", MainUtil.unitConversion(entity.getHsCrpReference(), "mg/l"));
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
