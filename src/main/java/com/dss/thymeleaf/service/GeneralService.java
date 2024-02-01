package com.dss.thymeleaf.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.common.beans.beans.GroupRequest;
import com.api.common.beans.beans.GroupResponse;
import com.api.common.beans.beans.Request;
import com.api.common.beans.beans.SaldoRequest;
import com.api.common.beans.beans.SaldoResponse;
import com.api.common.beans.constant.utils.UrlFormatter;

@Service
public class GeneralService {

	Logger logger = LoggerFactory.getLogger(GeneralService.class);
	
	@Value("${api.protocol}")
	private String http;
	
	@Value("${api.url.general}")
	private String host;
	
	@Value("${api.url.general.port}")
	private String port;
	
	@Value("${api.url.general.path.group.list}")
	private String pathListGroup;
	
	@Value("${api.url.general.path.saldo.list}")
	private String pathListSaldo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public List<GroupResponse> listGroups(){
		Request<GroupRequest> rq = new Request<GroupRequest>();
		
		String url = UrlFormatter.formatUrl(http, host, port, pathListGroup);
		GroupResponse[] emplo = restTemplate.postForObject(url, rq, GroupResponse[].class);
		List<GroupResponse> list = Arrays.asList(emplo);
		return list;
	}
	
	
	public List<SaldoResponse> listSaldo(){
		Request<SaldoRequest> rq = new Request<SaldoRequest>();
		
		String url = UrlFormatter.formatUrl(http, host, port, pathListSaldo);
		SaldoResponse[] emplo = restTemplate.postForObject(url, rq, SaldoResponse[].class);
		List<SaldoResponse> list = Arrays.asList(emplo);
		return list;
	}
}
