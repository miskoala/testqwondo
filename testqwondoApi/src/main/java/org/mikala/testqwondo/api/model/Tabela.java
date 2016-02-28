package org.mikala.testqwondo.api.model;

import java.io.Serializable;


/**
 * The persistent class for the tabela database table.
 * 
 */
public class Tabela extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	public Tabela() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}