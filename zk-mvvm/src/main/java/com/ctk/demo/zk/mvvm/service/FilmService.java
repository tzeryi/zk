package com.ctk.demo.zk.mvvm.service;

import java.util.List;

import com.ctk.demo.zk.mvvm.entity.Film;

public interface FilmService {

	public List<Film> listAll();
	public List<Film> queryByTitle(String title);
	public Film reload(Film film);
}
