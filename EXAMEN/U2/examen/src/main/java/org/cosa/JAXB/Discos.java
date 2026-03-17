package org.cosa.JAXB;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "discos")
public class Discos {
    private List<Disco> discos;

    public Discos() {
        discos = new ArrayList<>();
    }

    public Discos(List<Disco> discos) {
        this.discos = discos;
    }
    @XmlElement (name = "productos")
    public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }

    @Override
    public String toString() {
        return "Discos{" +
                "discos=" + discos +
                '}';
    }
}
