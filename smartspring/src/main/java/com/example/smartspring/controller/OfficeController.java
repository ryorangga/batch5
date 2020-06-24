package com.example.smartspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/office")
public class OfficeController {
// req : /office/penjualan
	// : req : office/karyawan
	
	//master/modul
	
	@RequestMapping("/penjualan")
	public String penjualanOffice() {
		String html = "/office/penjualanOffice";
		return html;
	}

	@RequestMapping("/karyawan")
	public String karyawanOffice() {
		String html = "/office/penjualanOffice";
		return html;
	}
}
