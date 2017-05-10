package br.com.corretora.filtro;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.corretora.modelo.JPAUtil;

@WebFilter("/*")
public class Filtro implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("entrou no doFilter");
		try {
			EntityManager manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();

			request.setAttribute("manager", manager);

			chain.doFilter(request, response);

			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void destroy() {
		JPAUtil.close();
		System.out.println("destruiu filtro");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("iniciou filtro");
	}

}
