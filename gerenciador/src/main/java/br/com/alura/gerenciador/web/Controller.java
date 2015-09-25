package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executar")
public class Controller extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		if (tarefa == null) {
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa!");
		}
		try {
			String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
			Class<Tarefa> type = (Class<Tarefa>) Class.forName(nomeDaClasse);
			Tarefa objetoTarefa = type.newInstance();
			String pagina = objetoTarefa.executa(req, res);
			req.getRequestDispatcher(pagina).forward(req, res);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}
