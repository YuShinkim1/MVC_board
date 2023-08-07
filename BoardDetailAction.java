package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDto;

public class BoardDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardDao bDao = new BoardDao();

		BoardDto boardDto = null;
		try {
			boardDto = bDao.getBoardDto(bno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("boardDto", boardDto);
		RequestDispatcher rd = 
				request.getRequestDispatcher("BoardDetail.jsp");
		rd.forward(request, response);
	}

}




