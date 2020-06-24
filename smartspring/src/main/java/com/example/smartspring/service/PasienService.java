package com.example.smartspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartspring.model.PasienModel;
import com.example.smartspring.repository.PasienRepository;


@Service
@Transactional
public class PasienService {
	
	@Autowired // digunakan utk mengambil fungsi2 yang ada di clas lain
	private PasienRepository pasienRepository; // membuatkan variable baru dari class PasienRepository
	
	public void create(PasienModel pasienModel) {
		this.pasienRepository.save(pasienModel);
	}
	
	public List<PasienModel> readData() {
		return this.pasienRepository.findAll();
	}
	
	// buat update
	public void update(PasienModel pasienModel) {
		this.pasienRepository.save(pasienModel);
	}
	
	// delete
	public void remove(String namaPasien) {
		this.pasienRepository.deleteById(namaPasien);
	}
	
	public List<PasienModel> cariNamaDesc(){
		return this.pasienRepository.cariNamaDESC();
	}
	
	public List<PasienModel> cariDataMengandung() {
		return this.pasienRepository.cariDataYangMengandung();
	}
}
