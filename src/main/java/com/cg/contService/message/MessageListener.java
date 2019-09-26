package com.cg.contService.message;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.cg.contService.domain.Cert;
import com.cg.contService.domain.Contable;
import com.cg.contService.service.ContableService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.opentracing.Span;
import io.opentracing.Tracer;

@Component
@EnableBinding(Sink.class)
public class MessageListener {    
  
  @Autowired
  private MessageSender messageSender;
  
  @Autowired
  private ContableService svc;
  
  @Autowired
  private Tracer tracer;

  @SuppressWarnings("deprecation")
@StreamListener(target = Sink.INPUT, 
condition="headers['message']=='encurso'")
  @Transactional
  public void retrievePaymentCommandReceived(String messageJson) throws JsonParseException, JsonMappingException, IOException {
	  
	  Message<Cert> message = new ObjectMapper().readValue(messageJson, new TypeReference<Message<Cert>>(){});
	  
	  
	  Cert cert = message.getPayload();
	  boolean contable = svc.check((message.getPayload().getTstamp()));
	  System.out.println("payload "+message.getPayload());
	  System.out.println("contable "+contable);
	  if(contable)
	  {
		  System.out.println("Checkpoint-1");
		  if(message.getPayload().getPeriodo().after(new Date()))
		  {
			  message.getPayload().setStatus("Tramitada");
			  Cert cert1 = message.getPayload();
			  Message<Cert> message1 = new Message<Cert>("CertTramitadaEvent", cert1);
			  message1.setLabel("CheckDateOk-4");
			  Span span = tracer.buildSpan("Sending Tramitada Event from microservice 1").start();
			  span.finish();
			  messageSender.sendTramitada(message1);
		  }
		  else if((message.getPayload().getPeriodo().getDay()==new Date().getDay())&&
				  (message.getPayload().getPeriodo().getMonth()==new Date().getMonth())&&
				  (message.getPayload().getPeriodo().getYear()==new Date().getYear()))
		  {
			  message.getPayload().setStatus("Tramitada");
			  Cert cert1 = message.getPayload();
			  Message<Cert> message1 = new Message<Cert>("CertTramitadaEvent", cert1);
			  message1.setLabel("CheckDate-Ok-4");
			   Span span = tracer.buildSpan("Sending Tramitada Event from microservice 1").start();
			  span.finish();
		         messageSender.sendTramitada(message1);
		  }
		  else if(message.getPayload().getPeriodo().before(new Date()))
		  {
			  message.getPayload().setStatus("Denegada");
			 Cert cert1 = message.getPayload();
		  Message<Cert> message1 = new Message<Cert>("OutOfDateEvent", cert1);
		  message1.setLabel("CheckDate-OutOfDate-4");
	         Span span = tracer.buildSpan("Sending OutOfDate Event from microservice 1").start();
		  span.finish();
			messageSender.sendOutOfDate(message1);
		  }
	  }
	  else
	  {
		  System.out.println("Checkpoint-3");
		  message.getPayload().setStatus("Denegada");
			 Cert cert1 = message.getPayload();
			 Message<Cert> message1 = new Message<Cert>("CertDenegadaEvent", cert1);
			 message1.setLabel("CheckDate-Denegada-8");
		          Span span = tracer.buildSpan("Sending Denegada Event from microservice 1").start();
			  span.finish();
				messageSender.sendCertdenegada(message1); 
		 
	  }
  }
  
      @StreamListener(target = Sink.INPUT, 
    		  condition="headers['message']=='provisiondenegada'")
	  @Transactional
    public void ProvisionesDenegadaReceived(String messageJson) throws JsonParseException, JsonMappingException, IOException {
    	  System.out.println("Checkpoint-2");
	  Message<Cert> message = new ObjectMapper().readValue(messageJson, new TypeReference<Message<Cert>>(){});
		 Message<Cert> message1 = new Message<Cert>("CertDenegadaEvent", message.getPayload());
		 message1.setLabel("Rollback-Denegada-8");
	     Span span = tracer.buildSpan("Sending rollback Denegada Event from microservice 1").start();
			  span.finish();
			messageSender.sendCertdenegada(message1); 
	 
  }
}
