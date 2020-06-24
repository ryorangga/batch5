package com.example.smartspring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartspring.model.PasienModel;
import com.example.smartspring.service.PasienService;

@RestController
@RequestMapping("/api/pasien")
public class PasienApi {

	/*
	 * INSERT | POST READ | GET
	 */
	@Autowired
	private PasienService pasienService;

	//POST || INSERT
	@PostMapping("/post") // digunakan utk memapping suatu method sebagai fungsi insert data dalam API
	@ResponseStatus(code = HttpStatus.CREATED) // Http Status, untuk memberikan info dari status http sukses atau
												// tidaknya
	public Map<String, Object> postMapping(@RequestBody PasienModel pasienModel) {

		this.pasienService.create(pasienModel);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", Boolean.TRUE);
		map.put("pesan", "datanya sudah masuk");

		return map;
	}
	
	// GET || READ
	@GetMapping("/get")
	@ResponseStatus(code = HttpStatus.OK)
	public List<PasienModel> getMapping() {

		List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
		pasienModelList = this.pasienService.readData();
		return pasienModelList;
		
	}
	
	// PUT || UPDATE
	@PutMapping("/put")
	@ResponseStatus(code=HttpStatus.OK)
	public Map<String, Object> putMapping(@RequestBody PasienModel pasienModel){
		
		this.pasienService.update(pasienModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("berhasil", Boolean.TRUE);
		map.put("selamat", "Data berhasil di update");
		
		return map;
	}
	
	// DELETE
	@DeleteMapping("/delete/{namaPasien}")
	public Map<String, Object> remove(@PathVariable String namaPasien){
		
		this.pasienService.remove(namaPasien);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("success", Boolean.TRUE);
		map.put("delete", "Berhasil");
		
		return map;
	}
	
	// Buat API utk menampilkan data berdasarkan Nama dari urutan terbesar hingga terkecil ( Z-A )
	
	// GET || READ DESC
		@GetMapping("/getNama")
		@ResponseStatus(code = HttpStatus.OK)
		public List<PasienModel> getNama() {

			List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
			pasienModelList = this.pasienService.cariNamaDesc();
			return pasienModelList;
			
		}
		
	// READ LIKE
		@GetMapping("/getNamaMengandung")
		@ResponseStatus(code = HttpStatus.OK)
		public List<PasienModel> getNamaMengandung() {

			List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
			pasienModelList = this.pasienService.cariDataMengandung();
			return pasienModelList;
			
		}
}
