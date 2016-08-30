package com.ctk.demo.zk.mvvm.service;

import java.util.List;

import com.ctk.demo.zk.mvvm.vo.CarVo;

public interface CarService {

	public List<CarVo> findAll();
	
	public List<CarVo> search(String keyword);
}
