package com.example.grpc.server;

import java.util.Date;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.grpc.ContableServiceGrpc.ContableServiceImplBase;

import io.grpc.stub.StreamObserver;
import java.text.SimpleDateFormat;
//import com.cg.grpc.GetPage;
import com.cg.grpc.request;
import com.cg.grpc.response;

@GRpcService
public class ContableServiceImpl extends ContableServiceImplBase{

	
	@Autowired
	private MessageDb db;
	
	public void creation(request req,StreamObserver<response> res) {
		
		response.Builder build = response.newBuilder();
		Date date = new Date(req.getTimestamp());
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd yyyy");  
	        String strDate= formatter.format(date);
		String msg = "Cierre contable creado para el periodo "+strDate;
		System.out.println("message "+msg);
		Message newmsg = new Message();
		newmsg.setPeriodo(date);
		newmsg.setMsg(msg);
		db.saveAndFlush(newmsg);
		build.setMsg(msg);
		response b = build.build();
		res.onNext(b);
		res.onCompleted();
		
	}
}
