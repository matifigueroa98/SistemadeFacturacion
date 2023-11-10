
package com.compania.sistemaFacturacion.service;

import com.compania.sistemaFacturacion.model.CreditNote;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CreditNoteService {
    
    private ArrayList<CreditNote> creditNotes = new ArrayList<>();
    private static Integer creditNoteIdCounter = 1;
    
    public void addCreditNote (){
        CreditNote creditNote = new CreditNote ();
        creditNote.setDate(LocalDate.now());
        creditNote.setId(creditNoteIdCounter++);
        creditNote.setIssueCode(UUID.randomUUID());
        
    }
}
