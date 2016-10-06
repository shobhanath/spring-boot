package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class CustomLoadBalancerAlgorithm {
	@Autowired
	private IClientConfig ribbonClientConfig;
	/*TODO: Please use either IPing or IRule at a time*/
	
	@Bean
	@Autowired /*Just to wire IClientConfig*/
	public IPing ribbonPing(IClientConfig config){
		return new PingUrl(); 
	}
	
	
	@Bean
	@Autowired /*Just to wire IClientConfig*/
	public IRule ribbonAvailability(IClientConfig config){
		return new AvailabilityFilteringRule(); 
	}
  
  
  
}
