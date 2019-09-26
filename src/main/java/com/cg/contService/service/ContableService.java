package com.cg.contService.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cg.contService.domain.Contable;
import com.cg.contService.domain.Db;
import com.fasterxml.jackson.annotation.JsonFormat;

@Service
public class ContableService {
	
	@Autowired
	private Db db;
	
	public boolean check(long tstamp) {
		System.out.println("inside service");
		Date date = new Date(tstamp);
		System.out.println("date "+date);
		return db.existsById(date);
		
	}
	
	public Contable createNew(Contable c) {
		Optional<Contable> con = db.findById(c.getPeriodo());
		
		if(!(con.isPresent()))
		{
		db.saveAndFlush(c);
		return c;
		}
		else
		{
		System.out.println("it already exists");
		return null;
		}
		
	}

	public void deleteById(Date periodo_certificacion) {
		db.deleteById(periodo_certificacion);
		
	}

	
	public Contable update(Contable c) {
		Optional<Contable> old = db.findById(c.getPeriodo());
		if((old.get().getFecha_cierre().getTime())!=(c.getFecha_cierre().getTime()))
		{
		Contable table = new Contable();
		table.setPeriodo(c.getPeriodo());
		table.setFecha_cierre(c.getFecha_cierre());
		db.saveAndFlush(table);
		return table;
		}
		else
			return null;
	}

	
	public Page<Contable> findUsingPagination(Pageable page) {
		return db.findAll(page);
	}

	
	public Page<Contable> search(String date, Pageable page)    {
			date="%"+date+"%";
		
		return db.search(date, page);
	
	}

}
