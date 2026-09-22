package application;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import java.util.function.UnaryOperator;
public class mascaras {
	public static void aplicarMascara(TextField campo, String mascara) {
		
		int quantidadeMaxima =(int) mascara.chars()
				.filter(caractere -> caractere == '#')
				.count();
		 UnaryOperator<TextFormatter.Change> filtro = alteracao -> {
			 String novoTexto = alteracao.getControlNewText(); 
			 String numeros = novoTexto.replaceAll("\\D", "");
			 if(numeros.length()>quantidadeMaxima) {
				 return null;
			 }
			 StringBuilder textoFormatado = new StringBuilder();
			 int posicaoNumero = 0;
			 for(int i =0;i<mascara.length();i++) {
				 char caractereMascara = mascara.charAt(i);
				 if(caractereMascara == '#') {
					 if(posicaoNumero <numeros.length()) {
						 textoFormatado.append(numeros.charAt(posicaoNumero));	 
						 posicaoNumero++;
				 }else {
					 break;
				 }
				 }else {
					 if(posicaoNumero<numeros.length()) {
						 textoFormatado.append(caractereMascara);
					 }
				 }
			 }
			 	alteracao.setRange(0, alteracao.getControlText().length());
	            alteracao.setText(textoFormatado.toString());
	            int novaPosicaoCursor = textoFormatado.length();
	            alteracao.setCaretPosition(novaPosicaoCursor);
	            alteracao.setAnchor(novaPosicaoCursor);
			 return alteracao;
		 };
		 TextFormatter<String> formatador = new TextFormatter<>(filtro);
		 campo.setTextFormatter(formatador);
	}
}
