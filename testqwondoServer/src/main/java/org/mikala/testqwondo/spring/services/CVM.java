package org.mikala.testqwondo.spring.services;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;

import org.mikala.testqwondo.api.model.User;

public class CVM<User> implements ConstraintViolation<User> {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessageTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getRootBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<User> getRootBeanClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLeafBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getExecutableParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getExecutableReturnValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path getPropertyPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getInvalidValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstraintDescriptor<?> getConstraintDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> U unwrap(Class<U> type) {
		// TODO Auto-generated method stub
		return null;
	}

}
