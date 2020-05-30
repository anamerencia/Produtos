package aplication;
 
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import dados.Produtos;
import dados.ProdutosImportados;
import dados.ProdutosUsados;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produtos> list = new ArrayList<>();
		
		System.out.print("Entre com o numero de produtos");
		
		int n = sc.nextInt();
	
		for(int i = 1; i<=n; i++) {
		
			System.out.println("Product #" + i + "data");
			System.out.print("Comum, usado ou importado? (c/u/i)");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Preco");
			Double preco = sc.nextDouble();
			if(ch == 'i') {
				System.out.println("Taxa alfandegaria: ");
				Double taxaAlfandegaria = sc.nextDouble();
				list.add((new ProdutosImportados(nome, preco, taxaAlfandegaria)));
				}
			
			else if(ch == 'u') {
				System.out.print("Data de fabricação (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.next());
				list.add(new ProdutosUsados(nome, preco, data));
			}else 
				list.add(new Produtos(nome, preco));
				
				
		}
		
		System.out.println();
		System.out.println("Etiqueta de preços");
		for(Produtos produt : list ) {
			System.out.println(produt.priceTag());
		}
		
		
		
		sc.close();
	}
}
