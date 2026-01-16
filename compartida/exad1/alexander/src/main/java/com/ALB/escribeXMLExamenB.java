package com.ALB;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class escribeXMLExamenB {
	public static void main(String[] args) {
		//ArrayList con los datos de los Productos
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(new Producto(1,"Cola Cao",12));
		listaProductos.add(new Producto(2,"Galletas María",8));
		listaProductos.add(new Producto(3,"Nueces 1 kg",6));

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation dom = builder.getDOMImplementation();
			Document documento = dom.createDocument(null, "xml", null);
			Element raiz = documento.createElement("Productos");
			documento.getDocumentElement().appendChild(raiz);
			Element nodoProducto = null , nodoDatos = null ;
			Text texto = null;

			for(Producto emp: listaProductos){
			//Producto
				nodoProducto=documento.createElement("Producto");
					raiz.appendChild(nodoProducto);
			//Id
				nodoDatos=documento.createElement("Id");
					//raiz.appendChild(nodoDatos);
                nodoProducto.appendChild(nodoDatos); // Debemos de hacer el appendChild con el nodo de productos

                texto=documento.createTextNode(String.valueOf(emp.getId()));
                //nodoProducto.appendChild(texto);
                nodoDatos.appendChild(texto); // Debemos de hace el appendChild con el nodo de datos
			//Nombre
				nodoDatos=documento.createElement("Nombre");
                //raiz.appendChild(nodoDatos);
                nodoProducto.appendChild(nodoDatos); // Debemos hacer el appendChild con el nodoProducto, sino se crea a partir de la raiz

                texto=documento.createTextNode(emp.getNom());
                //nodoProducto.appendChild(texto);
			    nodoDatos.appendChild(texto); // Debemos hacer el appendChild con el nodoDatos para que el texto obtenido se almacene en su etiqueta correspondiente
            //Precio
				nodoDatos=documento.createElement("Precio");
                //raiz.appendChild(nodoDatos);
                nodoProducto.appendChild(nodoDatos); // Debemos de hacer el appendChild con el nodoProducto no con la raiz

                texto=documento.createTextNode(String.valueOf(emp.getPrecio()));
                //nodoProducto.appendChild(texto);
                nodoDatos.appendChild(texto); // Debemos de hacer el appendChild con el nodo de datos para que se escriba en su etiqueta correspondiente
			}
			Source source = new DOMSource(documento);
			Result resultado = new StreamResult(new File("Productos.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty("indent","yes");
			transformer.transform(source,resultado);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}
	}
}
