package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Automovil;
import com.example.demo.modelo.Pago;
import com.example.demo.modelo.Renta;
import com.example.demo.repository.IRentaRepo;

@Service
public class RentaServiceImpl implements IRentaService {

	@Autowired
	private IRentaRepo iRentaRepo;
	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IAutomovilService automovilService;

	@Override
	public void realizar(String placa, String cedula, Integer numeroDias, String numeroTarjeta) {
		// TODO Auto-generated method stub
		Renta renta = new Renta();
		renta.setFecha(LocalDateTime.now());
		renta.setNumeroDias(numeroDias);
		renta.setCliente(this.clienteService.consultar(cedula));
		renta.setAutomovil(this.automovilService.consultar(placa));

		renta.setPago(null);
		Automovil automovil = this.automovilService.consultar(placa);
		renta.setValor(automovil.getValorPorDia().multiply(new BigDecimal(renta.getNumeroDias())));

		Pago pago = new Pago();
		pago.setNumeroTarjeta(numeroTarjeta);
		pago.setValor(renta.getValor().add(renta.getValor().multiply(new BigDecimal(0.05))));
		pago.setRenta(renta);

		this.iRentaRepo.insertar(renta);

	}

}
