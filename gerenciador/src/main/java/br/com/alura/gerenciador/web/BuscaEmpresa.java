package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet("/busca")
public class BuscaEmpresa implements Tarefa{

	public BuscaEmpresa() {
		System.out.println("Instanciando a Servlet" + this);
	}

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String filtro = request.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		request.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaEmpresas.jsp";
	}
}
