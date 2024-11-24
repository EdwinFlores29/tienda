package com.example.tienda_demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Detalleventa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    Integer IdDetalleventa;
    String cantidad;
    Double precio_unitario;
    Double monto_detalleventa;
    String estado;
    Integer idProducto;
    Integer idVenta;
}
