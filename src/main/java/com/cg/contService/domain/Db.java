package com.cg.contService.domain;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;



@Repository
public interface Db extends JpaRepository<Contable, Date>{

	@Query(value="select * from contable m where (DATE_FORMAT(m.periodo_certificacion,'%d/%m/%Y')) LIKE ?1 or (DATE_FORMAT(m.fecha_cierre,'%d/%m/%Y')) LIKE ?1",
			nativeQuery=true)
		Page<Contable> search(String date,Pageable page);
	
      

}
