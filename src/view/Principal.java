package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.fila.Fila;
import controller.ImpressoraController;

public class Principal {

	public static void main(String[] args) {

		Fila<String> fila = new Fila<>();
		ImpressoraController impressora = new ImpressoraController();
		
		int opc=0;
		
		while(opc!=9)
		{
			opc=Integer.parseInt(JOptionPane.showInputDialog("Digite:\n 1-Enviar documento \n 2-Imprimir \n 9-Finalizar"));
			switch (opc) {
			case 1: {
				StringBuffer documento=new StringBuffer();
				
				String idPc=JOptionPane.showInputDialog("Digite o Id do seu Pc");
					while(idPc.equals(""))
					{
						idPc=JOptionPane.showInputDialog("Digite o Id do seu Pc");
					}
					documento.append(idPc);
					documento.append(";");
					
					String nomeArquivo =JOptionPane.showInputDialog("Digite o nome do seu arquivo");
						while(nomeArquivo.equals(""))
						{
							nomeArquivo =JOptionPane.showInputDialog("Digite o nome do seu arquivo");
						}
						documento.append(nomeArquivo);
						impressora.insereDocumento(fila,documento.toString());
				break;	
			}
			case 2:
			{
				try {
					impressora.imprime(fila);		
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
			}
			case 9:
				System.out.println("Fim");
				break;
			default:
				System.out.println("Valor invalido , tente novamente:");
			}
		}
	}

}
