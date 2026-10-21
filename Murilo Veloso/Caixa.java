import java.util.Scanner;

public class caixa {
public static void main(String[]args){
	Scanner scanner = new Scanner(System.in);
	String senhacorreta ="1234";
	int tentativa = 0;
	boolean acesso = false;
	while(tentativa<3) {
		System.out.print("digite a senha");
		String senha = scanner.nextLine();
	if (senha.equals(senhacorreta))	{
		acesso = true;
		System.out.println("login realizado com sucesso");
		break;
		
	}else {
		tentativa++;
		System.out.print("senha incorreta\n");
	if(tentativa < 3){
		System.out.printf ("tentativas numero %d \n",tentativa);
		
	}
	}
	}
	if (!acesso) {
		System.out.println("numero de tentativa: 0");
		System.out.println("acesso bloqueado ");
	scanner.close();
	return;
	}
	double saldo = 0;
	int opcao;
	while (true){
		System.out.print("caixa eletronico\n");
		System.out.print("escolha uma opcao\n");
		System.out.print("1-consultar saldo \n");
		System.out.print("2- deposito \n");
		System.out.print("3- saque \n");
		System.out.print("4- sair\n");
		opcao= scanner.nextInt();
		switch(opcao) {
		case 1:
			System.out.printf("saldo: rs %.2f %n", saldo);
		break;
		case 2:
			System.out.print("digite o valor do deposito: rs:");
		double deposito = scanner.nextDouble();
		if (deposito <= 0) {
			System.out.print("erro\n");
		}else {
			saldo += deposito;
			System.out.printf("valor depositado, saldo atual %.2f %n:", saldo);
			
		}
		break;
		case 3:
			System.out.print("digite o valor do saque rs:");
		double saque = scanner.nextDouble();
		if (saque <= 0) {
			System.out.print("valor menor que 0\n");
		
		
		}else if (saque > saldo) {
			System.out.print("saldo insuficiente:");
		}else {
			saldo -= saque;
			System.out.printf("valor retirado, saldo atual %.2f %n:", saldo);
		}
		break;
		case 4:
			System.out.print("obrigado por utilizar o caixa ");
			scanner.close();
		return;
		default:
			System.out.print(" erro tente novamente");
	}
}

}
}
