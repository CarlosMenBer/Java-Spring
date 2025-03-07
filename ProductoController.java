
package com.example.demo;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;
 import java.util.List;
 
 @RestController
 public class ProductoController {
	 
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/api/productos")
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }
    
    @GetMapping("/api/{id}")
    public Producto obtenerProducto(@PathVariable int id) {
        return productoService.obtenerProductoPorId(id).orElse(null);
    }
    
    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable int id) {
        boolean eliminado = productoService.eliminarProducto(id);
        return eliminado ? "Producto eliminado correctamente" : "Producto no en contrado";
    }
 }