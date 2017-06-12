package ResponsibilityChain.Filter;

/**
 * Created by zhangyifa on 6/12/17.
 */
public class CharFilter implements Filter {

    @Override
    public String doFilter(String str) {
        return str.replace('@','#');
    }
}
