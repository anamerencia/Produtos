package dados;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ProdutosUsados extends Produtos {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dataDeFabricacao;
	
	public ProdutosUsados(String nome, Double preco, Date dataDeFabricacao) {
		super(nome, preco);
		this.dataDeFabricacao = dataDeFabricacao;
	}
	
	public Date getDataDeFabricacao() {
		return dataDeFabricacao;
	}
	
	public void setDataDeFabricacao(Date dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}
	
	@Override
	public String priceTag() {
		return getNome() 
				+ " (used) $ " 
				+ String.format("%.2f", getPreco())
				+ " (Manufacture date: "
				+ sdf.format(dataDeFabricacao)
				+ ")";
	}
	
}
