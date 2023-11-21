package com.compania.sistemaFacturacion.service;

import com.compania.sistemaFacturacion.model.Bill;
import com.compania.sistemaFacturacion.model.CreditNote;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class AsyncService {

    @Autowired
    private BillService billService;
    @Autowired
    private CreditNoteService creditNoteService;
    private static final long PROCESSING_REPORT = Duration.ofHours(2).toMillis();;

    @Async("asyncExecutor")
    public void executeBilling() { // billing process
        for (Bill bill : billService.getBills()) {
            bill.setStatus(Boolean.TRUE);
        }
        try {
            Thread.sleep(PROCESSING_REPORT);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Scheduled(cron = "0 00 20 * * ?")  // it will run every day at 8 PM
    public void scheduleBillingTask() {
        System.out.println("------------BILLING PROCESS------------");
        executeBilling();
        System.out.println("------------GENERATING REPORT------------"); // report will be ready at 10 PM
        generateReport();
        billService.clearBillsAndCreditNotes();
    }

    public void createReportOfTheDay(String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            int i = 0;
            writer.write("DAY: " + LocalDate.now());
            writer.newLine();
            writer.write("BILLS: ");
            writer.newLine();
            for (Bill bill : billService.getBills()) {
                if (bill.getStatus()) {
                    i++;
                    String content = i + ") " + billService.generateBillContent(bill);
                    writer.write(content);
                    writer.newLine();
                }
            }
            writer.write("CREDIT NOTES: ");
            writer.newLine();
            int j = 0;
            for (CreditNote cn : creditNoteService.getCreditNotes()) {
                j++;
                String content = j + ") " + creditNoteService.generateCreditNoteContent(cn);
                writer.write(content);
                writer.newLine();
            }
        } catch (IOException ex) {
        }
    }

    @Async("asyncExecutor")
    public void generateReport() {
        String report = "dayReport.txt";
        createReportOfTheDay(report);
    }
}
