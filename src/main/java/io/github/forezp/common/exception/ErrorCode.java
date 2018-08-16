package io.github.forezp.common.exception;

/**
 * 通用错误码
 * Created by fangzhipeng on 2017/5/18.
 */
public enum ErrorCode {

    OK( 0, "" ),
    FAIL( -1, "操作失败" ),
    ERROR_ARGS( 2, "参数不符合要求" ),
    USER_NOT_EXIST(3, "该用户不存在");
    ;


    private int code;
    private String msg;


    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ErrorCode codeOf(int code) {
        for (ErrorCode state : values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        return null;
    }
}
