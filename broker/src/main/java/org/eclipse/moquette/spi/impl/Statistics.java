package org.eclipse.moquette.spi.impl;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

	public long storedTopics;
	public long storedMessages;
	public long transferedMessages;
	public long publishedMessages;
	public long receivedMessagesFromPIAX;
	public List<ClientStatistics> clients;


	public Statistics() {
		init();
	}
	
	public Statistics(long st, long sm, long tm, long pm, long rmfp) {
		storedTopics = st;
		storedMessages = sm;
		transferedMessages = tm;
		publishedMessages = pm;
		receivedMessagesFromPIAX = rmfp;
		clients = new ArrayList<ClientStatistics>();
	}

	private void init() {
		storedTopics = 0;
		storedMessages = 0;
		transferedMessages = 0;
		publishedMessages = 0;
		receivedMessagesFromPIAX = 0;
		clients = new ArrayList<ClientStatistics>();
	}

}
