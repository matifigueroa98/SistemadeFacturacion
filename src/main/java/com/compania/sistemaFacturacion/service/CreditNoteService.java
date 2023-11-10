package com.compania.sistemaFacturacion.service;

import com.compania.sistemaFacturacion.model.Bill;
import com.compania.sistemaFacturacion.model.CreditNote;
import java.util.ArrayList;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CreditNoteService {

    private ArrayList<CreditNote> creditNotes = new ArrayList<>();
    private static Integer creditNoteIdCounter = 1;

    public void addCreditNote(Bill bill) {
        CreditNote creditNote = new CreditNote();
        creditNote.setDate(bill.getDate());
        creditNote.setId(creditNoteIdCounter++);
        creditNote.setIssueCode(UUID.randomUUID());
        creditNote.setClient(bill.getClient());
        creditNote.setLetter(bill.getLetter());
        creditNote.setTotal(bill.getTotal());
        creditNotes.add(creditNote);
    }
    
    public ArrayList<CreditNote> getCreditNotes() {
        return creditNotes;
    }

    public String generateCreditNoteContent(CreditNote creditNote) {
        return "Client Number: " + creditNote.getClient().getId() + " | " + creditNote.getClient().getDniType() + " | "
                + creditNote.getLetter() + " | Credit Note number: " + creditNote.getId() + " | "
                + creditNote.getDate() + " | TOTAL = $" + creditNote.getTotal();
    }
}
