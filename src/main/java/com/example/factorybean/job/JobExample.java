package com.example.factorybean.job;

import com.example.factorybean.common.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobExample {

	private final Step stepExample;

	public JobExample(Step stepExample) {
		this.stepExample = stepExample;
		log.info("JobExample.JobExample");
		log.info("stepExample = {} ", stepExample);
	}
}
