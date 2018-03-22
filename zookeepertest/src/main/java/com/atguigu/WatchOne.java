/**  
* <p>Title: WatchOne.java</p>  
* <p>Description: </p>  
* @date 2018Äê3ÔÂ22ÈÕ  
* @version 1.0  
*/
package com.atguigu;

import org.apache.log4j.Logger;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author ASUS
 *
 */
public class WatchOne extends BaseZooKeeper {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WatchOne.class);

	/**
	 * <p>
	 * Title: main
	 * </p>
	 * <p>
	 * Description: WatchOneTest
	 * </p>
	 * 
	 * @param args
	 * @throws IOException
	 * @throws Exception
	 * @throws KeeperException
	 */
	public static void main(String[] args) throws IOException, KeeperException, Exception {
		WatchOne wo = new WatchOne();

		ZooKeeper zk = wo.startZk();
		BaseZooKeeper.zk = zk;

		if (zk.exists(PATH, false) == null) {
			wo.createNode(BaseZooKeeper.PATH, "hello0322");

			String node = wo.getNode(BaseZooKeeper.PATH);
			System.out.println("node:" + node);
		} else {
			logger.info("This node is exits!");
		}

		Thread.sleep(Long.MAX_VALUE);

		wo.stopZk();

	}

}
