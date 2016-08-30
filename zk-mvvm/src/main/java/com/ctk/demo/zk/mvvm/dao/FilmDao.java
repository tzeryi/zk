package com.ctk.demo.zk.mvvm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctk.demo.zk.mvvm.entity.Film;

@Repository("filmDao")
public class FilmDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Film> listAll() {
		Query query = em.createQuery("SELECT f FROM Film f");
		List<Film> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Film> queryByTitle(String title) {
		Query query = em.createQuery("SELECT f FROM Film f where f.title like ?1");
		query.setParameter(1, StringUtils.defaultIfBlank(title, "") + "%");
		List<Film> result = query.getResultList();
		return result;
	}

	@Transactional(readOnly=true)
	public Film reload(Film film) {
		return em.find(Film.class, film.getFilmId());
	}
}
