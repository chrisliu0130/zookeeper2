package com.atguigu;

import org.apache.log4j.Logger;

public class HelloZookeeper extends BaseZooKeeper {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HelloZookeeper.class);

	public static void main(String[] args) throws Exception {
		HelloZookeeper hz = new HelloZookeeper();

		zk = hz.startZk();

		if (zk.exists(PATH, false) == null) {
			hz.createNode(PATH, DATA);

			String result = hz.getNode(PATH);

			if (logger.isInfoEnabled()) {
				logger.info("main(String[]) - String result=" + result);
			}
		} else {
			logger.info("This node is exits!");
		}

		hz.stopZk();

	}

	

}
