package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet("/novaEmpresa")
public class NovaEmpresa implements Tarefa {

	private static final long serialVersionUID = 8147512659241148541L;

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		request.setAttribute("nome", nome);
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}
}
