package io.github.woukies.spring_mvc_board.command;

import org.springframework.ui.Model;

public interface BCommand {
	public void execute(Model model);
}
