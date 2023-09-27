package com.example.mslibrary.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {
	private LocalDateTime timestamp = LocalDateTime.now();
	private String mensaje = "Error interno del servidor";
	private String detalles;
	private String estado = "-1";
	private String descripcion;

	public ExceptionResponse(String detalles, String descripcion) {
		super();
		this.detalles = detalles;
		this.descripcion = descripcion;
	}
}
