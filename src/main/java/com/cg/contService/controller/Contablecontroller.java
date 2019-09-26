package com.cg.contService.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.contService.domain.Contable;
import com.cg.contService.domain.Customresponse;
import com.cg.contService.domain.Provision;
import com.cg.contService.domain.SearchContableTo;
import com.cg.contService.service.ContableService;
import com.cg.contService.grpc.Client;

import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
@RequestMapping("adif")
public class Contablecontroller {
	
	@Autowired
	ContableService svc;
	
	@Autowired
	Client client;
	
	@Autowired
    private Tracer tracer;
	
	
	@CrossOrigin
	@PostMapping("/contables")
	public ResponseEntity<Contable> createNew(@RequestBody Contable c) 
	{
		 Contable con = svc.createNew(c);
		 if(con!=null) {
      	   Span span = tracer.buildSpan("Succesfully added a contable entry").start();
			  span.finish();
		      String msg = client.message(c.getTstamp());
		      Span span1 = tracer.buildSpan("Getting msg from provision microservice: "+msg).start();
			  span1.finish();
		    return new ResponseEntity<>(con, HttpStatus.OK);
	 }
		else
		    return new ResponseEntity<>(null, HttpStatus.CONFLICT);
	
	}
	
	@CrossOrigin
	 @DeleteMapping("/contables/{ts}")
	   void deleteById(@PathVariable("ts") long ts)
	   {
		 Date date = new Date(ts);
        svc.deleteById(date);
	   }
	
	@CrossOrigin
	 @PutMapping("/contables")
	 ResponseEntity<Contable> update(@RequestBody Contable c)
	  {
		 Contable con = svc.update(c);
		 if(con!=null)
			    return new ResponseEntity<>(c, HttpStatus.OK);
			else
			    return new ResponseEntity<>(null, HttpStatus.CONFLICT);
	  }
	
	@CrossOrigin
	 @GetMapping("/contables/{page}/{size}")
	 Page<Contable> findUsingPagination(@PathVariable("page") int page,@PathVariable("size") int size)
	 {
		Pageable listAll = null;
	     listAll = PageRequest.of(page, size, Sort.by("periodo").ascending());
		 return svc.findUsingPagination(listAll);
	 }
	
	@CrossOrigin
	 @PostMapping("/contables/search")
	 Page<Contable> search(@RequestBody SearchContableTo search)
	 {
		Pageable listAll = null;
	     listAll = PageRequest.of(search.getPage(), search.getSize(),Sort.by("periodo_certificacion").ascending());
		 return svc.search(search.getDate(), listAll);
		 
	 }
	
	
	
	
	
	

		
		

}
