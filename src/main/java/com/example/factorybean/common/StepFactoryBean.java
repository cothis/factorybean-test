package com.example.factorybean.common;

import org.springframework.beans.factory.FactoryBean;

public class StepFactoryBean implements FactoryBean<Step> {
	@Override
	public Step getObject() {
		return new Step();
	}

	@Override
	public Class<?> getObjectType() {
		return Step.class;
	}
}
