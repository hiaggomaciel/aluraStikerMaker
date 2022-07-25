import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo{

	public List<Conteudo> extraiConteudos(String json) {
		// extrair informacoes
		JsonParse parser = new JsonParse();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);
		
		List<Conteudo> conteudos = new ArrayList<>();
		
		for (Map<String, String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
			var conteudo = new Conteudo(titulo, urlImagem);
			
			conteudos.add(conteudo);
		}
		
		
		return conteudos;
	}
}
