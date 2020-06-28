package com.tristanchester.npc.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inventory {
	
	private Long id;
	private int size; //Standard size is 28 "slots", limits item set size
	private Set<Item> items;
	private int worth;
	private int weight;
	
	@JsonIgnore
	private Character owner;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	@OneToMany(mappedBy = "inventory")
	public Set<Item> getItems() {
		return items;
	}
	
	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@OneToOne
	@JoinColumn(name = "ownerId") //look into CascadeType.PERSIST or CascadeType.ALL
	public Character getOwner() {
		return owner;
	}

	public void setOwner(Character owner) {
		this.owner = owner;
	}

	public int getWorth() {
		return worth;
	}

	public void setWorth(int worth) {
		this.worth = worth;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
