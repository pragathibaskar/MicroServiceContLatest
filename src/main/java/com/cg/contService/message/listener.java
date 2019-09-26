package com.cg.contService.message;
import com.cg.contService.domain.Cert;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.opentracing.Span;

@EnableBinding(KStreamProcessorX.class)
public class listener {
	
	
	@Autowired
	  private MessageSender messageSender;
	
	@StreamListener(target = "input1", 
  		  condition="headers['message']=='provisiondenegada'")
	@Transactional
    public void ProvisionesDenegadaReceived(String messageJson) throws JsonParseException, JsonMappingException, IOException {
    	  System.out.println("Checkpoint-2");
	  Message<Cert> message = new ObjectMapper().readValue(messageJson, new TypeReference<Message<Cert>>(){});
		 Message<Cert> message1 = new Message<Cert>("CertDenegadaEvent", message.getPayload());
		 message1.setLabel("Rollback-Denegada-8");
			messageSender.sendCertdenegada(message1); 
	 
  }
	
	
	
