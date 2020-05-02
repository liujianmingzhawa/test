package cydemotwo;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;

public class ZookeeperTest {
    private String connectString="192.168.255.128:2181";
    private int sessionTimeout = 6000;
    private ZooKeeper zkClient;

    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            // 监听器，如果开启
            public void process(WatchedEvent watchedEvent) {
                String path = watchedEvent.getPath();
                System.out.println("---------start----------");
				List<String> children;
				try {
					children = zkClient.getChildren("/", true);

					for (String child : children) {
						System.out.println(child);
					}
					System.out.println("---------end----------");
				} catch (KeeperException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    // 创建子节点
    @org.junit.Test
    public void createNode() throws KeeperException, InterruptedException {
        // 参数1：数据插入到哪个节点下
        // 参数2：需要插入的数据
        // 参数3：安全验证的模式，一般选ZooDefs.Ids.OPEN_ACL_UNSAFE
        // 参数4：插入的类型，PERSISTENT(永久有效的),PERSISTENT_SEQUENTIAL(久化的有顺序编号的)
        //               EPHEMERAL(临时的)，EPHEMERAL_SEQUENTIAL(临时的有顺序编号的)
        String s = zkClient.create("/fyj3", "cheshi".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);
    }

    // 取子节点，并监控节点的变化
    @org.junit.Test
    public void getDataAndWatch() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }
        Thread.sleep(Integer.MAX_VALUE);
    }

    // 3 判断节点是否存在
    @org.junit.Test
    public void exist() throws KeeperException, InterruptedException{

        Stat stat = zkClient.exists("/atguigu", false);

        System.out.println(stat==null? "not exist":"exist");
    }
    
    
    public static void main(String[] args) throws Exception {
		ZookeeperTest zookeeperTest = new ZookeeperTest();
		zookeeperTest.init();
		zookeeperTest.createNode();
		zookeeperTest.getDataAndWatch();
		zookeeperTest.exist();
	}
}
