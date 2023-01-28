package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "renta")
public class Renta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rent_seq")
	@SequenceGenerator(name = "rent_seq", sequenceName = "rent_seq", allocationSize = 1)
	@Column(name = "rent_id")
	private Integer id;

	@Column(name = "rent_fecha")
	private LocalDateTime fecha;

	@Column(name = "rent_numero_dias")
	private Integer numeroDias;

	@Column(name = "rent_valor")
	private BigDecimal valor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rent_id_automovil")
	private Automovil automovil;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rent_id_cliente")
	private Cliente cliente;

	@OneToOne(mappedBy = "renta", cascade = CascadeType.ALL)
	private Pago pago;

	// Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

}
