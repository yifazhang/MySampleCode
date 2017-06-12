package ResponsibilityChain.Web;

/**
 * Created by zhangyifa on 6/12/17.
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
