package com.example.smartspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BerandaController {
	
	@RequestMapping("/beranda")
	public String beranda() {
		String html = "/beranda";
		return html;
	}
}

// 1. Buat halaman/HTML bernama utamaOffice :	
		// a. buat form sederhana saja, ada 2 textfield dan 1 button

// 2. Buat halaman/HTML bernama penjualanOffice didalam folder office :
		// a. buat tabel sedernahana saja, dengan kolom No, Barang, Harga, Jumlah Penjualan

// 3. Buat halaman/HTML bernama karyawanOffice didalam folder karyawan yang ada di dalam folder office. office/karyawan/ .. :
		// a. Buat Tabel sederhana daftar nama karyawan, (No, Nama, Jabatan);