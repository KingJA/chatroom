package kingja.chat.result;

/**
 * Description:TODO
 * Create Time:2018/8/6 17:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }
    public static Result simpleSuccess(String successMsg) {
        return new Result(0,successMsg);
    }

    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<T>(codeMsg);
    }

    private Result(T data) {
        this.data = data;
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(CodeMsg codeMsg) {
        if (codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
