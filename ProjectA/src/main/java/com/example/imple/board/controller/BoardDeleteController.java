package com.example.imple.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.imple.board.mapper.BoardMapper;
import com.example.imple.board.model.BoardDTO;
import com.example.standard.controller.DeleteController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/board")
public class BoardDeleteController implements DeleteController<BoardDTO> {

	@Autowired
	BoardMapper mapper;
	
	@Override
	public void delete(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		
		var bno = request.getParameter("bno");
		var key = Integer.parseInt(bno);
		
		try {
			model.addAttribute("board",mapper.boardDetail(key));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public String delete(@Valid BoardDTO dto, BindingResult binding, Model model, HttpServletRequest request,
			RedirectAttributes attr) {
		
		if(binding.hasErrors())
			return "redirect:/board/delete/?error";
		
		var bno = dto.getModel();
		
		try {
			mapper.boardDelete(bno.getBno());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return "redirect:/board/page/1/20";
	}

}
