package com.example.tienda_demo.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Venta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    Integer idVenta;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape= JsonFormat.Shape.STRING)
    String fecha_venta;

    Double monto_total;
    String estado;
    Integer idCliente;
}
