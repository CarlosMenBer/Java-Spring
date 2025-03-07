package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="productos")
public class Producto {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(name= "nombre",nullable = false)
   private String nombre;
   @Column(name= "precio",nullable = false)
   private double precio;
   @Column(name = "fecha_creacion", updatable = false)
   private LocalDateTime fechaCreacion;
   @PrePersist
   protected void onCreate() {
       this.fechaCreacion = LocalDateTime.now();
   }
   // Getters y setters
   public int getId() {
       return id;
   }
   public void setId(int id) {
       this.id = id;
   }
   public String getNombre() {
       return nombre;
   }
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }
   public double getPrecio() {
       return precio;
   }
   public void setPrecio(double precio) {
       this.precio = precio;
   }
   public LocalDateTime getFechaCreacion() {
       return fechaCreacion;
   }
}
