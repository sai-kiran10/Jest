package io.searchbox.core;

import io.searchbox.AbstractAction;
import io.searchbox.Action;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

/**
 * @author Dogukan Sonmez
 */


public class Explain extends AbstractAction implements Action {

    private static Logger log = Logger.getLogger(Explain.class.getName());

    public static class Builder {
        private String id;
        private String index;
        private String type;
        private final Object query;

        public Builder(Object query) {
            this.query = query;
        }

        public Builder index(String val) {
            index = val;
            return this;
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Explain build() {
            return new Explain(this);
        }

    }

    private Explain(Builder builder) {
        setURI(buildURI(builder.index, builder.type, builder.id));
        setData(builder.query);
    }

    @Override
    public String getRestMethodName() {
        return "POST";
    }

    @Override
    public String getName() {
        return "EXPLAIN";
    }

    protected String buildURI(String index,String type,String id) {
        StringBuilder sb = new StringBuilder();
        sb.append(super.buildURI(index,type,id))
                .append("/")
                .append("_explain");
        log.debug("Created URI for update action is :" + sb.toString());
        return sb.toString();
    }

    @Override
    public byte[] createByteResult(Map jsonMap) throws IOException {
        return new byte[0];  //To change body of implemented methods use File | Settings | File Templates.
    }
}
