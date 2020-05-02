package com.everything.demo.util;


import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.everything.demo.common.HttpResult;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.Map;

@Component
public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static SSLConnectionSocketFactory sslSocketFactory = null;
    private static PoolingHttpClientConnectionManager connectionManager = null;

    static {
        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) {
                    return true;
                }
            });
            sslSocketFactory = new SSLConnectionSocketFactory(builder.build(),
                    new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"},
                    null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslSocketFactory)
                    .build();
            connectionManager = new PoolingHttpClientConnectionManager(registry);
            connectionManager.setMaxTotal(200);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public HttpResult post(String url, Map<String, String> header, String charset, String body) {
        HttpResult result = new HttpResult();
        try {
            CloseableHttpClient client = HttpClients.custom()
                    .setSSLSocketFactory(sslSocketFactory)
                    .setConnectionManager(connectionManager)
                    .setConnectionManagerShared(true)
                    .build();
            HttpPost httpPost = new HttpPost(url);
            RequestConfig config = RequestConfig.custom().setConnectTimeout(6000).setSocketTimeout(6000).build();
            httpPost.setConfig(config);
            StringEntity requestEntity = new StringEntity(body, Charset.forName(charset));
            requestEntity.setContentEncoding(charset);
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
            httpPost.setEntity(requestEntity);

            CloseableHttpResponse response = client.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine != null) {
                result.setStatusCode(statusLine.getStatusCode());
            }

            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                InputStream stream = responseEntity.getContent();
                if (stream != null) {
                    result.setHttpBody(EntityUtils.toString(responseEntity, charset));
                }
            }
        } catch (Exception e) {
        	logger.info("http_read_timeout  url={},body={}",url,body);
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}