package com.robintegg.bnb.core;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class SynchronousCommandExecutorService implements CommandExecutorService {

	@Override
	public void run(Command command) {

		command.audit();

		command.execute();

	}

}
