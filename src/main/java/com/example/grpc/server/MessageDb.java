package com.example.grpc.server;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDb extends JpaRepository<Message, Date>{

}
