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

public class escribeXMLExamenA {
	public static void main(String[] args) {
		//ArrayList con los datos de los empleados
		List<Empleado> listaEmpleados=new ArrayList<>();
		listaEmpleados.add(new Empleado(1,"Pepe Pérez",2000));
		listaEmpleados.add(new Empleado(2,"Juan Martínez",1000));
		listaEmpleados.add(new Empleado(3,"Manolo López",1500));

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation dom = builder.getDOMImplementation();
			Document documento = dom.createDocument(null, "xml", null);
			Element raiz = documento.createElement("Empleados");
			documento.getDocumentElement().appendChild(raiz);
			Element nodoEmpleado = null , nodoDatos = null ;
			Text texto = null;

			for(Empleado emp: listaEmpleados){
			//Empleado
				nodoEmpleado=documento.createElement("Empleado");
					raiz.appendChild(nodoEmpleado);
			//Id
				nodoDatos=documento.createElement("Id");
					raiz.appendChild(nodoDatos);
					texto=documento.createTextNode(String.valueOf(emp.getId()));
						nodoEmpleado.appendChild(texto);
			//Nombre
				nodoDatos=documento.createElement("Nombre");
					raiz.appendChild(nodoDatos);
					texto=documento.createTextNode(emp.getNom());
						nodoEmpleado.appendChild(texto);
			//Salario
				nodoDatos=documento.createElement("Salario");
					raiz.appendChild(nodoDatos);
					texto=documento.createTextNode(String.valueOf(emp.getSalario()));
						nodoEmpleado.appendChild(texto);
                System.out.println(emp);
			}
			Source source = new DOMSource(documento);
			Result resultado = new StreamResult(new File("empleados.xml"));
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

