package com.compania.sistemaFacturacion.controller;

import com.compania.sistemaFacturacion.model.Bill;
import com.compania.sistemaFacturacion.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/cancelBill")
    public String cancelBill(@RequestParam("billId") Integer billId) {
        Bill bill = billService.getBillById(billId);
        billService.cancelBillToCreditNote(bill);
        return "redirect:/";
    }
}
