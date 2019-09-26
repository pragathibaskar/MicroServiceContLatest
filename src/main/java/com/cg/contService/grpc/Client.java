package com.cg.contService.grpc;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.cg.contService.service.ContableService;
import com.cg.grpc.ContableServiceGrpc;
import com.cg.grpc.request;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Component
public class Client {

	
	private ContableServiceGrpc.ContableServiceBlockingStub stub;
	
	@PostConstruct
	private void init() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090).usePlaintext(true).build();
		stub = ContableServiceGrpc.newBlockingStub(channel);
	}
	
	public String message(long ts) {
		request res = request.newBuilder().setTimestamp(ts).build();
		
		String msg = stub.creation(res).getMsg();
		
		
		return msg;
		
	}
}
