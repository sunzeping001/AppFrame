package com.szp.app.network.entity;

import java.io.Serializable;

/**
 * Created by sunzeping on 17/9/17.
 * Function :
 * Desc :
 */

public class Person implements Serializable {
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
