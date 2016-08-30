package com.ctk.demo.zk.mvvm.entity;
// Generated 2016/8/30 �W�� 11:06:56 by Hibernate Tools 5.1.0.Beta1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Inventory generated by hbm2java
 */
@Entity
@Table(name = "inventory", catalog = "sakila")
public class Inventory implements java.io.Serializable {

	private Integer inventoryId;
	private Film film;
	private Store store;
	private Date lastUpdate;
	private Set<Rental> rentals = new HashSet<Rental>(0);

	public Inventory() {
	}

	public Inventory(Film film, Store store, Date lastUpdate) {
		this.film = film;
		this.store = store;
		this.lastUpdate = lastUpdate;
	}

	public Inventory(Film film, Store store, Date lastUpdate, Set<Rental> rentals) {
		this.film = film;
		this.store = store;
		this.lastUpdate = lastUpdate;
		this.rentals = rentals;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "inventory_id", unique = true, nullable = false)
	public Integer getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id", nullable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventory")
	public Set<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

}
