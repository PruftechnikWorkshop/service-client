package com.example.demo.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.Signal;


@RestController
public class SignalController {
	
	@Autowired
	private RestTemplate rest;

	@Value("${data.source.app.name}")
	private String dataSourceAppName;
	
    @RequestMapping("/getSignalData")
    List<Signal> getSignalData() {
    	URI uri = UriComponentsBuilder.fromUriString(dataSourceAppName + "/api/signals")
                .build()
                .toUri();

    	List<Signal> greeting = Arrays.asList(rest.getForEntity(uri, Signal[].class).getBody());
            return greeting;
    }
}
