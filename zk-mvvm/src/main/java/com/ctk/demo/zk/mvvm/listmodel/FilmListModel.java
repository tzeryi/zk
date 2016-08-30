package com.ctk.demo.zk.mvvm.listmodel;

import java.util.List;

import org.zkoss.zul.AbstractListModel;

import com.ctk.demo.zk.mvvm.dao.FilmDao;
import com.ctk.demo.zk.mvvm.entity.Film;

public class FilmListModel extends AbstractListModel<Film> {

	private static final long serialVersionUID = 1L;

	private FilmDao filmDao;
	private List<Film> filmList;

	public FilmListModel(List<Film> filmList, FilmDao filmDao) {
		this.filmList = filmList;
		this.filmDao = filmDao;
	}

	@Override
	public Film getElementAt(int index) {
		System.out.println("25");
		return filmDao.reload(filmList.get(index));
	}

	@Override
	public int getSize() {
		return filmList.size();
	}

}
