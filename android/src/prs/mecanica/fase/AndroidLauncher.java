package prs.mecanica.fase;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import prs.mecanica.fase.MecanicaFaseMain;
import prs.mecanica.fase.global.Configuracao;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Configuracao.getInstance().setMobile(true);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MecanicaFaseMain(), config);
	}
}
