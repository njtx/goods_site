package com.nj.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;


/**
 * ����ȫվ�����Ż���
 */
public class EncodingFilter implements Filter {
	private String encoding; // ������������ı����
	private String contentType; // ��Ӧ����ҳ����

	/**
	 * ���س�ʼ����������������Ӧ����ҳ����
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "UTF-8";
		}
		contentType = config.getInitParameter("contentType");
		if (contentType == null) {
			contentType = "text/html;charset=UTF-8";
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// ǿ��ת��Ϊ��Э����صĶ���
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// ����ͻ�����Ӧ����
		response.setContentType(contentType);
		// ��request���а�װ����ǿ
		MyRequest myRequest = new MyRequest(request);
		// ����
		chain.doFilter(myRequest, response);
	}

	/**
	 * ��д��Ҫ��ǿ�ķ���
	 */
	private class MyRequest extends HttpServletRequestWrapper {
		private HttpServletRequest request;
		private boolean encoded = false; // �Ƿ��ѱ����

		public MyRequest(HttpServletRequest request) throws UnsupportedEncodingException {
			super(request);
			this.request = request;
		}

		@Override
		public String getParameter(String name) {
			String[] values = getParameterValues(name);
			if (values != null) {
				return values[0];
			}
			return null;
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			Map<String, String[]> map = request.getParameterMap();
			if (!encoded) {
				try {
					for (Map.Entry<String, String[]> me : map.entrySet()) {
						String[] values = me.getValue();
						for (int i = 0; i < values.length; i++) {
							values[i] = new String(values[i].getBytes("ISO-8859-1"), encoding);
						}
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				encoded = true;
			}
			return map;
		}

		@Override
		public String[] getParameterValues(String name) {
			Map<String, String[]> map = getParameterMap();
			if (map != null) {
				String[] values = map.get(name);
				if (values != null) {
					return values;
				}
			}
			return null;
		}
	}

	@Override
	public void destroy() {

	}
}
