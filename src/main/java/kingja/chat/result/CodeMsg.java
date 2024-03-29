package kingja.chat.result;

/**
 * Description:TODO
 * Create Time:2018/8/11 19:06
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CodeMsg {
    private int code;
    private String msg;

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "请求非法");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问太频繁！");
    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");


    public static CodeMsg HAS_REGISTERED = new CodeMsg(500216, "该用户已经存在");
    public static CodeMsg ACCOUNT_ERROR = new CodeMsg(500217, "账号或密码错误");
    public static CodeMsg UN_LOGIINED = new CodeMsg(500218, "用户未登录");

    //商品模块 5003XX


    //订单模块 5004XX
    public static CodeMsg ORDER_NOT_EXIST = new CodeMsg(500400, "订单不存在");

    //秒杀模块 5005XX
    public static CodeMsg MIAO_SHA_OVER = new CodeMsg(500500, "商品已经秒杀完毕");
    public static CodeMsg REPEATE_MIAOSHA = new CodeMsg(500501, "不能重复秒杀");
    public static CodeMsg MIAOSHA_FAIL = new CodeMsg(500502, "秒杀失败");


    //连接
    public static CodeMsg CONNECT_CREATE_ERROR = new CodeMsg(600100, "连接创建异常");
    public static CodeMsg CONNECT_COUNT_ERROR = new CodeMsg(600101, "连接人数异常");
    public static CodeMsg CONNECT_CONNECTID_ERROR = new CodeMsg(600102, "连接号错误，请重新输入");
    public static CodeMsg CONNECT_NEEDPASSWORD_ERROR = new CodeMsg(600103, "该连接需要密码");
    public static CodeMsg CONNECT_WRONGPASSWORD_ERROR = new CodeMsg(600104, "连接密码错误");
    public static CodeMsg CONNECT_ADMINCODE_ERROR = new CodeMsg(600105, "标识码错误");




    public CodeMsg fillArgs(Object...args) {
        return new CodeMsg(this.code,String.format(this.msg,args));
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



}
