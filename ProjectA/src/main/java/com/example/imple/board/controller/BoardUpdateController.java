package com.example.imple.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.imple.board.mapper.BoardMapper;
import com.example.imple.board.model.BoardDTO;
import com.example.standard.controller.UpdateController;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class BoardUpdateController implements UpdateController<BoardDTO>{

	@Autowired
	BoardMapper mapper;
	
	@Override
	public void update(Model model, HttpServletRequest request) {
		
		
		var bno = request.getParameter("bno");
		var key = Integer.parseInt(bno);
		try {
			model.addAttribute("board",mapper.boardDetail(key));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}

	@Override
	public String update(BoardDTO dto, BindingResult binding, Model model, HttpServletRequest request,
			RedirectAttributes attr) {
		
		if(binding.hasErrors())
			return "redirect:/board/update?error";
		
		var board = dto.getModel();
		
		
		mapper.boardUpdate(board);
		
		
		
		
		return "redirect:/board/page/1/20";
	}
	
}
