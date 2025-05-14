package br.iff.edu.jogodaforca;

import java.util.Map;
import java.util.Scanner;

import br.iff.edu.bancodepalavras.dominio.palavra.Palavra;
import br.iff.edu.bancodepalavras.dominio.palavra.PalavraAppService;
import br.iff.edu.bancodepalavras.dominio.palavra.PalavraFactory;
import br.iff.edu.bancodepalavras.dominio.tema.Tema;
import br.iff.edu.bancodepalavras.dominio.tema.TemaRepository;
import br.iff.edu.jogodaforca.dominio.boneco.Boneco;
import br.iff.edu.jogodaforca.dominio.boneco.texto.BonecoTextoFactory;
import br.iff.edu.jogodaforca.dominio.jogador.Jogador;
import br.iff.edu.jogodaforca.dominio.jogador.JogadorRepository;
import br.iff.edu.jogodaforca.dominio.rodada.Rodada;
import br.iff.edu.jogodaforca.dominio.rodada.RodadaAppService;
import br.iff.edu.jogodaforca.dominio.rodada.RodadaFactory;
import br.iff.edu.jogodaforca.dominio.rodada.RodadaRepository;

public class Main {

	public static void main(String[] args) {
		Aplicacao aplicacao = Aplicacao.getSoleInstance();
		
		aplicacao.configurar();
		
		RepositoryFactory aplicacaoRepositoryFactory = aplicacao.getRepositoryFactory();
		
		JogadorRepository jogadorRepository = aplicacaoRepositoryFactory.getJogadorRepository();

		RodadaFactory rodadaFactory = aplicacao.getRodadaFactory();

		RodadaRepository rodadaRepository = aplicacaoRepositoryFactory.getRodadaRepository();

		PalavraFactory palavraFactory = aplicacao.getPalavraFactory();
		
		TemaRepository temaRepository  = aplicacaoRepositoryFactory.getTemaRepository();

		PalavraAppService.createSoleInstance(aplicacaoRepositoryFactory.getTemaRepository(),
				aplicacaoRepositoryFactory.getPalavraRepository(), palavraFactory);

		RodadaAppService.createSoleInstance(rodadaFactory, rodadaRepository, jogadorRepository);

		Tema tema = aplicacao.getTemaFactory().getTema("Nomes");
			
		Jogador jogador = aplicacao.getJogadorFactory().getJogador("Edivan");

		Boneco boneco = aplicacao.getBonecoFactory().getBoneco();

		Rodada.setBonecoFactory(aplicacao.getBonecoFactory());
		

		PalavraAppService palavraAppService = PalavraAppService.getSoleInstance();

		RodadaAppService rodadaAppService = RodadaAppService.getSoleInstance();

		palavraAppService.novaPalavra("Edivan", tema.getId());
		palavraAppService.novaPalavra("Iann", tema.getId());
		palavraAppService.novaPalavra("Samuel", tema.getId());

		rodadaAppService.novaRodada(jogador.getId());

		Scanner scanner = new Scanner(System.in);
		
		Rodada novaRodada = aplicacao.getRodadaFactory().getRodada(jogador);


		int option = 0;
		char letra;
		String tentativa;

		while (!novaRodada.encerrou()) {
			System.out.println("----Jogo da Forca----");
			System.out.println("1 - Tentar");
			System.out.println("2 - Arriscar");
			System.out.println("Escolha uma opção:");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("Digite uma letra:");
				letra = scanner.next().charAt(0);

				novaRodada.tentar(letra);
				novaRodada.exibirBoneco(novaRodada.getQtdeTentativas());
				novaRodada.exibirPalavras();
				novaRodada.exibirLetrasErradas();
				break;

			case 2:
				System.out.println("Digite uma palavra:");
				tentativa = scanner.next();
				for (int i = 0; i < novaRodada.getNumPalavras(); i++) {
					novaRodada.getItens()[i].arriscar(tentativa);
					if (novaRodada.getItens()[i].acertou()) {
						System.out.println("Você acertou a palavra: " + tentativa);
					}else {
						System.out.println("Você errou a palavra: " + tentativa);
					}
				}
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
				break;
			}
			if(novaRodada.encerrou()){
				System.out.println("A rodada foi encerrada! Sua Pontuação:" + novaRodada.calcularPontos());
			}
		}
	}
}
