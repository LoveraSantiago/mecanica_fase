package prs.mecanica.fase.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import prs.mecanica.fase.MecanicaFaseMain;
import prs.mecanica.fase.global.Configuracao;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Configuracao.getInstance().setMobile(true);

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MecanicaFaseMain(), config);
	}
}
