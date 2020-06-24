package com.example.smartspring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.smartspring.model.PasienModel;
import com.example.smartspring.service.PasienService;

@Controller
public class MenuController {

	@Autowired
	private PasienService pasienService;
	
	@RequestMapping("/menu1")
	public String menu1() {
		String home = "/menu/menu1";
		return home;
	}
	
	@RequestMapping("/lempar")
	public String lemparAja(HttpServletRequest request, Model model) {
		
		String lemparNama = request.getParameter("nama");
		
		model.addAttribute("lemparNama", lemparNama);
		
		String html = "/menu/menu1";
		return html;
	}
	
	@RequestMapping("/pasien/create")
	public String pasienCreate(HttpServletRequest request, Model model) throws ParseException {
		
		String nomorPasien = request.getParameter("nomor");
		String namaPasien = request.getParameter("nama");
		String jenisKelamin = request.getParameter("gender");
		String kategori = request.getParameter("kategori");
		int biaya = Integer.parseInt(request.getParameter("biaya"));
		
		//konversi date
		String tanggalLahir = request.getParameter("tanggalLahir");
		
		SimpleDateFormat formateDate = new SimpleDateFormat("yyyy-MM-dd");
		Date tanggalLahirDate = formateDate.parse(tanggalLahir);
		System.out.println(tanggalLahirDate);
		
		//instance PasienModel
		PasienModel pasienModel = new PasienModel();
		
		//simpan ke masing2 kolom di database
		pasienModel.setKodePasien(nomorPasien);
		pasienModel.setNamaPasien(namaPasien);
		pasienModel.setGender(jenisKelamin);
		pasienModel.setKategoriPasien(kategori);
		pasienModel.setBiaya(biaya);
		pasienModel.setTanggalLahir(tanggalLahirDate);
		
		//save
		this.pasienService.create(pasienModel);
		
		//list
		this.ListPasien(model);
		
		String html = "/pasien/list";
		
		return html;
	}
	
	public void ListPasien(Model model) {
		List<PasienModel> pasienModelList = new ArrayList<PasienModel>();// > 1
		pasienModelList = pasienService.readData();
		
		model.addAttribute("pasienModelList", pasienModelList);
	}
}
