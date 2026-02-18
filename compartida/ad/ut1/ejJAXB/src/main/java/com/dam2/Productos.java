package com.dam2;

import java.util.ArrayList;
import java.util.List;

//@XmlRootElement(name = "productos")

public class Productos {
    private List<Producto> productos;

    public Productos() {
        productos = new ArrayList<Producto>();
    }

    public Productos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "productos=" + productos +
                '}';
    }
}
