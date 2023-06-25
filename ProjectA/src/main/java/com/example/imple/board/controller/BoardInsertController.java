package com.example.imple.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.imple.board.mapper.BoardMapper;
import com.example.imple.board.model.BoardDTO;
import com.example.standard.controller.InsertController;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class BoardInsertController implements InsertController<BoardDTO>{

	@Autowired
	BoardMapper mapper;
	
	@Override
	public void insert(Model model, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		model.addAttribute("count",mapper.boardCount());
		model.addAttribute("username",username);
		
		var error = request.getParameter("error");
		if(error==null) {
			var session = request.getSession();
			session.removeAttribute("board");
			session.removeAttribute("binding");
		}
		
	}

	@Override
	@Transactional
	public String insert(BoardDTO dto, BindingResult binding, Model model, HttpServletRequest request,
			RedirectAttributes attr) {
		
		
		model.addAttribute("count",mapper.boardCount());
		
		var session = request.getSession();
		session.setAttribute("binding", binding);
		
		if(binding.hasErrors())
			return "redirect:/board/insert?error";
		
		 var in = dto.getModel();
		
		
		try {
			mapper.boardInsert(in);
		} catch (Exception e) {
			
			return "redirect:/board/insert?error";
		}
		
		
		return "redirect:/board/page/1/20";
	}
	
}
