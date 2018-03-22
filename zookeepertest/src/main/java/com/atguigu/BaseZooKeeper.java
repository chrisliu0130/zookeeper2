/**  
* <p>Title: BaseZooKeeper.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date 2018年3月21日  
* @version 1.0  
*/
package com.atguigu;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import lombok.Data;

/**
 * 可继承的抽象类
 * 
 * @author ASUS
 *
 */
@Data
public abstract class BaseZooKeeper {

	// 实例常量
	protected static final String CONNECTIONSTRING = "192.168.220.128:2181";
	protected static final int SESSION_TIMEOUT = 20 * 1000;
	protected static final String PATH = "/atguigu";
	protected static final String DATA = "helloworld0321";

	// 实例变量
	protected static ZooKeeper zk = null;
	public String oldStr;
	public String newStr;

	/**
	 * <p>
	 * Title: stopZk
	 * </p>
	 * <p>
	 * Description: 关闭连接
	 * </p>
	 * 
	 * @param zk
	 * @throws Exception
	 */
	public void stopZk() throws Exception {
		if (null != zk)
			zk.close();
	}

	/**
	 * <p>
	 * Title: getNode
	 * </p>
	 * <p>
	 * Description:获得节点的值
	 * </p>
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 * @throws InterruptedException
	 */
	public String getNode(String path) throws Exception, InterruptedException {
		String result = "";
		// byte[] bs = zk.getData(path, true, new Stat());
		byte[] bs = zk.getData(path, new Watcher() {

			public void process(WatchedEvent event) {

				try {
					triggerValue(event.getPath());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, new Stat());
		result = new String(bs);
		return result;
	}

	/**
	 * <p>
	 * Title: triggerValue
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param path
	 * @throws Exception
	 * @throws InterruptedException
	 */
	public void triggerValue(String path) throws Exception, InterruptedException {
		System.out.println("changed!!!");
		String newStr = getNode(path);
		if (newStr.equals(getOldStr())) {
			System.out.println("The values stay same");
		} else {
			System.out.println("oldStr:" + getOldStr() + ",newStr:" + newStr);
		}
		setOldStr(newStr);
	}

	/**
	 * <p>
	 * Title: createNode
	 * </p>
	 * <p>
	 * Description: 创建一个节点，并赋值
	 * </p>
	 * 
	 * @param path
	 * @param data
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public void createNode(String path, String data) throws KeeperException, InterruptedException {
		setOldStr(data);
		zk.create(path, data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}

	/**
	 * <p>
	 * Title: startZk
	 * </p>
	 * <p>
	 * Description: 获得ZooKeeper的实例对象
	 * </p>
	 * 
	 * @return
	 * @throws IOException
	 */
	public ZooKeeper startZk() throws IOException {
		ZooKeeper zk = new ZooKeeper(CONNECTIONSTRING, SESSION_TIMEOUT, new Watcher() {

			public void process(WatchedEvent event) {

			}
		});
		return zk;
	}
}
