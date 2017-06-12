package ResponsibilityChain.Web;

/**
 * Created by zhangyifa on 6/12/17.
 */
public class SesitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.setRequestStr(request.getRequestStr().replace("被就业","就业").replace("敏感","") + "\n------------------SesitiveFilter");
        chain.doFilter(request, response, chain);
        response.setResponseStr(response.getResponseStr() + "\n------------------SesitiveFilter");
    }
}
