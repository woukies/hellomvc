package io.github.woukies.spring_test_member_mybatis_std.dto;

public class MemDto {
	private String mem_uid;
	private String mem_pwd;
	private String mem_name;

	public String getMem_uid() {
		return mem_uid;
	}

	public void setMem_uid(String mem_uid) {
		this.mem_uid = mem_uid;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
}
