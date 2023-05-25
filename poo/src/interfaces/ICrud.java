package interfaces;

import java.io.IOException;

//los generics se suelen llamar con una sola letra pero en mayuscula
public interface ICrud<T> {

	//una clase tipo interfaz: todos sus metodos son abstractos
	
	//se puedo poner el abstract y no hay ningun problema
	public /*abstract*/ void Insertar(T x) throws IOException;
	public void Modificar(T x, int y) throws IOException;
	public void Eliminar(T x) throws IOException;
	public void Listar();
	public T Buscar(int x);
	
	//extends: extender
	//implements: obligo a que defina
	
}

//como hago para utilizar el parametro tipo??? o parametros genericos