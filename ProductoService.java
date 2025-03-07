package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
   private final ProductoRepository productoRepository;
   public ProductoService(ProductoRepository productoRepository) {
       this.productoRepository = productoRepository;
   }
   public List<Producto> listarProductos() {
       return productoRepository.findAll();
   }
   public Optional<Producto> obtenerProductoPorId(int id) {
       return productoRepository.findById(id);
   }
   public Producto agregarProducto(Producto producto) {
       return productoRepository.save(producto);
   }
   public boolean eliminarProducto(int id) {
       if (productoRepository.existsById(id)) {
           productoRepository.deleteById(id);
           return true;
       }
       return false;
   }
}