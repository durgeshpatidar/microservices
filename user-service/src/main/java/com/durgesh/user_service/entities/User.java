package com.durgesh.user_service.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Users")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@Column
	private String userId;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String phone;
	
	@Transient
	private List<Rating> ratings=new ArrayList<>();
}
