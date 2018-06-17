package my.hehe.web.weChat.filter.encrypt;

import java.io.*;
import java.nio.charset.Charset;

import javax.security.sasl.AuthenticationException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import my.hehe.web.WebApplication;
import my.hehe.web.weChat.entity.define.MsgType;
import my.hehe.web.weChat.entity.encrypt.AesException;
import my.hehe.web.weChat.entity.encrypt.WXBizMsgCrypt;
import org.springframework.stereotype.Service;

@Service
public class MsgEncryptFilter implements Filter {

    private WXBizMsgCrypt wxBizMsgCrypt;
    private final static ThreadLocal<MsgEncryptFilter.MsgToken> tokenThreadLocal = new ThreadLocal<MsgEncryptFilter.MsgToken>();

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        {
            MsgEncryptFilter.MsgToken token = new MsgEncryptFilter.MsgToken();
            token.signature = request.getParameter(MsgType.MSG_PARM_MSG_SIGNATURE);
            token.timeStamp = request.getParameter(MsgType.MSG_PARM_TIMESTAMP);
            token.nonce = request.getParameter(MsgType.MSG_PARM_NONCE);
            tokenThreadLocal.set(token);
            if (this.wxBizMsgCrypt == null) {
                this.wxBizMsgCrypt = WebApplication.getApplicationContext().getBean(WXBizMsgCrypt.class);
            }
        }
        ResponseEncrypt responseWrapper=new ResponseEncrypt((HttpServletResponse) response);
        chain.doFilter(new RequestDecrypt((HttpServletRequest)request), responseWrapper);
        responseWrapper.setEncryptDateToResponse((HttpServletResponse)response);

    }

    public void destroy() {
        tokenThreadLocal.remove();
    }

    class RequestDecrypt extends HttpServletRequestWrapper {

        private HttpServletRequest request;

        public RequestDecrypt(HttpServletRequest request)
                throws AuthenticationException {
            super(request);
            this.request = request;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            final StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                // read the payload into the StringBuilder 
                InputStream inputStream = request.getInputStream();

                if (inputStream != null) {
                    bufferedReader = new BufferedReader(new InputStreamReader(
                            inputStream, request.getCharacterEncoding()));
                    char[] charBuffer = new char[128];
                    int bytesRead = -1;
                    while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                        sb.append(charBuffer, 0, bytesRead);
                    }
                }
            } catch (IOException ex) {
                throw new AuthenticationException(
                        "Error reading the request payload", ex);
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException iox) {
                        // ignore 
                    }
                }
            }
            byte[] buffer = null;
            try {

                MsgEncryptFilter.MsgToken token = tokenThreadLocal.get();
                buffer = wxBizMsgCrypt.decryptMsg(token.signature, token.timeStamp, token.nonce, sb.toString()).getBytes(request.getCharacterEncoding());
            } catch (UnsupportedEncodingException | AesException e) {
                e.printStackTrace();
                return super.getInputStream();
            }
            final ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ServletInputStream newStream = new ServletInputStream() {

                @Override
                public int read() throws IOException {
                    return bais.read();
                }

                @Override
                public boolean isFinished() {
                    // TODO Auto-generated method stub
                    return false;
                }

                @Override
                public boolean isReady() {
                    // TODO Auto-generated method stub
                    return false;
                }

                @Override
                public void setReadListener(ReadListener listener) {
                    // TODO Auto-generated method stub

                }
            };

            return newStream;
        }

        // http://blog.chinaunix.net/uid-20783755-id-4729940.html
    }

    class ResponseEncrypt extends HttpServletResponseWrapper {

        private ByteArrayOutputStream buffer = null;
        private ServletOutputStream out = null;
        private PrintWriter writer = null;

        public ResponseEncrypt(HttpServletResponse response)
                throws IOException {
            super(response);
            buffer = new ByteArrayOutputStream();
            out = new my.hehe.web.weChat.filter.encrypt.MsgEncryptFilter.ResponseEncrypt.WapperedOutputStream(buffer);
            writer = new PrintWriter(new OutputStreamWriter(buffer,
                    this.getCharacterEncoding()));
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return writer;
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return out;
        }

        @Override
        public void flushBuffer() throws IOException {
            if (out != null) {
                out.flush();
            }
            if (writer != null) {
                writer.flush();
            }
        }

        @Override
        public void reset() {
            // TODO Auto-generated method stub
            buffer.reset();
        }

        public byte[] getResponseData() throws IOException {
            flushBuffer();
            out.close();
            return buffer.toByteArray();
        }
        public void setEncryptDateToResponse(HttpServletResponse response) {
            ServletOutputStream out = null;
            try {
                String response_body = new String(getResponseData(), Charset.forName("UTF-8"));
                MsgEncryptFilter.MsgToken token = tokenThreadLocal.get();
                String ecrypt = (response_body.equals(MsgType.MSG_REPLY)) ? response_body : wxBizMsgCrypt.encryptMsg(response_body, token.timeStamp, token.nonce);
                response.setContentLength(-1);
                out = response.getOutputStream();
                try {
                    out.write(ecrypt.getBytes(response.getCharacterEncoding()));
                } catch (Exception e) {
                    e.printStackTrace();
                    out.write(MsgType.MSG_REPLY.getBytes(response.getCharacterEncoding()));
                }
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private class WapperedOutputStream extends ServletOutputStream {
            private ByteArrayOutputStream bos = null;

            public WapperedOutputStream(ByteArrayOutputStream stream)
                    throws IOException {
                bos = stream;
            }

            @Override
            public void write(int b) throws IOException {
                bos.write(b);
            }

            @Override
            public void write(byte[] b) throws IOException {
                bos.write(b, 0, b.length);
            }

            @Override
            public boolean isReady() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void setWriteListener(WriteListener arg0) {
                // TODO Auto-generated method stub

            }
        }
    }
    class MsgToken {
        String timeStamp;
        String nonce;
        String signature;

        @Override
        public String toString() {
            return "MsgToken{" +
                    "timeStamp='" + timeStamp + '\'' +
                    ", nonce='" + nonce + '\'' +
                    ", signature='" + signature + '\'' +
                    '}';
        }
    }
}
