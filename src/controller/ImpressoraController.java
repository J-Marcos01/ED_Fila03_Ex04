package controller;

import br.edu.fateczl.fila.Fila;

public class ImpressoraController {

	public ImpressoraController() {
		super();
	}

	public void insereDocumento (Fila<String>fila,String documento)
	{
		fila.insert(documento);
	}
	public void imprime(Fila<String>fila)throws Exception
	{
		if(fila.isEmpty())
		{
			throw new Exception("Não há documentos para impressão.");
		}
		while(!fila.isEmpty())
		{
			try {
				String documento=fila.remove();
				String[]documentoVetor=documento.split(";");
				
				System.out.println("#Pc :"+documentoVetor[0]+"- Arquivo : "+documentoVetor[1]+"Imprimindo");
				int tempo =(int)((Math.random()*1001)+1000);
				Thread.sleep(tempo);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}	
		}
		
	}
}
