package com.ctk.test.zk.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class TestViewModel {

	private String msg;

	@Command
	@NotifyChange("msg")
	public void test() {
		msg = "Hello World 111";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
