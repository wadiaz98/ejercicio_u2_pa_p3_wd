package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "automovil")
public class Automovil {

	@Id
	@Column(name = "auto_placa")
	private String placa;

	@Column(name = "auto_valor_por_dia")
	private BigDecimal valorPorDia;

	@OneToMany(mappedBy = "automovil", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Renta> renta;

	// Set y get

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(BigDecimal valorPorDia) {
		this.valorPorDia = valorPorDia;
	}

	public List<Renta> getRenta() {
		return renta;
	}

	public void setRenta(List<Renta> renta) {
		this.renta = renta;
	}
	

}
