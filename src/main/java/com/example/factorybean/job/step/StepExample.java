package com.example.factorybean.job.step;

import com.example.factorybean.common.StepFactoryBean;
import com.example.factorybean.job.tasklet.TaskletExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StepExample extends StepFactoryBean {

	private final TaskletExample taskletExample;

	public StepExample(TaskletExample taskletExample) throws InterruptedException {
		this.taskletExample = taskletExample;
		log.info("StepExample.StepExample");
		Thread.sleep(500);
	}
}
