package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Automovil;
import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Pago;
import com.example.demo.modelo.Renta;
import com.example.demo.service.IAutomovilService;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IPagoService;
import com.example.demo.service.IRentaService;

@SpringBootApplication
public class EjercicioU2PaP3WdApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioU2PaP3WdApplication.class, args);
	}

	@Autowired
	private IAutomovilService automovilService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IRentaService iRentaService;

	@Autowired
	private IPagoService iPagoService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// PUNTO 1
		Automovil automovil = new Automovil();
		automovil.setPlaca("A1243");
		automovil.setValorPorDia(new BigDecimal(70000));
		this.automovilService.guardar(automovil);

		Cliente cliente = new Cliente();
		cliente.setCedula("172584516538");
		cliente.setNombre("Willan Diiaz");
		this.clienteService.guardar(cliente);

		List<Renta> rentas = new ArrayList<>();
		Renta renta1 = new Renta();
		renta1.setAutomovil(automovil);
		renta1.setCliente(cliente);
		renta1.setFecha(LocalDateTime.now());
		renta1.setNumeroDias(4);

		Pago pago = new Pago();
		pago.setNumeroTarjeta("11111111");
		pago.setRenta(renta1);
		pago.setValor(new BigDecimal(400));
		renta1.setPago(pago);

		Renta renta2 = new Renta();
		renta2.setAutomovil(automovil);
		renta2.setCliente(cliente);
		renta2.setFecha(LocalDateTime.now());
		renta2.setNumeroDias(4);

		Pago pago2 = new Pago();
		pago2.setNumeroTarjeta("11111111");
		pago2.setRenta(renta1);
		pago2.setValor(new BigDecimal(400));
		renta2.setPago(pago2);
		rentas.add(renta2);

		// Punto 2
		this.iRentaService.realizar("ABC123", "1725841538", 5, "111111111111");

		// Punto 3

		this.automovilService.consultar("ABC123");
		this.clienteService.consultar("1725841538");

		// Punto 4

	}

}
