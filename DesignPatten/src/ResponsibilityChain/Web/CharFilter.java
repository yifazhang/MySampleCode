package ResponsibilityChain.Web;

/**
 * Created by zhangyifa on 6/12/17.
 */
public class CharFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.setRequestStr(request.getRequestStr().replace('@','#') + "\n------------------CharFilter");
        chain.doFilter(request, response, chain);
        response.setResponseStr(response.getResponseStr() + "\n------------------CharFilter");
    }
}
