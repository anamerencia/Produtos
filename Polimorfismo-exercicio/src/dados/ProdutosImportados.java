package dados;

public class ProdutosImportados extends Produtos {
	
	private Double taxaAlfandegaria;

	public ProdutosImportados() {
		super();
	}
	
	public ProdutosImportados(String nome, Double preco, Double taxaAlfandegaria ) {
		super(nome,preco);
		this.taxaAlfandegaria = taxaAlfandegaria;
	}
	
	public Double getTaxaAlfandegaria() {
		return taxaAlfandegaria;
	}
	
	public void setTaxaAlfandegaria(Double taxaAlfandegaria) {
		this.taxaAlfandegaria = taxaAlfandegaria;
	}
	public double precoTotal() {
		return getPreco() + taxaAlfandegaria;
		
	}
	
	@Override
	public String priceTag() {
		return getNome() 
				+ " $ " 
				+ String.format("%.2f", precoTotal())
				+ " (Customs fee: $ " 
				+ String.format("%.2f", taxaAlfandegaria)
				+ ")";
	}
}
