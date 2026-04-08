package com.paniolweb.apppaniol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paniolweb.apppaniol.entities.Carrito;
import com.paniolweb.apppaniol.entities.CarritoItem;
import com.paniolweb.apppaniol.entities.Herramienta;
import com.paniolweb.apppaniol.entities.Insumo;
import com.paniolweb.apppaniol.exceptions.ResourceNotFoundException;
import com.paniolweb.apppaniol.repositories.CarritoRepository;
import com.paniolweb.apppaniol.repositories.HerramientaRepository;
import com.paniolweb.apppaniol.repositories.InsumoRepository;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private HerramientaRepository herramientaRepository;

    @Autowired
    private InsumoRepository insumoRepository;

    @Override
    public List<Carrito> obtenerTodos() {
        return carritoRepository.findAll();
    }

    @Override
    public Carrito agregarItem(Long id, String tipo, int cantidad, Long carritoId) {

        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el carrito con id " + carritoId));

        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }

        if ("HERRAMIENTA".equals(tipo)) {
            Herramienta herramienta = herramientaRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró herramienta con id " + id));

            if (herramienta.getCantidad() < cantidad) {
                throw new IllegalArgumentException("Stock insuficiente, disponibles: " + herramienta.getCantidad());
            }

            CarritoItem item = carrito.getItems().stream()
                    .filter(i -> i.getHerramienta() != null && i.getHerramienta().getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (item != null) {
                item.setCantidad(item.getCantidad() + cantidad);
            } else {
                item = new CarritoItem();
                item.setCarrito(carrito);
                item.setHerramienta(herramienta);
                item.setCantidad(cantidad);
                carrito.getItems().add(item);
            }

        } else if ("INSUMO".equals(tipo)) {
            Insumo insumo = insumoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró insumo con id " + id));

            if (insumo.getCantidad() < cantidad) {
                throw new IllegalArgumentException("Stock insuficiente, disponibles: " + insumo.getCantidad());
            }

            CarritoItem item = carrito.getItems().stream()
                    .filter(i -> i.getInsumo() != null && i.getInsumo().getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (item != null) {
                item.setCantidad(item.getCantidad() + cantidad);
            } else {
                item = new CarritoItem();
                item.setCarrito(carrito);
                item.setInsumo(insumo);
                item.setCantidad(cantidad);
                carrito.getItems().add(item);
            }

        } else {
            throw new IllegalArgumentException("Tipo de item inválido");
        }

        return carritoRepository.save(carrito);
    }

    public void eliminarItemDelCarrito(Long carritoId, Long itemId) {
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el carrito con id " + carritoId));

        CarritoItem item = carrito.getItems().stream()
                .filter(i -> i.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Item no encontrado en el carrito"));

        carrito.getItems().remove(item);
        carritoRepository.save(carrito);
    }

    @Override
    public void eliminarCarrito(Long id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public Carrito buscarPorUsuario(Long usuarioId) {
        return carritoRepository.findByUsuario_Id(usuarioId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No se encontró carrito para el usuario " + usuarioId));
    }
}