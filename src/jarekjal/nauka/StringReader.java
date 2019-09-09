package jarekjal.nauka;

import java.io.IOException;
import java.io.Reader;

public class StringReader extends Reader{

    private String s;
    private int pos = 0;

    public StringReader(String s){
        this.s = s;
    }

    @Override
    public int read(char[] cbuf, int off, int len)  {
        int cnt = 0;
        if (pos >= s.length()) return -1;
        while (cnt < len && pos < s.length()) {
            cbuf[off + cnt] = s.charAt(pos);
            pos++;
            cnt++;
        }
        return cnt;
    }

    @Override
    public void close() throws IOException {
        //nothing to do
    }
}
