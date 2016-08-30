package com.ctk.demo.zk.mvvm.vm;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import com.ctk.demo.zk.mvvm.dao.FilmDao;
import com.ctk.demo.zk.mvvm.entity.Film;
import com.ctk.demo.zk.mvvm.listmodel.FilmListModel;
import com.ctk.demo.zk.mvvm.service.FilmService;
import com.ctk.demo.zk.mvvm.service.impl.FilmServiceImpl;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class FilmViewModel {

	@WireVariable("filmService")
	private FilmService filmService = new FilmServiceImpl();
	
	@WireVariable("filmDao")
	private FilmDao filmDao;

	private String titleText;
	private List<Film> filmList;
	
	private FilmListModel filmListModel;

	@Command
	@NotifyChange("filmListModel")
	public void searchByTitle() {
		filmList = filmDao.queryByTitle(titleText);
		filmListModel = new FilmListModel(filmList, filmDao);
	}

	public String getTitleText() {
		return titleText;
	}

	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	public List<Film> getFilmList() {
		return filmList;
	}

	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
	}

	public FilmListModel getFilmListModel() {
		return filmListModel;
	}

	public void setFilmListModel(FilmListModel filmListModel) {
		this.filmListModel = filmListModel;
	}

}
