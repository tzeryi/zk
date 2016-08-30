package com.ctk.demo.zk.mvvm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.ctk.demo.zk.mvvm.dao.FilmDao;
import com.ctk.demo.zk.mvvm.entity.Film;
import com.ctk.demo.zk.mvvm.service.FilmService;

@Service("filmService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmDao dao = new FilmDao();

	@Override
	public List<Film> listAll() {
		return dao.listAll();
	}

	@Override
	public List<Film> queryByTitle(String title) {
		return dao.queryByTitle(title);
	}

	@Override
	public Film reload(Film film) {
		return dao.reload(film);
	}

}
