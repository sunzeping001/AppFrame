package com.szp.app.network.reponse;

import com.szp.app.network.base.BaseResponse;
import com.szp.app.network.entity.Person;

/**
 * Created by sunzeping on 17/9/17.
 * Function : Person返回的结果类
 * Desc :
 */

public class PersonBaseResponse extends BaseResponse {

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
