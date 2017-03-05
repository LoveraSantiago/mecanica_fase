package prs.mecanica.fase.global;

public class Configuracao {
    
    private final static Configuracao configuracao;
    
    static{
        configuracao = new Configuracao();
    }
    
    private boolean mobile;   
    

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public static Configuracao getInstance() {
        return configuracao;
    }
}
