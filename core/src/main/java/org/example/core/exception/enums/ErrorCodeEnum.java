package org.example.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Tax Number invalido", "ON-0001"),

    ON0002("Tax Number indisponivel", "ON-0002"),
    ON0003("Email indisponivel", "ON-0003"),
    ON0004("Houve um Erro na criacao do usuario", "ON-0004"),
    TR0001("usuario lojista nao pode fazer tranferencia", "TR-0001"),
    TR0002("saldo indisponivel", "TR-0002"),
    TR0003("houve um erro ao realizar transferencia", "TR-0003"),
    TR0004("tranferencia nao autorizada", "TR-0004"),

    TRP0001("Pin invalido", "TRP-0001"),
    WA0001("carteira nao encontrada", "WA-0001"),
    NO0001("erro na notificaçao do usuario", "NO-0001"),
    ATH0001("houve um erro na authenticaçao", "ATH-0001"),




    ;
    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
