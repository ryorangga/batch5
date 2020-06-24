package com.example.smartspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.smartspring.model.PasienModel;

// JpaRepository<Tabel DB = wajib di import, Type Variable Primary Key Tabelnya>
public interface PasienRepository extends JpaRepository<PasienModel, String>{

	/*
	 * @Query("select p from pasienModel p") List<PasienModel> bacaData();
	 * 
	 * @Query("select p from pasienModel p where p.namaPasien like %?1%")
	 * List<PasienModel> cariNama(String namaPasien);
	 */
	
	@Query("SELECT P FROM PasienModel P ORDER BY P.namaPasien DESC")
	List<PasienModel> cariNamaDESC();
	
	@Query("SELECT P FROM PasienModel P WHERE P.namaPasien LIKE '%k%' ")
	List<PasienModel> cariDataYangMengandung();
	
	// Adim, "SELECT P FROM PasienModel P WHERE P.namaPasien LIKE %o%"
	// Icha, "SELECT P FROM PasienModel P WHERE P.namaPasien LIKE a%"
	// Irianto, "SELECT P FROM PasienModel P WHERE P.biaya >2000"
	// Jonathan, "SELECT P FROM PasienModel P WHERE P.biaya <1000 AND P.biaya >500"
}
