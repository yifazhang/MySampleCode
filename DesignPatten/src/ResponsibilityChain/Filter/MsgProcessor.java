package ResponsibilityChain.Filter;

import ResponsibilityChain.Filter.FilterChain;

/**
 * Created by zhangyifa on 6/12/17.
 */
public class MsgProcessor {

    //Filter[] filters = {new HtmlFilter(), new SesitiveFilter()};
    private FilterChain fc;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FilterChain getFc() {
        return fc;
    }

    public void setFc(FilterChain fc) {
        this.fc = fc;
    }


    public String process() {
        return fc.doFilter(msg);
    }

}
