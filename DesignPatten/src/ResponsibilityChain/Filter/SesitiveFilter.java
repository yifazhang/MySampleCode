package ResponsibilityChain.Filter;

import ResponsibilityChain.Filter.Filter;

/**
 * Created by zhangyifa on 6/12/17.
 */
public class SesitiveFilter implements Filter {
    @Override
    public String doFilter(String str) {
        return str.replace("被就业","就业").replace("敏感","");
    }
}
