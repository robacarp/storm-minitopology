import backtype.storm.LocalCluster;
import backtype.storm.Config;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class StormDemo {
	public static void main(String[] args) throws Exception {
		TopologyBuilder builder = new TopologyBuilder();

		builder.setSpout("spout", new ASpout());
		builder.setBolt("middleMan", new BBolt())
					 .shuffleGrouping("spout");
		builder.setBolt("bolt", new ABolt())
					 .shuffleGrouping("middleMan");

		Config config = new Config();
		config.setDebug(true);

		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("topology", config, builder.createTopology());
		Utils.sleep(7010);
		cluster.killTopology("topology");
		cluster.shutdown();
	}
}

