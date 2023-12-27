package com.example.parkview.service.ifs;

import com.example.parkview.entity.Comment;
import com.example.parkview.vo.BasicRes;

public interface CommentService {
	public BasicRes create(Comment comment);
}
