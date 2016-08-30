package com.ctk.demo.zk.mvvm.vm;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import com.ctk.demo.zk.mvvm.service.CarService;
import com.ctk.demo.zk.mvvm.service.impl.CarServiceImpl;
import com.ctk.demo.zk.mvvm.vo.CarVo;

public class SearchViewModel {

	private String keyword;
	private List<CarVo> carList;
	private CarVo selectedCar;

	private CarService carService = new CarServiceImpl();

	@Command
	@NotifyChange("carList")
    public void search() {
        carList = carService.search(keyword);
    }

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<CarVo> getCarList() {
		return carList;
	}

	public void setCarList(List<CarVo> carList) {
		this.carList = carList;
	}

	public CarVo getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(CarVo selectedCar) {
		this.selectedCar = selectedCar;
	}
}
