package cydemotwo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;

public class MM7Test {
	
	public static void main(String[] args) throws Exception {
		ByteBuf byteBuf = null;
        try (InputStreamReader reader = new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("mm7_submit_resp.xml"), StandardCharsets.UTF_8);
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(output, StandardCharsets.UTF_8)) {
               Template template = new Template("mm7_submit_resp.xml", reader, null);
               Map<String, Object> dataModel = new HashMap<>();
               dataModel.put("TransactionID", "123456");
               dataModel.put("MM7Version", "3.0");
               dataModel.put("MessageID", "568952");
               dataModel.put("StatusCode", "DELEV");
               dataModel.put("StatusText", "");
               template.process(dataModel, writer);
               System.err.println(template.toString());
               
              byte[] bytes = output.toByteArray();
              System.err.println(new String(bytes,"utf-8"));
               byteBuf = Unpooled.wrappedBuffer(bytes);
/*               HttpHeaders resHeaders = new DefaultHttpHeaders();
               resHeaders.add("Content-Length", bytes.length);
               resHeaders.add("Connection", "close");
               FullHttpResponse httpResponse = new DefaultFullHttpResponse(null,
                       HttpResponseStatus.OK, byteBuf, resHeaders, new DefaultHttpHeaders());*/
               //ctx.channel().writeAndFlush(httpResponse);
           }
	}
}
