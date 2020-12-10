package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.cognizant.entity.Profile;

@SpringBootApplication
@EnableBinding(Sink.class)
public class RcgthMessageBrokerApplication {

	private Logger logger = LoggerFactory.getLogger(RcgthMessageBrokerApplication.class);

	@StreamListener("input")
	public void consumeMessage(Profile profile) {
		logger.info("Consume Payload : " + profile);
	}

	public static void main(String[] args) {
		SpringApplication.run(RcgthMessageBrokerApplication.class, args);
	}

}
