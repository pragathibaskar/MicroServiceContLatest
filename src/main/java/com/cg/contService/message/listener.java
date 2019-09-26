package com.cg.contService.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.transaction.annotation.Transactional;
import com.cg.contService.domain.Cert;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.opentracing.Tracer;
import io.opentracing.Span;


@EnableBinding(KStreamProcessorX.class)
public class listener {
	
	@Autowired
        private Tracer tracer;
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
	    Span span = tracer.buildSpan("Sending rollback Denegada Event from microservice 1").start();
			  span.finish();
			messageSender.sendCertdenegada(message1); 
	 
  }
	
}
	
