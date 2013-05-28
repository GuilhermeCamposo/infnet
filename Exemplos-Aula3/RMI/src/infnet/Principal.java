package infnet;

import java.rmi.Naming;

public class Principal {

	public static void main(String[] args) throws Exception
	{
		chamadaLocal();

		chamadaRemota();

	}

	public static void chamadaLocal() throws Exception
	{
		// Criar objeto de acesso
		IAcessarConta objLocal = new AcessarConta();

		// Endereço do objeto local
		System.out.println("Acesso local:");
		System.out.println("Objeto AcessarConta: " + objLocal);

		// Fazer acesso (login)
		ContaCorrente conta = objLocal.acessar("sebastiana", "xaxado");

		// Chamar método
		System.out.println("Objeto Conta corrente: " + conta);
		System.out.println("=======================================\n");
	}

	public static void chamadaRemota() throws Exception
	{
		// Criar objeto
		IAcessarConta objRemoto = (IAcessarConta) Naming.lookup("rmi://Ulisses-PC:1099/AcessarConta");

		// Endereço do objeto remoto
		System.out.println("Acesso Remoto (RMI):");
		System.out.println("Objeto AcessarConta: " + objRemoto);

		// Fazer acesso (login)
		ContaCorrente conta = objRemoto.acessar("sebastiana", "xaxado");		

		// Chamar método
		System.out.println("Objeto Conta corrente: " + conta);
		System.out.println("Objeto Conta corrente: " + objRemoto.consultar(conta));
		System.out.println("=======================================");

	}


}
