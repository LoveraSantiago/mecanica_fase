package prs.mecanica.fase.utils.custom_anotacoes;

public @interface Revisao {

    String dataModificacao();
    String dataRevisao();
    boolean revisada();

    boolean importsVerificados();

    boolean classePublica();
    String justificativa_classePublica() default "";//Justificar casos positivos

    boolean classeFinal();
    String justificativa_classeFinal() default "";//Justificar casos negativos

    boolean metodosEncapsulados();
    boolean atributosEncapsulados();

    boolean substituivel();//Se a classe for concreta pode ser utilizada como nested class?
                           //Se a classe for concreta pode ser utilizada como interface?
                           //Se for interface pode ser uma classe Abstrata?
                           //Se é uma classe abstrata pode ser uma interface?

    String[] TODOS() default {};
    String descricao();
    Class[] utilizadores() default {};
    Class[] implementadores() default {};
    String[] links() default {};
}
