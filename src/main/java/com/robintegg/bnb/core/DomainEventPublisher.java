package com.robintegg.bnb.core;

import org.springframework.context.ApplicationEvent;

public interface DomainEventPublisher {

	void publishEvent(ApplicationEvent event);

}
