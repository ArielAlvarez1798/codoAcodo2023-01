package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Autos {
    
    private int idAuto;
    private String marca;
    private String modelo;
    private String nacionalidad;
    private String periodo;
    private String potencia;
    private String aceleracion;
    private String velocidad;    
    private double precio;
    private byte[] imagen;
    private String imagenBase64;

    public Autos(String marca, String modelo, String nacionalidad, String periodo, String potencia, String aceleracion, String velocidad, double precio, byte[] imagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.nacionalidad = nacionalidad;
        this.periodo = periodo;
        this.potencia = potencia;
        this.aceleracion = aceleracion;
        this.velocidad = velocidad;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Autos(int idAuto, String marca, String modelo,String nacionalidad, String periodo, String potencia, String aceleracion, String velocidad, double precio, byte[] imagen) {
        this.idAuto = idAuto;
        this.marca = marca;
        this.modelo = modelo;
        this.nacionalidad = nacionalidad;
        this.periodo = periodo;
        this.potencia = potencia;
        this.aceleracion = aceleracion;
        this.velocidad = velocidad;
        this.precio = precio;
        this.imagen = imagen;
    }
    
    
}
