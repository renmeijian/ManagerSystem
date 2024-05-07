package org.example.manage.common;

public enum ErrorCodeEnum {
    S_SUCCESS("000000", "Operation successful"),

    E_COMMON("999999", "Request exception, please try again"),

    E_NOT_LOGIN("900001", "Not logged in"),

    E_EXCEPTION("900004", "Unknown exception");;

    private String code;
    private String flag;

    private ErrorCodeEnum(String code, String flag) {
        this.code = code;
        this.flag = flag;
    }

    public String getCode() {
        return this.code;
    }

    public String getFlag() {
        return this.flag;
    }
}
