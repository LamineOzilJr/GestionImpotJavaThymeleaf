package com.isi.ImpotRegaluation.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.isi.ImpotRegaluation.dao.IPaiement;
import com.isi.ImpotRegaluation.entities.Paiement;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class PdfDownloadController {
	
	// Injection des dépendances pour le repository
		 private final IPaiement iPaiement;
		
		

		    @Autowired
		    public PdfDownloadController(IPaiement iPaiement) {
		        this.iPaiement = iPaiement;   
		    }

    @GetMapping("/api/paiements/pdf/{id}")
    public ResponseEntity<byte[]> generatePdf(@PathVariable Long id) throws IOException {
    	Paiement paiement = iPaiement.findById(id).orElse(null);
    	
        if (paiement == null) {
            // Gérer le cas où l'ID du paiement n'est pas trouvé
            return ResponseEntity.notFound().build();
        }

        // Créer un document PDF
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Écrire les détails du paiement dans le PDF
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(100, page.getMediaBox().getHeight() - 50);
                contentStream.showText("Détails du Paiement:");
                contentStream.showText("     ");
                contentStream.showText("Montant: " + paiement.getMontantPaiement());
                contentStream.showText("     ");
                contentStream.showText("Date du Paiement: " + paiement.getDatePaiement());
               
                contentStream.endText();
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.save(outputStream);
            document.close();

            //réponse avec le contenu du PDF
            byte[] pdfContents = outputStream.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "details-paiement.pdf");

            return new ResponseEntity<>(pdfContents, headers, HttpStatus.OK);
        }
    }
}

