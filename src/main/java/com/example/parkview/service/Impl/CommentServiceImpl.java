package com.example.parkview.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkview.constants.RtnCode;
import com.example.parkview.entity.Comment;
import com.example.parkview.repository.CommentDao;
import com.example.parkview.service.ifs.CommentService;
import com.example.parkview.vo.BasicRes;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao dao;

	@Override
	public BasicRes create(Comment comment) {
		dao.save(comment);
		return new BasicRes(RtnCode.SUCCESSFUL);
	}

}
