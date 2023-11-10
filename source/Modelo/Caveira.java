package Modelo;

import java.util.Random;

import Controler.Fase;
import interfaces.IterageComHeroi;
import interfaces.Monstro;

public class Caveira extends Personagem implements IterageComHeroi, Monstro{
    private static final long serialVersionUID = 20231107083000L;
    
    private int numeroDoSprite = 0;
    private boolean podeMexer = false;
    private int direcao = 0;
    private boolean trocaDir = false;

    public Caveira() {
        super(0,13);
        super.bTransponivel = false;
    }
    public boolean interageHeroi(Hero hero,Fase umaFase) {
    	Personagem moeda = new Moeda();
    	moeda.setPosicao(this.pPosicao);    	
    	umaFase.addPersonagem(moeda);
    	hero.setNumeroVidasRestantes(-1);
	    umaFase.removePersonagem(this);
	    return true;
    }
	@Override
	public void acabouAsVidas() {
		podeMexer = true;
	}
	
	public void autoDesenho() {
		super.autoDesenho();
		if(podeMexer == true) {
			super.setImage(numeroDoSprite % 2, 13);
			numeroDoSprite++;
			if(trocaDir == true) {
				Random random = new Random();
				int anterior;
				do {
					anterior = direcao;
					direcao = random.nextInt(4);
				}while(direcao == anterior);
				}
			switch(direcao) {
				case 0:
					trocaDir = !(this.moveUp());
					break;
				case 1:
					trocaDir = !(this.moveDown());
					break;
				case 2:
					trocaDir = !(this.moveLeft());
					break;
				case 3:
					trocaDir = !(this.moveRight());
					break;
				default:
					break;
			}
		}
	}
    			
}
